<%@page import="Model.Notification"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<header>
    <div class="header-container">
        <div class="header-wrapper">
            <div class="logoBox">
                <a href="home.jsp" style="font-size: 20px;"><h1>SOCO</h1></a>
            </div>
            <div class="searchBox">
                <input type="search">
                <i class="fas fa-search"></i>
            </div>
            <div class="iconBox2">
                <c:if test="${name!=null}">
                    <a href="home.jsp"><i class="fa-solid fa-house"></i></a>
                    <a href="ViewFollow?my_id=<%= session.getAttribute("id") %>"><i class="fas fa-user-friends"></i></a>
                    <div id="notificationIconContainer">
                        <i id="notificationIcon" class="fa-solid fa-bell"></i>
                        <%List<Notification> listNotificationUser = (List<Notification>) session.getAttribute("listNotificationUser");%>
                        <% if (listNotificationUser != null && listNotificationUser.size() > 0){ %>
                        <span id="notificationCount"><%= listNotificationUser.size() %></span>
                        <%}else{%>
                        <span id="notificationCount">0</span>
                        <%}%>
                    </div>
                    
                    <div id="notification" class="hidden" style="margin-right:800px;">
                        <div class="notification-header">
                            <h3>Thông báo</h3>
                        </div>
                        <% if (listNotificationUser != null && listNotificationUser.size() > 0){ %>
                        <%  for(Notification notify :  listNotificationUser){ %>
                        <div class="notification-content">
                            <img src="<%= notify.getReacter() %>" alt="">
                            <a href="<%= notify.getLink_notify() %>" style="color: black;">
                                <p><%= notify.getNotification_content() %></p>
                            </a>
                            <a class="delete-notification-link" href="RemoveNotificationSocial?notify_id=<%= notify.getId() %>"><i class="fa-solid fa-xmark"></i></a>
                        </div>
                        <div class="notification-time"><%= notify.getNotification_date() %></div>
                        <% }}else{ %>
                        <h3 style="font-size: 16px; color: grey; margin: 20px">Bạn chưa có thông báo nào</h3>
                        <% } %>
                        
                    </div>
                    <% if(session.getAttribute("img") != null){ %>
                    <label><img src="<%= session.getAttribute("img") %>" alt="user"></label>
                    <% }else{ %>
                    <label><img src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg" alt="user"></label>
                    <% } %>
                    <i class="fa-solid fa-caret-down" id="dropdownButton"></i>
                    <div class="dropdown-content" style="margin-left: 120px;">
                        <a href="UserProfileSocial"><i class="fas fa-eye"></i>Trang cá nhân</a>
                        <a href=""><i class="fas fa-highlighter"></i>Đổi mật khẩu</a>
                        <a href="logout"><i class="fas fa-sign-out-alt"></i>Đăng xuất</a>
                    </div>
                </c:if>
            </div>
            <c:if test="${name==null}">
                <a href="login" style="font-weight: 1000; font-family: monospace; font-size:20px; color: #4575b5;">Đăng nhập</a>
            </c:if>
        </div>
        
    </div>
    
</header>



<script>
  const notificationIcon = document.getElementById("notificationIcon");
const notification = document.getElementById("notification");

let isNotificationVisible = false;

notificationIcon.addEventListener("click", () => {
  if (!isNotificationVisible) {
    // Hiển thị thông báo nếu nó không hiển thị
    notification.style.display = "block"; // hoặc sử dụng các lớp CSS
    isNotificationVisible = true;
  } else {
    // Ẩn thông báo nếu nó đang hiển thị
    notification.style.display = "none"; // hoặc sử dụng các lớp CSS
    isNotificationVisible = false;
  }
});

</script>


<style>
 #notification {
    display: none;
    position: fixed;
    background-color: white;
    border: 1px solid #ccc;
    width: 320px; /* Điều chỉnh kích thước theo mong muốn */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    border-radius: 4px;
    margin-top: 53px;
    margin-left: -80px;
}

.notification-header {
    padding: 10px;
    border-bottom: 1px solid #ccc;
}

.notification-header h3 {
    margin: 0;
    font-size: 20px;
    font-weight: 700;
}

.notification-content {
    font-size:19px; 
    font-weight: 500;
    padding: 10px;
    display: flex;
    align-items: center;
}

.notification-content img {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    margin-right: 10px;
}

.notification-content p {
    margin: 0;
    font-size: 14px;
}
.notification-time {
    margin-top: -10px; /* Di chuyển lên trên 10px */
    margin-left: 57px; /* Di chuyển sang phải 20px */
    font-size: 12px;
    color: #1877f2;
}

#notificationIconContainer {
  position: relative;
  display: inline-block;
}

#notificationIcon {
  font-size: 24px; /* Thay đổi kích thước biểu tượng theo mong muốn */
}

#notificationCount {
  position: absolute;
  margin-top: -8px;
  margin-left: 7px;
  top: 0;
  right: 0;
  background-color: red; /* Màu nền cho số thông báo */
  color: white; /* Màu chữ cho số thông báo */
  border-radius: 50%; /* Kích thước góc bo tròn */
  padding: 4px 8px; /* Khoảng cách giữa số và biểu tượng */
  font-size: 12px; /* Kích thước của số thông báo */
}

 
</style>