package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.NumberFormat;

public final class Statistics_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Double totalRevenueObj = (Double) request.getAttribute("totalRevenue");
    Integer totalOrdersObj = (Integer) request.getAttribute("totalOrders");
    Integer totalUsersObj = (Integer) request.getAttribute("totalUsers");

    double totalRevenue = totalRevenueObj != null ? totalRevenueObj.doubleValue() : 0.0;
    int totalOrders = totalOrdersObj != null ? totalOrdersObj.intValue() : 0;
    int totalUsers = totalUsersObj != null ? totalUsersObj.intValue() : 0;

    List<Map<String, Object>> topProducts = (List<Map<String, Object>>) request.getAttribute("topSellingProducts");
    NumberFormat nf = NumberFormat.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Thống kê</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Inter', sans-serif;\n");
      out.write("            margin: 20px;\n");
      out.write("            background-color: #f8fafc;\n");
      out.write("            color: #1e293b;\n");
      out.write("        }\n");
      out.write("        .stat-box {\n");
      out.write("            display: flex;\n");
      out.write("            gap: 20px;\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            background: #ffffff;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 2px 8px rgba(0,0,0,0.05);\n");
      out.write("            flex: 1;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .card h2 {\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 24px;\n");
      out.write("            color: #0f172a;\n");
      out.write("        }\n");
      out.write("        .card p {\n");
      out.write("            margin-top: 8px;\n");
      out.write("            color: #64748b;\n");
      out.write("            font-size: 14px;\n");
      out.write("        }\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            background: #fff;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            overflow: hidden;\n");
      out.write("            box-shadow: 0 2px 8px rgba(0,0,0,0.05);\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            padding: 14px 18px;\n");
      out.write("            border-bottom: 1px solid #e2e8f0;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #f1f5f9;\n");
      out.write("            color: #1e293b;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <h1>📊 Trang thống kê</h1>\n");
      out.write("\n");
      out.write("    <div class=\"stat-box\">\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <h2>");
      out.print( nf.format(totalRevenue) );
      out.write(" đ</h2>\n");
      out.write("            <p>Tổng doanh thu</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <h2>");
      out.print( totalOrders );
      out.write("</h2>\n");
      out.write("            <p>Tổng đơn hàng</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <h2>");
      out.print( totalUsers );
      out.write("</h2>\n");
      out.write("            <p>Tổng khách hàng</p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <h2>🔥 Top sản phẩm bán chạy</h2>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>#</th>\n");
      out.write("            <th>Tên sản phẩm</th>\n");
      out.write("            <th>Số lượng đã bán</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

            int index = 1;
            if (topProducts != null) {
                for (Map<String, Object> p : topProducts) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( index++ );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( p.get("name") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( p.get("total_sold") );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("        <h2>📈 Biểu đồ sản phẩm bán chạy</h2>\n");
      out.write("        <canvas id=\"topSellingChart\" width=\"600\" height=\"300\"></canvas>\n");
      out.write("<script>\n");
      out.write("    const productLabels = [];\n");
      out.write("    const productQuantities = [];\n");
      out.write("\n");
      out.write("    ");
 if (topProducts != null) {
           for (Map<String, Object> p : topProducts) {
    
      out.write("\n");
      out.write("        productLabels.push(\"");
      out.print( p.get("name").toString().replace("\"", "\\\"") );
      out.write("\");\n");
      out.write("        productQuantities.push(");
      out.print( p.get("total_sold") );
      out.write(");\n");
      out.write("    ");
   }
       }
    
      out.write("\n");
      out.write("\n");
      out.write("    const ctx = document.getElementById('topSellingChart').getContext('2d');\n");
      out.write("    const topSellingChart = new Chart(ctx, {\n");
      out.write("        type: 'bar',\n");
      out.write("        data: {\n");
      out.write("            labels: productLabels,\n");
      out.write("            datasets: [{\n");
      out.write("                label: 'Số lượng đã bán',\n");
      out.write("                data: productQuantities,\n");
      out.write("                backgroundColor: 'rgba(54, 162, 235, 0.5)',\n");
      out.write("                borderColor: 'rgba(54, 162, 235, 1)',\n");
      out.write("                borderWidth: 1,\n");
      out.write("                borderRadius: 5\n");
      out.write("            }]\n");
      out.write("        },\n");
      out.write("        options: {\n");
      out.write("            plugins: {\n");
      out.write("                title: {\n");
      out.write("                    display: true,\n");
      out.write("                    text: 'Top sản phẩm bán chạy',\n");
      out.write("                    font: {\n");
      out.write("                        size: 18\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            scales: {\n");
      out.write("                y: {\n");
      out.write("                    beginAtZero: true,\n");
      out.write("                    title: {\n");
      out.write("                        display: true,\n");
      out.write("                        text: 'Số lượng'\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                x: {\n");
      out.write("                    title: {\n");
      out.write("                        display: true,\n");
      out.write("                        text: 'Sản phẩm'\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("</script>\n");
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
