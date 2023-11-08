<link href="setofchat/css/chat.css" rel="stylesheet" />
<link href="static/css/style.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

<div style="margin-top:-25px;margin-left:-20px">
    <%@include file="subhome/header.jsp" %>
</div>

<div class="container"  style="margin-top:5px;margin-left:17px">
    <div class="row clearfix">
        <div class="col-lg-12">
            <div class="card chat-app" style="width: 1135px; height: 550px;">
                <div id="plist" class="people-list">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-search"></i></span>
                        </div>
                        <input type="text" id="search-input" class="form-control" placeholder="Search...">
                    </div>
                    <ul id="suggestion-list" class="list-unstyled">
                        <!-- Danh sách g?i ý s? ???c hi?n th? ? ?ây -->
                    </ul>


                    <ul class="list-unstyled chat-list mt-2 mb-0">

                        <c:forEach var="nguoinhantin" items="${listnguoinhantin}">
                            <li class="clearfix">
                                <img src="${nguoinhantin.image}" alt="avatar">
                                <div class="about">
                                    <a href="getcontentchat?nguoinhantin=${nguoinhantin.name}">${nguoinhantin.name}</a>
                                </div>
                            </li>
                        </c:forEach>



                    </ul>
                </div>
                <div class="chat">
                    <div class="chat-header clearfix">
                        <div class="row">
                            <div class="col-lg-6">
                                <a href="javascript:void(0);" data-toggle="modal" data-target="#view_info">
                                    <img src="${img1}" alt="avatar">
                                </a>
                                <div class="chat-about">
                                    <h4 class="m-b-0">${nguoinhan}</h4>
                                </div>
                            </div>
                            <div class="col-lg-6 hidden-sm text-right">
                                <a href="javascript:void(0);" class="btn btn-outline-secondary"><i class="fa fa-camera"></i></a>
                                <a href="javascript:void(0);" class="btn btn-outline-primary"><i class="fa fa-image"></i></a>
                                <a href="javascript:void(0);" class="btn btn-outline-info"><i class="fa fa-cogs"></i></a>
                                <a href="javascript:void(0);" class="btn btn-outline-warning"><i class="fa fa-question"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="chat-history" id="chat-history" style="max-height: 400px; overflow-y: auto;">

                        <ul class="m-b-0">
                            <c:set var="id" value="${id}"></c:set>
                            <c:forEach var="item" items="${listcontent}">
                                <c:if test="${item.senderid.toString().equals(id.toString())}">
                                    <li class="clearfix">
                                        <div class="message-data text-right" style="margin-left:600px">
                                            <span class="message-data-time">${item.date}</span>
                                        </div>
                                        <div class="message other-message float-right"> ${item.content} </div>
                                    </li>
                                </c:if>
                                <c:if test="${!item.senderid.equals(id)}">
                                    <li class="clearfix">
                                        <div class="message-data">
                                            <span class="message-data-time">${item.date}</span>
                                        </div>
                                        <div class="message my-message">${item.content}</div>                                    
                                    </li>  
                                </c:if>

                            </c:forEach>



                        </ul>
                    </div>
                    <div class="chat-message clearfix">
                        <div class="input-group mb-0">
                            <form action="guitinnhan" method="post" style="  width: 400px; padding: 20px;">
                                <input type="text" name="content" placeholder="Enter text here...">    
                                <input type="hidden" name="id1" value="${id1}"> 

                                <input type="hidden" name="nguoinhan" value="${nguoinhan}"> 
                                <button type="submit" ><span class="input-group-text"><i class="fa fa-send"></i></span></button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var chatHistory = document.getElementById("chat-history");
        chatHistory.scrollTop = chatHistory.scrollHeight;
    });
</script>


</script>
<script>

// G?i hàm khi ng??i dùng nh?p vào ô tìm ki?m
// G?i hàm khi ng??i dùng nh?p vào ô tìm ki?m
    document.getElementById("search-input").addEventListener("input", function () {
        var searchTerm = this.value.toLowerCase();
        getMatchingSuggestions(searchTerm);
    });

// Hàm ?? l?y danh sách g?i ý t? server (s? d?ng AJAX)
    function getMatchingSuggestions(searchTerm) {
        $.ajax({
            url: 'getusernames', // Thay ??i ???ng d?n t?i Servlet ho?c máy ch? c?a b?n
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                var suggestions = data; // Danh sách tên ng??i dùng t? server
                var matchingSuggestions = [];

                suggestions.forEach(function (suggestion) {
                    if (suggestion.toLowerCase().includes(searchTerm)) {
                        matchingSuggestions.push(suggestion);
                    }
                });

                // Hi?n th? danh sách g?i ý d??i ô tìm ki?m
                var suggestionList = document.getElementById("suggestion-list");

                // Ki?m tra xem ô tìm ki?m có tr?ng không
                if (searchTerm === "") {
                    suggestionList.innerHTML = ""; // Xóa danh sách g?i ý
                } else {
                    suggestionList.innerHTML = ""; // Xóa danh sách g?i ý tr??c khi thêm l?i
                    matchingSuggestions.forEach(function (matchingSuggestion) {
                        var suggestionItem = document.createElement("li");
                        var suggestionLink = document.createElement("a");
                        suggestionLink.href = "getcontentchat?nguoinhantin=" + matchingSuggestion;
                        suggestionLink.textContent = matchingSuggestion;
                        suggestionItem.appendChild(suggestionLink);
                        suggestionList.appendChild(suggestionItem);
                    });
                }
            },
            error: function () {
                console.log('L?i khi l?y danh sách tên ng??i dùng');
            }
        });
    }


</script>
<script src="static/js/js.js"></script>

