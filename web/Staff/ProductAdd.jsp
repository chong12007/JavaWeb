

    
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
                <!--card shadow-lg mx-4 card-profile-bottom-->
              
                 <div class="card-body p-3">

                    <h2>Add Product</h2>
                </div>
                <div class="container-fluid py-4">

                    <div class="col-md-12">
                        <div class="card">

                            <div class="card-body">
                                <p class="text-uppercase text-sm">Product Infomation</p>
                                <div class="row">
                                    <form action="../AddProductServlet" method="post"  enctype="multipart/form-data">
                                        
                                        <div class="col-md-6">
                                            <div class="form-group">
                                               
                                                
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="example-text-input" class="form-control-label">Product Name</label>
                                                <input class="form-control" type="text" name="productName" required >
                                            </div>
                                        </div>


                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="example-text-input" class="form-control-label">Price</label>
                                                <input class="form-control" type="number" step="0.01" min="0" onwheel="return false;" name="price" required>
                                                        </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label for="example-text-input" class="form-control-label">Category</label>
                                                                <select name="productType" class="form-select" required>

                                                                    <option value="Perfume">Perfume</option>
                                                                    <option value="Lipstick">Lipstick</option>
                                                                    <option value="Makeup">Makeup</option>

                                                                </select>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label for="example-text-input" class="form-control-label">Available Quantity</label>
                                                                <input class="form-control" type="number" onwheel="return false;" step="1" min="0" name="quantity" required>
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="col-md-8 control-label" for="product_description">PRODUCT DESCRIPTION</label>
                                                            <div class="col-md-8">                     
                                                                <textarea class="form-control" id="product_description" name="product_description" required ></textarea>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-2">
                                                            <div class="form-group">
                                                                <label for="example-text-input" class="form-control-label">Status</label>
                                                                <select name="status" class="form-select" required>
                                                                    <option value="Available">Available</option>
                                                                    <option value="Hidden">Hidden</option>


                                                                </select>
                                                            </div>

                                                        </div>

                                                        <!-- File Button --> 
                                                        <div class="form-group">

                                                            <label class="col-md-4 control-label" for="image">Select New Product Photo</label>
                                                            <div class="col-md-4">
                                                                <input id="imageFile" name="image" class="input-file" type="file" required>
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
        </main>
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                

                            <div class="fixed-plugin">
                                <a class="fixed-plugin-button  position-fixed px-3 mt-1 ms-auto py-2">
                                    <!--                        <i class="fa fa-cog py-2"> -->
                                    <!--                            <input class="form-check-input  fa fa-eye" type="button"  onclick="darkMode(this)"> comment -->
                                    <button style=" border: 0; background-color: white;" onclick="darkMode(this)"> <i class="fa fa-eye"></i></button> 
                                    <!--                        </i>-->
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
                            </body>

                            </html>