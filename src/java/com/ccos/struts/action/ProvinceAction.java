/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import com.ccos.struts.actionform.ProvinceActionForm;
import com.ccos.struts.model.ProvinceDTO;
import com.ccos.struts.model.bean.Province;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author shand
 */
public class ProvinceAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SEARCH_PAGE = "search_page";
    private static final String CREATE_PAGE = "create_page";
    private static final String SEARCH_SUCCESS = "search_success";
    private static final String CREATE_SUCCESS = "create_success";
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
        
        String task = request.getParameter("task");
        
        System.out.println("Task : " + task);
        
        ProvinceActionForm provinceForm = (ProvinceActionForm) form;
        ProvinceDTO provdto = new ProvinceDTO();
        
        if(task == null) {
            return mapping.findForward(SEARCH_PAGE);
        } else if(task.equals("create_page")) {
            return mapping.findForward(CREATE_PAGE);
        } else if(task.equals("search")) {
            
            List<Province> provinces = new ArrayList();
            
            if(provinceForm.getSearchBy().equals("code")) {
                provinces = provdto.getProvincesById(provinceForm.getSearchValue());
            } else if(provinceForm.getSearchBy().equals("description")) {
                provinces = provdto.getProvincesByName(provinceForm.getSearchValue());
            }
            
            request.setAttribute("provinces", provinces);
            return mapping.findForward(SEARCH_SUCCESS);
            
        } else if(task.equals("create")) {
            String created_by = (String) request.getSession().getAttribute("userId");
            
            Integer result = provdto.insertProvince(
                    provinceForm.getCode(), 
                    provinceForm.getName(), 
                    created_by);
            
            if(result != 0) {
                return mapping.findForward(CREATE_SUCCESS);
            } else {
                return mapping.findForward(FAILED);
            }
        } else {
            return mapping.findForward(FAILED);
        }
    }
}
