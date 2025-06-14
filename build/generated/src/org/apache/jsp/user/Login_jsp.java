package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Đăng nhập</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        html, body {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            height: 100%;\n");
      out.write("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("            overflow: hidden;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #particles-js {\n");
      out.write("            position: fixed;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100%;\n");
      out.write("            z-index: -1;\n");
      out.write("            background: linear-gradient(to right, #ffe6f0, #ffccda);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            position: relative;\n");
      out.write("            z-index: 1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card {\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card-header {\n");
      out.write("            background-color: #ff99cc;\n");
      out.write("            color: white;\n");
      out.write("            border-top-left-radius: 20px;\n");
      out.write("            border-top-right-radius: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card-body {\n");
      out.write("            background-color: #fff0f5;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-control {\n");
      out.write("            border-radius: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-success {\n");
      out.write("            background-color: #ff66a3;\n");
      out.write("            border-color: #ff66a3;\n");
      out.write("            border-radius: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-success:hover {\n");
      out.write("            background-color: #ff3385;\n");
      out.write("            border-color: #ff3385;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card-footer {\n");
      out.write("            background-color: #ffe6f0;\n");
      out.write("            border-bottom-left-radius: 20px;\n");
      out.write("            border-bottom-right-radius: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a {\n");
      out.write("            color: #ff3399;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .alert-danger {\n");
      out.write("            border-radius: 10px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- Hiệu ứng nền hạt cát -->\n");
      out.write("<div id=\"particles-js\"></div>\n");
      out.write("\n");
      out.write("<div class=\"container mt-5\">\n");
      out.write("    <div class=\"row justify-content-center\">\n");
      out.write("        <div class=\"col-md-6\">\n");
      out.write("            <div class=\"card shadow\">\n");
      out.write("                <div class=\"card-header text-center\">\n");
      out.write("                    <h4>Đăng nhập</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"username\">Tên đăng nhập</label>\n");
      out.write("                            <input type=\"text\" name=\"username\" class=\"form-control\" value=\"");
      out.print( request.getParameter("username") != null ? request.getParameter("username") : "" );
      out.write("\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"password\">Mật khẩu</label>\n");
      out.write("                            <input type=\"password\" name=\"password\" class=\"form-control\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success btn-block\">Đăng nhập</button>\n");
      out.write("                    </form>\n");
      out.write("                    ");

                        String error = (String) request.getAttribute("error");
                        if (error != null && !error.isEmpty()) {
                    
      out.write("\n");
      out.write("                    <div class=\"alert alert-danger mt-3\">");
      out.print( error );
      out.write("</div>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-footer text-center\">\n");
      out.write("                    Chưa có tài khoản? <a href=\"Register.jsp\">Đăng ký ngay</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Thư viện particles.js -->\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("    particlesJS(\"particles-js\", {\n");
      out.write("        \"particles\": {\n");
      out.write("            \"number\": {\n");
      out.write("                \"value\": 80,\n");
      out.write("                \"density\": {\n");
      out.write("                    \"enable\": true,\n");
      out.write("                    \"value_area\": 800\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            \"color\": {\n");
      out.write("                \"value\": \"#ff69b4\"\n");
      out.write("            },\n");
      out.write("            \"shape\": {\n");
      out.write("                \"type\": \"circle\"\n");
      out.write("            },\n");
      out.write("            \"opacity\": {\n");
      out.write("                \"value\": 0.5\n");
      out.write("            },\n");
      out.write("            \"size\": {\n");
      out.write("                \"value\": 4\n");
      out.write("            },\n");
      out.write("            \"line_linked\": {\n");
      out.write("                \"enable\": true,\n");
      out.write("                \"distance\": 150,\n");
      out.write("                \"color\": \"#ffb6c1\",\n");
      out.write("                \"opacity\": 0.4,\n");
      out.write("                \"width\": 1\n");
      out.write("            },\n");
      out.write("            \"move\": {\n");
      out.write("                \"enable\": true,\n");
      out.write("                \"speed\": 2\n");
      out.write("            }\n");
      out.write("        },\n");
      out.write("        \"interactivity\": {\n");
      out.write("            \"events\": {\n");
      out.write("                \"onhover\": {\n");
      out.write("                    \"enable\": true,\n");
      out.write("                    \"mode\": \"repulse\"\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        },\n");
      out.write("        \"retina_detect\": true\n");
      out.write("    });\n");
      out.write("</script>\n");
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
