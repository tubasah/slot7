<%@page import="Model.User"%>
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
            <div class="container" style="display: flex;">
                
                <%@ include file="subhome/home_left.jsp" %>
                
                <div class="middle">
                    <h1>Kết quả tìm kiếm</h1>
                    <% if(request.getAttribute("listUserFound") != null){ %>
                    <% for(User users : (List<User>) request.getAttribute("listUserFound")){ %>
                    <section class="search-result-item">
                        <a class="image-link" href="UserProfileSocial?user_id=<%=users.getId() %>"><img class="image" src="<%= users.getImage() %>">
                        </a>
                        <div class="search-result-item-body">
                            <div class="row">
                                <div class="col-sm-9">
                                    <h4 class="search-result-item-heading"><a href="UserProfileSocial?user_id=<%=users.getId() %>"><b><%= users.getName() %></b></a></h4>
                                    <p class="info" style="margin: 5px;color: #769bcb;"><%=users.getFullname() %></p>
                                    <p class="description"><%= users.getBio() %></p>
                                </div>
                            </div>
                        </div>
                    </section>
                    <%}}%>
                    <c:if test="${empty requestScope.listUserFound}">
                        <br><br>
                    <h2 style="color: red">Không tìm thấy người dùng nào</h2>
                    </c:if>
                </div>
            </div>
        </div>

    </body>
</html>

<script src="static/js/js.js"></script>
<style>
.middle{
    margin-left: 50px;
}
.middle h2 {
margin-left: 30px;
color: red;
font-weight: 600;
}
.middle h1 {
margin-left: 30px;
color: black;
font-weight: 700;
}
.search-result-item {
display: flex;
align-items: center;
justify-content: space-between;
background-color: #f5f5f5;
border: 1px solid #ddd;
padding: 10px;
margin: 10px;
border-radius: 20px;
height: 130px;
width: 600px;
}

.image-link img {
max-width: 100px;
max-height: 100px;
border: 1px solid #ddd;
border-radius: 50%;
}

.search-result-item-body {
flex: 1; 
margin-left: 10px; 
}

.search-result-item-heading a {
text-decoration: none;
color: #333;
font-weight: bold;
}


.info {
color: #777;
}

.description {
font-style: italic;
color: #555;
}

</style>

