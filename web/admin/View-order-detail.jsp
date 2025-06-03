<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entity.OrderDetails"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đơn hàng</title>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="mb-0">Chi tiết đơn hàng #<%= request.getAttribute("ORDER_ID") %></h2>
        <a href="?action=AddOrEdit&orderId=<%= request.getAttribute("ORDER_ID") %>" class="btn btn-success">
            + Thêm chi tiết mới
        </a>
    </div>

    <div class="table-responsive">
        <table class="table table-striped table-bordered align-middle">
            <thead class="table-dark text-center">
                <tr>
                    <th>ID</th>
                    <th>Product Variant ID</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<OrderDetails> list = (List<OrderDetails>) request.getAttribute("DETAILS");
                if (list != null && !list.isEmpty()) {
                    for (OrderDetails od : list) {
            %>
                <tr>
                    <td class="text-center"><%= od.getId() %></td>
                    <td class="text-center"><%= od.getProductVariantId() %></td>
                    <td><%= od.getProductName() != null ? od.getProductName() : "Không rõ" %></td>
                    <td class="text-center"><%= od.getQuantity() %></td>
                    <td class="text-end"><%= od.getPrice() %></td>
                    <td class="text-center">
                        <a href="?action=AddOrEdit&id=<%= od.getId() %>&orderId=<%= od.getOrderId() %>" class="btn btn-primary btn-sm me-1">Sửa</a>
                        <a href="?action=Delete&id=<%= od.getId() %>&orderId=<%= od.getOrderId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa chi tiết này?');">Xóa</a>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="6" class="text-center text-muted">Không có chi tiết đơn hàng nào.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <div class="mt-4">
        <a href="<%=request.getContextPath()%>/admin/OrderManagerServlet" class="btn btn-secondary">
            ← Quay lại danh sách đơn hàng
        </a>
    </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
