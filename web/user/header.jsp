<%@ page import="entity.Users" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    Users user = (Users) session.getAttribute("user");
%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="../css/css10.css">

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container">
            <!-- Logo -->
            <a class="navbar-brand" href="View-products.jsp">
                <img src="logo.png" alt="MyPhamShop Logo">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarContent">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="trangDiemDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            TRANG ĐIỂM
                        </a>
                        <div class="dropdown-menu" aria-labelledby="trangDiemDropdown">
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=Son">Son môi</a>
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=Phấn">Phấn nền</a>
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=Kẻ mắt">Kẻ mắt</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="chamSocDaDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            CHĂM SÓC DA
                        </a>
                        <div class="dropdown-menu" aria-labelledby="chamSocDaDropdown">
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=gội">Dầu gội</a>
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=Serum">Serum</a>
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=Kem dưỡng">Kem dưỡng</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="nuocHoaDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            NƯỚC HOA
                        </a>
                        <div class="dropdown-menu" aria-labelledby="nuocHoaDropdown">
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=nước hoa nữ">Nước hoa nữ</a>
                            <a class="dropdown-item" href="<%= request.getContextPath() %>/user/search-products?keyword=nam">Nước hoa nam</a>
                        </div>
                    </li>
                </ul>

                <div class="d-flex align-items-center">
                    <!-- Search Form -->
                    <form action="<%= request.getContextPath() %>/user/search-products" method="get" class="form-inline mr-3">
                        <input type="text" name="keyword" placeholder="Tìm sản phẩm..." class="form-control form-control-sm mr-2" />
                        <button type="submit" class="btn btn-sm btn-outline-success">Tìm</button>
                    </form>

                    <!-- Cart Icon -->
                    <a href="view-cart.jsp" class="btn btn-outline-secondary btn-sm ml-3 mr-3">
                        <i class="bi bi-cart3"></i> Giỏ hàng
                    </a>

                    <% if (user != null) { %>
                        <span class="user-info mr-3">👋 Xin chào, <%= user.getFullname() %></span>
                        <a href="<%= request.getContextPath() %>/LogoutServlet" class="btn btn-outline-danger btn-sm">Đăng xuất</a>
                    <% } else { %>
                        <a href="Login.jsp" class="btn btn-outline-primary btn-sm d-flex align-items-center">
                            <i class="bi bi-person-circle mr-2"></i> Đăng nhập
                        </a>
                    <% } %>
                </div>
            </div>
        </div>
    </nav>
</header>

<!-- Link Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
