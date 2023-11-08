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

        <!-- Hero Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad" style="padding-top: 20px">
            <div class="container">

                <!-- Shoping Cart Section Begin -->
                <section class="shoping-cart spad" style="padding-top: 0;">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="shoping__cart__table">
                                    <c:set var="currentShop" value="" />
                                    <c:set var="totalPrice" value="0" />
                                    <c:set var="checksodon" value="0" />
                                    <c:set var="demsanpham" value="0" />
                                    <c:set var="totalPriceAll" value="0" />
                                    <table>
                                        <tbody>
                                        <form action="muahang" method="post">
                                            <c:forEach var="item" items="${listthanhtoan}">
                                                <c:if test="${!item.shopname.equals(currentShop)}">
                                                    <!-- Hiển thị tên cửa hàng nếu khác với cửa hàng trước đó -->
                                                    <c:if test="${!empty currentShop}">
                                                        <tr>
                                                            <td colspan="4" style="text-align: right">
                                                                <h4> Tổng tiền đơn hàng: ${totalPrice} VND</h4>
                                                                <h4> Tổng tiền bao gồm tiền ship (Ship 35000 VND): ${totalPrice+35000} VND</h4>
                                                                <c:set var="totalPriceAll" value="${totalPriceAll+totalPrice+35000} " />

                                                            </td>
                                                        </tr>
                                                    </c:if>

                                                    <tr>
                                                        <th class="shoping__product" colspan="5" style="text-align: left; padding-top: 10px">
                                                            Shop: ${item.shopname}
                                                        </th>
                                                    </tr>
                                                    <!-- Lưu tên cửa hàng hiện tại để so sánh với các sản phẩm tiếp theo -->
                                                    <c:set var="currentShop" value="${item.shopname}" />
                                                    <!-- Reset biến tổng tiền cho đơn hàng mới -->
                                                    <c:set var="totalPrice" value="0" />
                                                    <c:set var="checksodon" value="${checksodon+1}" />
                                                </c:if>
                                                <!-- Hiển thị thông tin sản phẩm -->
                                                <tr>

                                                    <td class="shoping__cart__item">
                                                        <input type="hidden" value="${item.id}" name="itemid${demsanpham}">
                                                        <input type="hidden" value="${item.shopname}" name="shopname${demsanpham}">
                                                        <input type="hidden" value="${item.productid}"name="productid${demsanpham}">
                                                        <input type="hidden" value="${item.sellerid}"name="sellerid${demsanpham}">
                                                        <input type="hidden" value="${item.cartid}"name="cartid${demsanpham}">
                                                        <input type="hidden" value="${item.price}"name="price${demsanpham}">
                                                        <input type="hidden" value="${item.quantity}"name="quantity${demsanpham}">
                                                        <c:set var="demsanpham" value="${demsanpham+1}" />
                                                        <img src="${item.img}" alt="" style="width: 100px; height: 100px; object-fit: cover;">
                                                        <h5>${item.productname}</h5>
                                                    </td>
                                                    <td class="shoping__cart__price">
                                                        ${item.price}
                                                    </td>
                                                    <td class="shoping__cart__quantity">
                                                        <div class="quantity">
                                                            ${item.quantity}
                                                        </div>
                                                    </td>
                                                    <td class="shoping__cart__total">
                                                        ${item.price * item.quantity}
                                                    </td>
                                                </tr>

                                                <!-- Cộng tổng tiền cho đơn hàng hiện tại -->
                                                <c:set var="totalPrice" value="${totalPrice + item.price * item.quantity}" />
                                                <input type="hidden" value="${totalPrice+35000}" name="total${item.sellerid.toLowerCase().trim()}">

                                            </c:forEach>
                                            <!-- Hiển thị tổng tiền cho đơn hàng cuối cùng -->
                                            <c:if test="${!empty currentShop}">
                                                <tr>
                                                    <td colspan="4" style="text-align: right">
                                                        <h4> Tổng tiền đơn hàng: ${totalPrice} VND</h4>
                                                        <h4> Tổng tiền bao gồm tiền ship: ${totalPrice+35000} VND</h4>
                                                        <c:set var="totalPriceAll" value="${totalPriceAll+totalPrice+35000} " />
                                                    </td>
                                                </tr>
                                            </c:if>
                                            </tbody>
                                    </table>
                                    Bạn đã mua đơn hàng của ${checksodon} Shop
                                    <br>
                                    Tổng cộng: ${demsanpham} sản phẩm
                                    <br>
                                    Tổng giá tiền cả ship: ${totalPriceAll} VND
                                </div>
                            </div>
                        </div>
                        <input type="hidden" value=" ${checksodon}"  name="sodon" >
                        <input type="hidden" value=" ${demsanpham}"  name="sosanpham" >
                        <div class="form-group row">

                            <label for="email" class="col">Email:</label>
                            <input type="text" value="${emailuser}" id="email" name="email" class="form-control col" placeholder="Email" readonly>
                        </div>
                        <input type="hidden" value="${id}"  name="iduser" >
                        <div class="form-group row">
                            <label for="fullName" class="col">Full Name:</label>

                            <input type="text" id="full-name" name="fullName" class="form-control col" placeholder="Full Name" required>
                            <br />

                        </div>

                              <div class="form-group row">
    <label for="Town" class="col">Thành phố:</label>
    <select id="town" name="town" class="form-control col" required>
        <option value="" disabled selected>Chọn thành phố</option>
        <option value="hanoi">Hà Nội</option>
        <option value="hochiminh">Hồ Chí Minh</option>
        <option value="danang">Đà Nẵng</option>
        <option value="gialai">Gia Lai</option>
        <option value="vungtau">Vũng Tàu</option>
        <!-- Thêm các thành phố khác bằng cách sao chép dòng trên và chỉnh sửa value và nội dung -->
    </select>
</div>

                        <div class="form-group row">
                            <label for="address" class="col">Địa chỉ:</label>
                            <input type="text" id="address" name="address" class="form-control col" placeholder="Address" required>
                        </div>
                        <div class="form-group row">
                            <label for="phone" class="col">Phone number:</label>
                            <input type="tel" id="phone" name="phone" class="form-control col" placeholder="Phone number" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit Request</button>
                        </form>
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
