
<%@page import="DAO.CommentSocialDAO"%>
<%@page import="Model.CommentSocial"%>
<%@page import="DAO.LikeSocialDAO"%>
<%@page import="Model.LikeSocial"%>
<%@page import="DAO.UserDAO"%>
<%@page import="Model.UserPost"%>
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
                    
                    <!-- home center start here -->
                    <div class="home-center">
                        <div class="home-center-wrapper">    
                            <%if( request.getAttribute("listFollowingPost") != null){
                                UserDAO manageUser = new UserDAO();
                                for(UserPost home_post : (List<UserPost>) request.getAttribute("listFollowingPost")){
                                for(User usr : manageUser.getAllUsers()){if(usr.getId().toString().toLowerCase()
                                .equals(home_post.getUser_id().toString().toLowerCase())){
                                ArrayList<LikeSocial> listLikes = new ArrayList<>();LikeSocialDAO likes = new LikeSocialDAO();
                                for(LikeSocial like : likes.getLikeSocials()){
                                    if(like.getPost_id().toString().toLowerCase().equals(home_post.getId().toString().toLowerCase())){
                                        listLikes.add(like);
                                    }
                                }
                                String check_like = null;
                                for(LikeSocial heart : listLikes){
                                    if(session.getAttribute("id")!=null && home_post.getId().toString().toLowerCase().equals(heart.getPost_id().toString().toLowerCase())
                                    && heart.getLiker_id().toString().toLowerCase().equals(session.getAttribute("id").toString().toLowerCase())){
                                        check_like = "notnull";
                                        break;
                                    }
                                }
                                ArrayList<CommentSocial> listComment = new ArrayList<>();
                                CommentSocialDAO manageComment = new CommentSocialDAO();
                                for(CommentSocial comments : manageComment.getCommentSocials()){
                                if(comments.getPost_id()!=null && comments.getPost_id().toString().toLowerCase().equals(home_post.getId().toString().toLowerCase())){
                                    listComment.add(comments);
                                }}
                                listComment.sort((comment1, comment2) -> comment1.getComment_date().compareTo(comment2.getComment_date()));
                            %>
                            <div class="fb-post1">
                                <div class="fb-post1-header">
                                    <ul>
                                        <a href="home.jsp"><li>popular</li></a>
                                        <a href="HomeFollowing"><li  class="active">following</li></a>
                                    </ul>
                                </div>
                                <div class="fb-post1-container">
                                    <div class="fb-p1-main">
                                        <div class="post-title">
                                            <a href="UserProfileSocial?user_id=<%= usr.getId() %>"><img src="<%= usr.getImage() %>" alt="user picture"></a>
                                            <ul>
                                                <a href="UserProfileSocial?user_id=<%= usr.getId() %>"><li><h3><%= usr.getFullname() %></h3></li></a>
                                                <li><span><%= home_post.getPost_date() %></span></li>
                                            </ul>
                                            <p><%= home_post.getPost_content() %></p>
                                        </div>
                                        <div class="post-images">
                                            <div class="post-images1" style="width: 100%; overflow: hidden;">
                                                <a href="<%= home_post.getPost_image() %>">
                                                    <img src="<%= home_post.getPost_image() %>" alt="post images 01" style="height: 100%;">
                                                </a>
                                                
                                            </div>
                                        </div>
                                        <div class="like-comment" style="font-size: 35px;">
                                            <ul>
                                                <li >
                                                    <a href="ReactPostHome?post_id=<%=home_post.getId()%>&name=<%=home_post.getPost_image() %>">
                                                        <% if (check_like != null) { %>
                                                        <i class="fas fa-heart"></i>
                                                        <% } else { %>
                                                        <i class="far fa-heart"></i>
                                                        <% } %>
                                                    </a>
                                                    <span style="margin-left: -4px;"><%= listLikes.size() %></span>
                                                </li>
                                                <li style="margin-left: 70px;"><i class="fa-regular fa-comment-dots"></i> <span><%= listComment.size() %></span></li>
                                            </ul>
                                        </div>
                                        <br>
                                        <% for (CommentSocial comment : listComment){for(User us : manageUser.getAllUsers()){
                                            if(comment.getCommentor_id().toString().toLowerCase().equals(us.getId().toString().toLowerCase())){
                                        %>
                                        <div class="comment">
                                            <a href="UserProfileSocial?user_id=<%= us.getId() %>"><img src="<%= us.getImage() %>" alt="user"></a>
                                            <div class="comment-content" style="margin-left: -55px;">
                                                <span class="comment-username" style="margin-left: -3px; font-size: 18px;"><%= us.getFullname()%> </span>
                                                <span style="color: grey; margin-left: 5px; font-size: 13px;"><%= comment.getComment_date() %></span>
                                                <p><%= comment.getComment_content() %></p>
                                            </div>
                                            <% if(comment.getCommentor_id().toString().toLowerCase().equals(session.getAttribute("id").toString().toLowerCase())
                                            || home_post.getUser_id().toString().toLowerCase().equals(session.getAttribute("id").toString().toLowerCase())){%>
                                            <a href="RemoveCommentSocial?id=<%= comment.getId() %>&post_id=<%=home_post.getId()%>
                                            &fullName=<%=usr.getFullname()%>&user_id=<%= usr.getId() %>
                                            &cs=<%=usr.getFullname()%>" style="color: grey;">
                                                <i class="fa-solid fa-delete-left"></i>
                                            </a>
                                            <%}%>
                                        </div>
                                        <% }}} %>
                                        <form method="POST" action="CommentPost?post_id=<%=home_post.getId()%>&fullName=<%=usr.getFullname()%>
                                              &user_id=<%=usr.getId() %>">
                                            <div class="comment-box">
                                                <input type="hidden" name="checkcomhomefollowing" value="CheckHome" />
                                              <input type="text" placeholder="Post a comment" name="comment" />
                                              <button type="submit">Post</button>
                                            </div>
                                        </form>        
                                    </div>                                    
                                </div>
                            </div><br>
                            <% }}}}else{ %>  
                            <h3 style="margin-top: 20px; margin-left: 30px; font-size: 25px">
                                Chưa có bài viết nào. Vui lòng đăng nhập để xem bài viết
                            </h3>
                            <%}%>
                                            
                                
                                            
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

