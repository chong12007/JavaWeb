
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

                <div class="card-body p-3">

                    <h2>Register a new staff </h2>
                </div>
                <div class="container-fluid py-4">

                    <div class="col-md-12">
                        <div class="card">

                            <div class="card-body">
                                <p class="text-uppercase text-sm">Staff Infomation</p>
                                <div class="row">
                                    <form method="post" action="../AddEditDeleteStaffServlet">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <% if (session.getAttribute("staffAlreadyRegistered") != null) {%>
                                                <div style="color: red; text-align: left;""><%= session.getAttribute("staffAlreadyRegistered")%></div>
                                                <% }%>
                                                 <% if (session.getAttribute("SuccessfulAddedStaff") != null) {%>
                                                <div style="color: green; text-align: left;""><%= session.getAttribute("SuccessfulAddedStaff")%></div>
                                                <% }%>
                                                <label for="username" class="form-control-label">Staff username</label>
                                                <input class="form-control" type="text" name="username">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="example-text-input" class="form-control-label">Password</label>
                                                <input class="form-control" type="password" name="password">
                                            </div>
                                        </div>


                                </div>
                                <hr class="horizontal dark">
                                <p class="text-uppercase text-sm">Role</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Role</label>

                                            <select class="form-select" id="role" name="role">
                                                <option value="Security Role Manager">Security Role Manager</option>
                                                <option value="Security Role Staff">Security Role Staff</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
<!--                                important!!!!!1-->
                                 <input type="hidden" name="action" value="add">
                                <div class="col-md-6">
                                    <input type="submit" class="btn btn-primary">
                                </div>
                                </form>
                                <!--                                    <div class="col-md-4">
                                                                        <div class="form-group">
                                                                            <label for="example-text-input" class="form-control-label">City</label>
                                                                            <input class="form-control" type="text" value="New York">
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-4">
                                                                        <div class="form-group">
                                                                            <label for="example-text-input" class="form-control-label">Country</label>
                                                                            <input class="form-control" type="text" value="United States">
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-4">
                                                                        <div class="form-group">
                                                                            <label for="example-text-input" class="form-control-label">Postal code</label>
                                                                            <input class="form-control" type="text" value="437300">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <hr class="horizontal dark">
                                                                <p class="text-uppercase text-sm">Phone Number</p>
                                                                <div class="row">
                                                                    <div class="col-md-12">
                                                                        <div class="form-group">
                                                                            <label for="example-text-input" class="form-control-label">Phone Number</label>
                                                                            <input class="form-control" type="text" value="A beautiful Dashboard for Bootstrap 5. It is Free and Open Source.">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>-->
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
