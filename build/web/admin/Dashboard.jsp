<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ Quản Lý Admin</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/css1.css">
    <script src="../js/snow.js"></script>

</head>
<body>

    <div class="navbar">
        <div class="logo" id="message"></div>
        <div class="nav-links">
            <a href="View-users.jsp" target="mainFrame">👤 Người dùng</a>
            <div class="has-submenu">
                <a href="#">🛒 Sản phẩm ▼</a>
                <div class="submenu">
                    <a href="View-products.jsp" target="mainFrame">Sản phẩm</a>
                    <a href="View-product-variants.jsp" target="mainFrame">Kho sản phẩm</a>
                    <a href="View-categories.jsp" target="mainFrame">Danh mục</a>
                </div>
            </div>

            <a href="View-orders.jsp" target="mainFrame">🧾 Đơn hàng</a>
            <a href="${pageContext.request.contextPath}/admin/StatisticsServlet" target="mainFrame">📊 Thống kê</a>
            <div class="logout">
                <a href="<%= request.getContextPath() %>/logout">🚪 Đăng xuất</a>
            </div>
        </div>
    </div>

    <iframe name="mainFrame" src="${pageContext.request.contextPath}/admin/StatisticsServlet"></iframe>

</body>

<script>
    const messages = [
        "❤️ Chúc năm mới an khang, thịnh vượng ❤️",
        "🧡 Vạn sự như ý, tấn tài tấn lộc 🧡",
        "💛 Xuân sang phúc đến, lộc về đầy nhà 💛",
        "💚 Tiền vào như nước, sức khỏe dồi dào 💚",
        "💙 Gia đình hạnh phúc, công danh rạng rỡ 💙",
        "💜 Chúc Tết phát tài, chúc Xuân như ý 💜",
        "🩷 Xuân này hơn hẳn mấy Xuân qua 🩷",
        "❤️ Cung chúc tân xuân, phúc lộc đầy nhà ❤️",
        "🧡 Tết đến trăm điều như ý, vạn sự thành công 🧡",
        "💛 Mai vàng nở rộ, phúc lộc đầy sân 💛",
        "💚 Tân niên phú quý, đắc tài đắc lộc 💚",
        "💙 Khai xuân đắc lộc, phát tài phát đạt 💙",
        "💜 Chúc bạn năm mới niềm vui bất tận 💜",
        "🩷 Cả năm rộn ràng tiếng cười hạnh phúc 🩷",
        "❤️ Vui Xuân sum họp, đón Tết bình an ❤️",
        "🧡 Lộc trời ban, phúc đầy nhà 🧡",
        "💛 Sức khỏe như rồng, tiền tài như nước 💛",
        "💚 Vui Tết đón xuân, an nhiên trọn đời 💚",
        "💙 Bốn mùa no ấm, vạn sự hanh thông 💙",
        "💜 Xuân đến hoa cười, lòng người phơi phới 💜",
        "🩷 Tết đến lộc sang, năm mới rộn ràng 🩷",
        "❤️ Trăm điều may mắn, nghìn sự như ý ❤️",
        "🧡 Gia đạo bình an, phúc thọ đầy nhà 🧡",
        "💛 Lời chúc năm mới, ngập tràn yêu thương 💛",
        "💚 Đầu năm thuận lợi, giữa năm phát tài 💚",
        "💙 Chúc bạn năm mới rạng rỡ như hoa 💙",
        "💜 Chúc Tết sung túc, trọn vẹn niềm vui 💜",
        "🩷 Xuân an khang, tết thịnh vượng 🩷",
        "❤️ Chúc bạn gặp nhiều điều tốt đẹp nhất ❤️",
        "🧡 Mừng năm mới – Mọi điều như mơ 🧡"
    ];

    let currentMessageIndex = 0;

    function changeMessage() {
        const messageElement = document.getElementById('message');
        if (messageElement) {
            messageElement.textContent = messages[currentMessageIndex];
            currentMessageIndex = (currentMessageIndex + 1) % messages.length;
        }
    }

    setInterval(changeMessage, 2000);
    changeMessage();
</script>

</html>
