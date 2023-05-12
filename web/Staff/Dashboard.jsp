
<%@page import="entity.Payment"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="assets/img/favicon.png">
  <title>
    Manager_MainPage
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
    <div class="container-fluid py-4">
      <div class="row">
        <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                 
                    <p class="text-sm mb-0 text-uppercase font-weight-bold">Today's Money</p>
                    <h5 class="font-weight-bolder">
                     
                    </h5>
<!--                    <p class="mb-0">
                      <span class="text-success text-sm font-weight-bolder">+55%</span>
                      since yesterday
                    </p>-->
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div class="icon icon-shape bg-gradient-primary shadow-primary text-center rounded-circle">
                    <i class="ni ni-money-coins text-lg opacity-10" aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                    <p class="text-sm mb-0 text-uppercase font-weight-bold">Today's Users</p>
                    <h5 class="font-weight-bolder">
                      2,300
                    </h5>
                    <p class="mb-0">
                      <span class="text-success text-sm font-weight-bolder">+3%</span>
                      since last week
                    </p>
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div class="icon icon-shape bg-gradient-danger shadow-danger text-center rounded-circle">
                    <i class="ni ni-world text-lg opacity-10" aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                    <p class="text-sm mb-0 text-uppercase font-weight-bold">New Clients</p>
                    <h5 class="font-weight-bolder">
                      +3,462
                    </h5>
                    <p class="mb-0">
                      <span class="text-danger text-sm font-weight-bolder">-2%</span>
                      since last quarter
                    </p>
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div class="icon icon-shape bg-gradient-success shadow-success text-center rounded-circle">
                    <i class="ni ni-paper-diploma text-lg opacity-10" aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                    <p class="text-sm mb-0 text-uppercase font-weight-bold">Sales</p>
                    <h5 class="font-weight-bolder">
                      $103,430
                    </h5>
                    <p class="mb-0">
                      <span class="text-success text-sm font-weight-bolder">+5%</span> than last month
                    </p>
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div class="icon icon-shape bg-gradient-warning shadow-warning text-center rounded-circle">
                    <i class="ni ni-cart text-lg opacity-10" aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
        
        <!--paste here-->
     <br>
     <br>
     <br>
     <br>
  </main>
  
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
 
 <div class="fixed-plugin">
                            <a class="fixed-plugin-button  position-fixed px-3 mt-1 ms-auto py-2">
                                <!--                        <i class="fa fa-cog py-2"> -->
                                <!--                            <input class="form-check-input  fa fa-eye" type="button"  onclick="darkMode(this)"> comment -->
                                <button style=" border: 0; background-color: white;" onclick="darkMode(this)"> <i class="fa fa-eye"></i></button> 
                                <!--                        </i>-->
                            </a>
                        </div>
  
  <!-- Github buttons -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
  <scriptssets/js/argon-dashboard.min.js?v=2.0.4"></script>
</body>

</html>