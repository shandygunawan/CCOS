<%-- 
    Document   : login
    Created on : Nov 9, 2021, 1:26:40 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        
        <title>CCOS - Login</title>
    </head>
    <body>
        <div class="d-flex justify-content-center p-4">
            
            <div class="card shadow p-3">
                <h5 class="card-title text-center">Welcome to CCOS-BCA!</h5>
                <div class="card-body">
                    <html:form action="login-action.do" method="post">
                        <div class="mb-3 row">
                            <label for="login-userid" class="col-sm-4 col-form-label">User ID</label>
                            <div class="col-sm-8">
                                <html:text property="userId" styleClass="form-control" styleId="login-userid"></html:text>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="login-password" class="col-sm-4 col-form-label">Password</label>
                            <div class="col-sm-8">
                                <html:text property="password" styleClass="form-control" styleId="login-password"></html:text>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 d-flex flex-row-reverse">
                                <html:submit styleClass="btn btn-primary" value="Login"/>
                            </div>
                        </div>
                    </html:form>
                </div>
            </div>
            <html:errors />
        </div>
    </body>
    
    <script>
        $(document).ready(function() {
            // Login User ID
            $("#login-userid").attr("maxlength", 8);
            $("#login-userid").prop('required', true);
            
            // Login Password
            $("#login-password").attr("type", "password");
            $("#login-password").attr("maxlength", "20");
            $("#login-password").prop('required', true);
        });
    </script>
</html>
