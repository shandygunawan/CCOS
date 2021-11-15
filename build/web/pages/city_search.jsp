<%-- 
    Document   : city_search
    Created on : Nov 11, 2021, 1:22:10 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %>
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
        
        <title>CCOS - City Search</title>
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
                        <span style="font-weight: bold">Search City</span>
                    </div>
                    <div class="row mt-3">
                        <label for="search-by" class="col-sm-2 col-form-label">Search By</label>
                        <div class="col-sm-4">
                            <div class="form-check">
                                <html:radio property="searchBy" value="code" styleId="radio-searchby-code" styleClass="form-check-input" />
                                <label class="form-check-label" for="radio-searchby-code">
                                  Code
                                </label>
                            </div>
                            <div class="form-check">
                                <html:radio property="searchBy" value="description" styleId="radio-searchby-description" styleClass="form-check-input" />
                                <label class="form-check-label" for="radio-searchby-description">
                                  Description
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-3" id="search-provid-row">
                        <label for="search-provid" class="col-sm-2 col-form-label">Enter Province</label>
                        <div class="col-sm-4">
                            <html:select property="provId" styleClass="form-select" styleId="search-provid">
                                <option value="0" selected>All Provinces</option>
                                <c:forEach items="${provinces}" var="province" varStatus="loop">
                                    <option value="${province.id}">
                                        ${province.name}
                                    </option>
                                </c:forEach>
                            </html:select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <label for="search-value" class="col-sm-2 col-form-label">Enter Value</label>
                        <div class="col-sm-4">
                            <html:text property="searchValue" styleClass="form-control" styleId="search-value" />
                            <small id="search-value-help" class="form-text text-muted"></small>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <html:submit styleClass="btn btn-primary me-2" value="Search"/>
                            <a href="/CCOS/city.do?task=create_page">
                                <button class="btn btn-primary" type="button">Add</button>
                            </a>
                        </div>
                    </div>
                    <html:hidden property="task" value="search" />
                </html:form>
                
                <html:errors />
                <br/>
                
                <logic:notEmpty name="cities">
                    <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">Cities List</span>
                    </div>
                    <div class="row mt-3">
                        <table id="table-city-list" class="table table-hover">
                            <thead class="table-light">
                                <tr>
                                    <th>Code</th>
                                    <th>Description</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate name="cities" id="city">
                                    <tr>
                                        <td><bean:write name="city" property="id"></bean:write></td>
                                        <td><bean:write name="city" property="name"></bean:write></td>
                                        <td>
                                            <a href="/CCOS/city.do?task=edit_page&cityId=${city.id}">
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
            $("#sidebar-submenu-city").addClass("active");
            
            $("#search-provid-row").hide();
            
            // constraint - maxlength
            $("#search-value").attr("maxlength", "40");
            
            // Init fields value
            $("#radio-searchby-code").prop("checked", true);
            
            // Init Elements text
            $("#search-value-help").text("0/40");
            
            // DataTable
            $('#table-city-list').DataTable();
            
            // Select2
            $('#search-provid').select2( { width: '100%' } );
           
        });
        
        //
        // JQuery - Events
        //
        $("#search-value").keyup(function() {
            $('#search-value-help').text(this.value.replace(/ /g,'').length + '/40');
        });
        
        $('input[type="radio"]').click(function () {
            if ($(this).attr("value") === "code") {
                $("#search-provid-row").hide();
            }
            if ($(this).attr("value") === "description") {
                $("#search-provid-row").show();

            }
        });
    </script>
</html>
