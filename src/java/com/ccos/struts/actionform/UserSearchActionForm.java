/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.ccos.struts.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import com.ccos.struts.model.UserDTO;
import com.ccos.struts.model.bean.User;

/**
 *
 * @author shand
 */
public class UserSearchActionForm extends org.apache.struts.action.ActionForm {
    
    private String userId;
    private String userName;
    private String branch;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getBranch() {
        return branch;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    

    /**
     *
     */
    public UserSearchActionForm() {
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
        
        return errors;
    }
}
