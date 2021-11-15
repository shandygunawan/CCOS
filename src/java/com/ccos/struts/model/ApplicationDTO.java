/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import com.ccos.struts.model.bean.Application;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shand
 */
public class ApplicationDTO {
    
    /*
        ===== SELECT MULTIPLE RESULTS =====
    */
    public List<Application> getApplicationsByCustId(Integer cust_id) throws SQLException {
        Connection conn = DBConnection.getConnection();
            
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_APPLICATION WHERE cust_id = ?;");
        stmt.setInt(1, cust_id);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Application> apps = new ArrayList();
        
        while(rs.next()) {
            Application app = new Application();
            
            app.setId(rs.getInt(Application.TABLE_ID));
            app.setCustId(rs.getInt(Application.TABLE_CUST_ID));
            app.setStatus(rs.getString(Application.TABLE_STATUS));
            app.setBranchReferral(rs.getString(Application.TABLE_BRANCH_REFERRAL));
            app.setReceivedDate(rs.getDate(Application.TABLE_RECEIVED_DATE));
            app.setFacility(rs.getString(Application.TABLE_FACILITY));
            app.setPurpose(rs.getString(Application.TABLE_PURPOSE));
            app.setBusinessSource(rs.getString(Application.TABLE_BUSINESS_SOURCE));
            app.setMediaChannel(rs.getString(Application.TABLE_MEDIA_CHANNEL));
            app.setBranchFee(rs.getString(Application.TABLE_BRANCH_FEE));
            app.setBranchProvision(rs.getString(Application.TABLE_BRANCH_PROVISION));
            app.setBranchKckk(rs.getString(Application.TABLE_BRANCH_KCKK));
            app.setStaffName(rs.getString(Application.TABLE_STAFF_NAME));
            app.setStaffNip(rs.getString(Application.TABLE_STAFF_NIP));
            app.setStaffBranch(rs.getString(Application.TABLE_STAFF_BRANCH));
            app.setStaffAccount(rs.getString(Application.TABLE_STAFF_ACCOUNT));
            app.setCreatedAt(rs.getTimestamp(Application.TABLE_CREATED_AT));
            app.setCreatedBy(rs.getString(Application.TABLE_CREATED_BY));
            app.setModifiedAt(rs.getTimestamp(Application.TABLE_MODIFIED_AT));
            app.setModifiedBy(rs.getString(Application.TABLE_MODIFIED_BY));
            
            apps.add(app);
        }
        
        return apps;
    }
    
    public void insertApplication(
            Integer cust_id,
            String status,
            String branch_referral,
            Date received_date,
            String facility,
            String purpose,
            String business_source,
            String media_channel,
            String branch_fee,
            String branch_provision,
            String branch_kckk,
            String staff_name,
            String staff_nip,
            String staff_branch,
            String staff_account,
            String created_by
        ) throws SQLException {
        
        Connection conn = DBConnection.getConnection();
            
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO T_APPLICATION(cust_id, status, branch_referral, received_date, facility, purpose, business_source, media_channel, branch_fee, branch_provision, branch_kckk, staff_name, staff_nip, staff_branch, staff_account, created_at, created_by) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)");
        stmt.setInt(1, cust_id);
        stmt.setString(2, status);
        stmt.setString(3, branch_referral);
        stmt.setDate(4, received_date);
        stmt.setString(5, facility);
        stmt.setString(6, purpose);
        stmt.setString(7, business_source);
        stmt.setString(8, media_channel);
        stmt.setString(9, branch_fee);
        stmt.setString(10, branch_provision);
        stmt.setString(11, branch_kckk);
        stmt.setString(12, staff_name);
        stmt.setString(13, staff_nip);
        stmt.setString(14, staff_branch);
        stmt.setString(15, staff_account);
        stmt.setString(16, created_by);
        
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Creating Application failed, no rows affected");
        }
    }
    
    public void updateApplication(
            Integer id,
            Integer cust_id,
            String status,
            String branch_referral,
            Date received_date,
            String facility,
            String purpose,
            String business_source,
            String media_channel,
            String branch_fee,
            String branch_provision,
            String branch_kckk,
            String staff_name,
            String staff_nip,
            String staff_branch,
            String staff_account,
            String created_by
        ) throws SQLException {
        
        Connection conn = DBConnection.getConnection();
            
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE T_APPLICATION SET branch_referral = ?, received_date = ?, facility = ?, purpose= ?, "
              + "business_source = ?, media_channel = ?, branch_fee = ?, branch_provision = ?, branch_kckk = ?, "
              + "staff_name = ?, staff_nip = ?, staff_branch = ?, staff_account = ?, modified_at = CURRENT_TIMESTAMP, modified_by = ? "
              + "WHERE id = ?");
        
        stmt.setString(1, branch_referral);
        stmt.setDate(2, received_date);
        stmt.setString(3, facility);
        stmt.setString(4, purpose);
        stmt.setString(5, business_source);
        stmt.setString(6, media_channel);
        stmt.setString(7, branch_fee);
        stmt.setString(8, branch_provision);
        stmt.setString(9, branch_kckk);
        stmt.setString(10, staff_name);
        stmt.setString(11, staff_nip);
        stmt.setString(12, staff_branch);
        stmt.setString(13, staff_account);
        stmt.setString(14, created_by);
        stmt.setInt(15, id);
        
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Creating Application failed, no rows affected");
        }
    }
}
