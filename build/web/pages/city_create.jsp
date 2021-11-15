<%-- 
    Document   : city_create
    Created on : Nov 11, 2021, 3:29:22 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        
        <!-- JQuery DataTables -->
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">
        
        <!-- Select2 -->
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - Add City</title>
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
                        <span style="font-weight: bold">Add City</span>
                    </div>
                    <div class="row mt-3">
                        <label for="city-code" class="col-sm-2 col-form-label">City Code</label>
                        <div class="col-sm-4">
                            <html:text property="code" styleClass="form-control" styleId="city-code" />
                            <small id="city-code-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="city-province" class="col-sm-2 col-form-label">City Province</label>
                        <div class="col-sm-4">
                            <html:select property="provId" styleClass="form-select" styleId="city-province">
                                <c:forEach items="${provinces}" var="province" varStatus="loop">
                                    <option value="${province.id}">
                                        ${province.name}
                                    </option>
                                </c:forEach>
                            </html:select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="city-description" class="col-sm-2 col-form-label">City Description</label>
                        <div class="col-sm-4">
                            <html:text property="name" styleClass="form-control" styleId="city-description" />
                            <small id="city-description-help" class="form-text text-muted"></small>
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
        $(document).ready(function() {
           // Sidebar
           $("#sidebar-submenu-city").addClass("active");
           
           // Init Text
           $("#city-code-help, #city-description-help").text("0/40");
           
           // Init Select 2
           $('#city-province').select2();
           
           // Constraint - Required
           $("#city-code, #city-province, #city-description").prop("required", true);
           
           // Constraint - Max Length
           $("#city-code, #city-description").attr("maxlength", "40");
           
        });
        $("#city-code").keyup(function() {
            $('#city-code-help').text(this.value.length + '/40');
        });
        $("#city-description").keyup(function() {
            $('#city-description-help').text(this.value.length + '/40');
        });
        
    </script>
</html>
