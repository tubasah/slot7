<%-- 
    Document   : left_admin
    Created on : Oct 7, 2023, 9:32:37 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="admin.jsp">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <!-- Start Management Member Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#member-tables-nav" data-bs-toggle="collapse" href="#member-tables-nav">
                <i class="bi bi-person-fill"></i><span>Quản lý thành viên</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="member-tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="getListUser">
                        <i class="bi bi-circle"></i><span>Danh sách thành viên</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Management Member Nav -->


        <!-- Start Role Management Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#role-tables-nav" data-bs-toggle="collapse" href="#role-tables-nav">
                <i class="bi bi-key"></i><span>Quản lý vai trò</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="role-tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="taotaikhoanshipper.jsp">
                        <i class="bi bi-circle"></i><span>Tạo tài khoản vận chuyển</span>
                    </a>
                </li>
                <li>
                    <a href="getRequestRole">
                        <i class="bi bi-circle"></i><span>Nâng cấp vai trò</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Role Management Nav -->

        <!-- Start Category Management Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#category-tables-nav" data-bs-toggle="collapse" href="#category-tables-nav">
                <i class="bi bi-pen"></i><span>Quản lý danh mục sản phẩm</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="category-tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="list_category.jsp">
                        <i class="bi bi-circle"></i><span>Danh mục sản phẩm</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Category Management Nav -->
        
        <!-- Start Product Management Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#product-tables-nav" data-bs-toggle="collapse" href="#product-tables-nav">
                <i class="bi bi-basket2"></i><span>Quản lý sản phẩm</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="product-tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="list_product.jsp">
                        <i class="bi bi-circle"></i><span>Danh sách sản phẩm</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Product Management Nav -->

        

<!--        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li> End Profile Page Nav 

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-faq.html">
                <i class="bi bi-question-circle"></i>
                <span>F.A.Q</span>
            </a>
        </li> End F.A.Q Page Nav 

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-contact.html">
                <i class="bi bi-envelope"></i>
                <span>Contact</span>
            </a>
        </li> End Contact Page Nav 

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-register.html">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
            </a>
        </li> End Register Page Nav 

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-login.html">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
            </a>
        </li> End Login Page Nav 

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-error-404.html">
                <i class="bi bi-dash-circle"></i>
                <span>Error 404</span>
            </a>
        </li> End Error 404 Page Nav 

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-blank.html">
                <i class="bi bi-file-earmark"></i>
                <span>Blank</span>
            </a>
        </li> End Blank Page Nav 

    </ul>-->

</aside><!-- End Sidebar-->
