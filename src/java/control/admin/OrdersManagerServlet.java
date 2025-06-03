package control.admin;

import dao.OrderDao;
import entity.Orders;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/admin/OrdersManagerServlet")
public class OrdersManagerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        OrderDao dao = new OrderDao();
        Orders order = null;

        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "List";
        }

        try {
            switch (action) {
                case "SaveOrUpdate":
                    int id = parseInt(request.getParameter("id"));
                    int userId = parseInt(request.getParameter("userId"));
                    double total = Double.parseDouble(request.getParameter("total"));
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    Timestamp orderDate = Timestamp.valueOf(request.getParameter("orderDate"));
                    String status = request.getParameter("status");
                    if (status == null || status.trim().isEmpty()) {
                        status = "Đang chờ";
                    }

                    order = new Orders(id, userId, orderDate, total, address, phone, status);

                    if (id == 0 || dao.getOrderById(id) == null) {
                        dao.addOrder(order);  // Gọi đúng hàm không truyền Connection
                    } else {
                        dao.updateOrder(order);
                    }

                    // Sau khi lưu xong, chuyển về danh sách đơn hàng
                    response.sendRedirect("OrdersManagerServlet?action=List");
                    break;

                case "AddOrEdit":
                    id = parseInt(request.getParameter("id"));
                    order = dao.getOrderById(id);
                    if (order == null) {
                        order = new Orders(); // Constructor không tham số
                    }

                    request.setAttribute("ORDER", order);
                    request.setAttribute("ACTION", "SaveOrUpdate");
                    request.getRequestDispatcher("/admin/OrdersManager.jsp").forward(request, response);
                    break;

                case "Delete":
                    id = parseInt(request.getParameter("id"));
                    dao.deleteOrder(id);
                    response.sendRedirect("OrdersManagerServlet?action=List");
                    break;

                case "UpdateStatus":
                    id = parseInt(request.getParameter("id"));
                    String newStatus = request.getParameter("status");
                    order = dao.getOrderById(id);
                    if (order != null) {
                        order.setStatus(newStatus);
                        dao.updateOrder(order);
                    }
                    response.sendRedirect("OrdersManagerServlet?action=List");
                    break;

                case "List":
                default:
                    request.setAttribute("list", dao.getAllOrders());
                    request.getRequestDispatcher("/admin/View-orders.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private int parseInt(String value) {
        return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }
}
