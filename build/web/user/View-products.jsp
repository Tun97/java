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
    <style>
       body {
    font-family: 'Inter', sans-serif;
    background-color: #fff5f7; /* Nền hồng phấn nhạt */
    color: #4a4a4a; /* Màu chữ xám đậm nhẹ */
}
.wrapper {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

.wrapper > main {
    flex: 1;
}


/* Slideshow Styling */
#slideshow {
    max-width: 900px; /* Tăng nhẹ chiều rộng */
    margin: 30px auto;
    position: relative;
    overflow: hidden;
    border-radius: 12px; /* Bo góc mềm mại hơn */
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08); /* Shadow nhẹ */
    background-color: #ffffff; /* Nền trắng để nổi bật */
}

#slideshow img {
    width: 100%;
    height: 350px; /* Tăng chiều cao ảnh */
    object-fit: cover;
    display: none;
    transition: opacity 0.6s ease; /* Hiệu ứng chuyển mượt hơn */
}

#slideshow img.active {
    display: block;
    opacity: 1;
}

.slideshow-dots {
    position: absolute;
    bottom: 20px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    gap: 12px; /* Tăng khoảng cách giữa các chấm */
}

.slideshow-dot {
    width: 12px; /* Chấm to hơn */
    height: 12px;
    background-color: #f8bbd0; /* Hồng nhạt */
    border-radius: 50%;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.slideshow-dot.active {
    background-color: #f06292; /* Hồng đậm hơn khi active */
}

/* Product Card Styling */
.product-card {
    border: none;
    border-radius: 12px; /* Bo góc mềm mại hơn */
    overflow: hidden;
    background-color: #ffffff; /* Nền trắng cho card */
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.product-card:hover {
    transform: translateY(-8px); /* Nâng nhẹ khi hover */
    box-shadow: 0 8px 20px rgba(240, 98, 146, 0.15); /* Shadow hồng nhạt */
}

.product-image {
    height: 220px; /* Tăng chiều cao ảnh sản phẩm */
    object-fit: cover;
    border-top-left-radius: 12px;
    border-top-right-radius: 12px;
}

.buy-overlay {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(244, 143, 177, 0.75); /* Nền hồng nhạt trong suốt */
    color: #ffffff;
    display: flex;
    align-items: center;
    justify-content: center;
    opacity: 0;
    transition: opacity 0.3s ease;
    font-size: 1.1em;
    font-weight: 500;
    text-decoration: none;
}

.product-card:hover .buy-overlay {
    opacity: 1;
}

.card-body {
    padding: 20px; /* Tăng padding cho thoải mái */
    text-align: center;
}

.card-title {
    font-size: 1.25em;
    margin-bottom: 12px;
    font-weight: 600;
    color: #d81b60; /* Màu hồng đậm cho tiêu đề */
}

.card-title a {
    text-decoration: none;
    color: inherit;
}

.card-text {
    font-size: 0.95em;
    color: #666; /* Màu xám nhạt */
    margin-bottom: 10px;
}

.text-danger {
    font-size: 1.15em;
    font-weight: 600;
    color: #f06292; /* Màu hồng đậm cho giá */
}

.alert-success {
    max-width: 600px;
    margin: 20px auto;
    border-radius: 8px;
    background-color: #fce4ec; /* Nền hồng phấn cho thông báo */
    color: #d81b60; /* Màu chữ hồng đậm */
    border: 1px solid #f8bbd0; /* Viền hồng nhạt */
}

/* Responsive Design */
@media (max-width: 768px) {
    #slideshow img {
        height: 250px; /* Giảm chiều cao ảnh cho mobile */
    }

    .product-image {
        height: 180px; /* Giảm chiều cao ảnh sản phẩm */
    }

    .col-md-3 {
        flex: 0 0 50%;
        max-width: 50%;
    }

    .card-body {
        padding: 15px;
    }

    .card-title {
        font-size: 1.1em;
    }
}

@media (max-width: 576px) {
    #slideshow img {
        height: 200px;
    }

    .col-md-3 {
        flex: 0 0 100%;
        max-width: 100%;
    }

    .product-image {
        height: 200px;
    }
}
    </style>
</head>
<body>
    <div class="wrapper">
    <%@ include file="header.jsp" %>
    <section id="slideshow">
        <img src="https://cocolux.com/storage/slider/larger/1748915345-Banner%20-%20700x400px(5).webp" class="active" alt="Ảnh 1">
        <img src="https://cocolux.com/storage/slider/larger/1748680938-2CE4D301-98F0-4F2A-AF86-7325C73513A5.webp" alt="Ảnh 2">
        <div class="slideshow-dots">
            <span class="slideshow-dot active"></span>
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
```