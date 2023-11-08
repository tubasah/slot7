<%-- 
    Document   : seller_form
    Created on : Sep 17, 2023, 2:25:10 PM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Category"%>
<%@page import="Model.Category"%>
<%@page import="DAO.AdminDAO"%>
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
                        <%AdminDAO admindao=new AdminDAO();%>
                        <% ArrayList<Category> list =admindao.getAllCategory(); %>
                        <select name="commoditiesSector" id="sector" class="form-control col">
                            <option selected>Choose...</option>
                             <% for (Category item:list) { %>
                            <option value="<%=item.getCid()%>"><%=item.getType()%></option>
                            <% } %>
                            
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





