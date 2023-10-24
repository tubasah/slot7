<%-- 
    Document   : purchase
    Created on : Sep 28, 2023, 3:58:35 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <h2>Quản lí đơn hàng</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>
                               <a href="Shipper"> <li>Nhận đơn</li></a>
                               <a href="ShipperComplete"> <li class="active">Hoàn thành</li></a>
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
                        <c:set var="tong" value="${null}"></c:set> 
                        <table>
                            <tbody>
                                <tr>
                                    <th class="shoping__product" colspan="5" style="text-align: left; padding-top: 10px">
                                        Order ID: ${orderId} 
                                    
                                    </th>
                                </tr>
                         
                                <c:forEach items="${donhangList}" var="donhang">
                                   
                                        
                                    <c:if test="${donhang.total!=tong}">
                                         <th class="shoping__product" colspan="5" style="text-align: left; padding-top: 10px">
                                           <c:if test="${donhang.status eq 'Dang giao'}">
                                    <form action="xacnhandon" method="post">
                                        <input type="hidden" value="${orderId}"name="orderid">
                                        <input type="hidden" value="sethoanthanh"name="action">
                                        <input type="submit" value="Hoàn thành?">
                                    </form>
                                        </c:if>
                                
                                <c:if test="${donhang.status eq 'Hoan thanh'}">
                                 <h4 style="color:green">Hoàn thành đơn hàng</h4>
                                 </c:if>
                                    </th>
                                    <th class="shoping__product" colspan="5" style="text-align: left; padding-top: 10px">
                                        Tổng đơn: ${donhang.total} VND
                                        <c:set var="tong" value="${donhang.total}"></c:set>
                                    </th>
                                        <th class="shoping__product" colspan="5" style="text-align: left; padding-top: 10px">
                                       Thông tin người nhận ${donhang.fullname} ${donhang.phone} ${donhang.town} 
                                       ${donhang.location} ${donhang.town}
                                    </th>
                                    
                                    </c:if>
                                    <tr>
                                        <td class="shoping__cart__item">
                                            <img src="${donhang.img}" alt="" style="width: 100px; height: 100px; object-fit: cover;">
                                            <h5>${donhang.productname}</h5>
                                            <h5>X ${donhang.quantity}</h5>
                                            <h5>Giá: ${donhang.price}</h5>
                                            <h5>Tổng: ${donhang.price*donhang.quantity}</h5>
                                 
                                         
                                        </td>
                                    </tr>
                                    
                                
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