<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- header section start -->
<header>
    <div class="header-container">


        <div class="header-wrapper">
            <div class="logoBox">
                <div class="logo-soco">
                    <a href="shopping"><h2>SOCO</h2></a>
                </div>
                <c:if test="${role==2}">
                    <div class="content">
                        <a href="onboarding.jsp"><h5>Đăng ký bán hàng trên SOCO</h5></a>
                    </div>
                </c:if>

                <c:if test="${role==3}">
                    <div class="content">
                        <form action="seller" method="post">
                            <button type="submit" class="btn btn-light" style="background-color: white; border: none"><h5>Shop của bạn</h5></button>
                        </form>
                    </div>
                </c:if>
            </div>
            <c:choose>
                <c:when test="${name != null}">
                    <div class="iconBox2" style="padding: 0 10px;">

                        <a href="/SocialCommercial"  style="margin-right: 0;"><i class="fa fa-home"></i></a>
                        <a href="cart" id="cartLink" style="margin-right: 10px;"><i class="fa fa-shopping-cart"></i></a>
                            <% if (session.getAttribute("img") != null) {%>
                        <label><img src="<%= session.getAttribute("img")%>" alt="user"></label>
                            <% } else { %>
                        <label><img src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg" alt="user"></label>
                            <% }%>
                        <span class="arrow_carrot-down"></span>
                    </div>
                    <div class="header-dropdown">
                        <div class="dropdown-content" style="min-width: 170px;">
                            <c:if test="${role==3}">
                                <a href="seller_management"> Thống kê</a>
                            </c:if>
                                 <c:if test="${role==4||role==5||role==6||role==7||role==8}">
                                <a href="Shipper"> Shipper</a>
                            </c:if>
                            <a href="edit_userprofile.jsp">Hồ sơ của bạn</a>
                            <c:if test="${role==3}">
                            <a href="quanlidonhang" >Quản lí đơn hàng</a>
                            </c:if>
                            <a href="xemdonhang" >Đơn mua</a>
                            <a href="logout">Đăng xuất</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="loginContainer">
                        <a href="login" style="font-weight: 1000; font-family: monospace; font-size: 20px; color: #4575b5;">Đăng nhập</a>
                    </div>
                </c:otherwise>
            </c:choose>


        </div>
    </div>

</header>
<script src="setofshop/js/dropdown-content.js"></script>
<script>
                    document.getElementById("cartLink").addEventListener("click", function (event) {
                        event.preventDefault(); // Prevent the default link behavior
                        var xhr = new XMLHttpRequest();
                        xhr.open("POST", "cart", true);
                        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                        xhr.send(); // Send the POST request
                        // Handle the response
                        xhr.onload = function () {
                            if (xhr.status === 200) {
                                // Here, you can decide what to do based on the response.
                                // For example, you can redirect to the "cart" page:
                                window.location.href = "cart";
                            }
                        };
                    });
</script>
<!-- header section end -->
