<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>
    <link rel="stylesheet" href="../css/css6.css">
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
        #particles-js {
            position: fixed;
            width: 100%;
            height: 100%;
            z-index: -1;
            background: linear-gradient(to right, #ffe6f0, #ffccda);
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
    <div id="particles-js"></div>
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
<script src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>
<script>
    particlesJS("particles-js", {
        "particles": {
            "number": {
                "value": 80,
                "density": {
                    "enable": true,
                    "value_area": 800
                }
            },
            "color": {
                "value": "#ff69b4"
            },
            "shape": {
                "type": "circle"
            },
            "opacity": {
                "value": 0.5
            },
            "size": {
                "value": 4
            },
            "line_linked": {
                "enable": true,
                "distance": 150,
                "color": "#ffb6c1",
                "opacity": 0.4,
                "width": 1
            },
            "move": {
                "enable": true,
                "speed": 2
            }
        },
        "interactivity": {
            "events": {
                "onhover": {
                    "enable": true,
                    "mode": "repulse"
                }
            }
        },
        "retina_detect": true
    });
</script>
</body>

</html>
