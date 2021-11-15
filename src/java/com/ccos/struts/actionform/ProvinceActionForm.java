/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.ccos.struts.actionform;

import com.ccos.struts.model.ProvinceDTO;
import com.ccos.struts.model.bean.Province;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author shand
 */
public class ProvinceActionForm extends org.apache.struts.action.ActionForm {
    
    private String code;
    private String name;
    private String searchBy;
    private String searchValue;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
    public String getSearchBy() {
        return searchBy;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    

    /**
     *
     */
    public ProvinceActionForm() {
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
        } else if(task.equals("create")) {
            return validateCreate();
        }
        
        return errors;  
    }
    
    private ActionErrors validateCreate() {
        ActionErrors errors = new ActionErrors();
        
        // Check Null
        if(code == null || code.length() < 1) {
            errors.add("code", new ActionMessage("province.errors.code.required"));
        }
        if(name == null || name.length() < 1) {
            errors.add("name", new ActionMessage("province.errors.name.required"));
        }
        
        // Check if Exists
        if(isProvinceCodeExists()) {
            errors.add("code", new ActionMessage("province.errors.code.alreadyExists"));
        }
        
        return errors;
    }
    
    private Boolean isProvinceCodeExists() {
        ProvinceDTO provdto = new ProvinceDTO();
        
        Province prov = provdto.getProvinceById(code);
        
        return prov != null;
    }
}
