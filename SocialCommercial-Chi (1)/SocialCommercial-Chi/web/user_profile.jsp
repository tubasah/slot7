<%@page import="java.util.List"%>
<%@page import="Model.UserPost"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="static/css/style_1.css">
        <link rel="stylesheet" href="static/css/style.css">
        

    </head>
    <body>

        <!--Header-->
        <%@ include file="subhome/header.jsp" %>
        <!--Header-->
        <div class="container">
            <div class="profile1">
                <div class="profile-image">
                    <a href="${link_image}"><img src="${link_image}" width="280px" height="300px" alt=""></a>

                </div>
                <div class="profile-user-settings row">
                    <div class="col-md-12">
                        <h1 class="profile-user-name" style="font-weight: 800;"><%= request.getAttribute("user_name")%></h1>
                    </div>
                    <div class="col-md-12">
                        <% if (request.getAttribute("check") != null) { %>
                        <a href="DisplayEditUserProfile" style="color: black;">
                            <button class="btn profile-edit-btn" style="background-color: #3a78ffec"><i class="fas fa-edit"></i> Edit Profile</button>
                        </a>   
                        <a href="create_post.jsp" style="color: black;">
                            <button class="btn profile-edit-btn" style="background-color: grey"><i class="fas fa-plus-circle"></i> Create Post</button>
                        </a>
                        <% } else {%>
                        <a href="FollowFriend?friend_id=<%= request.getAttribute("user_id")%>" style="color: black;">
                            <button class="btn profile-edit-btn" style="background-color: #3a78ffec">

                                <% if (request.getAttribute("check_follow") != null) {%>
                                <i class="fas fa-user-check"></i> Unfollow</button>
                                <%} else {%>
                            <i class="fas fa-user-plus"></i> Follow</button>
                            <%}%>
                        </a>
                        <a href="getcontentchat?nguoinhantin=<%= request.getAttribute("user_name")%>" style="color: black;">
                            <button class="btn profile-edit-btn" style="background-color: grey">
                                <i class="fab fa-facebook-messenger"></i> Messenger
                            </button>
                        </a>
                        <% }%>
                    </div>


                </div>

                <div class="profile-stats">

                    <ul>
                        <li><span class="profile-stat-count">${count}</span> posts</li>
                        <li>
                            <a href="ViewFollow?my_id=<%= session.getAttribute("id")%>" style="color: #3a78ffec; text-decoration: none;">
                                <span class="profile-stat-count">${follower}</span> followers</a>
                        </li>
                        <li>
                            <a href="ViewFollow?my_id=<%= session.getAttribute("id")%>" style="color: #3a78ffec; text-decoration: none;">
                                <span class="profile-stat-count">${following}</span> following
                            </a>
                        </li>
                    </ul>

                </div>

                <div class="profile-bio">
                    <p><i class="fas fa-info-circle"></i> ${fullName} - ${gender}</p>
                    <p><i class="fas fa-heart"></i> ${statusNow}</p>
                    <p><i class="fas fa-school"></i> ${school}</p>
                    <p><i class="fas fa-thumbs-up"></i> ${favourite}</p>
                    <p><span style="font-weight:600">Bio: </span>
                        ${bio}
                    </p>️

                </div>

            </div>
            <!-- End of profile section -->

        </div>
        <% if (request.getAttribute("check_listUserPost") != null) { %>                
        <h1 style="font-size: 30px;
            font-weight: 700;
            margin-left: 500px;">Danh sách bài viết đã đăng tải</h1>
        <br><br>
        <div class="container">
            <div class="gallery">
                <% for (UserPost post_user : (List<UserPost>) request.getAttribute("listUserPost")) {%>
                <a href="PostDetail?post_id=<%= post_user.getId()%>&fullName=${fullName}&user_id=<%= request.getParameter("user_id")%> ">
                    <div class="gallery-item" tabindex="0">
                        <img src="<%= post_user.getPost_image()%>" class="gallery-image" alt="">

                        <div class="gallery-item-info">
                            <ul>
                                <li class="gallery-item-likes"><span class="visually-hidden">Likes:</span><i class="fas fa-heart" aria-hidden="true"></i> ${listLikesSize}</li>
                                <li class="gallery-item-comments"><span class="visually-hidden">Comments:</span><i class="fas fa-comment" aria-hidden="true"></i> </li>
                            </ul>
                        </div>
                    </div>
                </a>
                <% } %> 
            </div>

            <!-- End of gallery -->
        </div>
        <% } else { %>
        <% if (request.getAttribute("check") != null) { %>
        <p style="color:black;
           margin: 50px 300px;
           font-size: 35px;
           font-weight: 700;
           ">You don't have any posts<i class="fas fa-address-card" style="color: grey;"></i><br>
            Click <a href="create_post.jsp"><i class="fas fa-plus-square"></i></a> to create your first post
        </p>
        <%} else {%>
        <p style="color:black;
           margin: 50px 450px;
           font-size: 35px;
           font-weight: 700;
           ">Don't have any posts
        </p>
        <% } %>
        <% }%>

        <!-- End of container -->
    </body>
</html>
<script src="static/js/js.js"></script>