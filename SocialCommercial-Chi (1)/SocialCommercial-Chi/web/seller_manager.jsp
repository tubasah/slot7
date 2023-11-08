<%-- 
    Document   : admin1
    Created on : Oct 7, 2023, 7:36:26 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Seller - Quản trị</title>

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Google Font -->
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->

        <link rel="stylesheet" href="setofshop/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="setofshop/css/styleonboarding.css">
        <link rel="stylesheet" href="setofshop/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="setofshop/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="setofshop/css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="setofshop/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="setofshop/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="setofshop/css/slicknav.min.css" type="text/css">

        <!-- Vendor CSS Files -->

        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="setofshop/css/style.css" type="text/css">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">

        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
    </head>

    <body style="background: #d1deec; ">


        <!-- ======= Header ======= -->
        <%@ include file="shop/header_shop.jsp" %>

        <main id="main" class="main" style="margin-left: 20px; background: #d1deec;">
            <div class="pagetitle">
                <h1>Thống kê bán hàng</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="seller_management">Thống kê bán hàng</a></li>
                        <li class="breadcrumb-item active">Tổng quan</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section dashboard">
                <div class="row">

                    <!-- Left side columns -->
                    <div class="col-lg-12">
                        <div class="row">

                            <!-- Sales Card -->
                            <div class="col-xxl-4 col-md-4">
                                <div class="card info-card sales-card">

                                    <div class="card-body">
                                        <h5 class="card-title">Tổng sản phẩm</h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-cart"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>${totalProduct}</h6>
                                                <span class="text-success small pt-1 fw-bold">12%</span> <span class="text-muted small pt-2 ps-1">increase</span>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Sales Card -->

                            <!-- Revenue Card -->
                            <div class="col-xxl-4 col-md-4">
                                <div class="card info-card revenue-card">

                                    <div class="card-body">
                                        <h5 class="card-title">Tổng đơn hàng</h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-currency-dollar"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>${totalOrder}</h6>
                                                <span class="text-success small pt-1 fw-bold">8%</span> <span class="text-muted small pt-2 ps-1">increase</span>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Revenue Card -->
                            <div class="col-xxl-4 col-md-4">
                                <div class="card info-card sales-card">

                                    <div class="card-body">
                                        <h5 class="card-title">Tổng doanh thu</h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-cart"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6 style="font-size: 25px"><fmt:formatNumber value="${totalRevenue}" type="currency" currencySymbol="" minFractionDigits="0"/></h6>
                                                <span class="text-success small pt-1 fw-bold">12%</span> <span class="text-muted small pt-2 ps-1">increase</span>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Sales Card -->

                            <!-- Top Selling -->
                            <div class="col-12">
                                <div class="card top-selling overflow-auto">

                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                            <li class="dropdown-header text-start">
                                                <h6>Filter</h6>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Today</a></li>
                                            <li><a class="dropdown-item" href="#">This Month</a></li>
                                            <li><a class="dropdown-item" href="#">This Year</a></li>
                                        </ul>
                                    </div>

                                    <div class="card-body pb-0">
                                        <h5 class="card-title">Top Sản Phẩm Bán Chạy Nhất</h5>

                                        <table class="table table-borderless">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Hình ảnh</th>
                                                    <th scope="col">Sản phẩm</th>
                                                    <th scope="col">Giá</th>
                                                    <th scope="col">Đã bán</th>
                                                    <th scope="col">Doanh thu</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="top5" items="${top5}">
                                                    <tr>

                                                        <th scope="row"><a href="#"><img src="${top5.productImage}" alt=""></a></th>
                                                        <td><a href="#" class="text-primary fw-bold">${top5.productName}</a></td>
                                                        <td>${top5.productPrice}</td>
                                                        <td class="fw-bold">${top5.totalBuy}</td>
                                                        <td>${top5.totalSales}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>

                                    </div>

                                </div>
                            </div><!-- End Top Selling -->


                        </div>
                    </div><!-- End Left side columns -->
                    <div class="col-12" id="chart1" style="background-color: white; padding-top: 20px;height: 450px;">

                    </div>
                </div>
            </section>

        </main><!-- End #main -->


        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->

        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.umd.js"></script>
        <script src="assets/js/echarts.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>


    </body>

</html>

<script>
                                        //Draw revenue, order echart
                                        var chartDom = document.getElementById('chart1');
                                        var myChart = echarts.init(chartDom);
                                        var option;
                                        option = {
                                            title: {
                                                text: 'Tổng doanh thu và tổng đơn hàng trong năm 2023',
                                                subtext: 'Đến: ' + new Date(),
                                                left: 'center',
                                                textStyle: {
                                                    align: 'center'
                                                }
                                            },
                                            tooltip: {
                                                trigger: 'axis',
                                                axisPointer: {
                                                    type: 'cross'
                                                }
                                            },
                                            grid: {
                                                top: '20%'
                                            },
                                            legend: {
                                                data: ['Doanh thu', 'Đơn hàng'],
                                                padding: [60, 0, 0, 0]
                                            },
                                            toolbox: {
                                                show: true,
                                                feature: {
                                                    dataView: {show: true, readOnly: false},
                                                    magicType: {show: true, type: ['line', 'bar']},
                                                    restore: {show: true},
                                                    saveAsImage: {show: true}
                                                }
                                            },
                                            calculable: true,
                                            xAxis: [
                                                {
                                                    type: 'category',
                                                    data: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
                                                }
                                            ],
                                            yAxis: [
                                                {
                                                    type: 'value',
                                                    name: 'Doanh thu',
                                                    min: 0,
                                                    max: 1000000,
                                                    axisLabel: {
                                                        formatter: function (value) {
                                                            if (value >= 1000000000) {
                                                                value = (value / 1000).toFixed(0) + 'M';
                                                            }
                                                            return '₫' + value;
                                                        }
                                                    }
                                                },
                                                {
                                                    type: 'value',
                                                    name: 'Đơn hàng'
                                                }
                                            ],
                                            series: [
                                                {
                                                    name: 'Doanh thu',
                                                    type: 'bar',
                                                    data: ${totalRevenueOfYear},
                                                    markPoint: {
                                                        data: [
                                                            {
                                                                type: 'max',
                                                                name: 'Max',
                                                                label: {
                                                                    formatter: function (params) {
                                                                        return (params.value / 1000).toFixed(0) + 'K';
                                                                    }
                                                                }
                                                            },
                                                            {
                                                                type: 'min',
                                                                name: 'Min',
                                                                label: {
                                                                    formatter: function (params) {
                                                                        return (params.value / 1000).toFixed(2) + 'K';
                                                                    }
                                                                }
                                                            }
                                                        ]
                                                    },

                                                    markLine: {
                                                        data: [{
                                                                type: 'average',
                                                                name: 'AVG',
                                                                label: {
                                                                    formatter: function (params) {
                                                                        return (params.value / 1000).toFixed(0) + 'k';
                                                                    }
                                                                }
                                                            }]
                                                    }
                                                },
                                                {
                                                    name: 'Đơn hàng',
                                                    type: 'bar',
                                                    yAxisIndex: 1,
                                                    data: ${totalOrderOfYear},
                                                    markPoint: {
                                                        data: [
                                                            {type: 'max', name: 'Max'},
                                                            {type: 'min', name: 'Min'}
                                                        ]
                                                    },
                                                    markLine: {
                                                        data: [{type: 'average', name: 'Avg'}]
                                                    }
                                                }
                                            ]
                                        };

                                        option && myChart.setOption(option);

                                        window.addEventListener('resize', myChart.resize);
                                        //End draw revenue, order echart
</script>
