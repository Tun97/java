<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, entity.Category"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Danh Mục</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-color: #f5f7fa;
            margin: 0;
            padding: 0;
            color: #333;
        }
        h2 {
            text-align: center;
            margin-top: 30px;
            color: #1e293b;
        }
        .center {
            text-align: center;
            margin-bottom: 20px;
        }
        .btn {
            display: inline-block;
            padding: 8px 16px;
            margin: 10px 5px;
            background-color: #3b82f6;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #2563eb;
            color: white;
            text-decoration: none;
        }
        .btn.delete {
            background-color: #ef4444;
        }
        .btn.delete:hover {
            background-color: #dc2626;
        }
        table {
            width: 60%;
            margin: 0 auto 40px;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px 16px;
            text-align: center;
            border-bottom: 1px solid #e5e7eb;
        }
        th {
            background-color: #f1f5f9;
            color: #334155;
            font-weight: 600;
        }
        tr:hover {
            background-color: #f9fafb;
        }
        .no-data {
            text-align: center;
            padding: 20px;
            color: #64748b;
        }
        .alert {
            width: 60%;
            margin: 20px auto;
            padding: 15px;
            border-radius: 6px;
        }
        .alert-success {
            background-color: #d1fae5;
            color: #065f46;
            border: 1px solid #10b981;
        }
        .alert-error {
            background-color: #fee2e2;
            color: #991b1b;
            border: 1px solid #ef4444;
        }
        .count-info {
            text-align: center;
            margin-bottom: 10px;
            color: #6b7280;
        }
    </style>
</head>
<body>
    <!-- Hiển thị thông báo thành công -->
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
    
    <!-- Hiển thị số lượng -->
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