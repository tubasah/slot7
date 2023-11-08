<%-- 
    Document   : listShipper
    Created on : Oct 7, 2023, 9:29:27 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                        <li class="breadcrumb-item">Quản lý thành viên</li>
                        <li class="breadcrumb-item active"><a href="list_member.jsp">Danh sách thành viên</a></li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Datatables</h5>
                                <p>Add lightweight datatables to your project with using the <a href="https://github.com/fiduswriter/Simple-DataTables" target="_blank">Simple DataTables</a> library. Just add <code>.datatable</code> class name to any table you wish to conver to a datatable</p>
   <h5 style="color:red">${msg} </h5>
    <c:set var="msg" value="${null}"></c:set>
                                <!-- Table with stripped rows -->
                                <table class="table datatable">
                                    <thead>
                                        <tr>

                                            <th scope="col">Name</th>
                                            <th scope="col">Pass</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Phone</th>
                                            <th scope="col">Role</th>
                                            <th scope="col">Delete</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="member" items="${listmember}">
                                        <tr>
                                            <th scope="row">${member.name}</th>
                                            <td>${member.password}</td>
                                            <td>${member.email}</td>
                                            <td>${member.number}</td>
                                            <td>${member.roleid}</td>
                                            <td><form action="deletemember" style="text-align: center" method="post" >
                                                    <input type="hidden" name="iddelete" value="${member.id}">
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


        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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