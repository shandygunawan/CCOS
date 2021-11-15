<%-- 
    Document   : customer_edit
    Created on : Nov 13, 2021, 2:09:05 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
        
        <!-- MomentJS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js" integrity="sha512-qTXRIMyZIFb8iQcfjXWCO8+M5Tbc38Qi5WzdPOYZHIlZpzBHG3L3by84BBBOiRGiEb7KKtAOAs5qYdUiZiQNNQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        
        <!-- Datepicker -->
        <link rel="stylesheet" href="assets/css/bootstrap-datepicker.standalone.min.css" />
        <script src="assets/js/bootstrap-datepicker.min.js"></script>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - Customer Detail</title>
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
                        <span style="font-weight: bold">Customer Detail</span>
                    </div>

                    <div id="form-personal-information">
                        <div class="row mt-2">
                            <h5>1. Personal Information</h5>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-name" class="col-sm-2 col-form-label">Customer Name</label>
                            <div class="col-sm-4">
                                <html:text property="name" styleClass="form-control" styleId="edit-personal-name" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-fullname" class="col-sm-2 col-form-label">Customer Full Name</label>
                            <div class="col-sm-4">
                                <html:text property="fullName" styleClass="form-control" styleId="edit-personal-fullname" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-idtype" class="col-sm-2 col-form-label">ID Type</label>
                            <div class="col-sm-4">
                                <html:select property="idType" styleClass="form-select" styleId="edit-personal-idtype">
                                    <option value="KTP">KTP</option>
                                    <option value="SIM">SIM</option>
                                    <option value="Passport">Passport</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-idnum" class="col-sm-2 col-form-label">ID No.</label>
                            <div class="col-sm-4">
                                <html:text property="idNum" styleClass="form-control" styleId="edit-personal-idnum" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-idexpiry" class="col-sm-2 col-form-label">ID Expiry Date</label>
                            <div class="col-sm-4">
                                <html:text property="idExpiryDate" styleClass="form-control" styleId="edit-personal-idexpiry" readonly="true" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-gender" class="col-sm-2 col-form-label">Gender</label>
                            <div class="col-sm-4">
                                <html:select property="gender" styleClass="form-select" styleId="edit-personal-gender">
                                    <option value="Male" selected>Male</option>
                                    <option value="Female">Female</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-birthplace" class="col-sm-2 col-form-label">Place of Birth</label>
                            <div class="col-sm-4">
                                <html:text property="birthPlace" styleClass="form-control" styleId="edit-personal-birthplace" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-birthprovince" class="col-sm-2 col-form-label">City Province</label>
                            <div class="col-sm-4">
                                <html:select property="birthProvince" styleClass="form-select" styleId="edit-personal-birthprovince">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-birthcity" class="col-sm-2 col-form-label">City of Birth</label>
                            <div class="col-sm-4">
                                <html:select property="birthCity" styleClass="form-select" styleId="edit-personal-birthcity">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-birthdate" class="col-sm-2 col-form-label">Date of Birth</label>
                            <div class="col-sm-4">
                                <html:text property="birthDate" styleClass="form-control" styleId="edit-personal-birthdate" readonly="true" />
                            </div>
                        </div>
                        <div class="row mt-2 d-flex">
                            <label class="col-sm-2 col-form-label">Age</label>
                            <div class="col-sm-4 d-flex align-items-center">
                                <span id="age-year"></span>
                                <span>&nbsp;Year(s) &nbsp;</span>
                                <span id="age-month"></span>
                                <span>&nbsp;Month(s) &nbsp;</span>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-marital" class="col-sm-2 col-form-label">Marital Status</label>
                            <div class="col-sm-4">
                                <html:select property="maritalStatus" styleClass="form-select" styleId="edit-personal-marital">
                                    <option value="Single">Single</option>
                                    <option value="Married">Married</option>
                                    <option value="Widowed">Widowed</option>
                                    <option value="Divorced">Divorced</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-dependent" class="col-sm-2 col-form-label">Number of Dependents</label>
                            <div class="col-sm-4">
                                <html:text property="dependentNum" styleClass="form-control" styleId="edit-personal-dependent" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-personal-education" class="col-sm-2 col-form-label">Level of Education</label>
                            <div class="col-sm-4">
                                <html:select property="education" styleClass="form-select" styleId="edit-personal-education">
                                    <option value="SD">SD</option>
                                    <option value="SMP">SMP</option>
                                    <option value="SMA">SMA</option>
                                    <option value="D3">D3</option>
                                    <option value="S1">S1</option>
                                    <option value="S2">S2</option>
                                    <option value="S3">S3</option>
                                </html:select>
                            </div>
                        </div>    
                        <div class="row mt-2">
                            <label for="edit-personal-mother" class="col-sm-2 col-form-label">Mother's Maiden Name</label>
                            <div class="col-sm-4">
                                <html:text property="motherName" styleClass="form-control" styleId="edit-personal-mother" />
                            </div>
                        </div>

                        <div id="form-spouse-information">
                            <br/>
                            <div class="row mt-2">
                                <h5>Spouse Information</h5>
                            </div>
                            <div class="row mt-2">
                                <label for="edit-spouse-name" class="col-sm-2 col-form-label">Spouse Name</label>
                                <div class="col-sm-4">
                                    <html:text property="spouseName" styleClass="form-control" styleId="edit-spouse-name" />
                                </div>
                            </div>
                            <div class="row mt-2">
                                <label for="edit-spouse-idnum" class="col-sm-2 col-form-label">ID No.</label>
                                <div class="col-sm-4">
                                    <html:text property="spouseIdNum" styleClass="form-control" styleId="edit-spouse-idnum" />
                                </div>
                            </div>
                            <div class="row mt-2">
                                <label for="edit-spouse-birthdate" class="col-sm-2 col-form-label">Date of Birth</label>
                                <div class="col-sm-4">
                                    <html:text property="spouseBirthDate" styleClass="form-control" styleId="edit-spouse-birthdate" readonly="true" />
                                </div>
                            </div>
                            <div class="row mt-2 d-flex">
                                <label for="age-spouse-year" class="col-sm-2 col-form-label">Age</label>
                                <div class="col-sm-4 d-flex align-items-center">
                                    <span id="age-spouse-year"></span>
                                    <span>&nbsp;Year(s) &nbsp;</span>
                                    <span id="age-spouse-month"></span>
                                    <span>&nbsp;Month(s) &nbsp;</span>
                                </div>
                            </div>

                            <div class="row mt-2">
                                <label for="edit-spouse-prenuptial" class="col-sm-2 col-form-label">Prenuptial Agreement</label>
                                <div class="col-sm-4">
                                    <html:select property="prenuptial" styleClass="form-select" styleId="edit-spouse-prenuptial">
                                        <option value="Yes">Yes</option>
                                        <option value="No">No</option>
                                    </html:select>
                                </div>
                            </div>  
                        </div>
                    </div>
                                
                    <div id="form-residence-information">
                        <br/><br/>
                        <div class="row mt-2">
                            <h5>2. Residence Information</h5>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-mailing" class="col-sm-2 col-form-label">Mailing Address</label>
                            <div class="col-sm-4">
                                <html:select property="mailingAddress" styleClass="form-select" styleId="edit-residence-mailing">
                                    <option value="Office">Office</option>
                                    <option value="Residence">Residence</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-address" class="col-sm-2 col-form-label">Residence Address</label>
                            <div class="col-sm-4">
                                <html:text property="address" styleClass="form-control" styleId="edit-residence-address" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-province" class="col-sm-2 col-form-label">Residence Province</label>
                            <div class="col-sm-4">
                                <html:select property="provId" styleClass="form-select" styleId="edit-residence-province">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-city" class="col-sm-2 col-form-label">Residence City</label>
                            <div class="col-sm-4">
                                <html:select property="cityId" styleClass="form-select" styleId="edit-residence-city">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-zipcode" class="col-sm-2 col-form-label">Zip Code</label>
                            <div class="col-sm-4">
                                <html:text property="zipCode" styleClass="form-control" styleId="edit-residence-zipcode" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-kelurahan" class="col-sm-2 col-form-label">Kelurahan</label>
                            <div class="col-sm-4">
                                <html:text property="kelurahan" styleClass="form-control" styleId="edit-residence-kelurahan" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-kecamatan" class="col-sm-2 col-form-label">Kecamatan</label>
                            <div class="col-sm-4">
                                <html:text property="kecamatan" styleClass="form-control" styleId="edit-residence-kecamatan" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-phonehome" class="col-sm-2 col-form-label">Home Phone No.</label>
                            <div class="col-sm-4">
                                <html:text property="phoneHome" styleClass="form-control" styleId="edit-residence-phonehome" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-phonemobile" class="col-sm-2 col-form-label">Mobile Phone No.</label>
                            <div class="col-sm-4">
                                <html:text property="phoneMobile" styleClass="form-control" styleId="edit-residence-phonemobile" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-email" class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-4">
                                <html:text property="email" styleClass="form-control" styleId="edit-residence-email" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="edit-residence-status" class="col-sm-2 col-form-label">Residence Status</label>
                            <div class="col-sm-4">
                                <html:select property="residenceStatus" styleClass="form-select" styleId="edit-residence-status">
                                    <option value="Owner">Owner</option>
                                    <option value="Parent">Parent</option>
                                    <option value="Rent">Rent</option>
                                    <option value="Relatives">Relatives</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2 d-flex">
                            <label for="edit-residence-stay-year" class="col-sm-2 col-form-label">Length of Stay</label>
                            <div class="col-sm-1">
                                <html:text property="stayLengthYear" styleClass="form-control" styleId="edit-residence-stay-year" />
                            </div>

                            <h5 class="col-sm-1 align-self-center">year(s)</h5>

                            <div class="col-sm-1">
                                <html:text property="stayLengthMonth" styleClass="form-control" styleId="edit-residence-stay-month" />
                            </div>

                            <h5 class="col-sm-1 align-self-center">month(s)</h5>
                        </div>
                        <div class="row mt-2">
                            <div class="col-sm-12 d-flex justify-content-end">
                                <button type="button" class="btn btn-primary" id="button_edit">Edit</button>
                                <html:submit styleClass="btn btn-primary ms-2" styleId="button_save" value="Save"/>
                            </div>
                        </div>
                    </div>
                    <html:hidden property="custId" value="${customer.id}" />
                    <html:hidden property="resiId" value="${residence.id}" />
                    <html:hidden property="spouseId" value="${spouse.id}" />
                    <html:hidden property="task" value="edit" />
                </html:form>
                
                <br/><br/>
                
                <div id="div-application">
                    <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">Customer Application List</span>
                    </div>
                    <div class="row mt-2">
                        <logic:empty name="applications">
                            <span>There is currently no application from this customer.</span>
                        </logic:empty>
                        <logic:notEmpty name="applications">
                            <table id="table-app-list" class="table table-hover">
                                <thead class="table-light">
                                    <tr>
                                        <th>Ref. No</th>
                                        <th>Date Created</th>
                                        <th>Creator</th>
                                        <th>Status</th>
                                        <th>Hold By</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:iterate name="applications" id="app">
                                        <tr>
                                            <td>
                                                ${fn:substring(app.branchReferral, 0, 4)}/500/${ String.format("%05d", app.id) }/${fn:substring(app.receivedDate, 2, 4)}
                                            </td>
                                            <td><bean:write name="app" property="receivedDate" format="dd/MM/yyyy" ignore="true" /></td>
                                            <td>${app.createdBy}</td>
                                            <td>${app.status}</td>
                                            <td>${app.createdBy}</td>
                                        </tr>
                                    </logic:iterate>
                                </tbody>
                            </table>
                        </logic:notEmpty>
                    </div>
                    <div class="row mt-2">
                        <div class="col-sm-12 d-flex justify-content-end  mb-3">
                            <a href="/CCOS/application.do?custId=${customer.id}">
                                <button class="btn btn-primary" type="button" id="button_add_application">Add Application</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
    
    <script>
        
        //
        // VARIABLES
        //
        var provs = JSON.parse('${provinces_json}');
        var cities = JSON.parse('${cities_json}');
        var isDetailEditable = false;
        
        //
        // FUNCTIONS
        //
        var DateDiff = {
            inDays: function(d1, d2) {
                var t2 = d2.getTime();
                var t1 = d1.getTime();

                return parseInt((t2-t1)/(24*3600*1000));
            },

            inWeeks: function(d1, d2) {
                var t2 = d2.getTime();
                var t1 = d1.getTime();

                return parseInt((t2-t1)/(24*3600*1000*7));
            },

            inMonths: function(d1, d2) {
                var d1Y = d1.getFullYear();
                var d2Y = d2.getFullYear();
                var d1M = d1.getMonth();
                var d2M = d2.getMonth();

                return (d2M+12*d2Y)-(d1M+12*d1Y);
            },

            inYears: function(d1, d2) {
                return d2.getFullYear()-d1.getFullYear();
            }
        }
        
        function changeAgeCalculation(birthdate_raw, element_id) {
            if (birthdate_raw === "") {
                if( element_id === "edit-personal-birthdate" ) {
                    $("#age-year").text("");
                    $("#age-month").text("");  
                } 
                else if( element_id === "edit-spouse-birthdate" ) {
                    $("#age-spouse-year").text("");
                    $("#age-spouse-month").text("");
                }
                
            } else {
                var birthdate_parts = birthdate_raw.split("/");
                var birthdate = new Date(birthdate_parts[2], birthdate_parts[1], birthdate_parts[0]);
                var today = new Date();
                var monthDiff = DateDiff.inMonths(birthdate, today);

                var ageYear = Math.floor(monthDiff/12) 
                var ageMonth = monthDiff % 12;
                
                if( element_id === "edit-personal-birthdate" ) {
                    $("#age-year").text(ageYear);
                    $("#age-month").text(ageMonth);
                } 
                else if( element_id === "edit-spouse-birthdate" ) {
                    $("#age-spouse-year").text(ageYear);
                    $("#age-spouse-month").text(ageMonth);
                }
            }  
        }
        
        function clearSpouseFields() {
            $("edit-spouse-name").val("");
            $("edit-spouse-idnum").val("");
            $("edit-spouse-birthdate").val("");
        }
        
        function fillSpouseFields() {
            $("#edit-spouse-name").val("${spouse.name}");
            $("#edit-spouse-idnum").val("${spouse.idNum}");
            $("#edit-spouse-birthdate").val('<bean:write name="spouse" property="birthDate" format="dd/MM/yyyy" ignore="true" />');
        }
        
        //
        // JQUERY - INIT
        //
        $(document).ready(function() {
            // Selected Sidebars menu
            $("#sidebar-menu-application").addClass("active");
            
            // Initiating datepickers
            $("#edit-personal-birthdate, #edit-spouse-birthdate, #edit-personal-idexpiry").attr("data-provide", "datepicker");
            $("#edit-personal-birthdate, #edit-spouse-birthdate").attr("data-date-end-date", "-365d");
            $("#edit-idexpiry").attr("data-date-start-date", "0d");
            $("#edit-personal-birthdate, #edit-spouse-birthdate, #edit-personal-idexpiry").datepicker({
                format: `dd/mm/yyyy`,
                autoclose: true,
                clearBtn: true
            });
            $("#edit-personal-idexpiry").datepicker("setDate", new Date("${customer.idExpiryDate}") );
            $("#edit-personal-birthdate").datepicker("setDate", new Date("${customer.birthDate}") );
            $("#edit-spouse-birthdate").datepicker("setDate", new Date("${spouse.birthDate}") );
            $("#edit-personal-birthdate, #edit-spouse-birthdate, #edit-personal-idexpiry").datepicker("update");
            
            // Populating provinces and cities selection
            provs.forEach(function(e, i) {
                $("#edit-personal-birthprovince, #edit-residence-province").append( $('<option></option>').val(e.id).text(e.name) );
            });
            cities.forEach(function(e, i) {
                
                if("${customer.birthProvince}" === "${residence.provinceId}") {
                    $("#edit-personal-birthcity, #edit-residence-city").append( $('<option></option>').val(e.id).text(e.name) );
                } else if(e.provId === "${customer.birthProvince}") {
                    $("#edit-personal-birth city").append( $('<option></option>').val(e.id).text(e.name) );
                } else if(e.provId === "${residence.provinceId}") {
                    $("#edit-residence-city").append( $('<option></option>').val(e.id).text(e.name) );
                }
            });
            
            // Initiating form values based on selected user
            $("#edit-personal-name").val("${customer.name}");
            $("#edit-personal-fullname").val("${customer.fullName}");
            $("#edit-personal-idtype option[value=${customer.idType}]").attr('selected', 'selected');
            $("#edit-personal-idnum").val("${customer.idNum}");
            $("#edit-personal-idexpiry").val('<bean:write name="customer" property="idExpiryDate" format="dd/MM/yyyy" />');
            $("#edit-personal-gender option[value=${customer.gender}]").attr('selected', 'selected');
            $("#edit-personal-birthplace").val("${customer.birthPlace}");
            $("#edit-personal-birthprovince option[value=${customer.birthProvince}]").attr('selected', 'selected');
            $("#edit-personal-birthcity option[value='${customer.birthCity}']").attr('selected', 'selected');
            $("#edit-personal-birthdate").val('<bean:write name="customer" property="birthDate" format="dd/MM/yyyy" />');
            $("#edit-personal-marital option[value=${customer.maritalStatus}]").attr('selected', 'selected');
            $("#edit-personal-dependent").val("${customer.dependentNum}");
            $("#edit-personal-education option[value=${customer.education}]").attr('selected', 'selected');
            $("#edit-personal-mother").val("${customer.motherName}");
            
            if("${customer.maritalStatus}" === "Married") {
                fillSpouseFields();
                
                if(${empty spouse.prenuptial} === true) {
                    $("#edit-spouse-prenuptial option[value=Yes]").attr('selected', 'selected');
                } else {
                    $("#edit-spouse-prenuptial option[value=No]").attr('selected', 'selected');
                }
                
                $("#form-spouse-information").show();
            } else {
                $("#form-spouse-information").hide();
            }
            
            // Calculate initial age
            changeAgeCalculation( $("#edit-personal-birthdate").val(), "edit-personal-birthdate" );
            changeAgeCalculation( $("#edit-spouse-birthdate").val(), "edit-spouse-birthdate" );
            
            // Initiate Residence fields
            $("#edit-residence-mailing option[value=${residence.mailingAddress}]").attr('selected', 'selected');
            $("#edit-residence-address").val("${residence.address}");
            $("#edit-residence-province option[value=${residence.provinceId}]").attr('selected', 'selected');
            $("#edit-residence-city option[value='${residence.cityId}']").attr('selected', 'selected');
            $("#edit-residence-zipcode").val("${residence.zipCode}");
            $("#edit-residence-kelurahan").val("${residence.kelurahan}");
            $("#edit-residence-kecamatan").val("${residence.kecamatan}");
            $("#edit-residence-phonehome").val("${residence.phoneHome}");
            $("#edit-residence-phonemobile").val("${residence.phoneMobile}");
            $("#edit-residence-email").val("${residence.email}");
            $("#edit-residence-status option[value=${residence.residenceStatus}]").attr('selected', 'selected');
            $("#edit-residence-stay-year").val("${residence.stayLengthYear}");
            $("#edit-residence-stay-month").val("${residence.stayLengthMonth}");
            
            
            // Initiate DataTables
            $('#table-app-list').DataTable();
            
            // Disable inputs & Hide save button
            $("input").prop('disabled', true);
            $("select").prop('disabled', true);
            $("#button_save").hide();
            
            
            // Constraint - required
            $("input, select").prop("required", true);
            $("#edit-spouse-name, #edit-spouse-idnum, #edit-spouse-birthdate, #edit-prenuptial").prop("required", false);
            $('select[name="table-app-list_length"]').prop("disabled", false);
            $('input[type="search"]').prop("disabled", false);
            
            // Constraint - number only
            $("#edit-personal-idnum, #edit-personal-dependent, #edit-residence-zipcode, #edit-residence-phonehome, #edit-residence-phonemobile, #edit-residence-stay-year, #edit-residence-stay-month").attr("type", "number");
            
            // Constraint - email pattern
            $("#edit-residence-email").attr("type", "email");
            
            // Constraint - maxlength
            $("input").attr("maxlength", "40");
            $("#edit-residence-zipcode").attr("maxlength", "5");
        });
        
        //
        // JQUERY - EVENTS
        //
        $("#edit-personal-birthdate, #edit-spouse-birthdate").change(function() {            
            changeAgeCalculation($(this).val(), $(this).attr("id"));            
        });
        
        $("#edit-personal-marital").change(function() {
            if($(this).val() === "Married") {
                $("#form-spouse-information").show();
                fillSpouseFields();
            } else {
                $("#form-spouse-information").hide();
                clearSpouseFields();
            }
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
                $('select[name="table-app-list_length"]').prop("disabled", false);
                $('input[type="search"]').prop("disabled", false);
                
                $("#button_save").hide();
                isDetailEditable = false;
           }
        });
        
        $("#edit-personal-idnum, #edit-personal-dependent, #edit-residence-zipcode, #edit-residence-phonehome, #edit-residence-phonemobile, #edit-residence-stay-year, #edit-residence-stay-month").keypress(function(e) {
            var txt = String.fromCharCode(e.which);
            if (!txt.match(/[0-9]/)) {
                return false;
            }
        });
        
        $("#edit-residence-zipcode").on('input',function() {
            if(this.value.length >= this.maxLength) {
                this.value = this.value.slice(0, this.maxLength);
            } 
        });
        
        $("#edit-residence-stay-year").keyup(function() {
            if( parseInt(this.value) > 11) {
                $(this).val("11");
                $("#edit-residence-stay-month").val("0");
            } else if( parseInt(this.value) === 11) {
                $("#edit-residence-stay-month").val("0");
            }
        });
        
        $("#edit-residence-stay-month").keyup(function() {
            if( parseInt($("#edit-residence-stay-year").val()) >= 11) {
                $(this).val("0");
                $("#edit-residence-stay-month").val("0");
            }
        });
    </script>
</html>
