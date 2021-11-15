/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import com.ccos.struts.actionform.CityActionForm;
import com.ccos.struts.model.CityDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ccos.struts.model.ProvinceDTO;
import com.ccos.struts.model.bean.City;
import com.ccos.struts.model.bean.Province;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts.action.ActionErrors;

/**
 *
 * @author shand
 */
public class CityAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";
    private static final String SEARCH_PAGE = "search_page";
    private static final String CREATE_PAGE = "create_page";
    private static final String EDIT_PAGE = "edit_page";
    private static final String SEARCH_SUCCESS = "search_success";
    private static final String CREATE_SUCCESS = "create_success";
    
    private ProvinceDTO provdto;
    private CityDTO citydto;
    
    public CityAction() {
        provdto = new ProvinceDTO();
        citydto = new CityDTO();
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
        
        if(task == null) { // search_page
            request.setAttribute("provinces", provdto.getProvincesAll());
            return mapping.findForward(SEARCH_PAGE);  
            
        } else if(task.equals("create_page")) {
            request.setAttribute("provinces", provdto.getProvincesAll());
            return mapping.findForward(CREATE_PAGE);  
            
        } else if(task.equals("edit_page")) {
            request.setAttribute("provinces", provdto.getProvincesAll());
            request.setAttribute("city", citydto.getCityById(request.getParameter("cityId")));
            return mapping.findForward(EDIT_PAGE);
        
        } else if(task.equals("search")) {
            CityActionForm cityForm = (CityActionForm) form;
            List<City> cities = new ArrayList();
            
            if(cityForm.getSearchBy().equals("code")) {
                cities = citydto.getCitiesById(cityForm.getSearchValue());
            } else if(cityForm.getSearchBy().equals("description")) {
                cities = citydto.getCitiesByNameProvId(cityForm.getSearchValue(), cityForm.getProvId());
            }
            
            request.setAttribute("cities", cities);
            request.setAttribute("provinces", provdto.getProvincesAll());
            
            return mapping.findForward(SEARCH_SUCCESS);
            
        } else if(task.equals("create")) {
            CityActionForm cityForm = (CityActionForm) form;
            ActionErrors errors = cityForm.validate(mapping, request);
            String created_by = (String) request.getSession().getAttribute("userId");
            
            if(errors.isEmpty()) {
                Integer result = citydto.insertCity(
                    cityForm.getCode(), 
                    cityForm.getName(),
                    cityForm.getProvId(),
                    created_by);
            
                if(result != 0) {
                    return mapping.findForward(CREATE_SUCCESS);
                } else {
                    return mapping.findForward(FAILED);
                }
            } else {
                return mapping.findForward(FAILED);
            }
            
        } else if(task.equals("edit")) {
            CityActionForm cityForm = (CityActionForm) form;
            ActionErrors errors = cityForm.validate(mapping, request);
            String modified_by = (String) request.getSession().getAttribute("userId");
            
            if(errors.isEmpty()) {
                Integer result = citydto.updateCity(
                    cityForm.getCode(), 
                    cityForm.getName(),
                    cityForm.getProvId(),
                    modified_by);
            
                if(result != 0) {
                    return mapping.findForward(CREATE_SUCCESS);
                } else {
                    return mapping.findForward(FAILED);
                }
            } else {
                return mapping.findForward(FAILED);
            }
        }
        
        return mapping.findForward(SUCCESS);
    }
    
}
