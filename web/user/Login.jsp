<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/css5.css">
</head>
<style>
            html, body {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            overflow: hidden;
        }

        #particles-js {
            position: fixed;
            width: 100%;
            height: 100%;
            z-index: -1;
            background: linear-gradient(to right, #ffe6f0, #ffccda);
        }

        .container {
            position: relative;
            z-index: 1;
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

        .btn-success {
            background-color: #ff66a3;
            border-color: #ff66a3;
            border-radius: 10px;
        }

        .btn-success:hover {
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
<body>
<!-- Hiệu ứng nền hạt cát -->
<div id="particles-js"></div>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header text-center">
                    <h4>Đăng nhập</h4>
                </div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="form-group">
                            <label for="username">Tên đăng nhập</label>
                            <input type="text" name="username" class="form-control" value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Mật khẩu</label>
                            <input type="password" name="password" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-success btn-block">Đăng nhập</button>
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
                    Chưa có tài khoản? <a href="Register.jsp">Đăng ký ngay</a>
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
