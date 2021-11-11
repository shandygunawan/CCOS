<%-- 
    Document   : user_add
    Created on : Nov 10, 2021, 1:01:03 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Material Design Icons -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/@mdi/font@6.4.95/css/materialdesignicons.min.css">
        
        <!-- JQuery, Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
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
                    <div class="row mt-2">
                        <label for="add-userid" class="col-sm-2 col-form-label">User ID</label>
                        <div class="col-sm-4">
                            <html:text property="userId" styleClass="form-control" styleId="add-userid" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="add-username" class="col-sm-2 col-form-label">User Name</label>
                        <div class="col-sm-4">
                          <html:text property="userName" styleClass="form-control" styleId="add-username" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="add-role" class="col-sm-2 col-form-label">Role</label>
                        <div class="col-sm-4">
                            <html:select property="role" styleClass="form-select" styleId="add-role">
                                <option value="Administrator" selected>Administrator</option>
                                <option value="Operator">Operator</option>
                            </html:select>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="add-branch" class="col-sm-2 col-form-label">Branch</label>
                        <div class="col-sm-4">
                          <html:text property="branch" styleClass="form-control" styleId="add-branch" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="add-password" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-4">
                          <html:text property="password" styleClass="form-control" styleId="add-password" />
                        </div>
                    </div>
                    <div class="row mt-2 d-flex justify-content-end">
                        <html:submit styleClass="btn btn-primary mr-2" value="Save"/>
                    </div>
                </html:form>
                <html:errors />
            </div>
        </div>
    </body>
    <script>
        $(document).ready(function() {
           $("#sidebar-menu-user").addClass("active");
           
           $("#add-role").attr("aria-label", "Default select example");
           $("#add-role").css("width", "100%");
           $("#add-role").css("height", "100%");
           
           // Login Password
           $("#add-password").attr("type", "password");
           $("#add-password").attr("maxlength", "20");
           
           $("input").prop('required', true);
        });
    </script>
</html>
