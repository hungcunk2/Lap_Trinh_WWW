<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.baitapchuong3.model.Nhacungcap" %>
<%@ page import="jakarta.validation.ConstraintViolation" %>
<%@ page import="iuh.fit.se.baitapchuong3.model.Dienthoai" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
    <style>
        form { max-width: 500px; margin: 30px auto; background: #f9f9f9; padding: 20px; border-radius: 8px; }
        label { display: block; margin-top: 10px; }
        input, select, textarea { width: 100%; padding: 6px; margin-top: 4px; }
        .error { color: red; font-size: 13px; }
    </style>
    <script>
    function validateForm() {
        var maDT = document.forms["addForm"]["maDT"].value.trim();
        var tenDT = document.forms["addForm"]["tenDT"].value.trim();
        var namSX = document.forms["addForm"]["namSanXuat"].value.trim();
        var cauHinh = document.forms["addForm"]["cauHinh"].value.trim();
        var hinhAnh = document.forms["addForm"]["hinhAnh"].value;
        var yearRegex = /^\d{4}$/;
        var configRegex = /^.{1,255}$/;
        var imgRegex = /\.(png|jpg|jpeg)$/i;
        var msg = "";
        if (!maDT || !tenDT || !namSX || !cauHinh) msg += "Tất cả các trường bắt buộc phải nhập!\n";
        if (!yearRegex.test(namSX)) msg += "Năm sản xuất phải là số nguyên 4 chữ số!\n";
        if (!configRegex.test(cauHinh)) msg += "Cấu hình không quá 255 ký tự!\n";
        if (hinhAnh && !imgRegex.test(hinhAnh)) msg += "Chỉ chấp nhận hình ảnh png, jpg, jpeg!\n";
        if (msg) { alert(msg); return false; }
        return true;
    }
    </script>
</head>
<body>
    <jsp:include page="index.jsp" />
    <h2>Thêm mới sản phẩm điện thoại</h2>
    <form name="addForm" action="DienThoaiFormServlet" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
        <%
        Set<ConstraintViolation<Dienthoai>> violations = (Set<ConstraintViolation<Dienthoai>>)request.getAttribute("violations");
        Dienthoai dt = (Dienthoai)request.getAttribute("dt");
        String getErr = "";
        %>
        <script>
        function getError(field) {
            var errors = {};
            <% if (violations != null) { for (jakarta.validation.ConstraintViolation v : violations) { %>
                errors['<%= v.getPropertyPath().toString() %>'] = '<%= v.getMessage() %>';
            <% }} %>
            return errors[field] || '';
        }
        </script>
        <label for="maDT">Mã ĐT *</label>
        <input type="text" name="maDT" id="maDT" required value="<%= dt != null ? dt.getMaDT() : "" %>" />
        <span class="error"><script>document.write(getError('maDT'));</script></span>
        <label for="tenDT">Tên điện thoại *</label>
        <input type="text" name="tenDT" id="tenDT" required value="<%= dt != null ? dt.getTenDT() : "" %>" />
        <span class="error"><script>document.write(getError('tenDT'));</script></span>
        <label for="namSanXuat">Năm sản xuất *</label>
        <input type="text" name="namSanXuat" id="namSanXuat" required pattern="^\d{4}$" title="Năm sản xuất phải là số nguyên 4 chữ số" value="<%= dt != null ? dt.getNamSanXuat() : "" %>" />
        <span class="error"><script>document.write(getError('namSanXuat'));</script></span>
        <label for="cauHinh">Cấu hình *</label>
        <textarea name="cauHinh" id="cauHinh" maxlength="255" required pattern="^.{1,255}$" title="Cấu hình không quá 255 ký tự"><%= dt != null ? dt.getCauHinh() : "" %></textarea>
        <span class="error"><script>document.write(getError('cauHinh'));</script></span>
        <label for="maNCC">Nhà cung cấp *</label>
        <select name="maNCC" id="maNCC" required>
            <option value="">-- Chọn nhà cung cấp --</option>
            <% List<Nhacungcap> nccList = (List<Nhacungcap>)request.getAttribute("nccList");
                if (nccList != null && !nccList.isEmpty()) {
                    for (Nhacungcap ncc : nccList) { %>
            <option value="<%= ncc.getMaNCC() %>" <%= (dt != null && dt.getNhaCungCap() != null && ncc.getMaNCC().equals(dt.getNhaCungCap().getMaNCC())) ? "selected" : "" %>>
                <%= ncc.getTenNhaCC() %> - <%= ncc.getDiaChi() %> - <%= ncc.getSoDienThoai() %>
            </option>
            <%   }
            } else { %>
            <option disabled>Không có nhà cung cấp nào</option>
            <% } %>
        </select>
        <span class="error"><script>document.write(getError('maNCC'));</script></span>
        <label for="hinhAnh">Hình ảnh (png, jpg, jpeg)</label>
        <input type="file" name="hinhAnh" id="hinhAnh" accept=".png,.jpg,.jpeg" />
        <span class="error"><script>document.write(getError('hinhAnh'));</script></span>
        <br><br>
        <button type="submit">Thêm</button>
    </form>
</body>
</html>
