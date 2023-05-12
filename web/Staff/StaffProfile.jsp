
<!DOCTYPE html>
<jsp:useBean id="staff" scope="session" class="entity.Staff" />
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



            <div class="container-fluid py-4">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header pb-0">
                            <div class="d-flex align-items-center">
                                <p class="mb-0">Edit Profile</p>
                                <!--                                <button class="btn btn-primary btn-sm ms-auto">Change Password</button>-->
                            </div>
                        </div>




                        <form action="../EditStaffProfileServlet" method="post" id="myForm">
                            <div class="card-body">
                                <p class="text-uppercase text-sm">User Information</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Username</label>
                                            <input class="form-control" type="text" name="username" value="${staff.username}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Nickname</label>
                                            <input class="form-control" type="text" name="nickname" value="${staff.nickname}">
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Email address</label>
                                            <input class="form-control" type="email" name="email" value="${staff.email}">
                                        </div>
                                    </div>

                                </div>
                                <hr class="horizontal dark">
                                <p class="text-uppercase text-sm">Contact Information</p>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Address</label>
                                            <input class="form-control" type="text" name="address" value="${staff.address}">
                                        </div>
                                    </div>
                                    <!--                <div class="col-md-4">
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
                                                    </div>-->
                                </div>
                                <hr class="horizontal dark">

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Phone Number</label>
                                            <input class="form-control" type="tel" name="phoneNumber" placeholder="eg:012-345-6789" pattern="[0]{1}[1]{1}[0-9]{1}-[0-9]{3}-[0-9]{4}" value="${staff.phonenumber}">
                                        </div>

                                        <p>Password</p>
                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Password</label>
                                            <input class="form-control" type="password" name="password" id="password" value="${staff.password}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="example-text-input" class="form-control-label">Confirm Password</label>
                                            <input class="form-control" type="password" id="ConfirmPassword" name="confirmPassword" value="${staff.password}" required>
                                        </div>
                                        
                                       
                                            <input class="form-control" type="hidden" id="ConfirmPassword" name="staffId" value="${staff.staffId}" required>
                                       

                                          <input type="submit" class="btn btn-primary float-end"><!-- comment -->
                                       <input type="button" class="btn btn-primary float-lg-end" value="Cancel" onclick="resetForm();">
                                      
                                        </form>

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
function resetForm() {
  document.getElementById("myForm").reset();
}
</script>

<script>
            function validateForm() {
                var password = document.getElementById("password").value;
                var confirmPassword = document.getElementById("Confirmassword").value;
                if (password === confirmPassword) {
                    return true;
                }
                alert("Passwords do not match.");
                return false;
            }
</script>


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