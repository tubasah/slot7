

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


        <title>SOCO Shopping</title>
    </head>
    <body>

        <!-- Header Section Begin -->
        <%@ include file="shop/header_shop.jsp" %>
        <!-- Header Section End -->

        <!-- Hero Section Begin -->
        <section class="hero">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <%@ include file="shop/hero__categories.jsp" %>
                    </div>
                    <div class="col-lg-9">
                        <%@ include file="shop/hero_search.jsp" %>
                        <div id="header-carousel" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active" style="height: 410px;">
                                    <img class="img-fluid" src="setofshop/img/carousel-1.jpg" alt="Image">
                                    <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                        <div class="p-3" style="max-width: 700px;">
                                            <h4 class="text-light text-uppercase font-weight-medium mb-3">10% Off Your First Order</h4>
                                            <h3 class="display-4 text-white font-weight-semi-bold mb-4">Fashionable Dress</h3>
                                            <a href="" class="btn btn-light py-2 px-3">Shop Now</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="carousel-item" style="height: 410px;">
                                    <img class="img-fluid" src="setofshop/img/carousel-2.jpg" alt="Image">
                                    <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                        <div class="p-3" style="max-width: 700px;">
                                            <h4 class="text-light text-uppercase font-weight-medium mb-3">10% Off Your First Order</h4>
                                            <h3 class="display-4 text-white font-weight-semi-bold mb-4">Reasonable Price</h3>
                                            <a href="" class="btn btn-light py-2 px-3">Shop Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
                                <div class="btn btn-dark" style="width: 45px; height: 45px;">
                                    <span class="carousel-control-prev-icon mb-n2"></span>
                                </div>
                            </a>
                            <a class="carousel-control-next" href="#header-carousel" data-slide="next">
                                <div class="btn btn-dark" style="width: 45px; height: 45px;">
                                    <span class="carousel-control-next-icon mb-n2"></span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Gợi ý hôm nay</h2>
                        </div>
                    </div>
                </div>
                <div id="content" class="row featured__filter">
                    <c:forEach items="${listP}" var="o">
                        <div class="productt col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="${o.productImage}" onclick="window.location='detail?pid=${o.productId}'">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                        <li><a href="detail?pid=${o.productId}"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?pid=${o.productId}">${o.productName}</a></h6>
                                    <h5><fmt:formatNumber value="${o.productPrice}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <button onclick="loadMore()" class="btn btn-primary" style="background-color: #5c91c6; border: 0;">Xem thêm</button>
            </div>
        </section>
        <!-- Featured Section End -->
        <!-- Flash Section End -->
        <!-- JavaScript Libraries -->
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script>
                    function loadMore() {
                        var amount = document.getElementsByClassName("productt").length;
                        $.ajax({
                            url: "/SocialCommercial/load",
                            method: "GET",
                            data: {
                                exits: amount
                            },
                            success: function (data) {
                                var row = document.getElementById("content");
                                row.innerHTML += data;
                            }
                        });
                    }
        </script>
    </body>
</html>