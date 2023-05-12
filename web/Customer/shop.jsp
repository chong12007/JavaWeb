
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%
    List<Product> productList = (List<Product>) session.getAttribute("productList");

%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>LVGC Beauty Product Online Shop-shop</title>
        <%@ include file="assets/Header.jsp" %>
        <!-- Navbar End -->


        <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="CustomerPage.jsp">Home</a>
                    <a class="breadcrumb-item text-dark" href="shop.jsp">Shop</a>
                    <span class="breadcrumb-item active">Shop List</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!--Filter-->


 <!-- Shop Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <!-- Shop Sidebar Start -->
            <div class="col-lg-3 col-md-4">
                <!-- Price Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by price</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form method="post" action="../getFilterResult">
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <button value="1000" name="price" class="custom-control-input" checked id="price-all">button</button>
                            <label class="custom-control-label" for="price-all">All Price</label>
                            <span class="badge border font-weight-normal">1000</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <button value="100" name="price" class="custom-control-input" id="price-1">button</button>
                            <label class="custom-control-label" for="price-1">$Lower than $100</label>
                            <span class="badge border font-weight-normal">150</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <button value="200" name="price" class="custom-control-input" id="price-2">button</button>
                            <label class="custom-control-label" for="price-2">$Lower than $200</label>
                            <span class="badge border font-weight-normal">295</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <button value="300" name="price" class="custom-control-input" id="price-3">button</button>
                            <label class="custom-control-label" for="price-3">$Lower than $300</label>
                            <span class="badge border font-weight-normal">246</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <button value="400" name="price" class="custom-control-input" id="price-4">button</button>
                            <label class="custom-control-label" for="price-4">$Lower than $400</label>
                            <span class="badge border font-weight-normal">145</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                            <button value="500" name="price" class="custom-control-input" id="price-5">button</button>
                            <label class="custom-control-label" for="price-5">$Lower than $500</label>
                            <span class="badge border font-weight-normal">168</span>
                        </div>
                    </form>
                </div>
                <!-- Price End -->

              


            </div>

            <!--Filter end-->
            <!-- Shop Sidebar End -->


            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-8">
                <div class="row pb-3">
                    <div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                           
                            <div class="ml-2 float-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sorting</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#">Latest</a>
                                        <a class="dropdown-item" href="#">Popularity</a>
                                        <a class="dropdown-item" href="#">Best Rating</a>
                                    </div>
                                </div>
                                <div class="btn-group ml-2">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Showing</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#">10</a>
                                        <a class="dropdown-item" href="#">20</a>
                                        <a class="dropdown-item" href="#">30</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <% for (Product product : productList) {%>


                    <div class="col-lg-4 col-xs-6 col-sm-6 pb-1">
                        <div class="product-item bg-light mb-4">
                            <a href="../GetProduct?pid=<%= product.getProductId()%>&action=viewCustomer">
                            <div class="product-img position-relative overflow-hidden">
                                <%if (!product.getStatus().equals("Available")) {%>
                                <img class="img-fluid  " style=" filter: blur(5px);  -webkit-filter: blur(5px); width: 290px; height: 220px;" src="<%=product.getImgPath()%>" alt="">
                              <%} else {%>
                               <img class="img-fluid  " style="width: 290px; height: 220px;" src="<%=product.getImgPath()%>" alt="">
                              <%}%>
                            </div>
                            <div class="text-center py-4">
                                <a class="h6 text-decoration-none text-truncate" href=""><%=product.getName()%>
                                <div class="d-flex align-items-center justify-content-center mt-2">
                                    <h5>RM <%=product.getPrice()%></h5>
                                </div>
                                <div class="d-flex align-items-center justify-content-center mb-1">
                                    <%if (product.getQuantity() != 0) {%>
                                    <small>Available Stock : (<%=product.getQuantity()%>)</small>
                                    <%} else {%>
                                    <small>(Out of stock)</small>
                                    <%}%>
                                </div>
                            </div>
                                    </a>
                        </div>
                    </div>


                    <%}%>





                 
            <!-- Shop Product End -->
        </div>
    </div>
    <!-- Shop End -->


   <%@ include file="assets/Footer.jsp" %>