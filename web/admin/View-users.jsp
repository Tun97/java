<%@page import="dao.UsersDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, entity.Users"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Người dùng</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
     <link rel="stylesheet" href="../css/css4.css">
</head>
<body>

    <h2>Danh sách Người dùng</h2>

    <div class="center">
        <a href="UsersManagerServlet?action=AddOrEdit" class="btn">+ Thêm người dùng</a>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên người dùng</th>
                <th>Họ tên</th>
                <th>Email</th>
                <th>Quyền</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <%
                UsersDao dao = new UsersDao();
                List<Users> arrPro = dao.getAllUsers();

                if (arrPro != null && !arrPro.isEmpty()) {
                    for (Users item : arrPro) {
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getUsername() %></td>
                <td><%= item.getFullname() %></td>
                <td><%= item.getEmail() %></td>
                <td><%= item.getRole() %></td>
                <td>
                    <a class="btn" href="UsersManagerServlet?action=AddOrEdit&id=<%= item.getId() %>">Sửa</a>
                    <a class="btn delete" href="UsersManagerServlet?action=Delete&id=<%= item.getId() %>" onclick="return confirm('Bạn có chắc muốn xoá người dùng này không?')">Xoá</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6" class="no-users">Không có người dùng nào.</td>
            </tr>
            <% } %>
        </tbody>
    </table>

</body>
</html>
