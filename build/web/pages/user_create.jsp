<%-- 
    Document   : user_add
    Created on : Nov 10, 2021, 1:01:03 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Material Design Icons -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/@mdi/font@6.4.95/css/materialdesignicons.min.css">
        
        <!-- JQuery, Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - Add User</title>
    </head>
    <body>
        <%
            if(session.getAttribute("userId") == null) {
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "/CCOS/login.do"); 
            }
        %>
        
        <jsp:include page="/components/header.jsp" />
        
        <div class="wrapper">
            <jsp:include page="/components/sidebar.jsp" />

            <div id="content" class="container">
                <html:form method="post">
                    <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">Add User</span>
                    </div>
                    <div class="row mt-3">
                        <label for="add-id" class="col-sm-2 col-form-label">User ID</label>
                        <div class="col-sm-4">
                            <html:text property="id" styleClass="form-control" styleId="add-id" />
                            <small id="add-id-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="add-name" class="col-sm-2 col-form-label">User Name</label>
                        <div class="col-sm-4">
                          <html:text property="name" styleClass="form-control" styleId="add-name" />
                          <small id="add-name-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="add-role" class="col-sm-2 col-form-label">Role</label>
                        <div class="col-sm-4">
                            <html:select property="role" styleClass="form-select" styleId="add-role">
                                <option value="Administrator" selected>Administrator</option>
                                <option value="Operator">Operator</option>
                            </html:select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="add-branch" class="col-sm-2 col-form-label">Branch</label>
                        <div class="col-sm-4">
                          <html:text property="branch" styleClass="form-control" styleId="add-branch" />
                          <small id="add-branch-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="add-password" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-4">
                          <html:text property="password" styleClass="form-control" styleId="add-password" />
                          <small id="add-password-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <html:submit styleClass="btn btn-primary mr-2" value="Save"/>
                        </div>
                    </div>
                <html:hidden property="task" value="create" />
                </html:form>
                <html:errors />
            </div>
        </div>
    </body>
    <script>
        //
        // JQuery - Init
        //
        $(document).ready(function() {
           $("#sidebar-menu-user").addClass("active");
           
           $("#add-password").attr("type", "password");
           
           // Contraint - required
           $("#add-id, #add-name, #add-role, #add-branch, #add-password").prop("required", true);
           
           // Contraint - maxlength
           $("#add-id").attr("maxlength", "8");
           $("#add-password").attr("maxlength", "20");
           $("#add-name, #add-branch").attr("maxlength", "40");
           
           // Init element texts
           $("#add-id-help").text("0/8");
           $("#add-password-help").text("0/20");
           $("#add-name-help, #add-branch-help").text("0/40");
        });
        
        //
        // JQuery - Events
        //
        $("#add-id").keyup(function() {
            $('#add-id-help').text(this.value.length + '/8');
        });
        $("#add-password").keyup(function() {
            $('#add-password-help').text(this.value.length + '/20');
        });
        $("#add-name").keyup(function() {
            $('#add-name-help').text(this.value.length + '/40');
        });
        $("#add-branch").keyup(function() {
            $('#add-branch-help').text(this.value.length + '/40');
        });
        
    </script>
</html>
