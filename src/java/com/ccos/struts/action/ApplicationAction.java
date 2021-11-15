/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import com.ccos.struts.actionform.ApplicationActionForm;
import com.ccos.struts.model.ApplicationDTO;
import com.ccos.struts.model.bean.Application;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author shand
 */
public class ApplicationAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String CREATE_PAGE = "create_page";
    private static final String CREATE_SUCCESS = "create_success";
    private static final String FAILED = "failed";
    
    private ApplicationDTO appdto;
    
    public ApplicationAction() {
        appdto = new ApplicationDTO();
    }
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        String task = request.getParameter("task");
        
        if(task == null) {
            request.setAttribute("custId", request.getParameter("custId"));
            return mapping.findForward(CREATE_PAGE);
            
        } else if(task.equals("create")) {
            
            ApplicationActionForm appForm = (ApplicationActionForm) form;
            String created_by = (String) request.getSession().getAttribute("userId");
            
            try {
                Integer cust_id = Integer.parseInt(request.getParameter("custId"));
                java.sql.Date receivedDate = this.dateStringToSqlDate(appForm.getReceivedDate());
                appdto.insertApplication(
                        cust_id, 
                        "Pending", 
                        appForm.getBranchReferral(), 
                        receivedDate, 
                        appForm.getFacility(),
                        appForm.getPurpose(), 
                        appForm.getBusinessSource(), 
                        appForm.getMediaChannel(), 
                        appForm.getBranchFee(), 
                        appForm.getBranchProvision(), 
                        appForm.getBranchKckk(), 
                        appForm.getStaffName(), 
                        appForm.getStaffNip(), 
                        appForm.getStaffBranch(), 
                        appForm.getStaffAccount(), 
                        created_by);
                
                return mapping.findForward(CREATE_SUCCESS);
            } catch(SQLException e) {
                e.printStackTrace();
                return mapping.findForward(FAILED);
            }
        }
        
        return mapping.findForward(FAILED);
    }
    
    private java.sql.Date dateStringToSqlDate(String date_str) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = format.parse(date_str);
        return new java.sql.Date(date.getTime());
    }
}
