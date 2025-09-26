<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.baitapchuong3.model.Dienthoai" %>
<%@ page import="iuh.fit.se.baitapchuong3.model.Nhacungcap" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f0f0f0; }
        select { padding: 4px; }
    </style>
</head>
<body>
    <jsp:include page="index.jsp" />
    <h2>Danh sách sản phẩm theo nhà cung cấp</h2>
    <form method="get" action="DanhSachDienThoaiNCCServlet">
        <label for="mancc">Chọn nhà cung cấp:</label>
        <select name="mancc" id="mancc" onchange="this.form.submit()">
            <option value="">-- Tất cả --</option>
            <% List<Nhacungcap> nccList = (List<Nhacungcap>)request.getAttribute("nccList");
               String selectedNCC = (String)request.getAttribute("selectedNCC");
               for (Nhacungcap ncc : nccList) { %>
                <option value="<%= ncc.getMaNCC() %>" <%= ncc.getMaNCC().equals(selectedNCC) ? "selected" : "" %>>
                    <%= ncc.getTenNhaCC() %>
                </option>
            <% } %>
        </select>
    </form>
    <table>
        <tr>
            <th>Mã ĐT</th>
            <th>Tên điện thoại</th>
            <th>Năm sản xuất</th>
            <th>Cấu hình</th>
            <th>Nhà cung cấp</th>
            <th>Hình ảnh</th>
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
        </tr>
        <% } %>
    </table>
</body>
</html>
