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
public class UserAddActionForm extends org.apache.struts.action.ActionForm {
    
    private String userId;
    private String userName;
    private String role;
    private String branch;
    private String Password;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public String getBranch() {
        return branch;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    

    /**
     *
     */
    public UserAddActionForm() {
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
        
        // Null Check
        if(getUserId() == null || getUserId().length() < 1) {
            errors.add("userId", new ActionMessage("user.errors.userid.required"));
        }
        if(getUserName() == null || getUserName().length() < 1) {
            errors.add("userName", new ActionMessage("user.errors.username.required"));
        }
        if(getRole() == null || getRole().length() < 1) {
            errors.add("role", new ActionMessage("user.errors.role.required"));
        }
        if(getBranch() == null || getBranch().length() < 1) {
            errors.add("branch", new ActionMessage("user.errors.branch.required"));
        }
        if(getPassword() == null || getPassword().length() < 1) {
            errors.add("password", new ActionMessage("user.errors.password.required"));
        }
        
        //TODO: Constraint Check
        
        return errors;
    }
}
