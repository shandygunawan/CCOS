/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ccos.struts.actionform.UserSearchActionForm;
import com.ccos.struts.model.bean.User;
import com.ccos.struts.model.UserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shand
 */
public class UserSearchAction extends org.apache.struts.action.Action {

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
        
        UserSearchActionForm searchForm = (UserSearchActionForm) form;
        
        UserDTO userdto = new UserDTO();
        List<User> users = new ArrayList();
        
        users = userdto.getUsersByIdNameBranch(
                searchForm.getUserId(),
                searchForm.getUserName(),
                searchForm.getBranch());
        
        request.setAttribute("users", users);
        return mapping.findForward(SUCCESS);
    }
}
