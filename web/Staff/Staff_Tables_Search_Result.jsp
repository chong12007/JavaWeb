<%-- 
    Document   : Staff_Tables
    Created on : May 2, 2023, 9:20:24 PM
    Author     : chong
--%>


<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Query"%>
<%@page import="entity.Staff"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%                                            
                                                        List<Staff> staffList = (List<Staff>) session.getAttribute("staffSearchResults");

                                                    %>


<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="assets/img/favicon.png">
        <title>
            Manage_Staff 
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

        <!--    <body "g-sidenav-show   bg-gray-100">-->


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
                                <h6>Staff Table   </h6>
                                <button  onclick="window.location.href = 'StaffAdd.jsp'" class="btn btn-primary float-end">Add Product</button>
                                <ul>

                                </ul>
                            </div>
                            <div class="card-body px-0 pt-0 pb-2">
                                <div class="table-responsive p-0">
                                    <table class="table align-items-center mb-0">
                                        <thead>
                                            <tr>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Staff ID</th>
                                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Staff Name</th>
                                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Role</th>
<!--                                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Email</th>-->
                                                <th class="text-left text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Edit Delete</th>
                                                <!--                                                <th class="text-secondary opacity-7">Edit Delete</th>-->
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>




                                                    <!--===========================================-->


                                                

                                                    <% for (Staff staff : staffList) {%>

                                            <tr>
                                                <td>
                                                    <div class="d-flex px-2 py-1">

                                                        <div class="d-flex flex-column justify-content-center">
                                                            <h6 class="mb-0 text-sm"><%= staff.getStaffId()%></h6>

                                                            <!--//                                                            <p class="text-xs text-secondary mb-0">laurent@creative-tim.com</p>-->
                                                        </div>
                                                    </div>
                                                </td>

                                                <td>
                                                    <h6 class="mb-0 text-sm"><%= staff.getUsername()%></h6>
                                                </td>
                                                <td class="align-middle text-center text-sm">
                                                    <h6 class="mb-0 text-sm"><%= staff.getStaffRole()%></h6>
                                                </td>
<!--                                                <td class="align-middle text-center">
                                                    <h6 class="mb-0 text-sm"><!= staff.getEmail()%></h6>
                                                </td>-->



                                                <td class="align-middle">
                                                    <a href="StaffEditDelete.jsp?sid=<%= staff.getStaffId()%>&action=edit"  class ="edit" > 
                                                        <i class="material-icons"  title="Edit">        &nbsp; &nbsp;&#xE254;</i>
                                                    </a>

                                                    <a href="StaffEditDelete.jsp?sid=<%= staff.getStaffId()%>&action=delete" class="delete" >
                                                        <i class="material-icons" title="Delete">&#xE872;</i>
                                                    </a>


                                                </td>



                                                <%}%>




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

