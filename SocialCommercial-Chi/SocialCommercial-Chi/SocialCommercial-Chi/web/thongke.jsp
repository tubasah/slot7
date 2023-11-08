<%-- 
    Document   : purchase
    Created on : Sep 28, 2023, 3:58:35 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

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
        <link rel="stylesheet" href="setofshop/css/style.css" type="text/css">

        <title>SOCO - Đơn mua</title>
    </head>
    <body>
        <!-- Header Section Begin -->
        <%@ include file="shop/header_shop.jsp" %>
        <!-- Header Section End -->

        <!-- Hero Section Begin -->
        <section class="hero hero-normal">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="hero__categories">
                            <div class="hero__categories__all">
                                <i class="fa fa-bars"></i>
                                <span>Danh mục</span>
                            </div>
                            <ul>
                                <li><a href="#">Bách hoá Online</a></li>
                                <li><a href="#">Thời trang nam</a></li>
                                <li><a href="#">Thời trang nữ</a></li>
                                <li><a href="#">Điện thoại & Phụ kiện</a></li>
                                <li><a href="#">Điện tử</a></li>
                                <li><a href="#">Máy tính & Laptop</a></li>
                                <li><a href="#">Mỹ phẩm</a></li>
                                <li><a href="#">Đồ chơi</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <%@ include file="shop/hero_search.jsp" %>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad" style="padding-top: 20px">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Thống kê doanh thu</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>

                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Shoping Cart Section Begin -->
                <section class="shoping-cart spad" style="padding-top: 0;">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="shoping__cart__table">
  <p class="table-light">
                                                        <th class="shoping__product" colspan="5" style="text-align: left; padding-top: 10px">
                                                            <h3>   ${doanhthu} </h3>

                                                        </th>
                                                    </>
                             

                                               
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Shoping Cart Section End -->
            </div>
        </section>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="setofshop/js/bootstrap.min.js"></script>
        <script src="setofshop/js/jquery.nice-select.min.js"></script>
        <script src="setofshop/js/jquery-ui.min.js"></script>
        <script src="setofshop/js/jquery.slicknav.js"></script>
        <script src="setofshop/js/mixitup.min.js"></script>
        <script src="setofshop/js/owl.carousel.min.js"></script>
        <script src="setofshop/js/main.js"></script>


    </body>
</html