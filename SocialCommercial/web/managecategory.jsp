<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>

        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Dashboard - NiceAdmin Bootstrap Template</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assetsofadmin/img/favicon.png" rel="icon">
        <link href="assetsofadmin/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assetsofadmin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assetsofadmin/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assetsofadmin/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assetsofadmin/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assetsofadmin/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assetsofadmin/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assetsofadmin/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assetsofadmin/css/style.css" rel="stylesheet">

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <title>facebook.com</title>
        <link rel="stylesheet" href="static/css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="shortcut icon" href="static/images/favicon.ico" type="image/x-icon">
        <!-- style css link -->
        <link rel="stylesheet" href="assetsofadmin/css/style.css">
        <!-- fontawesome css link -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>

        <!-- header section start -->


        <div style="margin-top:-18px;margin-left:-20px">
            <%@include file="subhome/header.jsp" %>
        </div>      
        <aside id="sidebar" class="sidebar" style="margin-top:70px;margin-left:15px">

            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-member">
                    <a class="nav-link " href="index.html">
                        <i class="bi bi-grid"></i>
                        <span>Dashboard</span>
                    </a>
                </li><!-- End Dashboard Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-menu-button-wide"></i><span>Manage Member</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="components-alerts.html">
                                <i class="bi bi-circle"></i><span>Role Managements</span>
                            </a>
                        </li>
                        <li>
                            <a href="getListUser">
                                <i class="bi bi-circle"></i><span>View Member List</span>
                            </a>
                        </li>
                        <li>
                            <a href="components-badges.html">
                                <i class="bi bi-circle"></i><span>Add Shipper</span>
                            </a>
                        </li>

                    </ul>
                </li><!-- End Components Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed " href="managecategory"">
                        <i class="bi bi-grid"></i>
                        <span>Manage Category</span>
                    </a>
                </li>
                <li class="nav-member">
                    <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-journal-text"></i><span>Forms</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="forms-elements.html">
                                <i class="bi bi-circle"></i><span>Form Elements</span>
                            </a>
                        </li>
                        <li>
                            <a href="forms-layouts.html">
                                <i class="bi bi-circle"></i><span>Form Layouts</span>
                            </a>
                        </li>
                        <li>
                            <a href="forms-editors.html">
                                <i class="bi bi-circle"></i><span>Form Editors</span>
                            </a>
                        </li>
                        <li>
                            <a href="forms-validation.html">
                                <i class="bi bi-circle"></i><span>Form Validation</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Forms Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-layout-text-window-reverse"></i><span>Tables</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="tables-general.html">
                                <i class="bi bi-circle"></i><span>General Tables</span>
                            </a>
                        </li>
                        <li>
                            <a href="tables-data.html">
                                <i class="bi bi-circle"></i><span>Data Tables</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Tables Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-bar-chart"></i><span>Charts</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="charts-chartjs.html">
                                <i class="bi bi-circle"></i><span>Chart.js</span>
                            </a>
                        </li>
                        <li>
                            <a href="charts-apexcharts.html">
                                <i class="bi bi-circle"></i><span>ApexCharts</span>
                            </a>
                        </li>
                        <li>
                            <a href="charts-echarts.html">
                                <i class="bi bi-circle"></i><span>ECharts</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Charts Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-gem"></i><span>Icons</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="icons-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="icons-bootstrap.html">
                                <i class="bi bi-circle"></i><span>Bootstrap Icons</span>
                            </a>
                        </li>
                        <li>
                            <a href="icons-remix.html">
                                <i class="bi bi-circle"></i><span>Remix Icons</span>
                            </a>
                        </li>
                        <li>
                            <a href="icons-boxicons.html">
                                <i class="bi bi-circle"></i><span>Boxicons</span>
                            </a>
                        </li>
                    </ul>
                </li><!-- End Icons Nav -->

                <li class="nav-heading">Pages</li>

                <li class="nav-member">
                    <a class="nav-link collapsed" href="users-profile.html">
                        <i class="bi bi-person"></i>
                        <span>Profile</span>
                    </a>
                </li><!-- End Profile Page Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" href="pages-faq.html">
                        <i class="bi bi-question-circle"></i>
                        <span>F.A.Q</span>
                    </a>
                </li><!-- End F.A.Q Page Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" href="pages-contact.html">
                        <i class="bi bi-envelope"></i>
                        <span>Contact</span>
                    </a>
                </li><!-- End Contact Page Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" href="pages-register.html">
                        <i class="bi bi-card-list"></i>
                        <span>Register</span>
                    </a>
                </li><!-- End Register Page Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" href="pages-login.html">
                        <i class="bi bi-box-arrow-in-right"></i>
                        <span>Login</span>
                    </a>
                </li><!-- End Login Page Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" href="pages-error-404.html">
                        <i class="bi bi-dash-circle"></i>
                        <span>Error 404</span>
                    </a>
                </li><!-- End Error 404 Page Nav -->

                <li class="nav-member">
                    <a class="nav-link collapsed" href="pages-blank.html">
                        <i class="bi bi-file-earmark"></i>
                        <span>Blank</span>
                    </a>
                </li><!-- End Blank Page Nav -->

            </ul>

        </aside><!-- End Sidebar-->

        <main id="main" class="main" style="margin-top:-40px">

            <div class="pagetitle">
                <h1>Data Tables</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-member"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-member">Tables</li>
                        <li class="breadcrumb-member active">Data</li>
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
                                <form action="addcategory" method="post" style="margin-left:10px;margin-bottom: 10pz">
                                    <input type="text" name="itemadd">
                                    <input type="submit" value="ADD">
                                </form>
                                <!-- Table with stripped rows -->
                                <table class="table datatable">
                                    <thead>
                                        <tr>


                                            <th scope="col">Type</th>
                                            <th scope="col">Delete</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cate" items="${listcategory}">
                                            <tr>

                                                <td>${cate.type}</td>

                                                <td><form action="deletecategory"  method="post" >
                                                        <input type="hidden" name="catedelete" value="${cate.id}">
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
        <!-- End #main -->

        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">
            <div class="copyright">
                &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
            </div>
            <div class="credits">
                <!-- All the links in the footer should remain intact. -->
                <!-- You can delete the links only if you purchased the pro version. -->
                <!-- Licensing information: https://bootstrapmade.com/license/ -->
                <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
            </div>
        </footer><!-- End Footer -->

        <a href="#" class="back-to-top d-flex align-members-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assetsofadmin/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assetsofadmin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assetsofadmin/vendor/chart.js/chart.umd.js"></script>
        <script src="assetsofadmin/vendor/echarts/echarts.min.js"></script>
        <script src="assetsofadmin/vendor/quill/quill.min.js"></script>
        <script src="assetsofadmin/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assetsofadmin/vendor/tinymce/tinymce.min.js"></script>
        <script src="assetsofadmin/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assetsofadmin/js/main.js"></script>
    </body>
    <html>


        <!-- header section end -->
        <!-- home section start -->








        <!-- home section end -->

        <script>
            var darkButton = document.querySelector(".darkTheme");

            darkButton.onclick = function () {
                darkButton.classList.toggle("button-Active");
                document.body.classList.toggle("dark-color")
            }

        </script>

    </body>
</html>