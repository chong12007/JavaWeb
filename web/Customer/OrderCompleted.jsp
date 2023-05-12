<%-- 
    Document   : OrderComplete
    Created on : May 11, 2023, 1:26:19 AM
    Author     : chong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Purchased Page</title>
        <%@ include file="assets/Header.jsp" %>
   


        <div class="row">
            <div class="col-sm-10 offset-sm-1 text-center">
                <p class="icon-addcart"><span><i class="icon-check"></i></span></p>
                <h2 class="mb-4">Thank you for purchasing, Your order is complete</h2>
                <p>
                    <a href="index.jsp"class="btn btn-primary btn-outline-primary">Home</a>
                    <a href="customerReviewPage.jsp" class="btn btn-primary btn-outline-primary">Leave Your Shopping Experience</a>
                    <a href="shop.jsp"class="btn btn-primary btn-outline-primary"><i class="icon-shopping-cart"></i> Continue Shopping</a>
                </p>
            </div>
        </div>
  
         <%@ include file="assets/Footer.jsp" %>
