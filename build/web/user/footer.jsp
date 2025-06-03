<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer class="site-footer">
    <div class="footer-container">
        <div class="footer-column about">
            <h3>Về Chúng Tôi</h3>
            <p>Tăng Anh Tuấn - Mỹ phẩm thân thiện , sang trọng, quý phái an toàn cho trải nghiệm người dùng</p>
            <a href="#" class="read-more">Đọc thêm <i class="fas fa-arrow-right"></i></a>
        </div>
        <div class="footer-column quick-links">
            <h3>Liên Kết Nhanh</h3>
            <ul>
                <li><a href="#">Trang Chủ</a></li>
                <li><a href="#">Sản Phẩm</a></li>
                <li><a href="#">Chính Sách</a></li>
                <li><a href="#">Liên Hệ</a></li>
            </ul>
        </div>
        <div class="footer-column contact">
            <h3>Liên Hệ</h3>
            <p><i class="fas fa-map-marker-alt"></i> Tân Tiến, Tp.Bắc Giang, Việt Nam</p>
            <p><i class="fas fa-phone"></i> 0968498556</p>
            <p><i class="fas fa-envelope"></i> a20221964@eaut.edu.vn</p>
        </div>
        <div class="footer-column subscribe">
            <h3>Đăng Ký Nhận Tin</h3>
            <p>Nhận thông tin mới nhất về sản phẩm và ưu đãi!</p>
            <form class="subscribe-form">
                <input type="email" placeholder="Nhập email của bạn" required>
                <button type="submit"><i class="fas fa-paper-plane"></i> Gửi</button>
            </form>
            <div class="social-icons">
                <a href="#" aria-label="Facebook"><i class="fab fa-facebook-f"></i></a>
                <a href="#" aria-label="Instagram"><i class="fab fa-instagram"></i></a>
                <a href="#" aria-label="TikTok"><i class="fab fa-tiktok"></i></a>
                <a href="#" aria-label="YouTube"><i class="fab fa-youtube"></i></a>
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy; 2025 .</p>
    </div>
</footer>

<style>
/* Footer Styling */
.site-footer {
    background-color: #1a1a1a;
    color: #ffffff;
    padding: 60px 20px 20px;
    font-family: 'Inter', sans-serif;
    line-height: 1.6;
}

.footer-container {
    max-width: 1200px;
    margin: 0 auto;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 30px;
}

.footer-column h3 {
    font-size: 1.3em;
    margin-bottom: 20px;
    position: relative;
    color: #ffffff;
    font-weight: 600;
}

.footer-column h3::after {
    content: '';
    position: absolute;
    left: 0;
    bottom: -5px;
    width: 40px;
    height: 2px;
    background-color: #007bff;
}

.footer-column p {
    font-size: 0.9em;
    opacity: 0.8;
    margin: 10px 0;
}

.footer-column p i {
    margin-right: 10px;
    color: #007bff;
}

.footer-column ul {
    list-style: none;
    padding: 0;
}

.footer-column ul li {
    margin: 10px 0;
}

.footer-column ul li a {
    color: #ffffff;
    text-decoration: none;
    font-size: 0.9em;
    transition: color 0.3s ease;
}

.footer-column ul li a:hover {
    color: #007bff;
}

.read-more {
    color: #007bff;
    text-decoration: none;
    font-size: 0.9em;
    display: inline-flex;
    align-items: center;
    gap: 5px;
    transition: transform 0.3s ease;
}

.read-more:hover {
    transform: translateX(5px);
}

.subscribe-form {
    display: flex;
    gap: 10px;
    margin: 15px 0;
}

.subscribe-form input {
    padding: 10px;
    border: none;
    border-radius: 5px;
    flex: 1;
    font-size: 0.9em;
    background-color: #333;
    color: #fff;
}

.subscribe-form input::placeholder {
    color: #aaa;
}

.subscribe-form button {
    padding: 10px 20px;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.subscribe-form button:hover {
    background-color: #0056b3;
}

.social-icons {
    display: flex;
    gap: 15px;
    margin-top: 20px;
}

.social-icons a {
    color: #ffffff;
    font-size: 1.4em;
    transition: color 0.3s ease, transform 0.3s ease;
}

.social-icons a:hover {
    color: #007bff;
    transform: scale(1.2);
}

.footer-bottom {
    text-align: center;
    padding: 20px 0;
    border-top: 1px solid #333;
    margin-top: 40px;
    font-size: 0.85em;
    opacity: 0.7;
}

/* Responsive Design */
@media (max-width: 768px) {
    .footer-container {
        grid-template-columns: 1fr;
        text-align: center;
    }

    .footer-column h3::after {
        left: 50%;
        transform: translateX(-50%);
    }

    .social-icons {
        justify-content: center;
    }

    .subscribe-form {
        flex-direction: column;
    }

    .subscribe-form input,
    .subscribe-form button {
        width: 100%;
    }
}
</style>
```