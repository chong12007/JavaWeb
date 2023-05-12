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
        <div class="row px-xl-5">
            <div class="col-lg-8">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="row">
                        <div class="col-md-6 form-group">

                            <form method="post" action="../CheckOutServlet">

                                <label>Name</label>
                                <input class="form-control" type="text" value="${cust.name}" name="name" required>
                                </div>

                                <div class="col-md-6 form-group">
                                    <label>E-mail</label>
                                    <input class="form-control" type="email" value="${cust.email}" name="email" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Mobile No</label>
                                    <input class="form-control" type="tel"  value="${cust.phonenumber}" name="phoneNum" required >
                                </div>
                                <div class="col-md-12 form-group">
                                    <label>Address </label>
                                    <input type="text" value="${cust.address}" name="address" required class="form-control">
                                </div>


                        </div>
                    </div>

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

                                    if (total <= 250)
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
                            
                            <input type="hidden" name="total" value="<%=total%>">
                            <input type="hidden" name="totalPrice" value="<%=subTotal%>">
                            <input type="hidden" name="fee" value="<%=fee%>">
                            <button type="submit" class="btn btn-block btn-primary font-weight-bold py-3">Proceed to Payment</button>
                            </form>
                        </div>


                    </div>
                    <!--                <div class="mb-5">
                                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
                                        <div class="bg-light p-30">
                                            <div class="form-group">
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" class="custom-control-input" name="payment" id="paypal">
                                                    <label class="custom-control-label" for="paypal">Paypal</label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" class="custom-control-input" name="payment" id="directcheck">
                                                    <label class="custom-control-label" for="directcheck">Direct Check</label>
                                                </div>
                                            </div>
                                            <div class="form-group mb-4">
                                                <div class="custom-control custom-radio">
                                                    <input type="radio" class="custom-control-input" name="payment" id="banktransfer">
                                                    <label class="custom-control-label" for="banktransfer">Bank Transfer</label>
                                                </div>
                                            </div>
                                           
                                        </div>
                                    </div>-->
                </div>
            </div>
        </div>
        <!-- Checkout End -->


        <%@ include file="assets/Footer.jsp" %>