package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import entity.Products;

public final class searchResults_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Kết quả tìm kiếm</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container mt-4\">\n");
      out.write("    <h2 class=\"text-center mb-4 text-primary\">Kết quả tìm kiếm</h2>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        ");

            List<Products> productList = (List<Products>) request.getAttribute("productList");
            if (productList != null && !productList.isEmpty()) {
                for (Products p : productList) {
                    String img = (p.getImage() != null) ? p.getImage() : "images/default.jpg";
                    String price = String.format("%,d", (int) p.getPrice());
        
      out.write("\n");
      out.write("        <div class=\"col-md-4 col-sm-6 mb-4 d-flex align-items-stretch\">\n");
      out.write("            <div class=\"card h-100 shadow-sm\">\n");
      out.write("                <img src=\"");
      out.print( img );
      out.write("\" class=\"card-img-top\" alt=\"");
      out.print( p.getName() );
      out.write("\">\n");
      out.write("                <div class=\"card-body d-flex flex-column\">\n");
      out.write("                    <h5 class=\"card-title\">");
      out.print( p.getName() );
      out.write("</h5>\n");
      out.write("                    <p class=\"card-text text-danger font-weight-bold mb-2\">");
      out.print( price );
      out.write(" VNĐ</p>\n");
      out.write("                    <a href=\"");
      out.print( request.getContextPath() );
      out.write("/user/search-products?action=detail&id=");
      out.print( p.getId() );
      out.write("\" class=\"btn btn-primary mt-auto\">Xem chi tiết</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

                }
            } else {
        
      out.write("\n");
      out.write("        <div class=\"col-12\">\n");
      out.write("            <div class=\"alert alert-warning text-center\" role=\"alert\">\n");
      out.write("                Không tìm thấy mỹ phẩm nào phù hợp!\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
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
