<%@ page import="entity.Users" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    Users user = (Users) session.getAttribute("user");
%>

<!-- Link Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- Link Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

<!-- Link Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<!-- Custom CSS -->
<style>
    body {
    font-family: 'Poppins', sans-serif;
    background-color: #fff5f7; /* Nền hồng nhạt nhẹ nhàng */
}

header {
    background-color: #ffffff;
    border-bottom: 2px solid #fce4ec; /* Viền hồng phấn */
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
    position: sticky;
    top: 0;
    z-index: 1020;
}

.navbar-brand img {
    height: 60px;
}

.nav-link {
    color: #4a4a4a !important; /* Màu xám đậm cho chữ */
    font-weight: 500;
    padding: 0.75rem 1.25rem; /* Tăng khoảng cách giữa các mục nav */
    transition: color 0.3s ease;
}

.nav-link:hover {
    color: #f48fb1 !important; /* Hồng nhẹ khi hover */
}

.dropdown-menu {
    border-radius: 0.5rem;
    border: none;
    box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
    background-color: #fff5f7; /* Nền dropdown hồng nhạt */
}

.dropdown-item {
    color: #4a4a4a;
    transition: background-color 0.3s ease;
}

.dropdown-item:hover {
    background-color: #fce4ec; /* Nền hồng nhạt khi hover dropdown */
    color: #d81b60; /* Màu hồng đậm hơn */
}

/* Căn chỉnh form tìm kiếm và các nút */
.form-inline {
    display: flex;
    align-items: center;
    gap: 0.5rem; /* Khoảng cách giữa các phần tử */
}

.form-inline .form-control {
    border-radius: 2rem;
    border: 1px solid #f8bbd0; /* Viền hồng nhạt */
    padding: 0.5rem 1rem;
    background-color: #fff5f7; /* Nền input hồng nhạt */
    transition: border-color 0.3s ease;
}

.form-inline .form-control:focus {
    border-color: #f48fb1; /* Viền hồng đậm hơn khi focus */
    box-shadow: 0 0 0 0.2rem rgba(244, 143, 177, 0.25); /* Hiệu ứng shadow hồng nhạt */
}

/* Căn chỉnh các nút */
.form-inline .btn,
.btn-outline-primary,
.btn-outline-danger,
.btn-outline-secondary {
    border-radius: 2rem;
    padding: 0.5rem 1.25rem; /* Kích thước nút đồng đều */
    font-size: 0.875rem; /* Kích thước chữ nhỏ hơn */
    transition: all 0.3s ease;
}

.btn-outline-primary {
    border-color: #f48fb1; /* Viền hồng nhạt */
    color: #f48fb1;
}

.btn-outline-primary:hover {
    background-color: #f48fb1; /* Nền hồng nhạt */
    color: #ffffff;
    border-color: #f48fb1;
}

.btn-outline-danger {
    border-color: #ef9a9a; /* Viền hồng đỏ nhạt */
    color: #ef9a9a;
}

.btn-outline-danger:hover {
    background-color: #ef9a9a; /* Nền hồng đỏ nhạt */
    color: #ffffff;
    border-color: #ef9a9a;
}

.btn-outline-success {
    border-color: #f06292; /* Viền hồng đậm */
    color: #f06292;
}

.btn-outline-success:hover {
    background-color: #f06292; /* Nền hồng đậm */
    color: #ffffff;
    border-color: #f06292;
}

.btn-outline-secondary {
    border-color: #fce4ec; /* Viền hồng phấn */
    color: #f48fb1;
}

.btn-outline-secondary:hover {
    background-color: #fce4ec; /* Nền hồng phấn */
    color: #d81b60; /* Màu chữ hồng đậm */
}

/* Căn chỉnh user-info */
.user-info {
    font-weight: 600;
    color: #d81b60; /* Màu hồng đậm */
    margin-right: 1rem;
}

/* Responsive cho mobile */
@media (max-width: 768px) {
    .navbar-nav {
        text-align: center;
        margin-bottom: 1rem;
    }

    .form-inline {
        flex-direction: column;
        align-items: stretch;
        gap: 0.75rem;
    }

    .form-inline .form-control,
    .form-inline .btn,
    .btn-outline-primary,
    .btn-outline-danger,
    .btn-outline-secondary {
        width: 100%;
        margin-bottom: 0.5rem;
    }

    .user-info {
        margin-bottom: 0.5rem;
        text-align: center;
    }

    .d-flex.align-items-center {
        flex-direction: column;
        align-items: stretch;
        gap: 0.75rem;
    }
}
</style>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container">
            <!-- Logo -->
            <a class="navbar-brand" href="View-products.jsp">
                <img src="logo.png" alt="MyPhamShop Logo">
            </a>

            <!-- Toggle button for mobile -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar links -->
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

                <!-- User Info and Actions -->
                <div class="d-flex align-items-center">
                    <% if (user != null) { %>
                        <span class="user-info mr-3">👋 Xin chào, <%= user.getUsername() %></span>
                        <a href="<%= request.getContextPath() %>/LogoutServlet" class="btn btn-outline-danger btn-sm mr-3">Đăng xuất</a>
                    <% } else { %>
                        <a href="Login.jsp" class="btn btn-outline-primary btn-sm mr-3 d-flex align-items-center">
                            <i class="bi bi-person-circle mr-2"></i> Đăng nhập
                        </a>
                    <% } %>

                    <!-- Search Form -->
                    <form action="<%= request.getContextPath() %>/user/search-products" method="get" class="form-inline">
                        <input type="text" name="keyword" placeholder="Tìm sản phẩm..." class="form-control form-control-sm mr-2" />
                        <button type="submit" class="btn btn-sm btn-outline-success">Tìm</button>
                    </form>

                    <!-- Cart Icon -->
                    <a href="view-cart.jsp" class="btn btn-outline-secondary btn-sm ml-3">
                        <i class="bi bi-cart3"></i> Giỏ hàng
                    </a>
                </div>
            </div>
        </div>
    </nav>
</header>

<!-- Link Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
