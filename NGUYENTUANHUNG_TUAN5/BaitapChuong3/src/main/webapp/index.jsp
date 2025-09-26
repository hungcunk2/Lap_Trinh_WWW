<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý điện thoại</title>
    <style>
        body { margin: 0; font-family: Arial, sans-serif; }
        .header { text-align: center; padding: 10px 0; }
        .nav {
            background: #fff;
            border-top: 1px solid #333;
            border-bottom: 1px solid #333;
            text-align: center;
            padding: 5px 0;
        }
        .nav a {
            color: #003399;
            text-decoration: none;
            margin: 0 10px;
            font-weight: bold;
        }
        .nav a:hover { text-decoration: underline; }
        .content { min-height: 400px; padding: 20px; }
        .footer {
            position: fixed;
            left: 0; right: 0; bottom: 0;
            background: #fff;
            border-top: 1px solid #333;
            text-align: center;
            padding: 5px 0;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="header">
        <!-- Replace with your logo image if available -->
        <img src="images/logo.png" alt="Logo" style="height:150px; width: 300px" onerror="this.style.display='none'" />
    </div>
    <div class="nav">
        <a href="DanhSachDienThoaiNCCServlet">Danh sách sản phẩm</a> |
        <a href="DienThoaiFormServlet">Thêm mới sản phẩm</a> |
        <a href="QuanLyFormServlet">Chức năng quản lý</a>
    </div>
    <div class="footer">
        NGUYENTUANHUNG - 20099001
    </div>
</body>
</html>