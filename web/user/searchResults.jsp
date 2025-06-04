<%@ page import="java.util.List" %>
<%@ page import="entity.Products" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả tìm kiếm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp" />
<main>
<div class="container mt-4">
    <h2 class="text-center mb-4 text-primary">Kết quả tìm kiếm</h2>
    <div class="row">
        <%
            List<Products> productList = (List<Products>) request.getAttribute("productList");
            if (productList != null && !productList.isEmpty()) {
                for (Products p : productList) {
                    String img = (p.getImage() != null) ? p.getImage() : "images/default.jpg";
                    String price = String.format("%,d", (int) p.getPrice());
        %>
        <div class="col-md-4 col-sm-6 mb-4 d-flex align-items-stretch">
            <div class="card h-100 shadow-sm">
                <img src="<%= img %>" class="card-img-top" alt="<%= p.getName() %>">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title"><%= p.getName() %></h5>
                    <p class="card-text text-danger font-weight-bold mb-2"><%= price %> VNĐ</p>
                    <a href="<%= request.getContextPath() %>/user/search-products?action=detail&id=<%= p.getId() %>" class="btn btn-primary mt-auto">Xem chi tiết</a>
                </div>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <div class="col-12">
            <div class="alert alert-warning text-center" role="alert">
                Không tìm thấy mỹ phẩm nào phù hợp!
            </div>
        </div>
        <% } %>
    </div>
</div>
</main>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>
