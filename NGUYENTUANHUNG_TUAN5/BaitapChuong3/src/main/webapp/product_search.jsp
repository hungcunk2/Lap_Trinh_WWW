<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.baitapchuong3.model.Nhacungcap" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tìm kiếm nhà cung cấp</title>
    <style>
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f0f0f0; }
        form { margin: 20px 0; }
    </style>
</head>
<body>
    <jsp:include page="index.jsp" />
    <div class="content">
        <h2>Tìm kiếm nhà cung cấp</h2>
        <form method="get" action="NhaCungCapSearchServlet">
            <input type="text" name="keyword" placeholder="Nhập mã, tên, địa chỉ hoặc số điện thoại" value="<%= request.getAttribute("keyword") != null ? request.getAttribute("keyword") : "" %>" style="width:300px;" />
            <button type="submit">Tìm kiếm</button>
        </form>
        <table>
            <tr>
                <th>Mã NCC</th>
                <th>Tên nhà cung cấp</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
            </tr>
            <% List<Nhacungcap> nccList = (List<Nhacungcap>)request.getAttribute("nccList");
               if (nccList != null) for (Nhacungcap ncc : nccList) { %>
            <tr>
                <td><%= ncc.getMaNCC() %></td>
                <td><%= ncc.getTenNhaCC() %></td>
                <td><%= ncc.getDiaChi() %></td>
                <td><%= ncc.getSoDienThoai() %></td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>

