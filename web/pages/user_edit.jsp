<%-- 
    Document   : user_edit
    Created on : Nov 10, 2021, 2:34:50 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %>

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
        
        <title>CCOS - User Detail</title>
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
                        <span style="font-weight: bold">User Detail</span>
                    </div>
                    <div class="row mt-2">
                        <label for="edit-userid" class="col-sm-2 col-form-label">User ID</label>
                        <div class="col-sm-4">
                            <html:text property="userId" 
                                       styleClass="form-control" 
                                       styleId="edit-userid"
                                       value="${user.userId}" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="edit-username" class="col-sm-2 col-form-label">User Name</label>
                        <div class="col-sm-4">
                          <html:text property="userName" 
                                     styleClass="form-control" 
                                     styleId="edit-username" 
                                     value="${user.name}" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="edit-role" class="col-sm-2 col-form-label">Role</label>
                        <div class="col-sm-4">
                            <html:select property="role" styleClass="form-select" styleId="edit-role">
                                <option value="Administrator">Administrator</option>
                                <option value="Operator">Operator</option>
                            </html:select>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="edit-branch" class="col-sm-2 col-form-label">Branch</label>
                        <div class="col-sm-4">
                          <html:text property="branch" 
                                     styleClass="form-control" 
                                     styleId="edit-branch" 
                                     value="${user.branch}" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="edit-password" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-4">
                          <html:text property="password" 
                                     styleClass="form-control" 
                                     styleId="edit-password"
                                     value="${user.password}" />
                        </div>
                    </div>
                    <div class="row mt-2 d-flex justify-content-end">
                        <button type="button" class="btn btn-primary" id="button_edit">Edit</button>
                        <input type="hidden" name="method" value="edit" />
                        <html:submit styleClass="btn btn-primary ml-2" styleId="button_save" value="Save"/>
                    </div>
                </html:form>
                <html:errors />
            </div>
        </div>
    </body>
    <script>
        var isDetailEditable = false;
        
        $(document).ready(function() {
           $("#sidebar-menu-user").addClass("active");
           
           $("#edit-role").attr("aria-label", "Default select example");
           $("#edit-role").css("width", "100%");
           $("#edit-role").css("height", "100%");
           $("#edit-role").attr("data-selected", "${user.role}")
           
           // Login Password
           $("#edit-password").attr("type", "password");
           $("#edit-password").attr("maxlength", "20");
           
           $("input").prop('required', true);
           $("input").prop('disabled', true);
           $("select").prop('disabled', true);
           
           $("#button_save").hide();
           
           $("#edit-role option[value=${user.role}]").attr('selected', 'selected');
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
