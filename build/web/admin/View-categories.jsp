<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, entity.Category"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Danh Mục</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/css2.css">
</head>
<body>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <div class="alert alert-success">
        <%= message %>
    </div>
    <%
        }
    %>
    
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <div class="alert alert-error">
        <%= error %>
    </div>
    <%
        }
    %>

    <h2>Danh sách Danh Mục</h2>
    <%
        Integer count = (Integer) request.getAttribute("count");
        if (count != null) {
    %>
    <div class="count-info">
        Tổng số danh mục: <strong><%= count %></strong>
    </div>
    <%
        }
    %>  
    <div class="center">
        <a href="CategoriesManagerServlet?action=AddOrEdit" class="btn">+ Thêm Danh Mục mới</a>
    </div>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên Danh Mục</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <%
                @SuppressWarnings("unchecked")
                List<Category> list = (List<Category>) request.getAttribute("list");
                if (list != null && !list.isEmpty()) {
                    for (Category item : list) {
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getCategoryName() != null ? item.getCategoryName() : "" %></td>
                <td>
                    <a class="btn" href="CategoriesManagerServlet?action=AddOrEdit&id=<%= item.getId() %>">Sửa</a>
                    <a class="btn delete" href="CategoriesManagerServlet?action=Delete&id=<%= item.getId() %>" 
                       onclick="return confirm('Bạn có chắc muốn xoá danh mục \'<%= item.getCategoryName() %>\' không?')">Xoá</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3" class="no-data">
                    Không có danh mục nào. <a href="CategoriesManagerServlet?action=AddOrEdit">Thêm danh mục đầu tiên</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>