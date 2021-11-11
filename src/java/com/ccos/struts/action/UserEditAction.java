/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import com.ccos.struts.actionform.UserEditActionForm;
import com.ccos.struts.model.UserDTO;
import com.ccos.struts.model.bean.User;
import com.ccos.utils.Encryption;
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
public class UserEditAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";
    private static final String DETAIL = "detail";

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
        
        
        String method = request.getParameter("method");
        UserDTO userdto = new UserDTO();
        Encryption enc = new Encryption();
        
        String user_id = request.getParameter("userId");
        
        User user = userdto.getUserById(user_id);
        
        if(method.equals("detail")) {
            
            if (user != null) {
                user.setPassword(enc.decryptText(user.getPassword()));
                request.setAttribute("user", user);
                return mapping.findForward(DETAIL);
            } else {
                
                return mapping.findForward(FAILED);
            }
            
        } else if(method.equals("edit")) {
            ActionErrors errors = new ActionErrors();
            UserEditActionForm editForm = (UserEditActionForm) form;
            
            if(errors.isEmpty()) {
                String modified_by = (String) request.getSession().getAttribute("userId");

                Integer result = userdto.updateUser(
                        editForm.getUserId(), 
                        editForm.getUserName(), 
                        enc.encryptText(editForm.getPassword()), 
                        editForm.getRole(),
                        editForm.getBranch(),
                        modified_by
                );

                if(result != 0) {   
                    return mapping.findForward(SUCCESS);
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
