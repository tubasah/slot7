<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SOCO</title>
        <!-- style css link -->
        <!-- fontawesome css link -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>

        <!--Header-->
        <%@ include file="subhome/header.jsp" %>
        <!--Header-->

        <!-- home section start -->


        <div class="home">
            <div class="container">
                <div class="home-weapper">

                    <!-- home left start here -->
                    <%@ include file="subhome/home_left.jsp" %>
                    <!-- home left end here -->

                    <!-- home center start here -->

                    <div class="home-center">
                        <div class="home-center-wrapper">


                            <div class="fb-post1">
                                <div class="fb-post1-container">
                                    <div class="fb-post1-header">
                                        <ul>
                                            <li class="active">popular</li>
                                            <li>following</li>
                                        </ul>
                                    </div>
                                    <div class="fb-p1-main">
                                        <div class="post-title">
                                            <img src="static/images/user2.jpg" alt="user picture">
                                            <ul>
                                                <li><h3>Arham Kabir <span> . 2 hours ago</span></h3></li>
                                                <li><span>02 march at 12:55 PM</span></li>
                                            </ul>
                                            <p>Hello Everyone Thanks for Watching Please SUBSCRIBE My Channel - Like Comments and Share
                                                <a href="https://www.youtube.com/channel/UCHhGX-DD7A8jq7J_NPGN6gA">https://www.youtube.com/channel/UCHhGX-DD7A8jq7J_NPGN6gA</a>
                                            </p>
                                        </div>

                                        <div class="post-images">
                                            <div class="post-images1" style="width: 100%; overflow: hidden;">
                                                <img src="static/images/pp.jpg" alt="post images 01" style="height: 100%;">
                                                
                                            </div>
                                        </div>

                                        <div class="like-comment">
                                            <ul>
                                                <li>
                                                    <img src="static/images/love.png" alt="love">
                                                    <img src="static/images/like.png" alt="like">
                                                    <span>22k like</span>
                                                </li>
                                                <li><i class="fa-regular fa-comment-dots"></i> <span>555 comments</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div> <!-- home center wrapper end -->
                    </div> <!-- home center end -->

                    <!-- home right start here -->
                    <%@ include file="subhome/home_right.jsp" %>
                    <!-- home right end here -->






                </div>
            </div>
        </div>

    </body>
</html>

<script src="static/js/js.js"></script>