<%-- 
    Document   : province_edit
    Created on : Nov 11, 2021, 12:41:48 PM
    Author     : shand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/styles.css" />
        
        <title>CCOS - Province Edit</title>
    </head>
    <body>
         <jsp:include page="/components/header.jsp" />
        
        <div class="wrapper">
            <jsp:include page="/components/sidebar.jsp" />
            
             <div id="content" class="container">
                 <html:form method="post">
                     <div class="row mt-4 p-2" style="background-color: lightblue">
                        <span style="font-weight: bold">Edit Province <bean:write name="province" property="id"></bean:write></span>
                     </div>
                     <div class="row mt-3">
                        <label for="province-edit-name" class="col-sm-2 col-form-label">Description</label>
                        <div class="col-sm-4">
                            <html:text property="name" value="${province.name}" 
                                       styleClass="form-control" styleId="province-edit-name" />
                            <small id="province-name-help" class="form-text text-muted"></small>
                        </div>
                     </div>
                     <div class="row mt-3">
                         <div class="col-sm-12 d-flex justify-content-end">
                            <button type="button" class="btn btn-primary" id="button_edit">Edit</button>
                            <html:submit styleClass="btn btn-primary ms-2" styleId="button_save" value="Save"/>
                         </div>
                     </div>
                     <html:hidden property="task" value="edit" />
                     <html:hidden property="code" value="${province.id}" />
                 </html:form>
                 
             </div>
        </div>
        
        
    </body>
    <script>
        
        //
        // Variables
        //
        var isDetailEditable = false;
        
        //
        // JQuery - Init
        //
        $(document).ready(function() {
            // Sidebar
            $("#sidebar-submenu-province").addClass("active");
            
            // Constraints - Required
            $("#province-edit-name").prop('required', true);
            
            // Constraints - Max Length
            $("#province-edit-name").attr("maxlength", "40");
            
            // Init texts
            $('#province-name-help').text( $("#province-edit-name").val().length + "/40");
            
            // Disable inputs if not in edit mode
            $("#province-edit-name").prop('disabled', true);
            $("#button_save").hide();
        });
        
        //
        // JQuery - Events
        //
        $("#province-edit-name").keyup(function() {
            $('#province-name-help').text(this.value.length + '/40');
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
                
                $("#button_save").hide();
                isDetailEditable = false;
           }
        });
        
    </script>
</html>
