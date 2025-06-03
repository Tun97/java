<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #ffe6f0, #ffccda);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .card {
            border: none;
            border-radius: 20px;
        }

        .card-header {
            background-color: #ff99cc;
            color: white;
            border-top-left-radius: 20px;
            border-top-right-radius: 20px;
        }

        .card-body {
            background-color: #fff0f5;
        }

        .form-control {
            border-radius: 10px;
        }

        .btn-primary {
            background-color: #ff66a3;
            border-color: #ff66a3;
            border-radius: 10px;
        }

        .btn-primary:hover {
            background-color: #ff3385;
            border-color: #ff3385;
        }

        .card-footer {
            background-color: #ffe6f0;
            border-bottom-left-radius: 20px;
            border-bottom-right-radius: 20px;
        }

        a {
            color: #ff3399;
        }

        a:hover {
            text-decoration: underline;
        }

        .alert-danger {
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header text-center">
                    <h4>Đăng ký tài khoản</h4>
                </div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/register" method="post">
                        <div class="form-group">
                            <label for="username">Tên đăng nhập</label>
                            <input type="text" name="username" class="form-control" 
                                   value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Mật khẩu</label>
                            <input type="password" name="password" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="fullname">Họ tên</label>
                            <input type="text" name="fullname" class="form-control"
                                   value="<%= request.getParameter("fullname") != null ? request.getParameter("fullname") : "" %>">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" name="email" class="form-control"
                                   value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Đăng ký</button>
                    </form>
                    <%
                        String error = (String) request.getAttribute("error");
                        if (error != null && !error.isEmpty()) {
                    %>
                    <div class="alert alert-danger mt-3"><%= error %></div>
                    <%
                        }
                    %>
                </div>
                <div class="card-footer text-center">
                    Đã có tài khoản? <a href="Login.jsp">Đăng nhập</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
