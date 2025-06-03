<%@page import="entity.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
<%
    String action = (String) request.getAttribute("ACTION");
    Category category = (Category) request.getAttribute("CATEGORY");
    if (action == null) action = "SaveOrUpdate";
    if (category == null) category = new Category();
%>
<div class="container" style="margin-top: 10px;">
    <div class="row" style="border: 1px solid darkgrey; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <h2>Category Manager</h2>
            <form action="CategoriesManagerServlet" method="post"> 
                <input type="hidden" name="action" value="<%=action%>">
                
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" class="form-control" name="id" value="<%=category.getId()%>" readonly>
                </div>
                
                <div class="form-group">
                    <label>Category Name <span style="color: red;">*</span></label>
                    <input type="text" class="form-control" name="categoryName" value="<%=category.getCategoryName() != null ? category.getCategoryName() : ""%>" required>
                </div>
                
                <input type="submit" class="btn btn-primary" value="<%=category.getId() > 0 ? "Cập nhật" : "Thêm mới"%>">
                <a href="CategoriesManagerServlet?action=List" class="btn btn-default">Xem Danh Mục</a>
            </form>
        </div>
    </div>
</div>

<!-- Hiển thị thông báo lỗi nếu có -->
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<div class="container" style="margin-top: 20px;">
    <div class="alert alert-danger">
        <%= error %>
    </div>
</div>
<%
    }
%>

<!-- Hiển thị thông báo thành công nếu có -->
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
<div class="container" style="margin-top: 20px;">
    <div class="alert alert-success">
        <%= message %>
    </div>
</div>
<%
    }
%>

</body>
</html>