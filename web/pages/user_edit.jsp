<%-- 
    Document   : user_edit
    Created on : Nov 10, 2021, 2:34:50 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %>

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
        
        <title>CCOS - Edit User</title>
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
                        <span style="font-weight: bold">Edit User <bean:write name="user" property="id" /> </span>
                    </div>
                    <div class="row mt-3">
                        <label for="edit-name" class="col-sm-2 col-form-label">User Name</label>
                        <div class="col-sm-4">
                          <html:text property="name" 
                                     styleClass="form-control" 
                                     styleId="edit-name" />
                          <small id="edit-name-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="edit-role" class="col-sm-2 col-form-label">Role</label>
                        <div class="col-sm-4">
                            <html:select property="role" styleClass="form-select" styleId="edit-role">
                                <option value="Administrator">Administrator</option>
                                <option value="Operator">Operator</option>
                            </html:select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="edit-branch" class="col-sm-2 col-form-label">Branch</label>
                        <div class="col-sm-4">
                          <html:text property="branch" 
                                     styleClass="form-control" 
                                     styleId="edit-branch" />
                          <small id="edit-branch-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="edit-password" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-4">
                          <html:text property="password" 
                                     styleClass="form-control" 
                                     styleId="edit-password" />
                          <small id="edit-password-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <button type="button" class="btn btn-primary" id="button_edit">Edit</button>
                            <html:submit styleClass="btn btn-primary ms-2" styleId="button_save" value="Save"/>
                        </div>
                    </div>
                    <html:hidden property="task" value="edit" />
                    <html:hidden property="id" value="${user.id}" />
                </html:form>
                <html:errors />
            </div>
        </div>
    </body>
    <script>
        //
        // Variables
        //
        var isDetailEditable = false;
        
        //
        // JQuery - Init
        //
        $(document).ready(function() {
            $("#sidebar-menu-user").addClass("active");
            
            // Init fields value
            $("#edit-name").val("${user.name}");
            $("#edit-branch").val("${user.branch}");
            $("#edit-password").val("${user.password}");
            $("#edit-role").attr("data-selected", "${user.role}")
            $("#edit-role option[value=${user.role}]").attr('selected', 'selected');
            
            // Constraint - required
            $("input, select").prop('required', true);
            
            // Contraint - maxlength
            $("#edit-name, #edit-branch").attr("maxlength", "20");
            $("#edit-password").attr("maxlength", "20");
            
            // Login Password
            $("#edit-password").attr("type", "password");
            
            // Init elements text
            $("#edit-name-help").text( $("#edit-name").val().length + "/40")
            $("#edit-branch-help").text( $("#edit-branch").val().length + "/40")
            $("#edit-password-help").text( $("#edit-password").val().length + "/20")
           
            // Edit Mode
            $("input").prop('disabled', true);
            $("select").prop('disabled', true);
            $("#button_save").hide();
           
        });
        
        //
        // JQuery - Events
        //
        $("#edit-name").keyup(function() {
            $('#edit-name-help').text(this.value.length + '/40');
        });
        $("#edit-branch").keyup(function() {
            $('#edit-branch-help').text(this.value.length + '/40');
        });
        $("#edit-password").keyup(function() {
            $('#edit-password-help').text(this.value.length + '/20');
        });
        
        $("#button_edit").click(function() {
           if(isDetailEditable === false) {
                $("#button_edit").text("Cancel");
                $("#button_edit").removeClass();
                $("#button_edit").addClass("btn btn-danger");
                
                $("input").prop('disabled', false);
                $("select").prop('disabled', false);
                $("#button_save").show();
                isDetailEditable = true;
           } else {
                $("#button_edit").text("Edit");
                $("#button_edit").removeClass();
                $("#button_edit").addClass("btn btn-primary");

                $("input").prop('disabled', true);
                $("select").prop('disabled', true);
                
                $("#button_save").hide();
                isDetailEditable = false;
           }
        });
        
        
    </script>
</html>
