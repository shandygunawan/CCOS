<%-- 
    Document   : province_create
    Created on : Nov 11, 2021, 11:11:09 AM
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
        
        <title>CCOS - Add Province</title>
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
                        <span style="font-weight: bold">Add Province</span>
                    </div>
                    <div class="row mt-3">
                        <label for="province-code" class="col-sm-2 col-form-label">Province Code</label>
                        <div class="col-sm-4">
                            <html:text property="code" styleClass="form-control" styleId="province-code" />
                            <small id="province-code-help" class="form-text text-muted"></small>
                        </div>
                        <div class="col-sm-1">
                            
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="province-description" class="col-sm-2 col-form-label">Province Description</label>
                        <div class="col-sm-4">
                            <html:text property="name" styleClass="form-control" styleId="province-description" />
                            <small id="province-description-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12 d-flex justify-content-end">
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
            // Sidebar
            $("#sidebar-submenu-province").addClass("active");
            
            // Initiate Values
            $("#province-code-help, #province-description-help").text("0/40");
            
            //
            // CONSTRAINTS
            //
            
            // Required
            $("#province-code, #province-description").prop("required", true);
            
            // Max Length
            $("#province-code, #province-description").attr("maxlength", "40");
        });
        
        //
        // JQuery - Events
        //
        $("#province-code").keyup(function() {
            $('#province-code-help').text(this.value.replace(/ /g,'').length + '/40');
        });
        $("#province-description").keyup(function() {
            $('#province-description-help').text(this.value.replace(/ /g,'').length + '/40');
        });
        
    </script>
</html>
