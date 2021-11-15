/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ccos.struts.model.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import javax.ejb.Stateless;

/**
 *
 * @author shand
 */
@Stateless
public class Customer {
    
    private Integer id;
    private String name;
    private String fullName;
    private String idType;
    private String idNum;
    private Date idExpiryDate;
    private String gender;
    private Date birthDate;
    private String birthPlace;
    private String birthCity;
    private String birthProvince;
    private String maritalStatus;
    private Integer dependentNum;
    private String motherName;
    private String education;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;
    
    private Residence residence;
    
    /*
    ===== Constructor =====
    */
    public Customer() {}
    
    /*
    ===== Getter =====
    */

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

    public Date getIdExpiryDate() {
        return idExpiryDate;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public Residence getResidence() {
        return residence;
    }
    
    /*
    ===== Setter =====
    */
    
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

    public void setIdExpiryDate(Date idExpiryDate) {
        this.idExpiryDate = idExpiryDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
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

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }
    
    
    /*
    ===== Utils =====
    */

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", birthDate=" + birthDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.fullName);
        hash = 59 * hash + Objects.hashCode(this.idNum);
        hash = 59 * hash + Objects.hashCode(this.birthDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.idType, other.idType)) {
            return false;
        }
        if (!Objects.equals(this.idNum, other.idNum)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.birthPlace, other.birthPlace)) {
            return false;
        }
        if (!Objects.equals(this.birthCity, other.birthCity)) {
            return false;
        }
        if (!Objects.equals(this.birthProvince, other.birthProvince)) {
            return false;
        }
        if (!Objects.equals(this.motherName, other.motherName)) {
            return false;
        }
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idExpiryDate, other.idExpiryDate)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        return true;
    }
    
    
    
}
