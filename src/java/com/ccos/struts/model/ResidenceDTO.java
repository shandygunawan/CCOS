/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import com.ccos.struts.model.bean.Residence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shand
 */
public class ResidenceDTO {
    
    public ResidenceDTO() {}
    
    /*
        ===== SELECT ONE RESULT =====
    */
    public Residence getResidenceByCustId(Integer custId) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_RESIDENCE WHERE cust_id = ?");
            stmt.setInt(1, custId);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getResidenceByCustId: There is no residence found!");
                return null;
            }
            
            rs.next();
            
            Residence resi = new Residence();
            resi.setId(rs.getInt("id"));
            resi.setMailingAddress(rs.getString("mailing_address"));
            resi.setAddress(rs.getString("address"));
            resi.setCityId(rs.getString("city_id"));
            resi.setProvinceId(rs.getString("province_id"));
            resi.setZipCode(rs.getString("zip_code"));
            resi.setKelurahan(rs.getString("kelurahan"));
            resi.setKecamatan(rs.getString("kecamatan"));
            resi.setPhoneHome(rs.getString("phone_home"));
            resi.setPhoneMobile(rs.getString("phone_mobile"));
            resi.setEmail(rs.getString("email"));
            resi.setResidenceStatus(rs.getString("residence_status"));
            resi.setStayLengthYear(rs.getInt("stay_length_year"));
            resi.setStayLengthMonth(rs.getInt("stay_length_month"));
            
            resi.setCreatedAt(rs.getTimestamp("created_at"));
            resi.setCreatedBy("created_by");
            resi.setModifiedAt(rs.getTimestamp("modified_at"));
            resi.setModifiedBy("modified_by");
            
            return resi;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== INSERT =====
    */
    public void insertResidence (
            Integer cust_id,
            String mailing_address,
            String address,
            String city_id,
            String province_id,
            String zip_code,
            String kelurahan,
            String kecamatan,
            String phone_home,
            String phone_mobile,
            String email,
            String residence_status,
            Integer stay_length_year,
            Integer stay_length_month,
            String created_by
            ) throws SQLException {
        
        Connection conn = DBConnection.getConnection();
            
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO T_RESIDENCE(cust_id, mailing_address, address, city_id, province_id, zip_code, kelurahan, kecamatan, phone_home, phone_mobile, email, residence_status, stay_length_year, stay_length_month, created_at, created_by)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)", 
                Statement.RETURN_GENERATED_KEYS
        );
        
        stmt.setInt(1, cust_id);
        stmt.setString(2, mailing_address);
        stmt.setString(3, address);
        stmt.setString(4, city_id);
        stmt.setString(5, province_id);
        stmt.setString(6, zip_code);
        stmt.setString(7, kelurahan);
        stmt.setString(8, kecamatan);
        stmt.setString(9, phone_home);
        stmt.setString(10, phone_mobile);
        stmt.setString(11, email);
        stmt.setString(12, residence_status);
        stmt.setInt(13, stay_length_year);
        stmt.setInt(14, stay_length_month);
        stmt.setString(15, created_by);
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Creating residence failed, no rows affected");
        }
    }
    
    /*
        ===== UPDATE =====
    */
    public void updateResidence (
            Integer resi_id,
            Integer cust_id,
            String mailing_address,
            String address,
            String city_id,
            String province_id,
            String zip_code,
            String kelurahan,
            String kecamatan,
            String phone_home,
            String phone_mobile,
            String email,
            String residence_status,
            Integer stay_length_year,
            Integer stay_length_month,
            String modified_by
            ) throws SQLException {
        
        Connection conn = DBConnection.getConnection();
            
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE T_RESIDENCE SET cust_id = ?, mailing_address = ?, address = ?, "
                        + "city_id = ?, province_id = ?, zip_code = ?, "
                        + "kelurahan = ?, kecamatan = ?, phone_home = ?, "
                        + "phone_mobile = ?, email = ?, residence_status = ?, "
                        + "stay_length_year = ?, stay_length_month = ?, "
                        + "modified_at = CURRENT_TIMESTAMP, modified_by = ?"
                        + "WHERE id = ?", 
                Statement.RETURN_GENERATED_KEYS
        );
        
        stmt.setInt(1, cust_id);
        stmt.setString(2, mailing_address);
        stmt.setString(3, address);
        stmt.setString(4, city_id);
        stmt.setString(5, province_id);
        stmt.setString(6, zip_code);
        stmt.setString(7, kelurahan);
        stmt.setString(8, kecamatan);
        stmt.setString(9, phone_home);
        stmt.setString(10, phone_mobile);
        stmt.setString(11, email);
        stmt.setString(12, residence_status);
        stmt.setInt(13, stay_length_year);
        stmt.setInt(14, stay_length_month);
        stmt.setString(15, modified_by);
        stmt.setInt(16, resi_id);
        Integer affectedRoles = stmt.executeUpdate();
        
        if(affectedRoles == 0) {
            throw new SQLException("Updating residence failed, no rows affected");
        }
    }
}