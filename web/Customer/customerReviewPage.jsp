<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LVGC Beauty Product Online Shop-Customer Review Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" id="bootstrap-css">

    </head>
    <link href="../assets/css/customerReviewPage.css" rel="stylesheet">
    <body>

        <div class="container d-flex justify-content-center mt-5">

            <div class="card text-center mb-5">

                Are You Like Our Shop?
                </span><br>




                <div class="rate bg-success py-3 text-white mt-3">

                    <h6 class="mb-0">Thanks For Purchasing Our Product</h6>

                    <p>Rate Your Shopping Experience?</p>

                    <form action="../CustomerReviewServlet" 
                          <div class="rating"> 
                        <input type="radio" name="rating" value="5" id="5"><label for="5">☆</label> 
                        <input type="radio" name="rating" value="4" id="4"><label for="4">☆</label>
                        <input type="radio" name="rating" value="3" id="3"><label for="3">☆</label> 
                        <input type="radio" name="rating" value="2" id="2"><label for="2">☆</label> 
                        <input type="radio" name="rating" value="1" id="1"><label for="1">☆</label>
                </div>
                <div class="form-group">
                    <label for="comment">Comment:</label>
                    <textarea class="form-control" name="comment" rows="2" id="comment"></textarea>
                </div>
          
        




        <div class="buttons px-4 mt-0">

            <button type="submit" class="btn btn-warning btn-block rating-submit">Submit</button>

        </div>
</form>

    </div>

    <footer>

</body>
</html>