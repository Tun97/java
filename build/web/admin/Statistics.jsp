<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.NumberFormat" %>
<%
    Double totalRevenueObj = (Double) request.getAttribute("totalRevenue");
    Integer totalOrdersObj = (Integer) request.getAttribute("totalOrders");
    Integer totalUsersObj = (Integer) request.getAttribute("totalUsers");

    double totalRevenue = totalRevenueObj != null ? totalRevenueObj.doubleValue() : 0.0;
    int totalOrders = totalOrdersObj != null ? totalOrdersObj.intValue() : 0;
    int totalUsers = totalUsersObj != null ? totalUsersObj.intValue() : 0;

    List<Map<String, Object>> topProducts = (List<Map<String, Object>>) request.getAttribute("topSellingProducts");
    NumberFormat nf = NumberFormat.getInstance();
%>

<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <meta charset="UTF-8">
    <title>Thống kê</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            margin: 20px;
            background-color: #f8fafc;
            color: #1e293b;
        }
        .stat-box {
            display: flex;
            gap: 20px;
            margin-bottom: 30px;
        }
        .card {
            background: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
            flex: 1;
            text-align: center;
        }
        .card h2 {
            margin: 0;
            font-size: 24px;
            color: #0f172a;
        }
        .card p {
            margin-top: 8px;
            color: #64748b;
            font-size: 14px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }
        th, td {
            padding: 14px 18px;
            border-bottom: 1px solid #e2e8f0;
            text-align: left;
        }
        th {
            background-color: #f1f5f9;
            color: #1e293b;
        }

        .chart-container {
            max-width: 600px;
            margin: 40px auto;
            background: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }
        canvas {
            width: 100% !important;
            height: auto !important;
        }
    </style>
</head>
<body>

    <h1>📊 Trang thống kê</h1>

    <div class="stat-box">
        <div class="card">
            <h2><%= nf.format(totalRevenue) %> đ</h2>
            <p>Tổng doanh thu</p>
        </div>
        <div class="card">
            <h2><%= totalOrders %></h2>
            <p>Tổng đơn hàng</p>
        </div>
        <div class="card">
            <h2><%= totalUsers %></h2>
            <p>Tổng khách hàng</p>
        </div>
    </div>

    <h2>🔥 Top mỹ phẩm bán chạy</h2>
    <table>
        <tr>
            <th>#</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng đã bán</th>
        </tr>
        <%
            int index = 1;
            if (topProducts != null) {
                for (Map<String, Object> p : topProducts) {
        %>
        <tr>
            <td><%= index++ %></td>
            <td><%= p.get("name") %></td>
            <td><%= p.get("total_sold") %></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <h2 style="text-align: center;">📈 Biểu đồ Mỹ phẩm bán chạy</h2>
    <div class="chart-container">
        <canvas id="topSellingChart"></canvas>
    </div>

    <script>
        const productLabels = [];
        const productQuantities = [];

        <% if (topProducts != null) {
               for (Map<String, Object> p : topProducts) {
        %>
            productLabels.push("<%= p.get("name").toString().replace("\"", "\\\"") %>");
            productQuantities.push(<%= p.get("total_sold") %>);
        <%   }
           }
        %>

        const ctx = document.getElementById('topSellingChart').getContext('2d');
        const topSellingChart = new Chart(ctx, {
            type: 'pie', // Chuyển sang biểu đồ tròn
            data: {
                labels: productLabels,
                datasets: [{
                    label: 'Số lượng đã bán',
                    data: productQuantities,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.6)',
                        'rgba(54, 162, 235, 0.6)',
                        'rgba(255, 206, 86, 0.6)',
                        'rgba(75, 192, 192, 0.6)',
                        'rgba(153, 102, 255, 0.6)',
                        'rgba(255, 159, 64, 0.6)',
                        'rgba(199, 199, 199, 0.6)'
                    ],
                    borderColor: '#fff',
                    borderWidth: 1
                }]
            },
            options: {
                plugins: {
                    title: {
                        display: true,
                        text: 'Tỉ lệ sản phẩm bán chạy',
                        font: {
                            size: 18
                        }
                    },
                    legend: {
                        position: 'right'
                    }
                }
            }
        });
    </script>

</body>
</html>
