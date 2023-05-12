<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="../assets/img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/assets/css/all.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">


<!-- Libraries Stylesheet -->
<link href="../assets/lib/animate/animate.min.css" rel="stylesheet">
<link href="../assets/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="../assets/css/style.css" rel="stylesheet">

<jsp:useBean id="cust" scope="session" class="entity.Customer" />



</head>

<body style="overflow-x: hidden;">
    <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-1 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center h-100">
                    <a class="text-body mr-3" href="about.jsp">About</a>
                    <a class="text-body mr-3" href="contact.jsp">Contact</a>
                    <a class="text-body mr-3" href="faq.jsp">FAQs</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Welcome Back ${cust.name} </button>
                        <div class="dropdown-menu dropdown-menu-right">


                            <a href="customerDashboard.jsp"><button class="dropdown-item" type="button">My Account</button></a>
                             <a href="../GetProduct?action=cart"><button class="dropdown-item" type="button">My Cart</button></a>
                            <a href="../SignOutServlet"><button class="dropdown-item" type="button">Sign Out</button></a>



                        </div>
                    </div>

                </div>

               



                <div class="d-inline-flex align-items-center d-block d-lg-none">
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-heart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-shopping-cart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="index.jsp" class="text-decoration-none">
                    <span class="h1 text-uppercase px-2" style="background-color:rgb(209,186,116);">LVGC</span>
                    <span class="h1 text-uppercase px-2 ml-n1" style="background-color:rgb(230,206,172);">Beauty Shop</span>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
                 <form method="Get" action="../GetSearchResultServlet">
                    <div class="input-group">
                        <input type="search" name="query" class="form-control" placeholder="Search for products">
                         <input type="hidden" name="table"  value="productTableView">
                        <div class="input-group-append">
                            <button type="submit" class="input-group-text bg-transparent text-primary">
                               <i class="fa fa-search"></i> 
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-4 col-6 text-right">
                <p class="m-0">Customer Service</p>
                <h5 class="m-0">+012 345 6789</h5>
            </div>
        </div>
    </div>

    <div class="container-fluid mb-30" style="background-color:rgb(230,206,172)">
        <div class="row px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn d-flex align-items-center justify-content-between " data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;background-color:rgb(209,186,116); ">
                    <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>

            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg navbar-dark py-3 py-lg-0 px-0" style="background-color:rgb(230,206,172); ">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <span class="h1 text-uppercase text-dark px-2"style="background-color:rgb(209,186,116)"> Multi</span>
                        <span class="h1 text-uppercase text-light px-2 ml-n1"style="background-color:rgb(230,206,172)">Shop</span>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="index.jsp" class="nav-item nav-link "style=" cursor: pointer; transition: background-color 0.3s ease-in-out;" onmouseover="this.style.color = 'black';" onmouseout="this.style.color = 'white';">Home</a>
                            <a href="../GetProduct?action=getAllProductCustomer" class="nav-item nav-link"style=" cursor: pointer; transition: background-color 0.3s ease-in-out;" onmouseover="this.style.color = 'black';" onmouseout="this.style.color = 'white';">Shop</a>

                            <a href="contact.jsp" class="nav-item nav-link"style=" cursor: pointer; transition: background-color 0.3s ease-in-out;" onmouseover="this.style.color = 'black';" onmouseout="this.style.color = 'white';">Contact</a>
                        </div>
                     
                         <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                              
                                <a href="../GetProduct?action=cart" class="btn px-0 ml-3">
                                    <i class="fas fa-shopping-cart text-primary"></i>
                                    <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;"></span>
                                </a>
                            </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>