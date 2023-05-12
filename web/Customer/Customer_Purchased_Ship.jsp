<%-- 
    Document   : Customer_Purchased_ToShip
    Created on : May 2, 2023, 1:54:22 PM
    Author     : vivo
--%>
<%@page import="entity.Purchase"%>
<%@page import="entity.Payment"%>
<%@page import="entity.PurchaseHistory"%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<PurchaseHistory> customerPurchaseHistoryList = (List<PurchaseHistory>) session.getAttribute("customerPurchaseHistory");

%>
<head>
    <meta charset="utf-8">
    <title>LVGC-ship</title>
  
     <%@ include file="assets/DashboardHeader.jsp" %>
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

                                <%for (PurchaseHistory purchaseHistory : customerPurchaseHistoryList) {  
                                
                                double totalProduct = 0;%>
                                <tr class="align-middle alert border-bottom" role="alert">

                                    <td class="text-center">
                                      
                                        <img class="pic"
                                             src="<%=purchaseHistory.getImgPath()%>"
                                             alt="">
                                       
                                    </td>
                                    <td>
                                        <div>
                                            <p class="m-0 fw-bold"><%=purchaseHistory.getName()%></p>
                                            <p class="m-0 text-muted"><%=purchaseHistory.getDescription()%></p>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="fw-600"><%=purchaseHistory.getPrice()%></div>
                                    </td>
                                    <td class="d-">
                                        <input class="input" type="text" value="<%=purchaseHistory.getQuantity()%>">
                                    </td>
                                     <% totalProduct = purchaseHistory.getPrice() * purchaseHistory.getQuantity();%>
                                    <td>
                                       <%=totalProduct%>
                                       
                                    </td>

                                </tr>
                                <%}%>
                              
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


