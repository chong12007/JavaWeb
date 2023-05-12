<%-- 
    Document   : checkOut
    Created on : May 9, 2023, 1:51:52 AM
    Author     : vivo
--%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%
    List<Product> productListCart = (List<Product>) session.getAttribute("productListCart");
    double total = 0;
    double fee = 0;
    double subTotal = 0;

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>LVGC Beauty Product Online Shop-mainPage</title>
        <%@ include file="assets/Header.jsp" %>
        <!-- Navbar End -->


        <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <a class="breadcrumb-item text-dark" href="#">Shop</a>
                    <span class="breadcrumb-item active">Checkout</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Checkout Start -->
    <div class="container-fluid">
        <form action="../PaymentServlet" method="post">
            <div class="row px-xl-5">
                <div class="col-lg-8">
                    <div class="mb-5">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
                        <div class="bg-light p-30">

                            <div class="form-group">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" name="payment" id="paypal" onchange="showPaymentForm('paypal')" value="MasterCard">
                                    <label class="custom-control-label" for="paypal">Master Card</label>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" name="payment" id="directcheck" onchange="showPaymentForm('paypal')" value="VisaCard"> 
                                    <label class="custom-control-label" for="directcheck">Visa Card</label>
                                </div>
                            </div>


                            <div class="form-group mb-4">
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" name="payment" id="cashOnDelivery" onchange="showPaymentForm('cashOnDelivery')" value="CashOnDelivery">
                                    <label class="custom-control-label" for="cashOnDelivery">Cash on Delivery</label>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div id="paypal-form" style="display:none;">
                        <!-- Paypal form fields -->
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Master Card Information</span></h5>
                        <div class="bg-light p-30 mb-5">


                            <div class="row">

                                <div class="col-md-6 form-group">
                                    <label>Owner</label><input class="form-control" type="text"  name="creditName" required></div>
                                <div class="col-md-6 form-group">
                                    <label>CVV</label><input class="form-control" type="text"  name="cvv" required></div>
                                <div class="col-md-12 form-group">
                                    <label>Card Number</label><input class="form-control" type="text"  name="cardNum" required></div>
                                <div class="col-md-12 form-group">
                                    <label for="expiry">Expiration Date:</label>
                                    <select id="expiry" name="expiry">
                                        <option value="">Month</option>
                                        <option value="01">January</option>
                                        <option value="02">February</option>
                                        <option value="03">March</option>
                                        <option value="04">April</option>
                                        <option value="05">May</option>
                                        <option value="06">June</option>
                                        <option value="07">July</option>
                                        <option value="08">August</option>
                                        <option value="09">September</option>
                                        <option value="10">October</option>
                                        <option value="11">November</option>
                                        <option value="12">December</option>
                                    </select>
                                    <select id="expiry-year" name="expiryYear">
                                        <option value="">Year</option>
                                        <option value="2022">2022</option>
                                        <option value="2023">2023</option>
                                        <option value="2024">2024</option>
                                        <option value="2025">2025</option>
                                        <option value="2026">2026</option>
                                        <!-- Add more years as needed -->
                                    </select>
                                </div>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-block btn-primary font-weight-bold py-3">Place Order</button>
                        </form>
                    </div>


                    <div id="cashOnDelivery-form" style="display:none;">
                        <!-- Bank Transfer form fields -->
                        <form method="post" action="../PaymentServlet">
                            
                            <input type="hidden" name="payment" value="CashOnDelivery">
                        <button type="submit" class="btn btn-block btn-primary font-weight-bold py-3">Place Order</button>
                        </form>
                    </div>


                    <script>
                        function showPaymentForm(paymentOption) {
                            // Hide all payment forms
                            document.getElementById("paypal-form").style.display = "none";
                            document.getElementById("cashOnDelivery-form").style.display = "none";


                            // Show the selected payment form
                            document.getElementById(paymentOption + "-form").style.display = "block";
                        }

                    </script>


                </div>
                <div class="col-lg-4">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                    <div class="bg-light p-30 mb-5">
                        <div class="border-bottom">
                            <% for (Product product : productListCart) {
                                    if (product.getQuantity() != 0) {
                                        double totalProductPrice = 0;

                            %>


                            <div class="d-flex justify-content-between">

                                <h6 class="mb-3"><%= product.getName()%></h6>
                                <%totalProductPrice = product.getPrice() * product.getQuantity();%>
                                <p>RM <%=totalProductPrice%></p>
                            </div>
                            <% total += product.getPrice() * product.getQuantity(); %>
                            <%}
                                }%>
                        </div>
                        <div class="border-bottom pt-3 pb-2">
                            <div class="d-flex justify-content-between mb-3">
                                <h6>Total</h6>

                                <h6>RM <%= total%></h6>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h6 class="font-weight-medium">Shipping</h6>
                                <%

                                    if (total <= 200)
                                        fee = 25;
                                %>
                                <h6 class="font-weight-medium">RM <%=fee%></h6>
                            </div>
                        </div>
                        <div class="pt-2">
                            <div class="d-flex justify-content-between mt-2">
                                <h5>SubTotal</h5>
                                <%
                                    subTotal = total + fee;%>
                                <h5>RM <%= subTotal%></h5>
                            </div>
                            <br>

                        

                          
                        </div>


                    </div>

                </div>
            </div>
    </div>
    <!-- Checkout End -->


    <%@ include file="assets/Footer.jsp" %>