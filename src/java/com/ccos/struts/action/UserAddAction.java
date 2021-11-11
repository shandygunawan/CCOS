/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ccos.utils.Encryption;

import com.ccos.struts.actionform.UserAddActionForm;
import com.ccos.struts.model.UserDTO;


/**
 *
 * @author shand
 */
public class UserAddAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

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
        
        ActionErrors errors = new ActionErrors();
        
        UserAddActionForm addForm = (UserAddActionForm) form;
        
        errors = addForm.validate(mapping, request);
        
        if(errors.isEmpty()) {
            
            UserDTO userdto = new UserDTO();
            
            Encryption enc = new Encryption();
            String created_by = (String) request.getSession().getAttribute("userId");
            Integer result = userdto.insertUser(
                    addForm.getUserId(), 
                    addForm.getUserName(), 
                    enc.encryptText(addForm.getPassword()), 
                    addForm.getRole(),
                    addForm.getBranch(),
                    created_by
            );
            
            if(result != 0) {
                
                return mapping.findForward(SUCCESS);
            } else {
                return mapping.findForward(FAILED);
            }
        } else {
            return mapping.findForward(FAILED);
        }
    }
}
