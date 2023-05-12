<%@page import="entity.Inventory"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%
    List<Product> productList = (List<Product>) session.getAttribute("productList");
    String userRolee = (String) session.getAttribute("user");
%>



<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="assets/img/favicon.png">
        <title>
            Product table
        </title>
        <!--     Fonts and icons     -->

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <!-- Nucleo Icons -->
        <link href="assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="assets/css/nucleo-svg.css" rel="stylesheet" /> 
        <link href="table.css" rel="stylesheet"/>
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
            <div class="container-fluid py-4">
                <div class="row">
                    <div class="col-12">
                        <div class="card mb-4">
                            <div class="card-header pb-0">

                                <h4>Product table</h4>
                                 <% if (!userRolee.equals("Security Role Staff")) {%>
                                <button id="ViewAndEditProduct" onclick="window.location.href = 'ProductAdd.jsp'" class="btn btn-primary float-end">Add Product</button>
                                <%}%>
                                <!--            position:absolute;right:5px;transform:translateY(-50%);display:inline-block;padding:10px20px;font-size:16px;font-weight:bold;text-align:center;text-decoration:none;background-color:#89CFF0;color:#ffffff;border:none;border-radius:5px;cursor:pointer;-->
                            </div>
                            <div class="card-body px-0 pt-0 pb-2">
                                <div class="table-responsive p-0">
                                    <table class="table align-items-center justify-content-center mb-0">


                                        <thead>
                                            <tr>
                                                <th class="text-sm font-weight-bolder mb-0 ">Product ID</th>
                                                <th class="text-sm font-weight-bolder mb-0">Image</th>
                                                <th class="text-sm font-weight-bolder mb-0">Name</th>
                                                <th class="text-sm font-weight-bolder mb-0">Price</th>
                                                <th class="text-sm font-weight-bolder mb-0">Category</th>

                                                <th class="text-sm font-weight-bolder mb-0 ps-2">Stock amount</th>
                                                <th class="text-sm font-weight-bolder mb-0 ps-2">Status</th>
                                                <%if(!userRolee.equals("manager")) {%>
                                                  <th class="text-sm font-weight-bolder mb-0 ps-2">Edit</th>
                                                <%} else {%>
                                                  <th class="text-sm font-weight-bolder mb-0 ps-2">Edit&Delete</th>
                                                  <%}%>
                                              
                                                
                                            </tr>
                                        </thead>
                                        <tbody>



                                            <% for (Product product : productList) {%>

                                            <tr>
                                                <td>
                                                    <p class="text-sm-start font-weight-bolder mb-0">&nbsp;&nbsp;&nbsp;<%= product.getProductId()%></p>
                                                </td>

                                                <td>
                                                    <div>
                                                        <img src="<%=product.getImgPath()%> " class="avatar avatar-xl  me-2" alt="spotify"> 
                                                        <div class="my-auto">
                                                            </td>
                                                            <td>
                                                                <div class="d-flex px-2">

                                                                    <h6 class="mb-0 text-sm"><%= product.getName()%></h6>
                                                                </div>
                                                            </td>

                                                        </div>
                                                </td>
                                                <td>
                                                    <p class="text-sm font-weight-bolder mb-0">RM <%= product.getPrice()%></p>
                                                </td>

                                                <td class="align-middle text-center">


                                                    <p class="text-sm font-weight-bolder mb-0"><%= product.getCategory()%></p>


                                                </td>

                                                <td>

                                                    <p class="text-sm-center font-weight-bolder mb-0 text-center "><%= product.getQuantity()%></p>

                                                </td>

                                        <div class="statusAvailable1">
                                            <td class="align-middle text-center">

                                                <!--                                                <select name="status" id="product">
                                                                                                    <option value="available">Available</option>
                                                                                                    <option value="out of stock">Out of Stock</option>
                                                                                                    <option value="Hidden">Hidden</option>
                                                                                                </select>-->
                                                <% if (product.getStatus().equals("Out Of Stock") || product.getQuantity() <=0) {%>
                                              <p class="text-sm-start font-weight-bolder mb-0 text-danger"><%= product.getStatus()%></p>
                                                <%} else if (product.getStatus().equals("Hidden")) {%>
                                                <p class="text-sm-start font-weight-bolder mb-0 text-muted"><%= product.getStatus()%></p>
                                                <%} else {%>
                                                
                                                  <p class="text-sm-start font-weight-bolder mb-0 text-success"><%= product.getStatus()%></p>
                                                <%}%>
                                            </td>

                                            <td class="align-middle text-center">


                                                <% if (userRolee.equals("manager")) {%>
                                                <a href="../GetProduct?pid=<%= product.getProductId()%>&action=edit"  class="edit" "><i class="material-icons" title="Edit">&#xE254;</i></a>
                                                <a href="../GetProduct?pid=<%= product.getProductId()%>&action=delete" class="delete" "><i class="material-icons"  title="Delete">&#xE872;</i></a>
                                                <%} else  {%>
                                                <a href="../GetProduct?pid=<%= product.getProductId()%>&action=edit"  class="edit" "><i class="material-icons" title="Edit">&#xE254;</i></a>
                                               
                                                <%}%>

                                            </td>
                                        </div>


                                        </tr>




                                        <%

                                            }%>


                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>




            </div>
        </div>
    </div>
</div>

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