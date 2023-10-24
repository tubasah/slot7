
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h3 class="title">
                        Đăng nhập
                    </h3>



                    <form action="login" method="POST" id="form">
                        <c:if test="${sessionScope.account == null}">
                            <h3 style="color: red">${requestScope.ms}</h3>
                        </c:if>
                        <c:if test="${sessionScope.account != null}">
                            <h3 style="color: red">${requestScope.error}</h3>
                        </c:if>

                        <div class="form_input">
                            <input type="text" name="username" id="name" required>
                            <label for="name">Tên đăng nhập</label>
                        </div>
                        <div class="form_input">
                            <input type="password" name="pass" id="password" required>
                            <label for="password">Mật khẩu</label>
                        </div>
                        <button class="btn submit">
                            Đăng nhập
                        </button>
                        <h2 style="color:red">${msg}</h2>
                        <c:set var="msg" value="${null}"></c:set>
                        <a href="forget.jsp" style="color: black; text-decoration: none;">Forgot Password?</a>
                    </form>

                </div>
            </div>

            <div class="box navigation">
                <div class="content">
                    <div class="nav navigation_signIn">
                        <p>
                            Nếu bạn chưa có tài khoản, vui lòng đăng kí. 
                        </p>


                        <button class="btn layer" id="signupButton">

                            Đăng kí
                        </button>
                    </div>


                </div>
            </div>




        </div>

        <!-- link javascript -->
        <!--<script src="static/js/loginJS_1.js"></script>-->
        <script>
            document.getElementById("signupButton").addEventListener("click", function () {
                window.location.href = "signup"; // Redirect to register.jsp
            });
        </script>
    </body>

</html>