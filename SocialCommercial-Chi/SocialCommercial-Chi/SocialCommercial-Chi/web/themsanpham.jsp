<%-- 
    Document   : seller_form
    Created on : Sep 17, 2023, 2:25:10 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SOCO - Seller</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

        <!-- style css link -->
        <link rel="stylesheet" href="setofshop/css/styleonboarding.css">
        <!-- fontawesome css link -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>

        <header>
            <%@ include file="shop/header_shop.jsp" %>

        </header>
        <div class="home">

            <div class="containerr">
                <form action="themsanpham" method="post" enctype="multipart/form-data">
                    <div class="form-group row">
                        <label for="email" class="col-md-4 col-form-label">Ngành hàng:</label>
                        <div class="col-md-8">
                            <input type="text" value="${tendanhmuc}" name="tendanhmuc" class="form-control" placeholder="Ngành hàng" readonly>
                        </div>
                    </div>
                    <input type="hidden" value="${danhmuc}" name="email" class="form-control col-md-8 offset-md-2" placeholder="Email" readonly>

                    <div class="form-group row">
                        <label for="fullName" class="col-md-4 col-form-label">Tên sản phẩm:</label>
                        <div class="col-md-8">
                            <input type="text" id="full-name" name="product_name" class="form-control" placeholder="Tên sản phẩm" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="image" class="col-md-4 col-form-label">Hình ảnh sản phẩm:</label>
                        <div class="col-md-8">
                            <input type="file" id="shop-name" name="image" class="form-control" placeholder="Ảnh sản phẩm" required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="address" class="col-md-4 col-form-label">Số lượng:</label>
                        <div class="col-md-8">
                            <input type="text" id="address" name="product_available" class="form-control" placeholder="Số lượng" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="phone" class="col-md-4 col-form-label">Giá tiền:</label>
                        <div class="col-md-8">
                            <input type="tel" id="phone" name="product_price" class="form-control" placeholder="Giá tiền" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="phone" class="col-md-4 col-form-label">Mô tả sản phẩm:</label>
                        <div class="col-md-8">
                            <input type="tel" id="phone" name="product_description" class="form-control" placeholder="Mô tả sản phẩm" required>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Lưu & Hiển thị</button>
                    <button type="button" class="btn btn-outline-danger" onclick="confirmCancel()">Huỷ</button>

                </form>


            </div>
        </div>

        <script>
            function confirmCancel() {
                var confirmation = confirm("Bạn có chắc chắn muốn huỷ?"); // Hiển thị hộp thoại xác nhận

                if (confirmation) {
                    // Nếu người dùng xác nhận, chuyển hướng đến trang khác
                    window.location.href = '/SocialCommercial/seller';
                } else {
                    // Người dùng đã nhấn "Hủy" trong hộp thoại xác nhận, không có hành động gì xảy ra
                }
            }
        </script>
        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


    </body>
</html>





