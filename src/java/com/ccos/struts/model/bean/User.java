/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ccos.struts.model.bean;

import javax.ejb.Stateless;
import java.sql.Timestamp;

/**
 *
 * @author shand
 */
@Stateless
public class User {
    private String userId;
    private String name;
    private String password;
    private String role;
    private String branch;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;

    /*
    ===== Constructor =====
    */
    public User() {
        
    }

    public User(String userId, String name, String password, String role, String branch, Timestamp createdAt, String createdBy, Timestamp modifiedAt, String modifiedBy) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
        this.branch = branch;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }
    
    
    
    /*
    ===== GETTER =====
    */
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getBranch() {
        return branch;
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
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
        return "User{" + "userId=" + userId + ", name=" + name + ", role=" + role + ", branch=" + branch + '}';
    }
    
}
