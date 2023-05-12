<%-- 
    Document   : cart
    Created on : May 5, 2023, 5:38:04 PM
    Author     : vivo
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        List<Product> productListCart = (List<Product>) session.getAttribute("productListCart");
        double total = 0;
        double fee = 0;
        double subTotal = 0;
        double discount =0;
    %>

    <head>
        <meta charset="utf-8">
        <title>LVGC Beauty Product Online Shop-mainPage</title>
        <%@ include file="assets/Header.jsp" %>


        <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="index.jsp">Home</a>
                    <a class="breadcrumb-item text-dark" href="shop.jsp">Shop</a>
                    <span class="breadcrumb-item active">Shopping Cart</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">

                        <% for (Product product : productListCart) {

                        if(product.getQuantity() >0){
                                double totalProductPrice = 0;
                                
                        %>


                        <tr>
                            <td onclick ="window.location.href = '../GetProduct?pid=<%= product.getProductId()%>&action=viewCustomer';" class="align-middle">
                                <img src="<%=product.getImgPath()%>" alt="" style="width: 100px;height: 100px;"> <%=product.getName()%>
                            </td>

                            <td class="align-middle" id="quantity-price-<%= product.getProductId()%>">

                                RM <%=product.getPrice()%>
                            </td>


                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">

                                    <input type="number" class="form-control form-control-sm bg-secondary border-0 text-center" 
                                           name="quantity" value="<%=product.getQuantity()%>" id="quantity-input-<%=product.getProductId()%>" readonly>

                                </div>
                            </td>


                    <script>
                        // Add an event listener to the quantity input field for the current product
                        var quantityInput = document.getElementById("quantity-input-<%=product.getProductId()%>");
                        quantityInput.addEventListener("change", function () {
                            // Get the updated quantity value
                            var quantity = quantityInput.value;
                            // Calculate the updated total product price
                            var totalProductPrice = <%= product.getPrice()%> * quantity;
                            // Update the total price element with the new value
                            var totalPriceElement = document.getElementById("total-price-<%=product.getProductId()%>");
                            totalPriceElement.innerHTML = totalProductPrice;
                        });
                    </script>

                    <% totalProductPrice = product.getPrice() * product.getQuantity();%>

                    <td class="align-middle ">


                        RM <%=totalProductPrice%>

                    </td>


                    <form action="../DeleteCart" method="post">

                        <input type="hidden" value="<%=product.getCartProductId()%>" name="cpId">
                        <td class="align-middle"><button type="submit" class="btn btn-sm btn-danger"><i class="fa fa-times"></i></button></td>
                    </form>






                   

                    </tr>
                    <%
                            total += totalProductPrice;}
                        }%>

                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <form class="mb-30" action="">
                    <div class="input-group">
                        <input type="text" class="form-control border-0 p-4" placeholder="Calculate">

                    </div>
                </form>
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Calculate</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="border-bottom pb-2">
                        <div class="d-flex justify-content-between mb-3">

                            <h6>Subtotal</h6>
                            <h6>RM <%=total%></h6>


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
                            <h5>Total</h5>
                            <%
                                subTotal = (total + fee);%>
                            <h5>RM <%=subTotal%></h5>

                        </div>
                        <form action="CheckOutPage.jsp" method="post">
                            <input type="hidden" name="total" value="<%=total%>">
                            <input type="hidden" name="totalPrice" value="<%=subTotal%>">
                            <input type="hidden" name="fee" value="<%=fee%>">
                            <button class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To Checkout</button>
                        </form>


                    </div>
                </div>
            </div>
        </div>
    </div>




    <!-- Cart End -->

    <%@ include file="assets/Footer.jsp" %>
