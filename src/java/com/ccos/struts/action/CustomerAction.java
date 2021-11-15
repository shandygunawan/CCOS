/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.ccos.struts.action;

import com.ccos.struts.actionform.CustomerActionForm;
import com.ccos.struts.model.ApplicationDTO;
import com.ccos.struts.model.CityDTO;
import com.ccos.struts.model.CustomerDTO;
import com.ccos.struts.model.ProvinceDTO;
import com.ccos.struts.model.ResidenceDTO;
import com.ccos.struts.model.SpouseDTO;
import com.ccos.struts.model.bean.Application;
import com.ccos.struts.model.bean.City;
import com.ccos.struts.model.bean.Customer;
import com.ccos.struts.model.bean.Province;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author shand
 */
public class CustomerAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String SEARCH_PAGE = "search_page";
    private static final String CREATE_PAGE = "create_page";
    private static final String EDIT_PAGE = "edit_page";
    private static final String SEARCH_SUCCESS = "search_success";
    private static final String CREATE_SUCCESS = "create_success";
    private static final String FAILED = "failed";
    
    private CustomerDTO custdto;
    private ResidenceDTO residto;
    private ProvinceDTO provdto;
    private CityDTO citydto;
    private SpouseDTO spoudto;
    private ApplicationDTO appdto;
    
    private Gson gson;
    
    public CustomerAction() {
        custdto = new CustomerDTO();
        residto = new ResidenceDTO();
        provdto = new ProvinceDTO();
        citydto = new CityDTO();
        spoudto = new SpouseDTO();
        appdto = new ApplicationDTO();
        
        gson = new Gson();
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
        
        if(task == null) {
            return mapping.findForward(SEARCH_PAGE);
            
        } else if(task.equals("create_page")) {
            
            List<Province> provinces = provdto.getProvincesAll();
            List<City> cities = citydto.getCitiesAll();
            
            request.setAttribute("provinces_json", gson.toJson(provinces));
            request.setAttribute("cities_json", gson.toJson(cities));
            
            return mapping.findForward(CREATE_PAGE);
            
        } else if(task.equals("edit_page")) {
            Integer custId = Integer.parseInt(request.getParameter("custId"));
            List<Province> provinces = provdto.getProvincesAll();
            List<City> cities = citydto.getCitiesAll();
            
            request.setAttribute("provinces_json", gson.toJson(provinces));
            request.setAttribute("cities_json", gson.toJson(cities));
            request.setAttribute("customer", custdto.getCustomerById(custId));
            request.setAttribute("spouse", spoudto.getSpouseByCustId(custId));
            request.setAttribute("residence", residto.getResidenceByCustId(custId));
            request.setAttribute("applications", appdto.getApplicationsByCustId(custId));
            
            return mapping.findForward(EDIT_PAGE);
            
        } else if(task.equals("search")) {
            CustomerActionForm custForm = (CustomerActionForm) form;
            List<Customer> custs = new ArrayList();
            
            if(custForm.getBirthDate().equals("")) {
                custs = custdto.getCustomersByNameIdNum(custForm.getName(), custForm.getIdNum());
                System.out.println("birthdate null");
            } else {
                java.sql.Date birthdate = this.dateStringToSqlDate(custForm.getBirthDate());
                
                custs = custdto.getCustomersByNameIdNumBirthDate(
                        custForm.getName(), 
                        custForm.getIdNum(), 
                        birthdate);
                System.out.println("birthdate not null");
            }
            
            System.out.println(custs);
            
            request.setAttribute("customers", custs);
            return mapping.findForward(SEARCH_SUCCESS);
        }
        else if(task.equals("create")) {
            CustomerActionForm custForm = (CustomerActionForm) form;
            String created_by = (String) request.getSession().getAttribute("userId");
            
            try {
                java.sql.Date idExpiryDate = this.dateStringToSqlDate(custForm.getIdExpiryDate());
                java.sql.Date birthdate = this.dateStringToSqlDate(custForm.getBirthDate());
                Integer cust_id = custdto.insertCustomerReturnId(
                        custForm.getName(),
                        custForm.getFullName(),
                        custForm.getIdType(), 
                        custForm.getIdNum(),
                        idExpiryDate,
                        custForm.getGender(),
                        birthdate,
                        custForm.getBirthPlace(),
                        custForm.getBirthCity(),
                        custForm.getBirthProvince(),
                        custForm.getMaritalStatus(),
                        custForm.getDependentNum(),
                        custForm.getMotherName(),
                        custForm.getEducation(),
                        created_by
                );
                
                residto.insertResidence(
                        cust_id, 
                        custForm.getMailingAddress(),
                        custForm.getAddress(),
                        custForm.getCityId(),
                        custForm.getProvId(),
                        custForm.getZipCode(),
                        custForm.getKelurahan(),
                        custForm.getKecamatan(),
                        custForm.getPhoneHome(),
                        custForm.getPhoneMobile(),
                        custForm.getEmail(),
                        custForm.getResidenceStatus(),
                        custForm.getStayLengthYear(),
                        custForm.getStayLengthMonth(),
                        created_by
                );
                
                if(custForm.getMaritalStatus().equals("Married")) {
                    java.sql.Date spouse_birthdate = this.dateStringToSqlDate(custForm.getSpouseBirthDate());
                    spoudto.insertSpouse(
                            cust_id, 
                            custForm.getSpouseName(), 
                            custForm.getSpouseIdNum(), 
                            spouse_birthdate, 
                            this.prenuptialStringToBoolean(custForm.getPrenuptial()), 
                            created_by
                    );
                }
                
                return mapping.findForward(CREATE_SUCCESS);
            } catch(SQLException e) {
                e.printStackTrace();
                return mapping.findForward(FAILED);
            }
            
        } else if(task.equals("edit")) {
            CustomerActionForm custForm = (CustomerActionForm) form;
            String modified_by = (String) request.getSession().getAttribute("userId");
            
            try {
                Integer cust_id = Integer.parseInt(request.getParameter("custId"));
                Integer resi_id = Integer.parseInt(request.getParameter("resiId"));
                
                java.sql.Date idExpiryDate = this.dateStringToSqlDate(custForm.getIdExpiryDate());
                java.sql.Date birthdate = this.dateStringToSqlDate(custForm.getBirthDate());
                custdto.updateCustomer(
                        cust_id,
                        custForm.getName(),
                        custForm.getFullName(),
                        custForm.getIdType(), 
                        custForm.getIdNum(),
                        idExpiryDate,
                        custForm.getGender(),
                        birthdate,
                        custForm.getBirthPlace(),
                        custForm.getBirthCity(),
                        custForm.getBirthProvince(),
                        custForm.getMaritalStatus(),
                        custForm.getDependentNum(),
                        custForm.getMotherName(),
                        custForm.getEducation(),
                        modified_by
                );
                
                residto.updateResidence(
                        resi_id,
                        cust_id, 
                        custForm.getMailingAddress(),
                        custForm.getAddress(),
                        custForm.getCityId(),
                        custForm.getProvId(),
                        custForm.getZipCode(),
                        custForm.getKelurahan(),
                        custForm.getKecamatan(),
                        custForm.getPhoneHome(),
                        custForm.getPhoneMobile(),
                        custForm.getEmail(),
                        custForm.getResidenceStatus(),
                        custForm.getStayLengthYear(),
                        custForm.getStayLengthMonth(),
                        modified_by
                );
                
                if(custForm.getMaritalStatus().equals("Married")) {
//                    Integer spouse_id = Integer.parseInt(request.getParameter("spouseId"));
                    java.sql.Date spouse_birthdate = this.dateStringToSqlDate(custForm.getSpouseBirthDate());
                    spoudto.upsertSpouse(
                            cust_id, 
                            custForm.getSpouseName(), 
                            custForm.getSpouseIdNum(), 
                            spouse_birthdate, 
                            this.prenuptialStringToBoolean(custForm.getPrenuptial()), 
                            modified_by
                    );
                }
                
                return mapping.findForward(CREATE_SUCCESS);
            } catch(SQLException e) {
                e.printStackTrace();
                return mapping.findForward(FAILED);
            }
        } else {
            return mapping.findForward(SUCCESS);
        }
    }
    
    private java.sql.Date dateStringToSqlDate(String date_str) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = format.parse(date_str);
        return new java.sql.Date(date.getTime());
    }
    
    private Boolean prenuptialStringToBoolean(String prenuptial) {
        if(prenuptial == "Yes") {
            return true;
        } else {
            return false;
        }
    }
}
