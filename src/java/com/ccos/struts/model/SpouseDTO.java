/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import com.ccos.struts.model.bean.Spouse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shand
 */
public class SpouseDTO {
    
    /*
        ===== SELECT ONE RESULT =====
    */
    public Spouse getSpouseByCustId(Integer custId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_SPOUSE WHERE cust_id = ?");
        stmt.setInt(1, custId);
        ResultSet rs = stmt.executeQuery();

        if(!rs.isBeforeFirst()) {
            System.out.println("getSpouseByCustId: There is no spouse found!");
            return null;
        }

        rs.next();

        Spouse spo = new Spouse();
        spo.setId(rs.getInt("id"));
        spo.setCustId(rs.getInt("cust_id"));
        spo.setName(rs.getString("name"));
        spo.setIdNum(rs.getString("id_num"));
        spo.setBirthDate(rs.getDate("birth_date"));
        spo.setPrenuptial(rs.getBoolean("prenuptial"));

        spo.setCreatedAt(rs.getTimestamp("created_at"));
        spo.setCreatedBy("created_by");
        spo.setModifiedAt(rs.getTimestamp("modified_at"));
        spo.setModifiedBy("modified_by");

        return spo;
        
    }
    
    /*
        ===== INSERT =====
    */
    public void insertSpouse(
            Integer cust_id, String name, String id_num, 
            Date birth_date, Boolean prenuptial, String created_by
    ) throws SQLException {
        Connection conn = DBConnection.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_SPOUSE(cust_id, name, id_num, birth_date, prenuptial, created_at, created_by) "
                + "VALUES(?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)");
        stmt.setInt(1, cust_id);
        stmt.setString(2, name);
        stmt.setString(3, id_num);
        stmt.setDate(4, birth_date);
        stmt.setBoolean(5, prenuptial);
        stmt.setString(6, created_by);
        
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Creating Spouse failed, no rows affected");
        }
    }
    
    /*
        ===== UPDATE =====
    */
    public void upsertSpouse(
            Integer cust_id, String name, String id_num, 
            Date birth_date, Boolean prenuptial, String modified_by
    ) throws SQLException {
        Connection conn = DBConnection.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement(
                  "INSERT INTO T_SPOUSE(cust_id, name, id_num, birth_date, prenuptial, created_at, created_by) "
                + "VALUES(?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?) "
                + "ON CONFLICT (cust_id) "
                + "DO "
                + "UPDATE SET name = ?, id_num = ?, birth_date = ?, prenuptial = ?, modified_at = CURRENT_TIMESTAMP, modified_by = ?;"
        );
        stmt.setInt(1, cust_id);
        stmt.setString(2, name);
        stmt.setString(3, id_num);
        stmt.setDate(4, birth_date);
        stmt.setBoolean(5, prenuptial);
        stmt.setString(6, modified_by);
        stmt.setString(7, name);
        stmt.setString(8, id_num);
        stmt.setDate(9, birth_date);
        stmt.setBoolean(10, prenuptial);
        stmt.setString(11, modified_by);
        
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Updating Spouse failed, no rows affected");
        }
    }
    
    
    public void updateSpouse(
            Integer id, Integer cust_id, String name, String id_num, 
            Date birth_date, Boolean prenuptial, String modified_by
    ) throws SQLException {
        Connection conn = DBConnection.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("UPDATE T_SPOUSE SET cust_id = ?, name = ?, id_num = ?, birth_date = ?, "
                + "prenuptial = ?, modified_at = CURRENT_TIMESTAMP, modified_by = ? "
                + "WHERE id = ?");
        stmt.setInt(1, cust_id);
        stmt.setString(2, name);
        stmt.setString(3, id_num);
        stmt.setDate(4, birth_date);
        stmt.setBoolean(5, prenuptial);
        stmt.setString(6, modified_by);
        stmt.setInt(7, id);
        
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Updating Spouse failed, no rows affected");
        }
    }
}
