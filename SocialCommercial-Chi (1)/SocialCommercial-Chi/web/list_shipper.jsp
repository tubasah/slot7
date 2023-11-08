<%-- 
    Document   : sellerstatusdemo
    Created on : Oct 9, 2023, 4:05:56 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Admin - Quản trị</title>

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- fontawesome css link -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="static/css/style.css">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">

        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>


    <body>
        <%@ include file="../subhome/header.jsp" %>
        <!-- ======= Sidebar ======= -->
        <%@ include file="../admin/left_admin.jsp" %>
        <!-- End Sidebar-->

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Data Tables</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="admin.jsp">Trang chủ</a></li>
                        <li class="breadcrumb-item">Quản lý vai trò</li>
                        <li class="breadcrumb-item active"><a href="getRequestRole">Nâng cấp vai trò</a></li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">

                    <div class="col-lg-12">

                        <div class="card">
                            <div class="card-body">
                                    <h5 style="color:red">${msg} </h5>
    <c:set var="msg" value="${null}"></c:set>

                                <h4>Thêm tài khoản vận chuyển</h4>
                                  <form action="taotaikhoanshipper" method="post">
        UserName:    <input name="name" type="text"  placeholder="Nhập tên tài khoản" required>
        <br>
        PassWord:   <input name="pass" type="text"  placeholder="Nhập mật khẩu"required>
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
                                <h5 class="card-title">Danh sách tài khoản vận chuyển</h5>
                                

                                <!-- Table with stripped rows -->
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">Tài khoản</th>
                                            <th scope="col">Mật khẩu</th>
                                            <th scope="col">Vai trò</th>
                               
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="mem" items="${listcategory}">
                                            <tr>
                                                <th scope="row">${mem.name}</th>
                                                <td>${mem.password}</td>
 <td>${mem.typerole}</td>                                            
                                              <td><form action="deleteshipper"  method="post" >
                                                        <input type="hidden" name="shipperdele" value="${mem.id}">
                                                        <input type="submit" value="X">
                                                    </form></td>
                                                    </tr>
                                        </c:forEach>
                                          
                                    </tbody>
                                </table>
                                <!-- End Table with stripped rows -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main><!-- End #main --> 
        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.umd.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>