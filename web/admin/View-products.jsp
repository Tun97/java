<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Products" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
     <link rel="stylesheet" href="../css/css3.css">
</head>
<body>
<div class="container">
    <h2>Danh sách sản phẩm</h2>

    <div class="mb-3 text-end">
        <a href="<%= request.getContextPath() %>/admin/ProductsManager?action=AddOrEdit" class="btn btn-success">+ Thêm sản phẩm</a>
    </div>

    <table class="table table-bordered table-hover align-middle text-center">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Mô tả</th>
                <th>Giá</th>
                <th>Hình ảnh</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <%
                ProductDao dao = new ProductDao();
                List<Products> arrPro = dao.getAllProducts();

                if (arrPro != null && !arrPro.isEmpty()) {
                    for (Products item : arrPro) {
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getName() %></td>
                <td><%= item.getDescription() %></td>
                <td><%= String.format("%,.0f", item.getPrice()) %> VNĐ</td>
                <td>
                    <% if (item.getImage() != null && !item.getImage().isEmpty()) { %>
                        <img src="<%= item.getImage() %>" alt="Ảnh" width="80" height="80">
                    <% } else { %>
                        <span class="no-img">Không có ảnh</span>
                    <% } %>
                </td>
                <td>
                   <a class="btn btn-sm btn-primary" href="<%= request.getContextPath() %>/admin/ProductsManager?action=AddOrEdit&id=<%= item.getId() %>">Sửa</a>
                   <a class="btn btn-sm btn-danger" href="<%= request.getContextPath() %>/admin/ProductsManager?action=Delete&id=<%= item.getId() %>" onclick="return confirm('Bạn có chắc muốn xoá sản phẩm này không?')">Xóa</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6">Không có sản phẩm nào.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
</body>
</html>
