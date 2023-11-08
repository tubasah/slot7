<%-- 
    Document   : purchase
    Created on : Sep 28, 2023, 3:58:35 PM
    Author     : ADMIN
--%>

<%@page import="DAO.FeedbackDAO"%>
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
                                <li><a href="xemdonhang" style="color: black"> Chưa được xác nhận</a></li>
                                <li><a href="xemdonhangchovanchuyen" style="color: black"> Chờ vận chuyển</a></li>
                                <li><a href="xemdonhangdanggiao" style="color: black"> Đang giao</a></li>
                                <li><a href="xemdonhanghoanthanh" style="color: black"> Hoàn thành</a></li>
                                <li><a href="xemdonhangdahuy" style="color: black"> Đã huỷ</a></li>
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

                                                            <th colspan="5" style="text-align: left; padding-top: 10px">
                                                                <div class="row">
                                                                    <div class="col-md-10">
                                                                        Shop: ${donhang.shopname}
                                                                    </div>
                                                                    <div class="col-md-2" style="text-align: right;">
                                                                        <c:if test="${donhang.status==null}">
                                                                            <form action="xacnhandon" method="post">
                                                                                <input type="hidden" value="${orderId}"name="orderid">
                                                                                <input type="hidden" value="sethuy" name="action">
                                                                                <input type="submit" class="btn btn-outline-danger" value="Hủy đơn hàng">
                                                                            </form>
                                                                        </c:if>
                                                                        <c:if test="${donhang.status == 'Dang giao'}">
                                                                            <span class="badge bg-light text-dark">Đang giao</span>
                                                                        </c:if>
                                                                        <c:if test="${donhang.status == 'Hoan thanh'}">
                                                                            <span class="badge bg-success">Hoàn thành</span>
                                                                        </c:if>
                                                                        <c:if test="${donhang.status == 'Da huy by customer'}">
                                                                            <span class="badge bg-danger">Đã huỷ</span>
                                                                        </c:if>
                                                                    </div>
                                                                </div>


                                                            </th>

                                                        </tr>
                                                    </c:if>
                                                    <tr>
                                                        <td class="shoping__cart__item table-light">
                                                            <div class="row">
                                                                <div class="col-md-2" style="text-align: right">
                                                                    <a href="detail?pid=${donhang.productid}"><img src="${donhang.img}" alt="" style="width: 100px; height: 100px; object-fit: cover;"></a>
                                                                </div>
                                                                <div class="col-md-10">
                                                                    <a href="detail?pid=${donhang.productid}"><h5>${donhang.productname}</h5></a>
                                                                    <div class="row">
                                                                        <div class="col-md-9">
                                                                            <h5>X ${donhang.quantity}</h5>
                                                                        </div>
                                                                        <div class="col-md-3" style="text-align: right;">
                                                                            <h5 class="text-info" style="padding-right: 10px">Giá:<fmt:formatNumber value="${donhang.price}" type="currency" currencySymbol="" minFractionDigits="0"/> VND</h5>
                                                                        </div>
                                                                        <div class="col-md-12" style="text-align: right; margin-top: 10px">


                                                                            <c:if test="${donhang.status == 'Hoan thanh'}">
                                                                         <% FeedbackDAO feedbackdao = new FeedbackDAO(); %>
<c:set var="productid" value="${donhang.productid}" />
<c:set var="id" value="${id}" />
<c:set var="status" value="${feedbackdao.getstatusOfProDuct(productid, id)}" />


                                                                        <c:if test="${status!=1}"  >
                                                                                <a href="#" class="btn btn-outline-danger write-feedback" data-toggle="modal" data-target="#addFeebackModal${donhang.productid}">Viết đánh giá</a>
                                                                                </c:if>  
                                                                                <div id="addFeebackModal${donhang.productid}" class="modal fade">
                                                                                    <div class="modal-dialog">
                                                                                        <div class="modal-content" style="border-radius: 10px; margin-top: 60px;">
                                                                                            <div class="modal-header">
                                                                                                <h2 style="margin-left: 35%">Đánh giá sản phẩm</h2>
                                                                                            </div>
                                                                                            <div class="modal-body">
                                                                                                <form action="feedback" method="post" enctype="multipart/form-data">
                                                                                                    <input type="hidden" name="productId" value="${donhang.productid}"/>
                                                                                                    <div class="form-group">
                                                                                                        <b>Viết đánh giá:</b>
                                                                                                    </div>
                                                                                                    <div class="form-group" style="text-align: left;">
                                                                                                        <textarea name="subject" placeholder="Viết bình luận.." style="height:200px; width: 460px"></textarea>
                                                                                                    </div>
                                                                                                    <div class="form-group">
                                                                                                        <b>Ảnh phản hồi:</b>
                                                                                                    </div>
                                                                                                    <div class="form-group" style="text-align: left;">
                                                                                                        <input name="imageurl" type="file" class="form-control" style="border-radius: 100px;">
                                                                                                    </div>
                                                                                                    <div class="form-group">
                                                                                                        <b>Đánh giá:</b>
                                                                                                    </div>
                                                                                                    <div class="form-group" style="text-align: left;">
                                                                                                        <select name="star" style="border-radius: 100px;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                                                                                            <option selected>Chọn số sao</option>
                                                                                                            <option value="1">1</option>
                                                                                                            <option value="2">2</option>
                                                                                                            <option value="3">3</option>
                                                                                                            <option value="4">4</option>
                                                                                                            <option value="5">5</option>
                                                                                                        </select>
                                                                                                    </div>
                                                                                                    <br>
                                                                                                    <div class="text-right">
                                                                                                        <button type="submit" class="btn btn-dark" style="border-radius: 100px;">Hoàn thành</button>
                                                                                                        <button type="button" class="btn btn-dark" data-dismiss="modal" style="border-radius: 100px;">Huỷ</button>
                                                                                                    </div>
                                                                                                </form>
                                                                                                <br><br>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </c:if>



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
        <script>
            const listItems = document.querySelectorAll('ul li');

            listItems.forEach(item => {
                item.addEventListener('click', () => {
                    listItems.forEach(otherItem => otherItem.classList.remove('active'));
                    item.classList.add('active');
                });

                // Lấy URL của trang hiện tại và so sánh với href của liên kết
                if (window.location.href.endsWith(item.querySelector('a').getAttribute('href'))) {
                    item.classList.add('active');
                }
            });
        </script>
        <script>
    // JavaScript to open the correct modal when "Viết đánh giá" is clicked
    document.querySelectorAll('.write-feedback').forEach(function (element) {
        element.addEventListener('click', function () {
            var targetModalId = element.getAttribute('data-target').substr(1); // Remove the '#' character
            $('#' + targetModalId).modal('show');
        });
    });
</script>






    </body>
</html>