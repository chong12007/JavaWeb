<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="../assets/img/favicon.ico" rel="icon">
<jsp:useBean id="cust" scope="session" class="entity.Customer" />

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
                           
                            <div class="profile-details">
                                <h3>
                                    <a href="#">${cust.name}</a> 
                                </h3>
                            </div>
                        </div>

                        <ul class="wraplist" style="height: auto;">	
                            <!--          <li class="menusection">Main</li>-->
                            <li><a href="customerDashboard.jsp"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Profile</span></a></li>
                            <li><a href="../GetMyPurchase"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Product To Ship</span></a></li>
                            <li><a href="../GetMyPurchaseReceive"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Product To Receive</span></a></li>
                            <li><a href="../GetMyPurchase?action=history"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Product To Rate</span></a></li>
                            <li><a href="../Public/index.jsp"><span class="sidebar-icon"><i class="fa fa-"></i></span> <span class="menu-title">Sign Out</span></a></li>
                        </ul>
                    </div>
                    <br>
                    <br>
                    <br>
                </div>