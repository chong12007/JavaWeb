<%-- 
    Document   : customerDashboard
    Created on : May 9, 2023, 3:11:00 AM
    Author     : vivo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cust" scope="session" class="entity.Customer" />
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="../assets/css/customerDashboard.css"/>
        <script src="../assets/js/customerDashboard.js"></script>

    </head>

    <body>
        <script src="https://use.fontawesome.com/07b0ce5d10.js"></script>




        <div class="page-topbar">
            <div class=""> </div>


            <ul class="pull-left info-menu user-info">
                <li class="profile">

                    <ul class="pull-left info-menu  user-notify">
                        <h2 style="color: rgb(209,186,116);font-family: Granjon;">LVGC Beauty Product Shop</h2>    
                    </ul>

                    </div>
                    </div>

                    <div class="page-sidebar expandit">
                        <div class="sidebar-inner" id="main-menu-wrapper">
                            <div class="profile-info row ">
                                <div class="profile-image ">
                                    <!--                <a href="ui-profile.html">
                                                        <img alt="" src="../assets/img/peoplePhoto.jpg" class="img-circle img-inline" class="img-responsive img-circle">
                                                    </a>-->
                                </div>
                                <div class="profile-details">
                                    <h3>
                                        <a href="#">${cust.name}</a> 
                                    </h3>
                                </div>
                            </div>

                            <ul class="wraplist" style="height: auto;">	
                                <!--          <li class="menusection">Main</li>-->
                                <li><a href="customerDashboard.jsp"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Profile</span></a></li>
                                <li><a href="Customer_Purchased_ToShip.jsp"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Product To Ship</span></a></li>
                                <li><a href="Customer_Purchased_ToReceive.jsp"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Product To Receive</span></a></li>
                                <li><a href="Customer_Purchased_History.jsp"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Product To Rate</span></a></li>
                                <li><a href="../Public/index.jsp"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Sign Out</span></a></li>

                            </ul>
                        </div>
                    </div>


                    <div class="container rounded bg-white mt-5 mb-5">
                        <div class="row">
                            <div class="col-md-3 border-right">

                            </div>
                            <div></div>
                            <div class="col-md-5 border-right">
                                <div class="p-3 py-5">
                                    <br>
                                    <br>
                                    <br>
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4 class="text-left">Profile Settings</h4>
                                    </div>
                                    <form method="post" action="">
                                        <div class="row mt-2">
                                            <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control"  value="${cust.name}"></div>
                                            <!--                    <div class="col-md-6"><label class="labels">Surname</label><input type="text" class="form-control" value="" placeholder="surname"></div>-->
                                        </div>
                                        <div class="row mt-3">
                                            <div class="col-md-12"><label class="labels">Mobile Number</label><input type="text" class="form-control"  value="${cust.phonenumber}"></div>

                                            <div class="col-md-12"><label class="labels">Address</label><textarea id="id" class=" form-control" name="name" rows="5" cols="10">${cust.address}</textarea></div>
                                            <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control"  value="${cust.email}"></div>

                                            <div class="col-md-12"><label class="labels">Password</label><input type="password" class="form-control"  value="${cust.password}"></div>
                                            <div class="col-md-12"><label class="labels">Confirm Password</label><input type="password" class="form-control"  value="${cust.password}"></div>
                                        </div>

                                        <br>
                                        <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Update Profile</button></div>
                                </div>
                                </form>
                            </div>

                        </div>
                    </div>
                    </div>
                    </div>


                    </body>
                    </html>