<%-- 
    Document   : shopping-cart
    Created on : Sep 28, 2023, 12:42:39 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SOCO Cart</title>
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
        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <h4 style="color: red; margin-left: 30px;">${msgcart}</h4>

            <c:set var="msgcart" value="${null}"></c:set>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__table">
                            <c:set var="currentShop" value="" />
                            <table>
                                <thead>
                                    <tr>
                                        <th class="shoping__product">Sản phẩm</th>
                                        <th>Đơn giá</th>
                                        <th>Số lượng</th>
                                        <th>Số tiền</th>
                                        <th></th>
                                    </tr>

                                </thead>
                                <tbody>
                                    <c:set var="dem" value="${0}" />
                                <form action="thanhtoan" method="post" id="cart-form">
                                    <c:forEach var="item" items="${listitemincart}">
                                        <c:set var="dem" value="${dem+1}" />
                                        <c:if test="${!item.shopname.equals(currentShop)}">
                                            <!-- Hiển thị tên cửa hàng nếu khác với cửa hàng trước đó -->
                                            <tr>
                                                <th class="shoping__product" colspan="5" style="text-align: left; padding-top: 10px">
                                                    Shop: ${item.shopname}
                                                </th>
                                            </tr>
                                            <!-- Lưu tên cửa hàng hiện tại để so sánh với các sản phẩm tiếp theo -->
                                            <c:set var="currentShop" value="${item.shopname}" />
                                        </c:if>
                                        <tr>
                                            <td class="shoping__cart__item">
                                                <input type="checkbox" class="product-checkbox" value="${item.id}" name="item${dem}" data-price="<fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/>">
                                                <input type="hidden" value="${item.productid}" name="productid${dem}">
                                                <img src="${item.img}" alt="" style="width: 100px; height: 100px; object-fit: cover;">
                                                <h5>${item.productname}</h5>
                                            </td>
                                            <td class="shoping__cart__price">
                                                <fmt:formatNumber value="${item.price}" type="currency" currencySymbol="" minFractionDigits="0"/>

                                            </td>
                                            <td class="shoping__cart__quantity">
                                                <div class="quantity">
                                                    <div class="pro-qty">
                                                        <input type="text" value="${item.quantity}" name="itemquantity${dem}">
                                                    </div>
                                                </div>
                                            </td>

                                            <td class="shoping__cart__total">
                                                <span class="item-total"><fmt:formatNumber value="${item.quantity * item.price}" type="currency" currencySymbol="" minFractionDigits="0"/></span>
                                            </td>
                                            <td class="shoping__cart__item__close">

                                            <td class="shoping__cart__item__close">
                                                <a class="btn btn-outline-danger" href="#" onclick="xoaSanPham('${item.id}')">XÓA</a>
                                            </td>


                                            </td>
                                        </tr>

                                        </tbody>
                                    </c:forEach>
                                    <input type="hidden" name="dem" value="${dem}">

                                </form>

                            </table>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__btns">
                            <a href="shopping" class="primary-btn cart-btn">Tiếp tục mua sắm</a>
                            <a href="cart" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                                Cập nhật giỏ hàng</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__continue">
                            <div class="shoping__discount">
                                <h5>Mã giảm giá</h5>
                                <form action="#">
                                    <input type="text" placeholder="Nhập mã phiếu giảm giá">
                                    <button type="submit" class="site-btn">Apply</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Tổng thanh toán</h5>
                            <ul>
                                <li>Tổng tiền hàng <span id="totalPriceAllVNĐ">0</span></li>
                                <!--                                <li>Giảm giá sản phẩm <span>-$154.98</span></li>-->
                                <!--                                <li>Tổng số tiền <span>$354.00</span></li>-->
                            </ul>
                            <button type="submit" class="btn primary-btn" id="buyNowButton" style="background-color: #5c91c6; width: 100%">MUA NGAY</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
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
        // Lấy tham chiếu đến form và nút "MUA NGAY"
        const cartForm = document.getElementById('cart-form');
        const buyButton = document.getElementById('buyNowButton');

        // Gắn sự kiện click cho nút "MUA NGAY"
        buyButton.addEventListener('click', function () {
        // Gửi form khi nút "MUA NGAY" được nhấn
        cartForm.submit();
       });
    </script>
    <script>
        function formatCurrency(amount) {
            return new Intl.NumberFormat('vi-VN', {
                style: 'currency',
                currency: 'VND',
                minimumFractionDigits: 3
            }).format(amount);
        }

        // Lấy danh sách tất cả các checkbox
        const checkboxes = document.querySelectorAll('.product-checkbox');

// Lấy tham chiếu đến thẻ hiển thị tổng tiền hàng
        const totalPriceAllElement = document.getElementById('totalPriceAllVNĐ');

// Hàm để tính tổng tiền dựa trên các sản phẩm đã chọn
        function calculateTotalPrice() {
            let total = 0;

            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    const itemTotal = checkbox.closest('tr').querySelector('.item-total');
                    total += parseFloat(itemTotal.textContent);
                }
            });

            // Cập nhật giá trị tổng tiền
            totalPriceAllElement.textContent = formatCurrency(total);
        }

// Gắn sự kiện change cho tất cả các checkbox
        checkboxes.forEach(checkbox => {
            checkbox.addEventListener('change', calculateTotalPrice);
        });

    </script>
    <script>
        function xoaSanPham(itemId) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "removeitemincart", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            var data = "itemcanxoa=" + itemId;
            xhr.onload = function () {
                if (xhr.status === 200) {
                    console.log(xhr.responseText); // In kết quả lên console (để kiểm tra)
                    // Cập nhật lại giao diện trang web nếu cần

                    // Tự động làm mới trang web sau khi xóa sản phẩm
                    location.reload(); // Làm mới trang web
                }
            };
            xhr.send(data);
        }



    </script>



</html>
