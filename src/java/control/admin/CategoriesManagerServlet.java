package control.admin;

import dao.CategoryDao;
import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "CategoriesManagerServlet", urlPatterns = {"/admin/CategoriesManagerServlet"})
public class CategoriesManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Debug: In ra console để kiểm tra servlet có được gọi không
        System.out.println("=== SERVLET ĐƯỢC GỌI ===");
        System.out.println("Action: " + request.getParameter("action"));
        System.out.println("Request URI: " + request.getRequestURI());
        
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        System.out.println("=== POST REQUEST ===");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        // Nếu không có database, test trực tiếp
        String testMode = request.getParameter("test");
        if ("true".equals(testMode)) {
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Test</title></head><body>");
            out.println("<h1>Servlet hoạt động bình thường!</h1>");
            out.println("<p>Thời gian: " + new java.util.Date() + "</p>");
            out.println("<a href='CategoriesManagerServlet'>Quay lại</a>");
            out.println("</body></html>");
            return;
        }
        
        CategoryDao dao = new CategoryDao();
        Category category = null;

        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "List";
        }

        System.out.println("Processing action: " + action);

        try {
            switch (action) {
                case "SaveOrUpdate":
                    String idStr = request.getParameter("id");
                    String name = request.getParameter("categoryName");

                    System.out.println("SaveOrUpdate - ID: " + idStr + ", Name: " + name);

                    // Validation
                    if (name == null || name.trim().isEmpty()) {
                        request.setAttribute("error", "Tên danh mục không được để trống!");
                        int id = (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0;
                        category = new Category(id, name);
                        request.setAttribute("CATEGORY", category);
                        request.setAttribute("ACTION", "SaveOrUpdate");
                        request.getRequestDispatcher("/admin/CategoryManager.jsp").forward(request, response);
                        return;
                    }

                    name = name.trim();
                    int id = (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0;
                    category = new Category(id, name);

                    boolean success = false;
                    String message = "";
                    
                    if (id == 0 || dao.getCategoryById(id) == null) {
                        success = dao.insertCategory(category);
                        message = success ? "Thêm danh mục thành công!" : "Không thể thêm danh mục!";
                    } else {
                        success = dao.updateCategory(category);
                        message = success ? "Cập nhật danh mục thành công!" : "Không thể cập nhật danh mục!";
                    }

                    if (success) {
                        request.setAttribute("message", message);
                    } else {
                        request.setAttribute("error", message);
                    }

                    List<Category> categories = dao.getAllCategories();
                    request.setAttribute("list", categories);
                    request.setAttribute("count", categories.size());
                    request.getRequestDispatcher("/admin/View-categories.jsp").forward(request, response);
                    break;

                case "AddOrEdit":
                    String idParam = request.getParameter("id");
                    int categoryId = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;
                    
                    System.out.println("AddOrEdit - ID: " + categoryId);
                    
                    if (categoryId > 0) {
                        category = dao.getCategoryById(categoryId);
                        if (category == null) {
                            request.setAttribute("error", "Không tìm thấy danh mục với ID: " + categoryId);
                            List<Category> errorList = dao.getAllCategories();
                            request.setAttribute("list", errorList);
                            request.setAttribute("count", errorList.size());
                            request.getRequestDispatcher("/admin/View-categories.jsp").forward(request, response);
                            return;
                        }
                    } else {
                        category = new Category();
                    }

                    request.setAttribute("CATEGORY", category);
                    request.setAttribute("ACTION", "SaveOrUpdate");
                    request.getRequestDispatcher("/admin/CategoryManager.jsp").forward(request, response);
                    break;

                case "Delete":
                    idParam = request.getParameter("id");
                    System.out.println("Delete - ID: " + idParam);
                    
                    if (idParam != null && !idParam.isEmpty()) {
                        categoryId = Integer.parseInt(idParam);
                        boolean deleted = dao.deleteCategory(categoryId);
                        
                        if (deleted) {
                            request.setAttribute("message", "Xóa danh mục thành công!");
                        } else {
                            request.setAttribute("error", "Không thể xóa danh mục!");
                        }
                    }
                    
                    List<Category> deleteList = dao.getAllCategories();
                    request.setAttribute("list", deleteList);
                    request.setAttribute("count", deleteList.size());
                    request.getRequestDispatcher("/admin/View-categories.jsp").forward(request, response);
                    break;

                case "List":
                default:
                    System.out.println("Listing categories...");
                    List<Category> allCategories = dao.getAllCategories();
                    request.setAttribute("list", allCategories);
                    request.setAttribute("count", allCategories.size());
                    System.out.println("Found " + allCategories.size() + " categories");
                    request.getRequestDispatcher("/admin/View-categories.jsp").forward(request, response);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
            request.setAttribute("error", "ID không hợp lệ!");
            List<Category> errorCategories = dao.getAllCategories();
            request.setAttribute("list", errorCategories);
            request.setAttribute("count", errorCategories.size());
            request.getRequestDispatcher("/admin/View-categories.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi hệ thống xảy ra: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}