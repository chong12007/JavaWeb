<%-- 
    Document   : CustomerLogin
    Created on : Apr 25, 2023, 4:01:09 PM
    Author     : chong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cust" scope="session" class="entity.Customer" />
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../assets/css/CustomerLogin.css">
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CustomerLogin Page</title>



    </head>

    <% if ((session.getAttribute("errorEmail") != null )||
    (request.getParameter("flag") != null) ||  (session.getAttribute("erorPhoneNumber") != null))  {%>
    <body onload="document.getElementById('signUpBtn').click();" style="overflow-x: hidden;">
    <% } else {%>
    <body style="overflow-x: hidden;">

        <%}%>




        <!--             <div id="loadingButton"></div>-->

        <div class="contlogin">
            <div class="loginform sign-in">
                <h2>Sign In</h2>
                <form action="../CustomerLoginRegisterServlet" method="POST">
                    <% if (session.getAttribute("errorMessage") != null) {%>
                    <div style="color: red; text-align: center;""><%= session.getAttribute("errorMessage")%></div>
                    <% } %>

                   


                    <% if (session.getAttribute("SuccessfulMessage") != null) {%>
                    <div style="color: green; text-align: center;""><%= session.getAttribute("SuccessfulMessage")%></div>
                    <% }%>
                    <label for="memberId">Email: </label><br>
                    <input type="text" id="email" name="email" placeholder="###" required value="${cust.email}">
                    <label for="password_user">Password: </label><br>
                    <input type="password" id="password_user" name="password" value="${cust.password}" required>

                    <input type="hidden" name="action" value="login">
                    <input type="submit" value="Sign In" >     

                </form>
                <p class="forgot-pass">Forgot Password ?</p>

                <div class="social-media">
                    <ul>
                        <li><img src="../assets/img/pictureForLogin/facebook.png"></li>

                        <li><img src="../assets/img/pictureForLogin/instagram.png"></li>

                        <li><img src="../assets/img/pictureForLogin/linkedin.png"></li>

                        <li><img src="../assets/img/pictureForLogin/twitter.png"></li>
                    </ul>
                </div>
            </div>

            <div class="sub-logincont">
                <div class="imglogging">
                    <div class="img-text m-up">
                        <h2>New here?</h2>
                        <p>Sign up and discover<br> great amount of new opportunities!</p>
                    </div>
                    <div class="img-text m-in">
                        <h2>One of us?</h2>
                        <p>If you already has an account,<br>  just sign in. We ve missed you!</p>
                    </div>
                    <div class="img-button">
                        <span class="m-up" id="signUpBtn">Sign Up</span>
                        <span class="m-in">Sign In</span>
                    </div>
                </div>
                <div class="loginform sign-up sign-up-cont">
                    <h2 id="signUpForm">Sign Up</h2>

                    <script>
                        function validateForm() {
                            var password = document.getElementById("RegisterPassword").value;
                            var confirmPassword = document.getElementById("confirm-password").value;
                            if (password === confirmPassword) {
                                return true;
                            }
                            alert("Passwords do not match.");
                            return false;
                        }
                    </script>


                    <form action="../CustomerLoginRegisterServlet" id="signUpForm" method="POST" onsubmit="return validateForm();">

                        <% if (session.getAttribute("errorEmail") != null) {%>
                        <div style="color: red; text-align: center;""><%= session.getAttribute("errorEmail")%></div>
                        <% }%>
                          <% if (session.getAttribute("errorPhoneNumber") != null) {%>
                    <div style="color: red; text-align: center;""><%= session.getAttribute("errorPhoneNumber")%></div>
                    <% } %>
                        <label for="user_name" >Name: </label><br>
                        <input type="text" id="user_name" name="username" pattern="[A-Za-z0-9 ]*" title="Only letters and spaces are permitted in this field." required>
                        <!--                                  <label for="user_gender">Gender</label><br>
                                                              <select id="user_gender" name="user_gender" required>
                                                                  <option value="selected hidden">Gender</option>
                                                                  <option value="male">Male</option>
                                                                  <option value="female">Female</option>
                                                              </select>-->
                        <label for="user_phone" >Phone Number: </label><br>
                        <input type="tel" id="user_number" name="phoneNum" placeholder="eg:012-345-6789" pattern="[0]{1}[1]{1}[0-9]{1}-[0-9]{3}-[0-9]{4}" required><br>
                        <label for="user_email">Email: </label><br>
                        <input type="email" id="email" name="email" required>
                        <label type="text">Address:</label><br>
                        <input type="text" id="user_home_address"
                               name="address">
                        <label for="password_user">Password: </label><br>
                        <input type="password" id="RegisterPassword" name="RegisterPassword" required>
                        <label for="comfirm_password_user">Comfirm Password: </label><br>
                        <input type="password" id="confirm-password" name="confirm-password" required>
                         <input type="hidden" name="action" value="register">
                        <input type="submit" value="Sign Up">      
                        <br><br>
                    </form>

                </div>

            </div>
        </div>
        <!--        <div class="load_display">
                    <iframe src="https://www.youtube.com/embed/DYJtKAlRs44" title="YouTube video player" frameborder="0" autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        
                </div>-->


    </body>
    
    <script type="text/javascript" src="../assets/js/CustomerLogin.js"></script>

    <script>

                        var loader = document.getElementById("loadingButton");

                        window.addEventListener("load", function (load) {
                            window.removeEventListener('load', load, false);
                            setTimeout(function () {
                                loader.style.display = 'none'
                            }, 2000);
                        }, false);


    </script>


</html>
