<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="static/css/style.css">

<div class="home-left" style="height: 500px;">

    <div class="profile">
        <% if (session.getAttribute("img") != null) {%>
        <label><a href="UserProfileSocial"><img src="<%= session.getAttribute("img")%>" alt="user"></a></label>
        <% } else { %>
        <label><img src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg" alt="user"></label>
        <% }%>
        <a href="UserProfileSocial"><h3>${name}</h3></a>
        <c:if test="${name==null}">
            <h3>Khách</h3>
        </c:if>
    </div>

    <div class="explore">
        <c:if test="${role==1}">
            <a href="admin.jsp"><i class="fa-solid fa-house"></i> Admin</a>
        </c:if>
        <a href="home.jsp"><i class="fa-solid fa-house"></i> Trang chủ</a>
        <a href="shopping"><i class="fa-brands fa-shopify"></i> Shopping</a>
        <a href="chat"><i class="fa-brands fa-facebook-messenger"></i> Messenger</a>
        <a href="create_post.jsp"><i class="fa-solid fa-circle-plus"></i> Tạo bài viết</a>
        <a href="LikedPost"><i class="fa-solid fa-heart"></i> Bài viết đã thích</a>

    </div>

</div>