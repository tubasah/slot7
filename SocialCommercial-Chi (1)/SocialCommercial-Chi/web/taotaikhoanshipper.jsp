<%-- 
    Document   : taotaikhoanshipper
    Created on : Oct 19, 2023, 7:19:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="taotaikhoanshipper" method="post">
        UserName:    <input name="name" type="text" required>
        <br>
        PassWord:   <input name="pass" type="text" required>
        <br>
        Thành phố:     <select name="town" required>
        <option value="" disabled selected>Chọn thành phố</option>
        <option value="6">Hà Nội</option>
        <option value="5">Hồ Chí Minh</option>
        <option value="4">Đà Nẵng</option>
        <option value="7">Gia Lai</option>
        <option value="8">Vũng Tàu</option>
        <!-- Thêm các thành phố khác bằng cách sao chép dòng trên và chỉnh sửa value và nội dung -->
    </select>
        <br>
        <input type="submit" value="OK">
        </form>
        ${msg}
    </body>
</html>
