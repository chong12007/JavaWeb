<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="../assets/css/StaffLogin.css">
  <title>Staff Login</title>
</head>
<body>
    <section>
        <div class="all">
        <div class="form-box">
            <div class="form-value">
                <form action="../StaffLoginServlet" method="post">
                    <h2>Staff Login</h2>
                     <% if (session.getAttribute("errorMessage") != null) {%>
                    <div style="color: red; text-align: center;""><%= session.getAttribute("errorMessage")%></div>
                    <% } %>
                    <div class="inputbox">
                        <ion-icon name="person-outline"></ion-icon>
                        <input type="text" placeholder="Username" name="username" required>
                       
                    </div>
                    <div class="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                      
                      
                        <input type="password" placeholder="Password" name="password" required>
                    </div>
                   
                    <input type="submit" value="Login" class="submitBtn">
                </form>
            </div>
        </div>
        </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>