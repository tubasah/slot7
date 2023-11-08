<%@page import="Model.User"%>
<%@page import="Model.FollowUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SOCO</title>
        <!-- style css link -->
        <link rel="stylesheet" href="static/css/style.css">
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
                    <!-- Follower -->
                    <div class="home-right">
                        <div class="home-right-wrapper">
                            <div class="event-friend">
                                <hr>
                                <div class="friend"  style="margin-right: 20px">
                                    <h3 class="heading">Your Follower</h3>
                                    <% for(User follower : (List<User>) request.getAttribute("listFollower")){ %>
                                    <ul>
                                        <li><img src="<%= follower.getImage() %>" alt="user"></li>
                                        <li>
                                            <b><%= follower.getFullname() %></b>
                                            <p>Follow you</p>
                                            <a href="UserProfileSocial?user_id=<%= follower.getId() %>"><button>View Profile</button></a>
                                        </li>
                                    </ul>
                                    <% } %>
                                </div>

                            </div>
                            
                        </div>                 
                    </div>
                    <div class="home-right">
                        <div class="home-right-wrapper">
                            <div class="event-friend">
                                <hr>
                                <div class="friend"  style="margin-right: 20px">
                                        <h3 class="heading">Your Following</h3>
                                    <% for(User following : (List<User>) request.getAttribute("listFollowing")){ %>
                                    <ul>
                                        <li><img src="<%= following.getImage() %>" alt="user"></li>
                                        <li>
                                            <b><%= following.getFullname() %></b>
                                            <p>Follow you</p>
                                            <a href="UserProfileSocial?user_id=<%= following.getId() %>"><button>View Profile</button></a>
                                        </li>
                                    </ul>
                                    <% } %>
                                </div>

                            </div>
                            
                        </div>                 
                    </div>
                    <div class="home-right">
                        <div class="home-right-wrapper">
                            <div class="event-friend">
                                <hr>
                                <div class="friend"  style="margin-right: 20px">
                                        <h3 class="heading">Your Friend</h3>
                                    <% for(User friend : (List<User>) request.getAttribute("listFriend")){ %>
                                    <ul>
                                        <li><img src="<%= friend.getImage() %>" alt="user"></li>
                                        <li>
                                            <b><%= friend.getFullname() %></b>
                                            <p>Follow you</p>
                                            <a href="UserProfileSocial?user_id=<%= friend.getId() %>"><button>View Profile</button></a>
                                        </li>
                                    </ul>
                                    <% } %>
                                </div>

                            </div>
                            
                        </div>                 
                    </div>
                    
            </div>
        </div>

    </body>
</html>

<script src="static/js/js.js"></script>

