<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.baitapchuong3.model.Dienthoai" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý sản phẩm</title>
    <style>
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f0f0f0; }
        form { display: inline; }
    </style>
</head>
<body>
    <jsp:include page="index.jsp" />
    <h2>Quản lý sản phẩm (Xóa sản phẩm)</h2>
    <table>
        <tr>
            <th>Mã ĐT</th>
            <th>Tên điện thoại</th>
            <th>Năm sản xuất</th>
            <th>Cấu hình</th>
            <th>Nhà cung cấp</th>
            <th>Hình ảnh</th>
            <th>Hành động</th>
        </tr>
        <% List<Dienthoai> dtList = (List<Dienthoai>)request.getAttribute("dtList");
           for (Dienthoai dt : dtList) { %>
        <tr>
            <td><%= dt.getMaDT() %></td>
            <td><%= dt.getTenDT() %></td>
            <td><%= dt.getNamSanXuat() %></td>
            <td><%= dt.getCauHinh() %></td>
            <td><%= dt.getNhaCungCap() != null ? dt.getNhaCungCap().getMaNCC() : "" %></td>
            <td>
                <% if (dt.getHinhAnh() != null && !dt.getHinhAnh().isEmpty()) { %>
                    <img src="images/<%= dt.getHinhAnh() %>" alt="Hình ảnh" style="height:40px;" />
                <% } %>
            </td>
            <td>
                <form method="post" action="QuanLyFormServlet" onsubmit="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">
                    <input type="hidden" name="maDT" value="<%= dt.getMaDT() %>" />
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
