<%-- 
    Document   : maintenance_user
    Created on : Nov 10, 2021, 9:50:05 AM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
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

            <div id="content" class="container">
                <html:form>
                    <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">Enter Search Criteria</span>
                    </div>
                    <div class="row mt-2">
                        <label for="search-userid" class="col-sm-2 col-form-label">User ID</label>
                        <div class="col-sm-4">
                            <html:text property="userId" styleClass="form-control" styleId="search-userid" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="search-username" class="col-sm-2 col-form-label">User Name</label>
                        <div class="col-sm-4">
                          <html:text property="userName" styleClass="form-control" styleId="search-username" />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <label for="search-branch" class="col-sm-2 col-form-label">Branch</label>
                        <div class="col-sm-4">
                          <html:text property="branch" styleClass="form-control" styleId="search-branch" />
                        </div>
                    </div>
                    <div class="row mt-2 d-flex justify-content-end">
                        <html:submit styleClass="btn btn-primary mr-2" value="Search"/>
                        
                        <a href="/CCOS/user-add.do">
                            <button class="btn btn-primary" type="button">Add</button>
                        </a>
                    </div>
                </html:form>
                <html:errors />
                
                <br/><br/><br/>
                
                <logic:notEmpty name="users">
                    <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">User List</span>
                    </div>
                    <div class="row mt-2">
                        <table class="table table-hover">
                            <thead class="table-light">
                                <tr>
                                    <th>User ID</th>
                                    <th>User Name</th>
                                    <th>Branch</th>
                                    <th>Role</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate name="users" id="user">
                                    <tr>
                                        <td><bean:write name="user" property="userId"></bean:write></td>
                                        <td><bean:write name="user" property="name"></bean:write></td>
                                        <td><bean:write name="user" property="branch"></bean:write></td>
                                        <td><bean:write name="user" property="role"></bean:write></td>
                                        <td>
                                            <a href="/CCOS/user-edit.do?method=detail&userId=${user.userId}">
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
        $(document).ready(function() {
           $("#sidebar-menu-user").addClass("active");
           $("input").css("border-width", "2px");
        });
    </script>
</html>
