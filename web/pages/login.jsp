<%-- 
    Document   : login
    Created on : Nov 9, 2021, 1:26:40 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/styles.css" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>CCOS - Login</title>
    </head>
    <body>
        <div class="d-flex m-2">
            
            
            
            <div id="login">
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
                <html:errors />
            </div>
            
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
