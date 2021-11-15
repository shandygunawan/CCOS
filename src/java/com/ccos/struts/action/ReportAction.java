/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import com.ccos.struts.actionform.ReportActionForm;
import com.ccos.utils.ReportGenerator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author shand
 */
public class ReportAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String REPORT_PAGE = "generate_success";

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
            return mapping.findForward(REPORT_PAGE);
        }
        
        if(task.equals("generate")) {
            ReportActionForm reportForm = (ReportActionForm) form;
            ReportGenerator repgen = new ReportGenerator();
            repgen.generateReport(reportForm.getMonth(), reportForm.getYear());
            
            request.setAttribute("report_filepath", repgen.outputFile);
        } 
        
        return mapping.findForward(REPORT_PAGE);
    }
}
