/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.ccos.struts.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author shand
 */
public class ApplicationActionForm extends org.apache.struts.action.ActionForm {
    
    private Integer custId;
    private String branchReferral;
    private String receivedDate;
    private String facility;
    private String purpose;
    private String businessSource;
    private String mediaChannel;
    private String branchFee;
    private String branchProvision;
    private String branchKckk;
    private String staffName;
    private String staffNip;
    private String staffBranch;
    private String staffAccount;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;

    public Integer getCustId() {
        return custId;
    }

    public String getBranchReferral() {
        return branchReferral;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public String getFacility() {
        return facility;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getBusinessSource() {
        return businessSource;
    }

    public String getMediaChannel() {
        return mediaChannel;
    }

    public String getBranchFee() {
        return branchFee;
    }

    public String getBranchProvision() {
        return branchProvision;
    }

    public String getBranchKckk() {
        return branchKckk;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffNip() {
        return staffNip;
    }

    public String getStaffBranch() {
        return staffBranch;
    }

    public String getStaffAccount() {
        return staffAccount;
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

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public void setBranchReferral(String branchReferral) {
        this.branchReferral = branchReferral;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setBusinessSource(String businessSource) {
        this.businessSource = businessSource;
    }

    public void setMediaChannel(String mediaChannel) {
        this.mediaChannel = mediaChannel;
    }

    public void setBranchFee(String branchFee) {
        this.branchFee = branchFee;
    }

    public void setBranchProvision(String branchProvision) {
        this.branchProvision = branchProvision;
    }

    public void setBranchKckk(String branchKckk) {
        this.branchKckk = branchKckk;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffNip(String staffNip) {
        this.staffNip = staffNip;
    }

    public void setStaffBranch(String staffBranch) {
        this.staffBranch = staffBranch;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
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
    
    
    

    /**
     *
     */
    public ApplicationActionForm() {
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
        
        if (custId == null) {
            errors.add("custId", new ActionMessage("application.errors.custid.required"));
        }
        return errors;
    }
}
