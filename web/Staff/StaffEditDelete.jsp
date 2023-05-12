


   
  <%@page import="entity.Staff"%>
<%    String action = request.getParameter("action");
    String staffIdStr = request.getParameter("sid"); 
         int staffId = Integer.parseInt(staffIdStr);
         session.setAttribute("sid", staffId);
         Staff staffedit = new Staff(staffId);
         session.setAttribute("staffedit", staffedit);
         %>
         
        
            <!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="assets/img/favicon.png">
        <title>
            Manage_Staff 
        </title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <!-- Nucleo Icons -->
        <link href="assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="assets/css/nucleo-svg.css" rel="stylesheet" /> 
        <link href="table.css" rel="stylesheet"/>
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <link href="assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- CSS Files -->
        <link id="pagestyle" href="assets/css/argon-dashboard.css?v=2.0.4" rel="stylesheet" />
    </head>
    
    
              
                    <div class="container-fluid py-4">
                        <%if(action.equals("edit")) {%>
                        <div class="col-12">

                            <form action="../EditProductServlet" method="POST" enctype="multipart/form-data">
                                <div class="card-body px-0 pt-0 pb-2">						
                                    <h4 class="modal-title">Edit Employee </h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">	
                                    <div class="form-group">
                                        <label>Staff ID</label>
                                        <input type="text" name="id" class="form-control" value="${staffedit.staffId}" readonly  >
                                    </div>
                                    <div class="form-group">
                                        <label>Role</label>
                                        <select class="form-select" name="role">
                                            <option value="Security Role Manager">Security Role Manager</option>
                                            <option value="Security Role Staff">Security Role Staff</option>
                                        </select>

                                      			
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" onclick="location.href='Staff_Tables.jsp'">
                                            <input type="submit" class="btn btn-info">
                                        </div>
<!--                                            important!!!!!1-->
                                 <input type="hidden" name="action" value="update">
                                        </form>
                                    </div>
                                </div>
                        </div>
                                    <%}else{%>
                        <!-- Delete Modal HTML -->
                        <div id="deleteEmployeeModal" class="">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="../AddEditDeleteStaffServlet" method="POST">
                                        <div class="modal-header">						
                                            <h4 class="modal-title">Delete Employee</h4>
                                       
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                             <div class="form-group">
                                        <label>Staff ID</label>
                                        <input type="text" name="id" class="form-control" value="${staffedit.staffId}" readonly >
                                    </div>
                                  
                                            <p>Are you sure you want to remove this staff?</p>
                                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" value="Cancel" onclick="location.href='Staff_Tables.jsp'">
                                            <input type="submit" class="btn btn-danger" value="Delete">
                                        </div>
<!--                                        important!!!!!1-->
                                 <input type="hidden" name="action" value="delete">
                                    </form>
                                </div>
                            </div>
                       <%}%>

                        
                        
                        
                      

</html>