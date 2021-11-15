/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import com.ccos.struts.actionform.UserActionForm;
import com.ccos.struts.model.UserDTO;
import com.ccos.struts.model.bean.User;
import com.ccos.utils.Encryption;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author shand
 */
public class UserAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SEARCH_PAGE = "search_page";
    private static final String CREATE_PAGE = "create_page";
    private static final String EDIT_PAGE = "edit_page";
    private static final String SEARCH_SUCCESS = "search_success";
    private static final String CREATE_SUCCESS = "create_success";
    private static final String FAILED = "failed";
    
    UserDTO userdto;
    Encryption enc;
    
    public UserAction() {
        userdto = new UserDTO();
        enc = new Encryption();
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
        
        UserActionForm userForm = (UserActionForm) form;
        
        if(task == null) {
            return mapping.findForward(SEARCH_PAGE);
            
        } else if(task.equals("create_page")) {
            return mapping.findForward(CREATE_PAGE);
        
        } else if(task.equals("edit_page")) {
            User user = userdto.getUserById(request.getParameter("userId"));
            user.setPassword(enc.decryptText(user.getPassword()));
            request.setAttribute("user", user);
            return mapping.findForward(EDIT_PAGE);
            
        } else if(task.equals("search")) {
            List<User> users = new ArrayList();
            
            users = userdto.getUsersByIdNameBranch(
                userForm.getId(),
                userForm.getName(),
                userForm.getBranch());
            
            request.setAttribute("users", users);
            return mapping.findForward(SEARCH_SUCCESS);
            
        } else if(task.equals("create")) {
            ActionErrors errors = userForm.validate(mapping, request);
            
            if(errors.isEmpty()) {
                String created_by = (String) request.getSession().getAttribute("userId");
                Integer result = userdto.insertUser(
                        userForm.getId(), 
                        userForm.getName(), 
                        enc.encryptText(userForm.getPassword()), 
                        userForm.getRole(),
                        userForm.getBranch(),
                        created_by
                );

                if(result != 0) {
                    return mapping.findForward(CREATE_SUCCESS);
                } else {
                    return mapping.findForward(FAILED);
                }
            } else {
                return mapping.findForward(FAILED);
            }   
        
        } else if(task.equals("edit")) {
            
            ActionErrors errors = userForm.validate(mapping, request);
            
            if(errors.isEmpty()) {
                String modified_by = (String) request.getSession().getAttribute("userId");
                
                Integer result = userdto.updateUser(
                        userForm.getId(), 
                        userForm.getName(), 
                        enc.encryptText(userForm.getPassword()), 
                        userForm.getRole(),
                        userForm.getBranch(),
                        modified_by
                );
                
                if(result != 0) {   
                    return mapping.findForward(CREATE_SUCCESS);
                } else {
                    return mapping.findForward(FAILED);
                }
            } else {
                return mapping.findForward(FAILED);
            }
            
        } else {
            return mapping.findForward(FAILED);
        }
        
    }
}
