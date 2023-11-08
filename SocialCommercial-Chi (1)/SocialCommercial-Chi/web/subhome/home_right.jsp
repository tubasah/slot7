<%@page import="DAO.AdminDAO"%>
<%@page import="DAO.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="static/css/style.css">

            <div class="home-right">
                <div class="home-right-wrapper">

                    <div class="event-friend">
                        <hr>
                    
                        <div class="friend">
                            <h3 class="heading">Đề xuất cho bạn<span>see all</span></h3>
                            <%  AdminDAO manage = new AdminDAO();if(session.getAttribute("id") != null){
                                for(User user : manage.getRandomUsers(session.getAttribute("id"))){%>
                            <ul>
                                <li><img src="<%= user.getImage() %>" alt="user"></li>
                                <li>
                                    <b><%= user.getFullname() %></b>
                                    <p>Theo dõi bạn</p>
                                    <a href="UserProfileSocial?user_id=<%= user.getId() %>"><button>View Profile</button></a>
                                    <a href=""><button class="friend-remove">remove</button></a>
                                </li>
                            </ul>
                            <% }} %>
                        </div>

                    </div>


                </div>
            </div>
