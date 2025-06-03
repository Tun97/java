package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import dao.ProductDao;
import entity.Products;
import java.util.List;

public final class View_002dproducts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Quản lý sản phẩm</title>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #f9fafb;\n");
      out.write("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            background-color: #fff;\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 10px rgba(0,0,0,0.05);\n");
      out.write("            margin-top: 40px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            color: #1f2937;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-success {\n");
      out.write("            background-color: #22c55e;\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-success:hover {\n");
      out.write("            background-color: #16a34a;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-primary {\n");
      out.write("            background-color: #3b82f6;\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-primary:hover {\n");
      out.write("            background-color: #2563eb;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-danger {\n");
      out.write("            background-color: #ef4444;\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-danger:hover {\n");
      out.write("            background-color: #dc2626;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table img {\n");
      out.write("            border-radius: 6px;\n");
      out.write("            object-fit: cover;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .no-img {\n");
      out.write("            color: #9ca3af;\n");
      out.write("            font-style: italic;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>Danh sách sản phẩm</h2>\n");
      out.write("\n");
      out.write("    <div class=\"mb-3 text-end\">\n");
      out.write("        <a href=\"");
      out.print( request.getContextPath() );
      out.write("/admin/ProductsManager?action=AddOrEdit\" class=\"btn btn-success\">+ Thêm sản phẩm</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <table class=\"table table-bordered table-hover align-middle text-center\">\n");
      out.write("        <thead class=\"table-dark\">\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Tên</th>\n");
      out.write("                <th>Mô tả</th>\n");
      out.write("                <th>Giá</th>\n");
      out.write("                <th>Hình ảnh</th>\n");
      out.write("                <th>Hành động</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                ProductDao dao = new ProductDao();
                List<Products> arrPro = dao.getAllProducts();

                if (arrPro != null && !arrPro.isEmpty()) {
                    for (Products item : arrPro) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( item.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( item.getName() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( item.getDescription() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( String.format("%,.0f", item.getPrice()) );
      out.write(" VNĐ</td>\n");
      out.write("                <td>\n");
      out.write("                    ");
 if (item.getImage() != null && !item.getImage().isEmpty()) { 
      out.write("\n");
      out.write("                        <img src=\"images/");
      out.print( item.getImage() );
      out.write("\" alt=\"Ảnh\" width=\"80\" height=\"80\">\n");
      out.write("                    ");
 } else { 
      out.write("\n");
      out.write("                        <span class=\"no-img\">Không có ảnh</span>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                   <a class=\"btn btn-sm btn-primary\" href=\"");
      out.print( request.getContextPath() );
      out.write("/admin/ProductsManager?action=AddOrEdit&id=");
      out.print( item.getId() );
      out.write("\">Sửa</a>\n");
      out.write("                   <a class=\"btn btn-sm btn-danger\" href=\"");
      out.print( request.getContextPath() );
      out.write("/admin/ProductsManager?action=Delete&id=");
      out.print( item.getId() );
      out.write("\" onclick=\"return confirm('Bạn có chắc muốn xoá sản phẩm này không?')\">Xóa</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                } else {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"6\">Không có sản phẩm nào.</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
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
