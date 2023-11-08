<%-- 
    Document   : seller
    Created on : Sep 26, 2023, 6:13:53 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SOCO Seller</title>
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
                        <%@ include file="shop/hero__categories.jsp" %>
                    </div>
                    <div class="col-lg-9">
                        <%@ include file="shop/hero_search.jsp" %>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <c:set var="msg" value="${null}"></c:set>
            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg" data-setbg="setofshop/img/breadcrumb.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>${shopName}</h2>
                            <div class="breadcrumb__option">
                                <a href="./seller">Home</a>
                                <span>Shop</span>
                            </div>
                            <div class="breadcrumb__option1" style="font-weight: 700;">
                                <a href="./themsanpham.jsp" style="color: white">Thêm sản phẩm mới</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-5">
                        <div class="sidebar">
                            <div class="sidebar__item">
                                <div class="latest-product__text">
                                    <h4>Sản phẩm mới nhất</h4>

                                    <div class="latest-product__slider owl-carousel">
                                        <div class="latest-prdouct__slider__item">
                                            <c:forEach var="top3" items="${listtop3product}">
                                                <a href="detail?pid=${top3.productId}" class="latest-product__item">
                                                    <div class="latest-product__item__pic">
                                                        <img src="${top3.productImage}" alt="">
                                                    </div>
                                                    <div class="latest-product__item__text">
                                                        <h6>${top3.productName}</h6>
                                                        <span><fmt:formatNumber value="${top3.productPrice}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</span>
                                                    </div>
                                                </a>
                                            </c:forEach>
                                        </div>
                                        <div class="latest-prdouct__slider__item">
                                            <c:forEach var="top3" items="${listtop3product}">
                                                <a href="detail?pid=${top3.productId}" class="latest-product__item">
                                                    <div class="latest-product__item__pic">
                                                        <img src="${top3.productImage}" alt="">
                                                    </div>
                                                    <div class="latest-product__item__text">
                                                        <h6>${top3.productName}</h6>
                                                        <span><fmt:formatNumber value="${top3.productPrice}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</span>
                                                    </div>
                                                </a>
                                            </c:forEach>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-7">
                        <div class="product__discount">
                            <div class="section-title product__discount__title">
                                <h2>Sản phẩm giảm giá</h2>
                            </div>
                             <div class="row">
                                <div class="product__discount__slider owl-carousel">

                                    <c:forEach var="top3" items="${listtop3product}">
                                        <div class="col-lg-4">
                                            <div class="product__discount__item">
                                                <div class="product__discount__item__pic set-bg"
                                                     data-setbg="${top3.productImage}">
                                                    <div class="product__discount__percent">-20%</div>
                                                    <ul class="product__item__pic__hover">
                                                        <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                        <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                                        <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>
                                                </div>
                                                <div class="product__discount__item__text">
                                                    <h5><a href="detail?pid=${top3.productId}">${top3.productName}</a></h5>
                                                    <div class="product__item__price"><fmt:formatNumber value="${top3.productPrice-(top3.productPrice*30/100)}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ <span><fmt:formatNumber value="${top3.productPrice}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</span></div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>




                                </div>
                                - </div>
                        </div>
                        <div class="filter__item">
                            <div class="row">
                                <div class="col-lg-4 col-md-5">
                                    <div class="filter__sort">
                                        <span>Sort By</span>
                                        <select>
                                            <option value="0">Default</option>
                                            <option value="0">Default</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <div class="filter__found">
                                        <h6>Tổng số sản phẩm:  <span>${total}</span></h6>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">

                            <c:forEach var="item" items="${listproduct}">
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="${item.productImage}">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a href="detail?pid=${item.productId}">${item.productName}</a></h6>
                                            <h5><fmt:formatNumber value="${item.productPrice}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</h5>
                                        </div>
                                        <div class="d-flex justify-content-end align-items-center">
                                            <form action="updatesanpham" method="get">
                                                <input type="hidden" name="productid" value="${item.productId}">
                                                <button type="submit" class="btn btn-primary btn-sm">Cập nhật</button>
                                            </form>
                                            
                                            <div style="margin-left: 10px;"></div><!-- Create a 10px gap -->
                                            <form action="deletesanpham" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?')">
                                                <input type="hidden" name="productid" value="${item.productId}">
                                                <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>




                        </div>
                        <div class="product__pagination">
                            <a href="#">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#"><i class="fa fa-long-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

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
    </body>
</html>
