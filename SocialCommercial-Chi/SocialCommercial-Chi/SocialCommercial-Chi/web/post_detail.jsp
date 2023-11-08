
<%@page import="java.util.List"%>
<%@page import="DAO.UserDAO"%>
<%@page import="Model.User"%>
<%@page import="Model.LikeSocial"%>
<%@page import="DAO.LikeSocialDAO"%>
<%@page import="DAO.CommentSocialDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.CommentSocial"%>
<%@page import="java.util.Date"%>
<%@page import="Model.UserPost"%>
<%@page import="DAO.UserPostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="static/images/favicon.ico" type="image/x-icon">
        <title>SOCO</title>
        <!-- style css link -->
        <link rel="stylesheet" href="static/css/style.css">
        <!-- fontawesome css link -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
     <%@ include file="subhome/header.jsp" %>
     
    <body>

        <!-- home section start -->
        <div class="fb-post1" >
            <div class="fb-post1-container">
                <div class="post-title" >
                    <% if(request.getAttribute("user_id") != null && !request.getAttribute("user_id").toString().equals("null")){%>
                    <img src="${user_image}" alt="user picture">
                    <% }else{ %>
                    <img src="<%= session.getAttribute("img") %>" alt="user picture">
                    <%}%>
                    <ul>
                        <li><h3><%= request.getParameter("fullName") %> </h3></li> 
                        <li><span>${post_date}</span></li> 
                    </ul>
                        <% if(request.getAttribute("user_id") != null && !request.getAttribute("user_id").toString().equals("null")){%>
                    <a href="UserProfileSocial?user_id=<%= request.getAttribute("user_id") %>" style="font-size: 40px; margin-bottom: 20px; color: black;">
                        <i class="far fa-times-circle"></i>
                    </a>
                    <% }else{ %>
                    <a href="UserProfileSocial" style="font-size: 40px; margin-bottom: 20px; color: black;">
                        <i class="far fa-times-circle"></i>
                    </a>
                    <% } %>
                    <p>${post_content}</p>
                    <a href="${post_image}"><img src="${post_image}" width="700px" height="660px"  alt="post images 01" ></a>
                </div>
                <div class="like-comment" style="font-size: 26px; ">
                    <ul>
                    <li>
                        <a href="LikePost?post_id=${post_id}&fullName=<%= request.getParameter("fullName") %>&user_id=<%= request.getAttribute("user_id") %>">
                            <% if (request.getAttribute("check") != null) { %>
                                <i class="fas fa-heart"></i>
                            <% } else { %>
                                <i class="far fa-heart"></i>
                            <% } %>
                        </a>
                        ${listLikesSize}
                    </li>
                        <li><i class="fa-regular fa-comment-dots"></i> ${listCommentSize} </li>
               
                        <% if(request.getAttribute("checkToRemovePost") != null){%>
                        <li><a href="removePost?post_id=${post_id}"><i class="fas fa-trash-alt"></i></a> Delete</li>
                        <% } %>
                    </ul>
                        <% for(User customer : (List<User>) request.getAttribute("listAllOfUsers")){
                            for(CommentSocial comment : (List<CommentSocial>) request.getAttribute("listComment")){
                            if(comment.getCommentor_id() != null && customer.getId() != null &&
                            comment.getCommentor_id().toString().toLowerCase().equals(customer.getId().toString().toLowerCase())){
                        %>
                        
                        <div class="comment">
                            <img src="<%= customer.getImage() %>" alt="user">
                            <div class="comment-content">
                                <span class="comment-username" style="font-size: 25px"><%= customer.getFullname() %></span>
                                <span style="color: grey; margin-left: 7px; font-size: 15px;"><%= comment.getComment_date() %></span>
                                <p><%= comment.getComment_content() %></p>
                            </div>
                                <% if(comment.getCommentor_id().toString().toLowerCase().equals(session.getAttribute("id").toString().toLowerCase())
                                || request.getAttribute("post_userId").toString().toLowerCase().equals(session.getAttribute("id").toString().toLowerCase())){%>
                            <a href="RemoveCommentSocial?id=<%= comment.getId() %>&post_id=${post_id}&fullName=<%= request.getParameter("fullName") %>&user_id=<%= request.getAttribute("user_id") %>" style="color: grey;">
                                <i class="fas fa-minus-circle"></i>
                            </a>
                             <% } %>
                        </div>
                        <%}}}%>
                        <form method="POST" action="CommentPost?post_id=${post_id}&fullName=<%= request.getParameter("fullName") %>&user_id=<%= request.getAttribute("user_id") %>">
                          <div class="comment-box">
                            <input type="text" placeholder="Post a comment" name="comment" />
                            <button type="submit">Post</button>
                          </div>
                        </form>
                    
                </div>
            </div>

            
        </div>

 
    </body>
</html>

<script src="static/js/js.js"></script>

<style>
       .comment {
  display: flex;
  align-items: flex-start;
  padding: 8px;
  margin: 40px 8px;
}

.comment img {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  object-fit: cover;
  margin-right: 10px;
}

.comment-content {
  flex: 1;
}

.comment-username {
  font-weight: bold; /* Tạo độ đậm cho tên người comment */
}

.comment-content p {
  padding: 8px;
  border-radius: 10px;
  margin: 0;
}

.comment-box {
  display: flex;
  align-items: center;
  width: 100%;
  max-width: 800px;
  margin: 30px 6px;
  background-color: #fff;
  border: 1px solid #ccc;
  padding: 8px;
  border-radius: 50px;
}

.comment-box input[type="text"] {
  flex: 1;
  padding: 8px;
  border: none;
  outline: none;
}

.comment-box button[type="submit"] {
  background-color: #007bff;
  color: #fff;
  border: none;
  padding: 8px 20px;
  margin: 10px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.comment-box button[type="submit"]:hover {
  background-color: #0056b3;
}

.like-comment i {
  font-size: 40px;
}

.like-comment ul li:nth-child(-n+2) {
  margin-right: 150px;
}

.like-comment ul li:nth-child(n+3) {
  margin-left: 150px;
}
    .post-title a img {
        margin-top: 15px;
        width: 830px;
        height: 400px;
    }
    .fb-post1{
        margin: 30px 200px;
        display: flex;
        width: 890px;
        
    }

</style>