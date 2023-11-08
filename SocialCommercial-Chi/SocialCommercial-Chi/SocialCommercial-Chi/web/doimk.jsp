
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- link css -->
        <link rel="stylesheet" href="static/css/login.css">

        <!-- link icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <title>Form Login</title>
    </head>

    <body>
        <div class="container">
            <div class="box login">
                <div class="content">
                    <h2 style="color: blue">
                        Đổi mật khẩu mới cho tài khoản ${name}
                    </h2>



                    <form action="doimatkhau" method="post" id="form">
                        <c:if test="${sessionScope.account == null}">
                            <h3 style="color: red">${requestScope.ms}</h3>
                        </c:if>
                        <c:if test="${sessionScope.account != null}">
                            <h3 style="color: red">${requestScope.error}</h3>
                        </c:if>
                    <div class="form_input">
                            <input type="password" name="passcurrent" id="password" required>
                            <label for="password">Mật khẩu hiện tại</label>
                        </div>
                       <div class="form_input">
                            <input type="password" name="pass" id="password" required>
                            <label for="password">Mật khẩu mới</label>
                        </div>
                        <div class="form_input">
                            <input type="password" name="pass1" id="password" required>
                            <label for="password">Nhập lại mật khẩu mới</label>
                        </div>
                            <input type="hidden" name="name" value="${name}">

                        <button class="btn submit">
                            GỬI
                        </button>
                        <h2 style="color:red;margin-top:10px">${msg}</h2>
                       
                        <a href="foget.jsp" style="color: white; text-decoration: none;">Forgot Password?</a>
                    </form>

                </div>
            </div>

            <div class="marks">
            </div>
        </div>

        <!-- link javascript -->
    </body>

</html>