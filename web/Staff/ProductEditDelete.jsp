
<%@page import="entity.Product"%>

<jsp:useBean id="productModify" scope="session" class="entity.Product" />
<%
    String action = (String) session.getAttribute("productAction");
    Product p = (Product) session.getAttribute("productModify");
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="assets/img/favicon.png">
        <title>
            Manager_Profile
        </title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <!-- Nucleo Icons -->
        <link href="assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <link href="assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- CSS Files -->
        <link id="pagestyle" href="assets/css/argon-dashboard.css?v=2.0.4" rel="stylesheet" />
    </head>

    <body class="g-sidenav-show   bg-gray-100">

        <%@ include file="assets/controlPannel.jsp" %>
        <main class="main-content position-relative border-radius-lg ">
            <!-- Navbar -->
            <%@ include file="assets/navbar.jsp" %>
            <!-- End Navbar -->
            <div class="card shadow-lg mx-4 ">

                <%if (action.equals("edit")) {%>


                <!--card shadow-lg mx-4 card-profile-bottom-->
                <div class="card-body p-3">

                    <h2>Edit Product</h2>
                </div>
                <div class="container-fluid py-4">

                    <div class="col-md-12">
                        <div class="card">

                            <div class="card-body">
                                <p class="text-uppercase text-sm">Product Infomation</p>
                                <div class="row">
                                    <form action="../EditProductServlet" method="post" enctype="multipart/form-data">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="example-text-input" class="form-control-label">Product ID</label>
                                                <input class="form-control" type="text" name="productId" value="${productModify.productId}" readonly>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="example-text-input" class="form-control-label">Product Name</label>
                                                <input class="form-control" type="text" name="productName" value="${productModify.name}">
                                            </div>
                                        </div>


                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="example-text-input" class="form-control-label">Price<Price>/label>
                                                        <input class="form-control" type="number" step="0.01" onwheel="return false;" min="0" name="price" value="${productModify.price}">
                                                        </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label for="example-text-input" class="form-control-label">Category</label>
                                                                <select name="productType" class="form-select">

                                                                    <option value="Perfume" ${productModify.category == 'Perfume' ? 'selected' : ''}>Perfume</option>
                                                                    <option value="Lipstick" ${productModify.category == 'Lipstick' ? 'selected' : ''}>Lipstick</option>
                                                                    <option value="Makeup" ${productModify.category == 'Makeup' ? 'selected' : ''}>Makeup</option>

                                                                </select>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label for="example-text-input" class="form-control-label">Available Quantity</label>
                                                                <input class="form-control" type="text" name="quantity" onwheel="return false;" step="1" min="0" value="${productModify.quantity}">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="col-md-8 control-label" for="product_description">PRODUCT DESCRIPTION</label>
                                                            <div class="col-md-8">                     
                                                                <textarea class="form-control" id="product_description" name="product_description" >${productModify.description}</textarea>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <label for="example-text-input" class="form-control-label">Status</label>
                                                                <select name="status" class="form-select">
                                                                    <option value="Available">Available</option>
                                                                    <option value="Hidden">Hidden</option>


                                                                </select>
                                                            </div>

                                                        </div>

                                                        <!-- File Button --> 
                                                        <div class="form-group">

                                                            <label class="col-md-4 control-label" for="image">Select New Product Photo</label>
                                                            <div class="col-md-4">
                                                                <input id="imageFile" name="image" class="input-file" type="file">
                                                            </div>

                                                        </div>


                                                        <input type="submit" class="btn btn-primary btn-lg float-end">

                                                        </form>
                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>
                                                        </div>


                                                        </div>
                                                        <%} else{%>



                                                        <div class="card-body p-3    ">

                                                            <h2><strong>Delete Product</strong></h2>
                                                        </div>
                                                        <div class="container-fluid py-4">

                                                            <div class="alert alert-danger alert-success">
                                                                <strong>Warning!</strong> Product will permanently Deleted!
                                                            </div>

                                                            <div class=" alert ">
                                                                It was recommended to set Product as Hidden
                                                            </div>
                                                            <div class="col-md-12">

                                                                <%if (p.getQuantity() > 0){%>
                                                                <div class=" alert alert-warning alert-success ">
                                                                   Please Clear all of the stock before deleting!
                                                                </div>
                                                                <div class="col-md-12">
                                                                    <%}%>
                                                                    <div class="card">

                                                                        <div class="card-body">
                                                                            <p class="text-uppercase text-sm">Product Infomation</p>
                                                                            <div class="row">
                                                                                <form action="../DeleteProductServlet" method="post">
                                                                                    <div class="col-md-6">
                                                                                        <div class="form-group">
                                                                                            <label for="example-text-input" class="form-control-label">Product ID</label>
                                                                                            <input class="form-control" type="text" name="id" value="${productModify.productId}" readonly>

                                                                                        </div>
                                                                                    </div>



                                                                                    <div class="col-md-6">
                                                                                        <div class="form-group">
                                                                                            <label for="example-text-input" class="form-control-label">Product Name</label>
                                                                                            <input class="form-control" type="text" name="productName" value="${productModify.name}">
                                                                                        </div>
                                                                                    </div>

                                                                                    <div class="col-md-6">
                                                                                        <div class="form-group">
                                                                                            <label for="example-text-input" class="form-control-label">Product Quantity</label>
                                                                                            <input class="form-control" type="text" name="productName" value="${productModify.quantity}" readonly>
                                                                                        </div>
                                                                                    </div>





                                                                                    <input type="hidden" name="action" value="delete">

                                                                                    <% if (p.getQuantity() > 0) {%>
                                                                                    <input type="submit" value="Delete" class="btn btn-danger btn-lg float-end">
                                                                                    <%} else {%>
                                                                                    <input type="submit" value="Delete" class="btn btn-danger btn-lg float-end" disabled>

                                                                                    <%}%>
                                                                                    <input type="button" class="btn btn-default btn-lg float-end" value="Cancel" onclick="location.href = 'Product_Tables.jsp'">


                                                                                </form>
                                                                            </div>
                                                                        </div>
                                                                    </div>


                                                                    <%}%>
                                                                    </main>




                                                                    <div class="fixed-plugin">
                                                                        <a class="fixed-plugin-button  position-fixed px-3 mt-1 ms-auto py-2">
                                                                            <!--                        <i class="fa fa-cog py-2"> -->
                                                                            <!--                            <input class="form-check-input  fa fa-eye" type="button"  onclick="darkMode(this)"> comment -->
                                                                            <button style=" border: 0; background-color: white;" onclick="darkMode(this)"> <i class="fa fa-eye"></i></button> 
                                                                            <!--                        </i>
                                                                            </a>
                                                                    </div>
                                    
                                    
                                    
                                                                            <!--   Core JS Files   -->
                                                                            <script src="assets/js/core/popper.min.js"></script>
                                                                            <script src="assets/js/core/bootstrap.min.js"></script>
                                                                            <script src="assets/js/plugins/perfect-scrollbar.min.js"></script>
                                                                            <script src="assets/js/plugins/smooth-scrollbar.min.js"></script>
                                                                            <script>
                                                                                var win = navigator.platform.indexOf('Win') > -1;
                                                                                if (win && document.querySelector('#sidenav-scrollbar')) {
                                                                                    var options = {
                                                                                        damping: '0.5'
                                                                                    }
                                                                                    Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
                                                                                }
                                                                            </script>
                                                                            <!-- Github buttons -->
                                                                            <script async defer src="https://buttons.github.io/buttons.js"></script>
                                                                            <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
                                                                            <script src="assets/js/argon-dashboard.min.js?v=2.0.4"></script>

                                                                            <script type="text/javascript">
                                                                                function validateFileType() {
                                                                                    var fileName = document.getElementById("imageFile").value;
                                                                                    var idxDot = fileName.lastIndexOf(".") + 1;
                                                                                    var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
                                                                                    if (extFile == "jpg" || extFile == "jpeg" || extFile == "png") {
                                                                                        //TO DO
                                                                                    } else {
                                                                                        alert("Only jpg/jpeg and png files are allowed!");
                                                                                        document.getElementById("\imageFile").value = "";
                                                                                    }
                                                                                }
                                                                            </script>

                                                                            </body>

                                                                            </html>