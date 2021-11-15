<%-- 
    Document   : customer_create
    Created on : Nov 12, 2021, 1:10:40 PM
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
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        
        <!-- JQuery DataTables -->
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css">
        
        <!-- Select2 -->
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
        
        <!-- MomentJS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js" integrity="sha512-qTXRIMyZIFb8iQcfjXWCO8+M5Tbc38Qi5WzdPOYZHIlZpzBHG3L3by84BBBOiRGiEb7KKtAOAs5qYdUiZiQNNQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        
        <!-- Datepicker -->
        <link rel="stylesheet" href="assets/css/bootstrap-datepicker.standalone.min.css" />
        <script src="assets/js/bootstrap-datepicker.min.js"></script>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - Add Customer</title>
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
                        <span style="font-weight: bold">Add Customer</span>
                    </div>
                    
                    <div id="form-personal-information">
                        <div class="row mt-3">
                            <h5>1. Personal Information</h5>
                        </div>
                        <div class="row mt-3">
                            <label for="add-name" class="col-sm-2 col-form-label">Customer Name</label>
                            <div class="col-sm-4">
                                <html:text property="name" styleClass="form-control" styleId="add-name" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-fullname" class="col-sm-2 col-form-label">Customer Full Name</label>
                            <div class="col-sm-4">
                                <html:text property="fullName" styleClass="form-control" styleId="add-fullname" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-idtype" class="col-sm-2 col-form-label">ID Type</label>
                            <div class="col-sm-4">
                                <html:select property="idType" styleClass="form-select" styleId="add-idtype">
                                    <option value="KTP" selected>KTP</option>
                                    <option value="SIM">SIM</option>
                                    <option value="Passport">Passport</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-idnum" class="col-sm-2 col-form-label">ID No.</label>
                            <div class="col-sm-4">
                                <html:text property="idNum" styleClass="form-control" styleId="add-idnum" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-idexpiry" class="col-sm-2 col-form-label">ID Expiry Date</label>
                            <div class="col-sm-4">
                                <html:text property="idExpiryDate" styleClass="form-control" styleId="add-idexpiry" readonly="true" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-gender" class="col-sm-2 col-form-label">Gender</label>
                            <div class="col-sm-4">
                                <html:select property="gender" styleClass="form-select" styleId="add-gender">
                                    <option value="Male" selected>Male</option>
                                    <option value="Female">Female</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-birthplace" class="col-sm-2 col-form-label">Place of Birth</label>
                            <div class="col-sm-4">
                                <html:text property="birthPlace" styleClass="form-control" styleId="add-birthplace" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-birthprovince" class="col-sm-2 col-form-label">City Province</label>
                            <div class="col-sm-4">
                                <html:select property="birthProvince" styleClass="form-select" styleId="add-birthprovince">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-birthcity" class="col-sm-2 col-form-label">City of Birth</label>
                            <div class="col-sm-4">
                                <html:select property="birthCity" styleClass="form-select" styleId="add-birthcity">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-birthdate" class="col-sm-2 col-form-label">Date of Birth</label>
                            <div class="col-sm-4">
                                <html:text property="birthDate" styleClass="form-control" styleId="add-birthdate" readonly="true" />
                            </div>
                        </div>
                        <div class="row mt-3 d-flex">
                            <label for="age-year" class="col-sm-2 col-form-label">Age</label>
                            <div class="col-sm-1">
                                <input type="text" class="form-control" id="age-year" readonly></input>
                            </div>
                            
                            <h5 class="col-sm-1 align-self-center">year(s)</h5>
                            
                            <div class="col-sm-1">
                                <input type="text" class="form-control" id="age-month" readonly></input>
                            </div>
                            
                            <h5 class="col-sm-1 align-self-center">month(s)</h5>
                        </div>
                        <div class="row mt-3">
                            <label for="add-marital" class="col-sm-2 col-form-label">Marital Status</label>
                            <div class="col-sm-4">
                                <html:select property="maritalStatus" styleClass="form-select" styleId="add-marital">
                                    <option value="Single" selected>Single</option>
                                    <option value="Married">Married</option>
                                    <option value="Widowed">Widowed</option>
                                    <option value="Divorced">Divorced</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-dependent" class="col-sm-2 col-form-label">Number of Dependents</label>
                            <div class="col-sm-4">
                                <html:text property="dependentNum" styleClass="form-control" styleId="add-dependent" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-education" class="col-sm-2 col-form-label">Level of Education</label>
                            <div class="col-sm-4">
                                <html:select property="education" styleClass="form-select" styleId="add-education">
                                    <option value="SD" selected>SD</option>
                                    <option value="SMP">SMP</option>
                                    <option value="SMA">SMA</option>
                                    <option value="D3">D3</option>
                                    <option value="S1">S1</option>
                                    <option value="S2">S2</option>
                                    <option value="S3">S3</option>
                                </html:select>
                            </div>
                        </div>    
                        <div class="row mt-3">
                            <label for="add-mother" class="col-sm-2 col-form-label">Mother's Maiden Name</label>
                            <div class="col-sm-4">
                                <html:text property="motherName" styleClass="form-control" styleId="add-mother" />
                            </div>
                        </div>
                            
                        <div id="form-spouse-information">
                            <br/>
                            <div class="row mt-3">
                                <h5>Spouse Information</h5>
                            </div>
                            <div class="row mt-3">
                                <label for="add-spouse-name" class="col-sm-2 col-form-label">Spouse Name</label>
                                <div class="col-sm-4">
                                    <html:text property="spouseName" styleClass="form-control" styleId="add-spouse-name" />
                                </div>
                            </div>
                            <div class="row mt-3">
                                <label for="add-spouse-idnum" class="col-sm-2 col-form-label">ID No.</label>
                                <div class="col-sm-4">
                                    <html:text property="spouseIdNum" styleClass="form-control" styleId="add-spouse-idnum" />
                                </div>
                            </div>
                            <div class="row mt-3">
                                <label for="add-spouse-birthdate" class="col-sm-2 col-form-label">Date of Birth</label>
                                <div class="col-sm-4">
                                    <html:text property="spouseBirthDate" styleClass="form-control" styleId="add-spouse-birthdate" readonly="true" />
                                </div>
                            </div>
                            <div class="row mt-3 d-flex">
                                <label for="age-spouse-year" class="col-sm-2 col-form-label">Age</label>
                                <div class="col-sm-1">
                                    <input type="text" class="form-control" id="age-spouse-year" readonly></input>
                                </div>

                                <h5 class="col-sm-1 align-self-center">year(s)</h5>

                                <div class="col-sm-1">
                                    <input type="text" class="form-control" id="age-spouse-month" readonly></input>
                                </div>

                                <h5 class="col-sm-1 align-self-center">month(s)</h5>
                            </div>
                                
                            <div class="row mt-3">
                                <label for="add-prenuptial" class="col-sm-2 col-form-label">Prenuptial Agreement</label>
                                <div class="col-sm-4">
                                    <html:select property="prenuptial" styleClass="form-select" styleId="add-prenuptial">
                                        <option value="Yes" selected>Yes</option>
                                        <option value="No">No</option>
                                    </html:select>
                                </div>
                            </div>  
                        </div>
                    </div>
                                
                    <div id="form-residence-information">
                        <div class="row mt-3">
                            <h5>2. Residence Information</h5>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-mailing" class="col-sm-2 col-form-label">Mailing Address</label>
                            <div class="col-sm-4">
                                <html:select property="mailingAddress" styleClass="form-select" styleId="add-residence-mailing">
                                    <option value="Office" selected>Office</option>
                                    <option value="Residence">Residence</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-address" class="col-sm-2 col-form-label">Residence Address</label>
                            <div class="col-sm-4">
                                <html:text property="address" styleClass="form-control" styleId="add-residence-address" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-province" class="col-sm-2 col-form-label">Residence Province</label>
                            <div class="col-sm-4">
                                <html:select property="provId" styleClass="form-select" styleId="add-residence-province">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-city" class="col-sm-2 col-form-label">Residence City</label>
                            <div class="col-sm-4">
                                <html:select property="cityId" styleClass="form-select" styleId="add-residence-city">
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-zipcode" class="col-sm-2 col-form-label">Zip Code</label>
                            <div class="col-sm-4">
                                <html:text property="zipCode" styleClass="form-control" styleId="add-residence-zipcode" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-kelurahan" class="col-sm-2 col-form-label">Kelurahan</label>
                            <div class="col-sm-4">
                                <html:text property="kelurahan" styleClass="form-control" styleId="add-residence-kelurahan" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-kecamatan" class="col-sm-2 col-form-label">Kecamatan</label>
                            <div class="col-sm-4">
                                <html:text property="kecamatan" styleClass="form-control" styleId="add-residence-kecamatan" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-phonehome" class="col-sm-2 col-form-label">Home Phone No.</label>
                            <div class="col-sm-4">
                                <html:text property="phoneHome" styleClass="form-control" styleId="add-residence-phonehome" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-phonemobile" class="col-sm-2 col-form-label">Mobile Phone No.</label>
                            <div class="col-sm-4">
                                <html:text property="phoneMobile" styleClass="form-control" styleId="add-residence-phonemobile" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-email" class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-4">
                                <html:text property="email" styleClass="form-control" styleId="add-residence-email" />
                            </div>
                        </div>
                        <div class="row mt-3">
                            <label for="add-residence-status" class="col-sm-2 col-form-label">Residence Status</label>
                            <div class="col-sm-4">
                                <html:select property="residenceStatus" styleClass="form-select" styleId="add-residence-status">
                                    <option value="Owner" selected>Owner</option>
                                    <option value="Parent">Parent</option>
                                    <option value="Rent">Rent</option>
                                    <option value="Relatives">Relatives</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-3 d-flex">
                            <label for="add-residence-stay-year" class="col-sm-2 col-form-label">Length of Stay</label>
                            <div class="col-sm-1">
                                <html:text property="stayLengthYear" styleClass="form-control" styleId="add-residence-stay-year" />
                            </div>

                            <h5 class="col-sm-1 align-self-center">year(s)</h5>

                            <div class="col-sm-1">
                                <html:text property="stayLengthMonth" styleClass="form-control" styleId="add-residence-stay-month" />
                            </div>

                            <h5 class="col-sm-1 align-self-center">month(s)</h5>
                        </div>
                    </div>
                    
                    <div class="row mt-4 p-2">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <button id="button-back" class="btn btn-primary me-2" type="button">Back</button>
                            <button id="button-next" class="btn btn-primary" type="button">Next</button>
                            <html:submit styleClass="btn btn-primary" styleId="button-save" value="Save"/>
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
        // VARIABLES
        //
        var provs = JSON.parse('${provinces_json}');
        var cities = JSON.parse('${cities_json}');
        
        
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
        
        //
        // JQUERY - INIT
        //
        $(document).ready(function() {
            $("#sidebar-menu-application").addClass("active");
            
            $("#form-spouse-information").hide();
            $("#form-residence-information").hide();
            
            $("#button-back").hide();
            $("#button-save").hide();
            
            // Datepicker
            $("#add-birthdate, #add-spouse-birthdate, #add-idexpiry").attr("data-provide", "datepicker");
            $("#add-birthdate, #add-spouse-birthdate").attr("data-date-end-date", "-365d");
            $("#add-idexpiry").attr("data-date-start-date", "0d");
            $("#add-birthdate, #add-spouse-birthdate, #add-idexpiry").datepicker({
                format: `dd/mm/yyyy`,
                autoclose: true,
                clearBtn: true,
                defaultViewDate: '-365d'
            });
            
            // Populate province selects
            provs.forEach(function(e, i) {
                $("#add-birthprovince, #add-residence-province").append( $('<option></option>').val(e.id).text(e.name) );
            });
            
            cities.forEach(function(e, i) {
                if(e.provId === provs[0].id) {
                    $("#add-birthcity, #add-residence-city").append( $('<option></option>').val(e.id).text(e.name) );
                }
            });
            
            // Initiate Select2
            $('#add-birthprovince, #add-birthcity, #add-residence-province, #add-residence-city').select2( { width: '100%' } );
            
            // Initiave fields value
            $("#add-dependent").val("0");
            
            // Contraint - required
            $("input, select").prop("required", true);
            $("#add-spouse-name, #add-spouse-idnum, #add-spouse-birthdate, #add-prenuptial").prop("required", false);
            
            // Constraint - number only
            $("#add-idnum, #add-dependent, #add-residence-zipcode, #add-residence-phonehome, #add-residence-phonemobile, #add-residence-stay-year, #add-residence-stay-month").attr("type", "number");
            
            // Constraint - email pattern
            $("#add-residence-email").attr("type", "email");
            
            // Constraint - maxlength
            $("input").attr("maxlength", "40");
            $("#add-residence-zipcode").attr("maxlength", "5");
            
        });
        
        //
        // JQUERY - EVENTS
        //
        $("#add-birthprovince, #add-residence-province").change(function() {
            let prov_id = $(this).val();
            let element_id = $(this).attr("id");
            
            if(element_id === "add-birthprovince") {
                $("#add-birthcity").find("option").remove();
            } else if(element_id === "add-residence-province") {
                $("#add-residence-city").find("option").remove();
            }
            
            cities.forEach(function(e, i) {
                if(e.provId === prov_id) {
                    if(element_id === "add-birthprovince") {
                        $("#add-birthcity").append( $('<option></option>').val(e.id).text(e.name) );
                    } else if(element_id === "add-residence-province") {
                        $("#add-residence-city").append( $('<option></option>').val(e.id).text(e.name) );
                    }
                }
            });
        })
        
        $("#add-birthdate, #add-spouse-birthdate").change(function() {
            var birthdate_raw = $(this).val();
            
            if (birthdate_raw === "") {
                if( $(this).attr("id") === "add-birthdate" ) {
                    $("#age-year").val("");
                    $("#age-month").val("");  
                } 
                else if( $(this).attr("id") === "add-spouse-birthdate" ) {
                    $("#age-spouse-year").val("");
                    $("#age-spouse-month").val("");
                }
                
            } else {
                var birthdate_parts = birthdate_raw.split("/");
                var birthdate = new Date(birthdate_parts[2], birthdate_parts[1], birthdate_parts[0]);
                var today = new Date();
                var monthDiff = DateDiff.inMonths(birthdate, today);

                var ageYear = Math.floor(monthDiff/12) 
                var ageMonth = monthDiff % 12;
                
                if( $(this).attr("id") === "add-birthdate" ) {
                    $("#age-year").val(ageYear);
                    $("#age-month").val(ageMonth);
                } 
                else if( $(this).attr("id") === "add-spouse-birthdate" ) {
                    $("#age-spouse-year").val(ageYear);
                    $("#age-spouse-month").val(ageMonth);
                }
            }  
        })
        
        $("#add-marital").change(function() {
            if($(this).val() === "Married") {
                $("#form-spouse-information").show();
            } else {
                $("#form-spouse-information").hide();
            }
        });
        
        $("#button-next").click(function() {
           $("#form-personal-information").hide();
           $("#form-residence-information").show();
           
           $("#button-back").show();
           $("#button-save").show();
           
           $(this).hide();
        });
        
        $("#button-back").click(function() {
           $("#form-personal-information").show();
           $("#form-residence-information").hide();
           
           $("#button-next").show();
           $("#button-save").hide();
           
           $(this).hide();
        });
        
        $("#add-idnum, #add-dependent, #add-residence-zipcode, #add-residence-phonehome, #add-residence-phonemobile, #add-residence-stay-year, #add-residence-stay-month").keypress(function(e) {
            var txt = String.fromCharCode(e.which);
            if (!txt.match(/[0-9]/)) {
                return false;
            }
        });
        
        $("#add-residence-zipcode").on('input',function() {
            if(this.value.length >= this.maxLength) {
                this.value = this.value.slice(0, this.maxLength);
            } 
        });
        
        $("#add-residence-stay-year").keyup(function() {
            if( parseInt(this.value) > 11) {
                $(this).val("11");
                $("#add-residence-stay-month").val("0");
            } else if( parseInt(this.value) === 11) {
                $("#add-residence-stay-month").val("0");
            }
        });
        
        $("#add-residence-stay-month").keyup(function() {
            if( parseInt($("#add-residence-stay-year").val()) >= 11) {
                $(this).val("0");
                $("#add-residence-stay-month").val("0");
            }
        });
        
    </script>
</html>
