/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ccos.struts.model.bean;

import java.sql.Timestamp;
import javax.ejb.Stateless;

/**
 *
 * @author shand
 */
@Stateless
public class City {
    
    private String id;
    private String name;
    private String provId;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;
    
    /*
    ===== Constructor =====
    */
    public City() {}

    public City(String id, String name, String provId, Timestamp createdAt, String createdBy, Timestamp modifiedAt, String modifiedBy) {
        this.id = id;
        this.name = name;
        this.provId = provId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }
    
    /*
    ===== GETTER =====
    */

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProvId() {
        return provId;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvId(String provId) {
        this.provId = provId;
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
        return "City{" + "id=" + id + ", name=" + name + ", provId=" + provId + '}';
    }
    
    
}
