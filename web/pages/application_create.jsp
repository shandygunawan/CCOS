<%-- 
    Document   : application_create
    Created on : Nov 14, 2021, 5:32:23 PM
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
        
        <!-- MomentJS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
        
        <!-- Datepicker -->
        <link rel="stylesheet" href="assets/css/bootstrap-datepicker.standalone.min.css" />
        <script src="assets/js/bootstrap-datepicker.min.js"></script>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - Create App</title>
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
                        <span style="font-weight: bold">Create Application</span>
                    </div>
                    
                    <div id="form-application-information">
                        <div class="row mt-2">
                            <h5>1. Application Information</h5>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-branchreferral" class="col-sm-2 col-form-label">Referral Branch</label>
                            <div class="col-sm-4">
                                <html:text property="branchReferral" styleClass="form-control" styleId="add-app-branchreferral" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-receiveddate" class="col-sm-2 col-form-label">Date Received</label>
                            <div class="col-sm-4">
                                <html:text property="receivedDate" styleClass="form-control" styleId="add-app-receiveddate" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-facility" class="col-sm-2 col-form-label">Facility</label>
                            <div class="col-sm-4">
                                <html:select property="facility" styleClass="form-select" styleId="add-app-facility">
                                    <option value="500" selected>500 - PL Asuransi Jiwa</option>
                                    <option value="600">600 - PL Asuransi Jiwa + PHK</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-purpose" class="col-sm-2 col-form-label">Application Purpose</label>
                            <div class="col-sm-4">
                                <html:select property="purpose" styleClass="form-select" styleId="add-app-purpose">
                                    <option value="Sekolah" selected>Sekolah</option>
                                    <option value="Liburan">Liburan</option>
                                    <option value="ModalKerja">Modal Kerja</option>
                                    <option value="Lainnya">Lainnya</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-source" class="col-sm-2 col-form-label">Business Source</label>
                            <div class="col-sm-4">
                                <html:text property="businessSource" styleClass="form-control" styleId="add-app-source" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-mediachannel" class="col-sm-2 col-form-label">Media Channel</label>
                            <div class="col-sm-4">
                                <html:select property="mediaChannel" styleClass="form-select" styleId="add-app-mediachannel">
                                    <option value="TV" selected>TV</option>
                                    <option value="SuratKabar">Surat Kabar</option>
                                    <option value="Internet">Internet</option>
                                    <option value="Cabang">Cabang</option>
                                    <option value="Lainnya">Lainnya</option>
                                </html:select>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-branchfee" class="col-sm-2 col-form-label">Fee Branch</label>
                            <div class="col-sm-4">
                                <html:text property="branchFee" styleClass="form-control" styleId="add-app-branchfee" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-branchprovision" class="col-sm-2 col-form-label">Provision Branch</label>
                            <div class="col-sm-4">
                                <html:text property="branchProvision" styleClass="form-control" styleId="add-app-branchprovision" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-app-branchkckk" class="col-sm-2 col-form-label">KCKK Branch</label>
                            <div class="col-sm-4">
                                <html:text property="branchKckk" styleClass="form-control" styleId="add-app-branchkckk" />
                            </div>
                        </div>
                    </div>
                            
                    <br/><br/>
                    
                    <div id="form-staff-information">
                        <div class="row mt-2">
                            <h5>2. Staff Introducer Information</h5>
                        </div>
                        <div class="row mt-2">
                            <label for="add-staff-name" class="col-sm-2 col-form-label">Staff's Name</label>
                            <div class="col-sm-4">
                                <html:text property="staffName" styleClass="form-control" styleId="add-staff-name" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-staff-nip" class="col-sm-2 col-form-label">Staff's NIP No.</label>
                            <div class="col-sm-4">
                                <html:text property="staffNip" styleClass="form-control" styleId="add-staff-nip" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-staff-branch" class="col-sm-2 col-form-label">Staff's Branch</label>
                            <div class="col-sm-4">
                                <html:text property="staffBranch" styleClass="form-control" styleId="add-staff-branch" />
                            </div>
                        </div>
                        <div class="row mt-2">
                            <label for="add-staff-account" class="col-sm-2 col-form-label">Staff's Account No</label>
                            <div class="col-sm-4">
                                <html:text property="staffAccount" styleClass="form-control" styleId="add-staff-account" />
                            </div>
                        </div>                
                    </div>
                    <div class="row mt-2">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <html:submit styleClass="btn btn-primary" styleId="button_save" value="Save"/>
                        </div>
                    </div>
                    
                    <html:hidden property="custId" value="${custId}" />
                    <html:hidden property="task" value="create" />
                </html:form>
            </div>
        </div>
        
    </body>
    <script>
        
        $(document).ready(function() {
            // Selected Sidebars menu
            $("#sidebar-menu-application").addClass("active");
            
            
            // Initiating datepickers
            $("#add-app-receiveddate").attr("data-provide", "datepicker");
            $("#add-app-receiveddate").datepicker({
                format: `dd/mm/yyyy`,
                autoclose: true,
                clearBtn: true
            });
            $("#add-app-receiveddate").datepicker("setDate", new Date() );
            $("#add-app-receiveddate").datepicker("update");
            
            // Initial Values
            $("#add-app-branchreferral, #add-app-branchfee, #add-app-branchprovision, #add-app-branchkckk").val("0960 – Unit Bisnis Kartu Kredit");
            $("#add-app-receiveddate").val(moment().format("DD/MM/YYYY"));
            
            
            // constraint - required
            $("input").attr("required", true);
            $("select").attr("required", true);
            
            // constraint - number only
            $("#add-staff-nip, #add-staff-account").attr("type", "number");
            
            // constraint - readonly
            $("#add-app-branchreferral, #add-app-branchfee, #add-app-branchprovision, #add-app-branchkckk").prop("readonly", true);
            $("#add-app-receiveddate").prop("readonly", true);
            
            // constraint - maxlength
            $("#add-app-branchreferral, #add-app-source, #add-app-branchfee, #add-app-branchprovision, #add-app-branchkckk").attr("maxlength", "40");
            $("#add-staff-name, #add-staff-nip, #add-staff-branch, #add-staff-account").prop("maxlength", "40");
        });
        
        $("#add-staff-nip, #add-staff-account").keypress(function(e) {
            var txt = String.fromCharCode(e.which);
            if (!txt.match(/[0-9]/)) {
                return false;
            }
        });
    </script>
</html>
