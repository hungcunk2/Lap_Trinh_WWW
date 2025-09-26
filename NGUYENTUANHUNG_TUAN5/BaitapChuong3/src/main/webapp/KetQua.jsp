1<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả thêm sản phẩm</title>
</head>
<body>
    <jsp:include page="index.jsp" />
    <h2>Kết quả</h2>
    <% Boolean success = (Boolean)request.getAttribute("success"); %>
    <% if (success != null && success) { %>
        <p style="color:green;">Thêm sản phẩm thành công!</p>
        <a href="DanhSachDienThoaiNCCServlet">Xem danh sách sản phẩm</a>
    <% } else { %>
        <p style="color:red;">Thêm sản phẩm thất bại. Vui lòng kiểm tra lại thông tin!</p>
        <a href="product_add.jsp">Quay lại</a>
    <% } %>
</body>
</html>
