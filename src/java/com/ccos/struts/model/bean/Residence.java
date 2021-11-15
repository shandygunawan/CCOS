/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ccos.struts.model.bean;

import java.sql.Timestamp;
import java.util.Objects;
import javax.ejb.Stateless;

/**
 *
 * @author shand
 */
@Stateless
public class Residence {

    private Integer id;
    private String custId;
    private String mailingAddress;
    private String address;
    private String cityId;
    private String provinceId;
    private String zipCode;
    private String kelurahan;
    private String kecamatan;
    private String phoneHome;
    private String phoneMobile;
    private String email;
    private String residenceStatus;
    private Integer stayLengthYear;
    private Integer stayLengthMonth;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;
    
    /*
    ===== Constructor =====
    */

    public Residence() {}
    
    
    /*
    ===== Getter =====
    */

    public Integer getId() {
        return id;
    }

    public String getCustId() {
        return custId;
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

    public String getProvinceId() {
        return provinceId;
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
    
    
    /*
    ===== SETTER =====
    */

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustId(String custId) {
        this.custId = custId;
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

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
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
    
    
    /*
    ===== UTILS =====
    */

    @Override
    public String toString() {
        return "Residence{" + "id=" + id + ", custId=" + custId + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.custId);
        hash = 37 * hash + Objects.hashCode(this.address);
        hash = 37 * hash + Objects.hashCode(this.cityId);
        hash = 37 * hash + Objects.hashCode(this.provinceId);
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
        final Residence other = (Residence) obj;
        if (!Objects.equals(this.custId, other.custId)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.cityId, other.cityId)) {
            return false;
        }
        if (!Objects.equals(this.provinceId, other.provinceId)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.kelurahan, other.kelurahan)) {
            return false;
        }
        if (!Objects.equals(this.kecamatan, other.kecamatan)) {
            return false;
        }
        if (!Objects.equals(this.phoneHome, other.phoneHome)) {
            return false;
        }
        if (!Objects.equals(this.phoneMobile, other.phoneMobile)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.residenceStatus, other.residenceStatus)) {
            return false;
        }
        if (!Objects.equals(this.createdBy, other.createdBy)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.stayLengthYear, other.stayLengthYear)) {
            return false;
        }
        if (!Objects.equals(this.stayLengthMonth, other.stayLengthMonth)) {
            return false;
        }
        return true;
    }
    
    
}
