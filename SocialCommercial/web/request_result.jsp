<%-- 
    Document   : onboarding
    Created on : Sep 17, 2023, 2:16:17 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>SOCO</title>

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

        <!-- header section start -->


        <header>
            <%@ include file="shop/header_shop.jsp" %>
        </header>


        <!-- header section end -->
        <!-- home section start -->


        <div class="home">
            <div class="containerr">
                <h1>Request Result</h1>

                <c:choose>
                    <c:when test="${insertResult}">
                        <p>Yêu cầu của bạn đã được gửi thành công. Bạn sẽ được quản trị viên liên hệ sớm.</p>
                    </c:when>
                </c:choose>
                <a href="shopping">Quay lại trang SOCO Shopping</a>
            </div>
        </div>



        <script>
            var darkButton = document.querySelector(".darkTheme");

            darkButton.onclick = function () {
                darkButton.classList.toggle("button-Active");
                document.body.classList.toggle("dark-color")
            }

        </script>

    </body>
</html>