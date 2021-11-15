<%-- 
    Document   : customer_search
    Created on : Nov 12, 2021, 9:00:55 AM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
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
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        
        <!-- JQuery DataTables -->
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">
        
        <!-- Datepicker -->
        <link rel="stylesheet" href="assets/css/bootstrap-datepicker.standalone.min.css" />
        <script src="assets/js/bootstrap-datepicker.min.js"></script>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - Search Customer</title>
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
            
            <div id="content" class="container ps-3 pe-3 pt-2">
                <html:form>
                    <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">Search Customers</span>
                    </div>
                    <div class="row mt-3">
                        <label for="search-name" class="col-sm-2 col-form-label">Customer Name</label>
                        <div class="col-sm-4">
                            <html:text property="name" styleClass="form-control" styleId="search-name" />
                            <small id="search-name-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="search-idnum" class="col-sm-2 col-form-label">ID No</label>
                        <div class="col-sm-4">
                          <html:text property="idNum" styleClass="form-control" styleId="search-idnum" />
                          <small id="search-idnum-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="search-birthdate" class="col-sm-2 col-form-label">Date of Birth</label>
                        <div class="col-sm-4">
                          <html:text property="birthDate" styleClass="form-control" styleId="search-birthdate" readonly="true" />
                          <span>(DD/MM/YYYY)</span>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <html:submit styleClass="btn btn-primary me-2" value="Search"/>
                            <a href="/CCOS/customer.do?task=create_page">
                                <button class="btn btn-primary" type="button">Add</button>
                            </a>
                        </div>
                    </div>
                    <html:hidden property="task" value="search" />
                </html:form>
                
                <html:errors />
                <br/>
                
                <logic:notEmpty name="customers">
                    <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">Cities List</span>
                    </div>
                    <div class="row mt-3">
                        <table id="table-cust-list" class="table table-hover">
                            <thead class="table-light">
                                <tr>
                                    <th>Customer Name</th>
                                    <th>Address</th>
                                    <th>ID Type</th>
                                    <th>ID No.</th>
                                    <th>Birth Date</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate name="customers" id="cust">
                                    <tr>
                                        <td><bean:write name="cust" property="name"></bean:write></td>
                                        <td>${cust.residence.address}</td>
                                        <td><bean:write name="cust" property="idType"></bean:write></td>
                                        <td><bean:write name="cust" property="idNum"></bean:write></td>
                                        <td><bean:write name="cust" property="birthDate" format="dd/MM/yyyy"></bean:write></td>
                                        <td>
                                            <a href="/CCOS/customer.do?task=edit_page&custId=${cust.id}">
                                                Edit
                                            </a>
                                        </td>
                                    </tr>
                                </logic:iterate>
                            </tbody>
                        </table>
                    </div>
                </logic:notEmpty>
            </div>
        </div>
        
    </body>
    <script>
        
        //
        // JQuery - Init
        //
        $(document).ready(function() {
           $("#sidebar-menu-application").addClass("active");
           
           $("#search-idnum").attr("type", "number");
           
           // Constraint - maxlength
           $("#search-name, #search-idnum").attr("maxlength", "40");
           
           // Init elements text
           $("#search-name-help, #search-idnum-help").text("0/40");
           
           // Datepicker
           $("#search-birthdate").attr("data-provide", "datepicker");
           $("#search-birthdate").attr("data-date-end-date", "0d");
           $("#search-birthdate").datepicker({
               format: `dd/mm/yyyy`,
               autoclose: true,
               todayBtn: true,
               todayHighlight: true,
               clearBtn: true
           });
           
           // DataTable
           $('#table-cust-list').DataTable();
        });
        
        //
        // JQuery - Events
        //
        $("#search-name").keyup(function() {
            $('#search-name-help').text(this.value.length + '/40');
        });
        
        $("#search-idnum").keyup(function() {
            $('#search-idnum-help').text(this.value.length + '/40');
        });
        
        $("#search-idnum").keypress(function(e) {
            var txt = String.fromCharCode(e.which);
            if (!txt.match(/[0-9]/)) {
                return false;
            }
        });
        
    </script>
</html>
