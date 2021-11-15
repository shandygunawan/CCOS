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
import com.ccos.utils.Encryption;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shand
 */
public class LoginActionForm extends org.apache.struts.action.ActionForm {
    
    private String userId;
    private String password;

    /**
     * @return
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * @param id
     */
    public void setUserId(String id) {
        this.userId = id;
    }

    /**
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     */
    public LoginActionForm() {
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
        
        UserDTO userdto = new UserDTO();
        
        User user = userdto.getUserById(this.getUserId());
        
        if (this.getUserId() == null || this.getUserId().length() < 1) {
            errors.add("userId_required", new ActionMessage("login.errors.userid.required"));
        }
        
        if (user == null ) {
            errors.add("userId_incorrect", new ActionMessage("login.errors.userid.incorrect"));
        }
        
        if (user != null) {
            Encryption enc = new Encryption();
            String decryptedPassword = enc.decryptText(user.getPassword());
            
            if(this.getPassword().equals(decryptedPassword) == false) {
                errors.add("password_incorrect", new ActionMessage("login.errors.password.incorrect"));
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
                session.setAttribute("name", user.getName());
                session.setAttribute("role", user.getRole());
            }
        }
        
        return errors;
    }
}
