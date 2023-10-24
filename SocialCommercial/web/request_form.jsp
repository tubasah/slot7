<%-- 
    Document   : seller_form
    Created on : Sep 17, 2023, 2:25:10 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
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

        <header>
            <%@ include file="shop/header_shop.jsp" %>
        </header>
        <div class="home">

            <div class="containerr">
                <form action="RequestSetRole" method="post">
                    <div class="form-group row">
                        <label for="email" class="col">Email:</label>
                        <input type="text" value="${emailuser}" id="email" name="email" class="form-control col" placeholder="Email" readonly>
                    </div>
                    <div class="form-group row">
                        <label for="fullName" class="col">Full Name:</label>

                        <input type="text" id="full-name" name="fullName" class="form-control col" placeholder="Full Name" required>
                        <br />

                    </div>
                    <div class="form-group row">
                        <label for="shopName" class="col">Shop name:</label>
                        <input type="text" id="shop-name" name="shopName" class="form-control col" placeholder="Shop name" required>
                    </div>
                    <div class="form-group row">
                        <label for="commoditiesSector" class="col">Commodities sector:</label>
                        <select name="commoditiesSector" id="sector" class="form-control col">
                            <option selected>Choose...</option>
                            <option value="32DE7141-E052-4591-A103-2F5F544E01E0">Bách hoá online</option>
                            <option value="467E803A-426E-441D-8DB8-669AE23A3469">Điện thoại & Phụ kiện</option>
                            <option value="EECBD3F1-134E-43B0-A3E1-700EDB72A6A4">Mỹ phẩm</option>
                            <option value="9BD9C078-7E46-4BA0-BE56-7223EE26608B">Máy ảnh & Máy quay phim</option>
                            <option value="C9C33AEB-38F4-44A0-89B5-860BA5AE8C23">Máy tính & Laptop</option>

                            <option value="1818E9A8-52CD-4538-9512-AD9234BD1EEA">Thời trang nam</option>
                            <option value="063C4EA1-948F-48ED-87DA-D8C9E326F01A">Thời trang nữ</option>
                            <option value="2EA22AA1-2368-4742-8D96-994337ED92DE">Đồ chơi</option>
                        </select>
                    </div>
                    <div class="form-group row">
                        <label for="address" class="col">Address:</label>
                        <input type="text" id="address" name="address" class="form-control col" placeholder="Address" required>
                    </div>
                    <div class="form-group row">
                        <label for="phone" class="col">Phone number:</label>
                        <input type="tel" id="phone" name="phone" class="form-control col" placeholder="Phone number" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit Request</button>
                </form>


            </div>
        </div>

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


    </body>
</html>





