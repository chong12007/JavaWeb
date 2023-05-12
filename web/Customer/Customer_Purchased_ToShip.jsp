<%-- 
    Document   : Customer_Purchased_ToShip
    Created on : May 2, 2023, 1:54:22 PM
    Author     : vivo
--%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>LVGC-ship</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="../assets/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  
    <a href="Customer_Purchased_ToShip.jsp"></a>
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/assets/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="../assets/lib/animate/animate.min.css" rel="stylesheet">
        <link href="../assets/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Customized Bootstrap Stylesheet -->
        <link href="../assets/css/style.css" rel="stylesheet">
        <link href="../assets/css/Customer_Purchased_ToShip.css" rel="stylesheet">
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
                <a href="ui-profile.html">
                    <img alt="" src="../assets/img/peoplePhoto.jpg" class="img-circle img-inline" class="img-responsive img-circle">
                </a>
            </div>
             <div class="profile-details">
                <h3>
                    <a href="#">Shane Taylor</a> 
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
   <br>
   <br>
   <br>
        </div>
        <div class="container" style="padding-left: 250px">
        <div class="table-wrap">
            <table class="table table-responsive table-borderless">
                <thead>
               <br>
   <br>
   <br>     
                     <th>&nbsp;</th>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>total</th>
                 
                </thead>
                <tbody>
                    <tr class="align-middle alert border-bottom" role="alert">
                        
                        <td class="text-center">
                            <img class="pic"
                                src=""
                                alt="">
                        </td>
                        <td>
                            <div>
                                <p class="m-0 fw-bold">Sneakers Shoes 2020 For Men</p>
                                <p class="m-0 text-muted">Fugiat Voluptates quasi nemo,ipsa perferencis</p>
                            </div>
                        </td>
                        <td>
                            <div class="fw-600">$44.99</div>
                        </td>
                        <td class="d-">
                            <input class="input" type="text" placeholder="2">
                        </td>
                        <td>
                            $89.98
                        </td>
                        
                    </tr>
                    <tr class="align-middle alert border-bottom" role="alert">
                       
                        <td class="text-center">
                            <img class="pic"
                                src=""
                                alt="">
                        </td>
                        <td>
                            <div>
                                <p class="m-0 fw-bold">Sneakers Shoes 2020 For Men</p>
                                <p class="m-0 text-muted">Fugiat Voluptates quasi nemo,ipsa perferencis</p>
                            </div>
                        </td>
                        <td>
                            <div class="fw-600">$54.99</div>
                        </td>
                        <td class="d-">
                            <input class="input" type="text" placeholder="2">
                        </td>
                        <td>
                            $108.98
                        </td>
                        
                    </tr>
                    <tr class="align-middle alert border-bottom" role="alert">
                       
                        <td class="text-center">
                            <img class="pic"
                                src=""
                                alt="">
                        </td>
                        <td>
                            <div>
                                <p class="m-0 fw-bold">Sneakers Shoes 2020 For Men</p>
                                <p class="m-0 text-muted">Fugiat Voluptates quasi nemo,ipsa perferencis</p>
                            </div>
                        </td>
                        <td>
                            <div class="fw-600">$50.99</div>
                        </td>
                        <td class="d-">
                            <input class="input" type="text" placeholder="2">
                        </td>
                        <td>
                            $100.98
                        </td>
                        
                    </tr>
                    <tr class="align-middle alert border-bottom" role="alert">
                        
                        <td class="text-center">
                            <img class="pic"
                                src=""
                                alt="">
                        </td>
                        <td>
                            <div>
                                <p class="m-0 fw-bold">Sneakers Shoes 2020 For Men</p>
                                <p class="m-0 text-muted">Fugiat Voluptates quasi nemo,ipsa perferencis</p>
                            </div>
                        </td>
                        <td>
                            <div class="fw-600">$74.99</div>
                        </td>
                        <td>
                            <input class="input" type="text" placeholder="2">
                        </td>
                        <td>
                            $148.98
                        </td>
                        
                    </tr>
                </tbody>
            </table>
        </div>
    </div>


        
        
        
        
        
      


        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="../assets/lib/easing/easing.min.js"></script>
        <script src="../assets/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="../assets/mail/jqBootstrapValidation.min.js"></script>
        <script src="../assets/mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="../assets/js/main.js"></script>
    </body>

</html>
