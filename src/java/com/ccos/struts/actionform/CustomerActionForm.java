/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.ccos.struts.actionform;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author shand
 */
public class CustomerActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer id;
    private String name;
    private String fullName;
    private String idType;
    private String idNum;
    private String idExpiryDate;
    private String gender;
    private String birthDate;
    private String birthPlace;
    private String birthCity;
    private String birthProvince;
    private String maritalStatus;
    private Integer dependentNum;
    private String motherName;
    private String education;
    
    private String spouseName;
    private String spouseIdNum;
    private String spouseBirthDate;
    private String prenuptial;
    
    private String mailingAddress;
    private String address;
    private String cityId;
    private String provId;
    private String zipCode;
    private String kelurahan;
    private String kecamatan;
    private String phoneHome;
    private String phoneMobile;
    private String email;
    private String residenceStatus;
    private Integer stayLengthYear;
    private Integer stayLengthMonth;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public String getBirthProvince() {
        return birthProvince;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Integer getDependentNum() {
        return dependentNum;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getEducation() {
        return education;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public String getSpouseIdNum() {
        return spouseIdNum;
    }

    public String getSpouseBirthDate() {
        return spouseBirthDate;
    }

    public String getPrenuptial() {
        return prenuptial;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getCityId() {
        return cityId;
    }

    public String getProvId() {
        return provId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public String getResidenceStatus() {
        return residenceStatus;
    }

    public Integer getStayLengthYear() {
        return stayLengthYear;
    }

    public Integer getStayLengthMonth() {
        return stayLengthMonth;
    }    
    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setIdExpiryDate(String idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public void setBirthProvince(String birthProvince) {
        this.birthProvince = birthProvince;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setDependentNum(Integer dependentNum) {
        this.dependentNum = dependentNum;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public void setSpouseIdNum(String spouseIdNum) {
        this.spouseIdNum = spouseIdNum;
    }

    public void setSpouseBirthDate(String spouseBirthDate) {
        this.spouseBirthDate = spouseBirthDate;
    }

    public void setPrenuptial(String prenuptial) {
        this.prenuptial = prenuptial;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    public void setStayLengthYear(Integer stayLengthYear) {
        this.stayLengthYear = stayLengthYear;
    }

    public void setStayLengthMonth(Integer stayLengthMonth) {
        this.stayLengthMonth = stayLengthMonth;
    }  
    

    /**
     *
     */
    public CustomerActionForm() {
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
        
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("customer.errors.name.required"));
        }
        
        return errors;
    }
}
