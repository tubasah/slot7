<%-- 
    Document   : purchase
    Created on : Sep 28, 2023, 3:58:35 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <%@ include file="shop/hero__categories.jsp" %>
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
                            <h2>Đơn mua</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>
                               <a href="xemdonhang"><li> Chưa được xác nhận</li></a>
                                 <a href="xemdonhangchovanchuyen"><li> Chờ vận chuyển</li></a>
                               <a href="xemdonhangdanggiao"> <li>Đang giao</li></a>
                               <a href="xemdonhanghoanthanh"> <li>Hoàn thành</li></a>
                              <a href="xemdonhangdahuy">  <li>Đã huỷ</li></a>
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
                                    <c:set var="tong" value="${null}"></c:set> 

                                    <c:forEach items="${orderMap}" var="entry">
                                        <c:set var="orderId" value="${entry.key}" />
                                        <c:set var="donhangList" value="${entry.value}" />
                                        <table class="table">
                                            <tbody>
                                                <c:forEach items="${donhangList}" var="donhang" varStatus="loop">
                                                    <c:if test="${loop.first}">
                                                        
                                                        <tr class="table-light">
                                                             <c:if test="${donhang.status==null}">
                                       <form action="xacnhandon" method="post">
                                        <input type="hidden" value="${orderId}"name="orderid">
                                        <input type="hidden" value="sethuy"name="action">
                                        <input type="submit" value="Hủy đơn hàng?">
                                    </form>
                                    </th>
                                    </c:if>
                                                            <th colspan="5" style="text-align: left; padding-top: 10px">
                                                                Shop: ${donhang.shopname}
                                                            </th>
                                                            
                                                        </tr>
                                                    </c:if>
                                                    <tr>
                                                        <td class="shoping__cart__item table-light">
                                                            <div class="row">
                                                                <div class="col-md-2" style="text-align: right">
                                                                    <img src="${donhang.img}" alt="" style="width: 100px; height: 100px; object-fit: cover;">
                                                                </div>
                                                                <div class="col-md-10">
                                                                    <h5>${donhang.productname}</h5>
                                                                    <div class="row">
                                                                        <div class="col-md-9">
                                                                            <h5>X ${donhang.quantity}</h5>
                                                                        </div>
                                                                        <div class="col-md-3" style="text-align: right;">
                                                                            <h5 class="text-info" style="padding-right: 10px">Giá:<fmt:formatNumber value="${donhang.price}" type="currency" currencySymbol="" minFractionDigits="0"/> VND</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <c:if test="${loop.last}">
                                                        <tr class="table-light">
                                                            <td>
                                                                <div class="row">
                                                                    <div class="col-md-8" style="text-align: left; font-weight: bold">
                                                                        Thông tin người nhận: <h5>${donhang.fullname} - ${donhang.phone}
                                                                            - ${donhang.location} - ${donhang.town}</h5>
                                                                    </div>
                                                                    <div class="col-md-4" style="text-align: right; font-weight: bold">
                                                                        Tổng đơn: <h4 class="text-danger"><fmt:formatNumber value="${donhang.total}" type="currency" currencySymbol="" minFractionDigits="0"/> VND </h4>
                                                                    </div>
                                                                    
                                                                </div>
                                                                
                                                            </td>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </c:forEach>



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
</html>