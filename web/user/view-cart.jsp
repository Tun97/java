<%@ page import="java.util.List" %>
<%@ page import="entity.CartBean" %>
<%@ page import="entity.ProductVariants" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        body {
                background: linear-gradient(to right, #fff0f5, #ffe6f0);
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                font-size: 16px; /* Tăng kích thước chữ cơ bản */
            }
            .wrapper {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }

            .wrapper > main {
                flex: 1;
            }


            h2 {
                text-align: center;
                color: #c2185b;
                margin: 40px 0;
                font-size: 2.5em; /* Tăng kích thước tiêu đề */
            }

            .btn-primary {
                background-color: #f48fb1;
                border-color: #f48fb1;
                color: white;
                padding: 10px 20px; /* Tăng kích thước nút */
                font-size: 1.1em;
            }

            .btn-primary:hover {
                background-color: #ec407a;
                border-color: #ec407a;
            }

            .btn-success {
                background-color: #f06292;
                border-color: #f06292;
                color: white;
                padding: 10px 20px;
                font-size: 1.1em;
            }

            .btn-success:hover {
                background-color: #e91e63;
                border-color: #e91e63;
            }

            .btn-danger {
                background-color: #ef5350;
                border-color: #ef5350;
                color: white;
                padding: 8px 16px; /* Tăng kích thước nút xóa */
                font-size: 1em;
            }

            .btn-danger:hover {
                background-color: #e53935;
                border-color: #e53935;
            }

            .table {
                background-color: #ffffff;
                border-radius: 12px;
                box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
                width: 90%; /* Tăng chiều rộng bảng */
                margin: 0 auto; /* Căn giữa bảng */
            }

            th {
                background-color: #f8bbd0;
                color: #880e4f;
                text-align: center;
                padding: 15px; /* Tăng padding cho tiêu đề */
                font-size: 1.2em; /* Tăng kích thước chữ tiêu đề */
            }

            td {
                text-align: center;
                vertical-align: middle;
                padding: 12px; /* Tăng padding cho ô */
                font-size: 1.1em; /* Tăng kích thước chữ */
            }

            .container {
                margin-top: 60px;
                max-width: 1200px; /* Tăng chiều rộng container */
            }

            .mb-3 {
                margin-bottom: 30px;
                display: flex;
                justify-content: flex-start; /* Căn trái các nút */
                gap: 15px; /* Khoảng cách giữa các nút */
            }

            strong {
                color: #c2185b;
                font-size: 1.2em; /* Tăng kích thước chữ tổng */
            }
    </style>
</head>

<body>
<div class="wrapper">
<%@ include file="header.jsp" %>
<main>
<div class="container">
    <h2>Giỏ hàng</h2>
    <div class="mb-3">
        <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/user/View-products.jsp">Thêm sản phẩm</a>
        <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/user/checkout">Thanh toán</a>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã Biến Thể</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<CartBean> cart = (List<CartBean>) session.getAttribute("cart");
            if (cart != null && !cart.isEmpty()) {
                double total = 0;
                for (int i = 0; i < cart.size(); i++) {
                    CartBean item = cart.get(i);
                    ProductVariants variant = item.getProductVariant();
                    double price = variant.getPrice(); 
                    int quantity = item.getQuantity();
                    double subtotal = price * quantity;
                    total += subtotal;
        %>
        <tr>
            <td><%= i + 1 %></td>
            <td><%= variant.getId() %></td>
            <td><%= variant.getProductName() %></td>
            <td><%= price %></td>
            <td><%= quantity %></td>
            <td><%= subtotal %></td>
            <td>
                <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/user/remove-from-cart?index=<%= i %>">Xóa</a>
            </td>
        </tr>
        <%  } %>
        <tr>
            <td colspan="5" class="text-right"><strong>Tổng:</strong></td>
            <td colspan="2"><strong><%= total %></strong></td>
        </tr>
        <%
            } else {
        %>
        <tr>
            <td colspan="7" class="text-center">Giỏ hàng trống</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</main>
<%@ include file="footer.jsp" %>
</div>
</body>
</html>
