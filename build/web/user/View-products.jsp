<%@page import="dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@page import="entity.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/css7.css">
    <script src="../js/snow.js"></script>

</head>
<body>
    <div class="wrapper">
    <%@ include file="header.jsp" %>
    <section id="slideshow">
        <img src="https://cocolux.com/storage/slider/larger/1748915345-Banner%20-%20700x400px(5).webp" class="active" alt="Ảnh 1">
        <img src="https://cocolux.com/storage/slider/larger/1748680938-2CE4D301-98F0-4F2A-AF86-7325C73513A5.webp" alt="Ảnh 2">
        <img src="https://cocolux.com/storage/upload_image/images/banner/BNSCTT320251282x442.jpg" alt="Ảnh 3">
        <img src="https://cocolux.com/storage/slider/larger/1748680938-2CE4D301-98F0-4F2A-AF86-7325C73513A5.webp" alt="Ảnh 4">
        <img src="https://cocolux.com/storage/slider/larger/1744420459-BNCSVC2025_3.webp" alt="Ảnh 5">
        <img src="https://theme.hstatic.net/200000551679/1001345525/14/slider_3_master.jpg?v=302" alt="Ảnh 6">
        <div class="slideshow-dots">
            <span class="slideshow-dot active"></span>
            <span class="slideshow-dot"></span>
            <span class="slideshow-dot"></span>
            <span class="slideshow-dot"></span>
            <span class="slideshow-dot"></span>
            <span class="slideshow-dot"></span>
        </div>
    </section>

    <div class="container mt-4">
        <%
            String success = request.getParameter("success");
            if ("true".equals(success)) {
        %>
        <div class="alert alert-success text-center">
            Đặt hàng thành công! Cảm ơn bạn đã mua hàng.
        </div>
        <%
            }
        %>

        <h2 class="mb-4 text-center">Danh sách Mĩ Phẩm</h2>

        <div class="row">
            <%
                ProductDao dao = new ProductDao();
                List<Products> productList = dao.getAllProducts();
                for (Products p : productList) {
            %>
            <div class="col-md-3 mb-4">
                <div class="card product-card h-100">
                    <div class="position-relative">
                        <a href="info-products.jsp?id=<%= p.getId() %>">
                            <img src="<%= p.getImage() %>" class="product-image card-img-top" alt="<%= p.getName() %>">
                            <div class="buy-overlay">Xem chi tiết</div>
                        </a>
                    </div>
                    <div class="card-body text-center">
                        <h5 class="card-title">
                            <a href="info-products.jsp?id=<%= p.getId() %>" style="text-decoration: none; color: inherit;">
                                <%= p.getName() %>
                            </a>
                        </h5>
                        <p class="card-text"><%= p.getDescription() %></p>
                        <p class="card-text text-danger"><%= p.getPrice() %> VND</p>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>

    <script>
        const slides = document.querySelectorAll('#slideshow img');
        const dots = document.querySelectorAll('.slideshow-dot');
        let index = 0;

        function showSlide(newIndex) {
            slides[index].classList.remove('active');
            dots[index].classList.remove('active');
            index = newIndex;
            slides[index].classList.add('active');
            dots[index].classList.add('active');
        }

        function nextSlide() {
            showSlide((index + 1) % slides.length);
        }

        dots.forEach((dot, i) => {
            dot.addEventListener('click', () => {
                showSlide(i);
            });
        });

        setInterval(nextSlide, 4000);
    </script>

    <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
