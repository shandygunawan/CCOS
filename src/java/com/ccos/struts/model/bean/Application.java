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
public class Application {
    
    /*
    ===== Variables =====
    */
    private Integer id;
    private Integer custId;
    private String status;
    private String branchReferral;
    private Date receivedDate;
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

    /*
    ===== Table Names =====
    */
    public static final String TABLE_ID = "id";
    public static final String TABLE_CUST_ID = "cust_id";
    public static final String TABLE_STATUS = "status";
    public static final String TABLE_BRANCH_REFERRAL = "branch_referral";
    public static final String TABLE_RECEIVED_DATE = "received_date";
    public static final String TABLE_FACILITY = "facility";
    public static final String TABLE_PURPOSE = "purpose";
    public static final String TABLE_BUSINESS_SOURCE = "business_source";
    public static final String TABLE_MEDIA_CHANNEL = "media_channel";
    public static final String TABLE_BRANCH_FEE = "branch_fee";
    public static final String TABLE_BRANCH_PROVISION = "branch_provision";
    public static final String TABLE_BRANCH_KCKK = "branch_kckk";
    public static final String TABLE_STAFF_NAME = "staff_name";
    public static final String TABLE_STAFF_NIP = "staff_nip";
    public static final String TABLE_STAFF_BRANCH = "staff_branch";
    public static final String TABLE_STAFF_ACCOUNT = "staff_account";
    public static final String TABLE_CREATED_AT = "created_at";
    public static final String TABLE_CREATED_BY = "created_by";
    public static final String TABLE_MODIFIED_AT = "modified_at";
    public static final String TABLE_MODIFIED_BY = "modified_by";
    
    /*
    ===== Constructor =====
    */
    public Application() {}
    
    
    /*
    ===== GETTER =====
    */

    public Integer getId() {
        return id;
    }

    public Integer getCustId() {
        return custId;
    }

    public String getStatus() {
        return status;
    }

    public String getBranchReferral() {
        return branchReferral;
    }

    public Date getReceivedDate() {
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
    
    /*
    ===== SETTER =====
    */

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBranchReferral(String branchReferral) {
        this.branchReferral = branchReferral;
    }

    public void setReceivedDate(Date receivedDate) {
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
    
    /*
    ===== UTILS =====
    */

    @Override
    public String toString() {
        return "Application{" + "id=" + id + ", custId=" + custId + ", branchReferral=" + branchReferral + ", receivedDate=" + receivedDate + ", facility=" + facility + ", purpose=" + purpose + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.custId);
        hash = 11 * hash + Objects.hashCode(this.branchReferral);
        hash = 11 * hash + Objects.hashCode(this.receivedDate);
        hash = 11 * hash + Objects.hashCode(this.facility);
        hash = 11 * hash + Objects.hashCode(this.purpose);
        hash = 11 * hash + Objects.hashCode(this.businessSource);
        hash = 11 * hash + Objects.hashCode(this.mediaChannel);
        hash = 11 * hash + Objects.hashCode(this.branchFee);
        hash = 11 * hash + Objects.hashCode(this.branchProvision);
        hash = 11 * hash + Objects.hashCode(this.branchKckk);
        hash = 11 * hash + Objects.hashCode(this.staffName);
        hash = 11 * hash + Objects.hashCode(this.staffNip);
        hash = 11 * hash + Objects.hashCode(this.staffBranch);
        hash = 11 * hash + Objects.hashCode(this.staffAccount);
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
        final Application other = (Application) obj;
        if (!Objects.equals(this.branchReferral, other.branchReferral)) {
            return false;
        }
        if (!Objects.equals(this.facility, other.facility)) {
            return false;
        }
        if (!Objects.equals(this.purpose, other.purpose)) {
            return false;
        }
        if (!Objects.equals(this.businessSource, other.businessSource)) {
            return false;
        }
        if (!Objects.equals(this.mediaChannel, other.mediaChannel)) {
            return false;
        }
        if (!Objects.equals(this.branchFee, other.branchFee)) {
            return false;
        }
        if (!Objects.equals(this.branchProvision, other.branchProvision)) {
            return false;
        }
        if (!Objects.equals(this.branchKckk, other.branchKckk)) {
            return false;
        }
        if (!Objects.equals(this.staffName, other.staffName)) {
            return false;
        }
        if (!Objects.equals(this.staffNip, other.staffNip)) {
            return false;
        }
        if (!Objects.equals(this.staffBranch, other.staffBranch)) {
            return false;
        }
        if (!Objects.equals(this.staffAccount, other.staffAccount)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.custId, other.custId)) {
            return false;
        }
        if (!Objects.equals(this.receivedDate, other.receivedDate)) {
            return false;
        }
        return true;
    }
}
