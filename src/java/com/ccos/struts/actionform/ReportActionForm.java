/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.ccos.struts.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author shand
 */
public class ReportActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer month;
    private Integer year;

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
    

    /**
     *
     */
    public ReportActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        String task = request.getParameter("task");
        
        if(task == null) {
            return errors;
        } else if(task.equals("generate")) {
            return validateGenerateReport();
        }
        
        return errors;
    }
    
    public ActionErrors validateGenerateReport() {
        ActionErrors errors = new ActionErrors();
        
        if(year == null) {
            errors.add("year", new ActionMessage("report.errors.year.required"));
        }
        if(year < 1) {
            errors.add("year", new ActionMessage("report.errors.year.invalid"));
        }
        if(month == null) {
            errors.add("month", new ActionMessage("report.errors.month.required"));
        }
        if(month < 1) {
            errors.add("year", new ActionMessage("report.errors.month.invalid"));
        }
        
        return errors;
    }
}
