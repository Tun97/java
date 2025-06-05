package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.ProductDao;
import java.util.List;
import entity.Products;
import entity.Users;

public final class View_002dproducts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/user/header.jsp");
    _jspx_dependants.add("/user/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Trang chủ</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/css7.css\">\n");
      out.write("    <script src=\"../js/snow.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"wrapper\">\n");
      out.write("    ");
      out.write('\n');
      out.write('\n');

    Users user = (Users) session.getAttribute("user");

      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap\" rel=\"stylesheet\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/css10.css\">\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light bg-white\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!-- Logo -->\n");
      out.write("            <a class=\"navbar-brand\" href=\"View-products.jsp\">\n");
      out.write("                <img src=\"logo.png\" alt=\"MyPhamShop Logo\">\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarContent\"\n");
      out.write("                aria-controls=\"navbarContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarContent\">\n");
      out.write("                <ul class=\"navbar-nav mx-auto\">\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"trangDiemDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            TRANG ĐIỂM\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"trangDiemDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=Son\">Son môi</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=Phấn\">Phấn nền</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=Kẻ mắt\">Kẻ mắt</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"chamSocDaDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            CHĂM SÓC DA\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"chamSocDaDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=gội\">Dầu gội</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=Serum\">Serum</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=Kem dưỡng\">Kem dưỡng</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"nuocHoaDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            NƯỚC HOA\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"nuocHoaDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=nước hoa nữ\">Nước hoa nữ</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?keyword=nam\">Nước hoa nam</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <div class=\"d-flex align-items-center\">\n");
      out.write("                    <!-- Search Form -->\n");
      out.write("                    <form action=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products\" method=\"get\" class=\"form-inline mr-3\">\n");
      out.write("                        <input type=\"text\" name=\"keyword\" placeholder=\"Tìm sản phẩm...\" class=\"form-control form-control-sm mr-2\" />\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-sm btn-outline-success\">Tìm</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <!-- Cart Icon -->\n");
      out.write("                    <a href=\"view-cart.jsp\" class=\"btn btn-outline-secondary btn-sm ml-3 mr-3\">\n");
      out.write("                        <i class=\"bi bi-cart3\"></i> Giỏ hàng\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("                    ");
 if (user != null) { 
      out.write("\n");
      out.write("                        <span class=\"user-info mr-3\">👋 Xin chào, ");
      out.print( user.getFullname() );
      out.write("</span>\n");
      out.write("                        <a href=\"");
      out.print( request.getContextPath() );
      out.write("/LogoutServlet\" class=\"btn btn-outline-danger btn-sm\">Đăng xuất</a>\n");
      out.write("                    ");
 } else { 
      out.write("\n");
      out.write("                        <a href=\"Login.jsp\" class=\"btn btn-outline-primary btn-sm d-flex align-items-center\">\n");
      out.write("                            <i class=\"bi bi-person-circle mr-2\"></i> Đăng nhập\n");
      out.write("                        </a>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<!-- Link Bootstrap JS and dependencies -->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    <section id=\"slideshow\">\n");
      out.write("        <img src=\"https://cocolux.com/storage/slider/larger/1748915345-Banner%20-%20700x400px(5).webp\" class=\"active\" alt=\"Ảnh 1\">\n");
      out.write("        <img src=\"https://cocolux.com/storage/slider/larger/1748680938-2CE4D301-98F0-4F2A-AF86-7325C73513A5.webp\" alt=\"Ảnh 2\">\n");
      out.write("        <img src=\"https://cocolux.com/storage/upload_image/images/banner/BNSCTT320251282x442.jpg\" alt=\"Ảnh 3\">\n");
      out.write("        <img src=\"https://cocolux.com/storage/slider/larger/1748680938-2CE4D301-98F0-4F2A-AF86-7325C73513A5.webp\" alt=\"Ảnh 4\">\n");
      out.write("        <img src=\"https://cocolux.com/storage/slider/larger/1744420459-BNCSVC2025_3.webp\" alt=\"Ảnh 5\">\n");
      out.write("        <img src=\"https://theme.hstatic.net/200000551679/1001345525/14/slider_3_master.jpg?v=302\" alt=\"Ảnh 6\">\n");
      out.write("        <div class=\"slideshow-dots\">\n");
      out.write("            <span class=\"slideshow-dot active\"></span>\n");
      out.write("            <span class=\"slideshow-dot\"></span>\n");
      out.write("            <span class=\"slideshow-dot\"></span>\n");
      out.write("            <span class=\"slideshow-dot\"></span>\n");
      out.write("            <span class=\"slideshow-dot\"></span>\n");
      out.write("            <span class=\"slideshow-dot\"></span>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <div class=\"container mt-4\">\n");
      out.write("        ");

            String success = request.getParameter("success");
            if ("true".equals(success)) {
        
      out.write("\n");
      out.write("        <div class=\"alert alert-success text-center\">\n");
      out.write("            Đặt hàng thành công! Cảm ơn bạn đã mua hàng.\n");
      out.write("        </div>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <h2 class=\"mb-4 text-center\">Danh sách Mĩ Phẩm</h2>\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            ");

                ProductDao dao = new ProductDao();
                List<Products> productList = dao.getAllProducts();
                for (Products p : productList) {
            
      out.write("\n");
      out.write("            <div class=\"col-md-3 mb-4\">\n");
      out.write("                <div class=\"card product-card h-100\">\n");
      out.write("                    <div class=\"position-relative\">\n");
      out.write("                        <a href=\"info-products.jsp?id=");
      out.print( p.getId() );
      out.write("\">\n");
      out.write("                            <img src=\"");
      out.print( p.getImage() );
      out.write("\" class=\"product-image card-img-top\" alt=\"");
      out.print( p.getName() );
      out.write("\">\n");
      out.write("                            <div class=\"buy-overlay\">Xem chi tiết</div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body text-center\">\n");
      out.write("                        <h5 class=\"card-title\">\n");
      out.write("                            <a href=\"info-products.jsp?id=");
      out.print( p.getId() );
      out.write("\" style=\"text-decoration: none; color: inherit;\">\n");
      out.write("                                ");
      out.print( p.getName() );
      out.write("\n");
      out.write("                            </a>\n");
      out.write("                        </h5>\n");
      out.write("                        <p class=\"card-text\">");
      out.print( p.getDescription() );
      out.write("</p>\n");
      out.write("                        <p class=\"card-text text-danger\">");
      out.print( p.getPrice() );
      out.write(" VND</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        const slides = document.querySelectorAll('#slideshow img');\n");
      out.write("        const dots = document.querySelectorAll('.slideshow-dot');\n");
      out.write("        let index = 0;\n");
      out.write("\n");
      out.write("        function showSlide(newIndex) {\n");
      out.write("            slides[index].classList.remove('active');\n");
      out.write("            dots[index].classList.remove('active');\n");
      out.write("            index = newIndex;\n");
      out.write("            slides[index].classList.add('active');\n");
      out.write("            dots[index].classList.add('active');\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function nextSlide() {\n");
      out.write("            showSlide((index + 1) % slides.length);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        dots.forEach((dot, i) => {\n");
      out.write("            dot.addEventListener('click', () => {\n");
      out.write("                showSlide(i);\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        setInterval(nextSlide, 4000);\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/css8.css\">\n");
      out.write("<footer class=\"site-footer\">\n");
      out.write("    <div class=\"footer-container\">\n");
      out.write("        <div class=\"footer-column about\">\n");
      out.write("            <h3>Về Chúng Tôi</h3>\n");
      out.write("            <p>Tăng Anh Tuấn - Mỹ phẩm thân thiện, sang trọng, quý phái an toàn cho trải nghiệm người dùng</p>\n");
      out.write("            <a href=\"#\" class=\"read-more\">Đọc thêm <i class=\"fas fa-arrow-right\"></i></a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-column quick-links\">\n");
      out.write("            <h3>Liên Kết Nhanh</h3>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"#\">Trang Chủ</a></li>\n");
      out.write("                <li><a href=\"#\">Sản Phẩm</a></li>\n");
      out.write("                <li><a href=\"#\">Chính Sách</a></li>\n");
      out.write("                <li><a href=\"#\">Liên Hệ</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-column contact\">\n");
      out.write("            <h3>Liên Hệ</h3>\n");
      out.write("            <p><i class=\"fas fa-map-marker-alt\"></i> Tân Tiến, Tp.Bắc Giang, Việt Nam</p>\n");
      out.write("            <p><i class=\"fas fa-phone\"></i> 0968498556</p>\n");
      out.write("            <p><i class=\"fas fa-envelope\"></i> 20221964@eaut.edu.vn</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-column subscribe\">\n");
      out.write("            <h3>Đăng Ký Nhận Tin</h3>\n");
      out.write("            <p>Nhận thông tin mới nhất về sản phẩm và ưu đãi!</p>\n");
      out.write("            <form class=\"subscribe-form\">\n");
      out.write("                <input type=\"email\" placeholder=\"Nhập email của bạn\" required>\n");
      out.write("                <button type=\"submit\"><i class=\"fas fa-paper-plane\"></i> Gửi</button>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"social-icons\">\n");
      out.write("                <a href=\"#\" aria-label=\"Facebook\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                <a href=\"#\" aria-label=\"Instagram\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                <a href=\"#\" aria-label=\"TikTok\"><i class=\"fab fa-tiktok\"></i></a>\n");
      out.write("                <a href=\"#\" aria-label=\"YouTube\"><i class=\"fab fa-youtube\"></i></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer-bottom\">\n");
      out.write("        <p>&copy; TAT-2025 .</p>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
