/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.ccos.struts.actionform;

import com.ccos.struts.model.UserDTO;
import com.ccos.struts.model.bean.User;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author shand
 */
public class UserActionForm extends org.apache.struts.action.ActionForm {
    
    private String id;
    private String name;
    private String role;
    private String branch;
    private String password;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getBranch() {
        return branch;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    /**
     *
     */
    public UserActionForm() {
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
        
        // Check null or empty
        if(id == null || id.length() < 1) {
            errors.add("id", new ActionMessage("user.errors.id.required"));
        }
        if(name == null || name.length() < 1) {
            errors.add("userName", new ActionMessage("user.errors.username.required"));
        }
        if(role == null || role.length() < 1) {
            errors.add("role", new ActionMessage("user.errors.role.required"));
        }
        if(branch == null || branch.length() < 1) {
            errors.add("branch", new ActionMessage("user.errors.branch.required"));
        }
        if(password == null || password.length() < 1) {
            errors.add("password", new ActionMessage("user.errors.password.required"));
        }
        
        // Check constraints
        if(isUserIdExists() == true) {
            errors.add("id", new ActionMessage("user.errors.id.alreadyExists"));
        }
        
        return errors;
    }
    
    private Boolean isUserIdExists() {
        UserDTO userdto = new UserDTO();
        
        User user = userdto.getUserById(id);
        
        if(user != null) {
            return true;
        } else {
            return false;
        }
    }
}
