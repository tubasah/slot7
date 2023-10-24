<%-- 
    Document   : hero__categories
    Created on : Oct 2, 2023, 7:11:11 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="hero__categories">
    <div class="hero__categories__all">
        <i class="fa fa-bars"></i>
        <span>Danh mục</span>
    </div>
    <ul>
        <c:forEach items="${listC}" var="o">
            <li><a href="categorytype?cid=${o.cid}">${o.type}</a></li>
        </c:forEach>

    </ul>
</div>
