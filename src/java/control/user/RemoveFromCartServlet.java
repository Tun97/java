package control.user;

import entity.CartBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
    
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
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int removeIndex = Integer.parseInt(request.getParameter("index"));
            HttpSession session = request.getSession();
            List<CartBean> cart = (List<CartBean>) session.getAttribute("cart");

            if (cart != null && removeIndex >= 0 && removeIndex < cart.size()) {
                cart.remove(removeIndex);
            }
        } catch (NumberFormatException e) {
            // Xử lý trường hợp index không hợp lệ
            System.err.println("Invalid index parameter: " + request.getParameter("index"));
        }

        response.sendRedirect(request.getContextPath() + "/user/view-cart.jsp");
    }
}