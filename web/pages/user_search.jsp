<%-- 
    Document   : maintenance_user
    Created on : Nov 10, 2021, 9:50:05 AM
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
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - User</title>
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
                        <span style="font-weight: bold">Search Users</span>
                    </div>
                    <div class="row mt-3">
                        <label for="search-id" class="col-sm-2 col-form-label">User ID</label>
                        <div class="col-sm-4">
                            <html:text property="id" styleClass="form-control" styleId="search-id" />
                            <small id="search-id-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="search-name" class="col-sm-2 col-form-label">User Name</label>
                        <div class="col-sm-4">
                          <html:text property="name" styleClass="form-control" styleId="search-name" />
                          <small id="search-name-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="search-branch" class="col-sm-2 col-form-label">Branch</label>
                        <div class="col-sm-4">
                          <html:text property="branch" styleClass="form-control" styleId="search-branch" />
                          <small id="search-branch-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <html:submit styleClass="btn btn-primary me-2" value="Search"/>
                            <a href="/CCOS/user.do?task=create_page">
                                <button class="btn btn-primary" type="button">Add</button>
                            </a>
                        </div>
                    </div>
                    <html:hidden property="task" value="search" />
                </html:form>
                
                <br/>
                
                <logic:notEmpty name="users">
                    <div class="row mt-4 p-2" style="background-color: lightblue;">
                        <span style="font-weight: bold">User List</span>
                    </div>
                    <div class="row mt-3">
                        <table id="table-user-list" class="table table-hover">
                            <thead class="table-light">
                                <tr>
                                    <th>User ID</th>
                                    <th>User Name</th>
                                    <th>Branch</th>
                                    <th>Role</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate name="users" id="user">
                                    <tr>
                                        <td><bean:write name="user" property="id"></bean:write></td>
                                        <td><bean:write name="user" property="name"></bean:write></td>
                                        <td><bean:write name="user" property="branch"></bean:write></td>
                                        <td><bean:write name="user" property="role"></bean:write></td>
                                        <td>
                                            <a href="/CCOS/user.do?task=edit_page&userId=${user.id}">
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
            // Sidebar
            $("#sidebar-menu-user").addClass("active");
            
            // Contraint - maxlength
            $("#search-id, #search-branch, #search-name").attr("maxlength", "40");
            
            // Init elements text
            $("#search-id-help, #search-branch-help, #search-name-help").text("0/40");
            
            // DataTable
            $('#table-user-list').DataTable();
        });
        
        //
        // JQuery - Events
        //
        $("#search-id").keyup(function() {
            $('#search-id-help').text(this.value.length + '/40');
        });
        
        $("#search-name").keyup(function() {
            $('#search-name-help').text(this.value.length + '/40');
        });
        
        $("#search-branch").keyup(function() {
            $('#search-branch-help').text(this.value.length + '/40');
        });
        
    </script>
</html>
