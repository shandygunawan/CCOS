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
public class Spouse {
    
    private Integer id;
    private Integer custId;
    private String name;
    private String idNum;
    private Date birthDate;
    private Boolean prenuptial;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;
    
    /*
    ===== Constructor =====
    */
    public Spouse() {}
    
    /*
    ===== Getter =====
    */
    
    public Integer getId() {
        return id;
    }

    public Integer getCustId() {
        return custId;
    }

    public String getName() {
        return name;
    }

    public String getIdNum() {
        return idNum;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Boolean getPrenuptial() {
        return prenuptial;
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
    ===== Setter =====
    */

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPrenuptial(Boolean prenuptial) {
        this.prenuptial = prenuptial;
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
    ===== Utils =====
    */

    @Override
    public String toString() {
        return "Spouse{" + "id=" + id + ", custId=" + custId + ", name=" + name + ", idNum=" + idNum + ", birthDate=" + birthDate + ", prenuptial=" + prenuptial + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.custId);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.idNum);
        hash = 29 * hash + Objects.hashCode(this.birthDate);
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
        final Spouse other = (Spouse) obj;
        if (!Objects.equals(this.custId, other.custId)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.idNum, other.idNum)) {
            return false;
        }
        if (!Objects.equals(this.prenuptial, other.prenuptial)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        return true;
    }
    
    
}
