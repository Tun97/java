package control.admin;

import dao.OrderDetailDao;
import entity.OrderDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/OrderDetailManagerServlet")
public class OrderDetailManagerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        OrderDetailDao dao = new OrderDetailDao();
        OrderDetails detail = null;

        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "List";
        }

        try {
            int orderId;
            int id;
            switch (action) {
                case "SaveOrUpdate":
                    id = parseInt(request.getParameter("id"));
                    orderId = parseInt(request.getParameter("orderId"));
                    int productVariantId = parseInt(request.getParameter("productVariantId"));
                    int quantity = parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));

                    detail = new OrderDetails(id, orderId, productVariantId, quantity, price);

                    if (id == 0 || dao.getDetailById(id) == null) {
                        dao.addDetail(detail);
                    } else {
                        dao.updateDetail(detail);
                    }

                    request.setAttribute("ORDER_ID", orderId);
                    request.setAttribute("DETAIL", new OrderDetails()); // reset form
                    request.setAttribute("DETAILS", dao.getDetailsByOrderId(orderId));
                    request.getRequestDispatcher("/admin/View-order-detail.jsp").forward(request, response);
                    break;

                case "AddOrEdit":
                    id = parseInt(request.getParameter("id"));
                    orderId = parseInt(request.getParameter("orderId"));

                    detail = dao.getDetailById(id);
                    if (detail == null) {
                        detail = new OrderDetails();
                        detail.setOrderId(orderId); // giữ orderId khi thêm mới
                    }

                    request.setAttribute("DETAIL", detail);
                    request.setAttribute("ORDER_ID", orderId);
                    request.setAttribute("DETAILS", dao.getDetailsByOrderId(orderId));
                    request.getRequestDispatcher("/admin/View-order-detail.jsp").forward(request, response);
                    break;

                case "Delete":
                    id = parseInt(request.getParameter("id"));
                    orderId = parseInt(request.getParameter("orderId"));

                    dao.deleteDetail(id);

                    request.setAttribute("DETAIL", new OrderDetails()); // reset form
                    request.setAttribute("ORDER_ID", orderId);
                    request.setAttribute("DETAILS", dao.getDetailsByOrderId(orderId));
                    request.getRequestDispatcher("/admin/View-order-detail.jsp").forward(request, response);
                    break;

                case "List":
                default:
                    orderId = parseInt(request.getParameter("orderId"));

                    request.setAttribute("ORDER_ID", orderId);
                    request.setAttribute("DETAIL", new OrderDetails()); // reset form
                    request.setAttribute("DETAILS", dao.getDetailsByOrderId(orderId));
                    request.getRequestDispatcher("/admin/View-order-detail.jsp").forward(request, response);
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
