package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Trang Chủ Quản Lý Admin</title>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        * {\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("            font-family: 'Inter', sans-serif;\n");
      out.write("            background-color: #f5f7fa;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar {\n");
      out.write("            width: 260px;\n");
      out.write("            background-color: #1e293b;\n");
      out.write("            height: 100vh;\n");
      out.write("            position: fixed;\n");
      out.write("            padding-top: 30px;\n");
      out.write("            color: white;\n");
      out.write("            overflow-y: auto;\n");
      out.write("            box-shadow: 2px 0 5px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar h3 {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 40px;\n");
      out.write("            font-size: 22px;\n");
      out.write("            font-weight: 600;\n");
      out.write("            color: #f1f5f9;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a {\n");
      out.write("            display: block;\n");
      out.write("            padding: 14px 28px;\n");
      out.write("            color: #cbd5e1;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-size: 15px;\n");
      out.write("            transition: background-color 0.2s, color 0.2s;\n");
      out.write("            border-left: 4px solid transparent;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a:hover,\n");
      out.write("        .sidebar a:focus {\n");
      out.write("            background-color: #334155;\n");
      out.write("            color: #ffffff;\n");
      out.write("            border-left: 4px solid #0ea5e9;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .submenu {\n");
      out.write("            background-color: #2c3e50;\n");
      out.write("            display: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .submenu a {\n");
      out.write("            padding-left: 45px;\n");
      out.write("            font-size: 14px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .has-submenu::after {\n");
      out.write("            content: '▼';\n");
      out.write("            float: right;\n");
      out.write("            font-size: 12px;\n");
      out.write("            margin-top: 4px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .has-submenu.active::after {\n");
      out.write("            content: '▲';\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .main-content {\n");
      out.write("            margin-left: 260px;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        iframe {\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100vh;\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logout {\n");
      out.write("            position: absolute;\n");
      out.write("            bottom: 30px;\n");
      out.write("            width: 100%;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logout a {\n");
      out.write("            color: #f87171;\n");
      out.write("            font-weight: 600;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logout a:hover {\n");
      out.write("            color: #ef4444;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <h3>Admin Panel</h3>\n");
      out.write("        <a href=\"View-users.jsp\" target=\"mainFrame\">👤 Quản lý người dùng</a>\n");
      out.write("\n");
      out.write("        <a href=\"#\" class=\"has-submenu\" onclick=\"toggleSubmenu(event)\">🛒 Quản lý sản phẩm</a>\n");
      out.write("        <div class=\"submenu\" id=\"productSubmenu\">\n");
      out.write("            <a href=\"View-products.jsp\" target=\"mainFrame\">Sản phẩm</a>\n");
      out.write("            <a href=\"View-product-variants.jsp\" target=\"mainFrame\">Kho sản phẩm</a>\n");
      out.write("            <a href=\"View-categories.jsp\" target=\"mainFrame\">Danh Mục</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <a href=\"View-orders.jsp\" target=\"mainFrame\">🧾 Quản lý đơn hàng</a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/StatisticsServlet\" target=\"mainFrame\">📊 Thống kê</a>\n");
      out.write("\n");
      out.write("        <div class=\"logout\">\n");
      out.write("            <a href=\"");
      out.print( request.getContextPath() );
      out.write("/logout\">🚪 Đăng xuất</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"main-content\">\n");
      out.write("<iframe name=\"mainFrame\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/StatisticsServlet\"></iframe>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function toggleSubmenu(e) {\n");
      out.write("            e.preventDefault();\n");
      out.write("            const link = e.target;\n");
      out.write("            link.classList.toggle('active');\n");
      out.write("            const submenu = document.getElementById('productSubmenu');\n");
      out.write("            submenu.style.display = submenu.style.display === 'block' ? 'none' : 'block';\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
