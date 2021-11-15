/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import com.ccos.struts.model.bean.Province;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shand
 */
public class ProvinceDTO {
    public ProvinceDTO() {
        
    }
    
    /*
        ===== SELECT ONE RESULT =====
    */
    public Province getProvinceById(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_PROVINCE WHERE id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("There is no province found!");
                return null;
            }
            
            rs.next();
            
            Province province = new Province();
            province.setId(rs.getString("id"));
            province.setName(rs.getString("name"));
            province.setCreatedAt(rs.getTimestamp("created_at"));
            province.setCreatedBy("created_by");
            province.setModifiedAt(rs.getTimestamp("modified_at"));
            province.setModifiedBy("modified_by");
            
            return province;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== SELECT MULTIPLE RESULTS =====
    */
    public List<Province> getProvincesAll() {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_PROVINCE ORDER BY id");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getProvincesAll: There is no provinces found!");
                return null;
            }
            
            ArrayList<Province> provinces = new ArrayList();
            
            while(rs.next()) {
                Province province = new Province();
                province.setId(rs.getString("id"));
                province.setName(rs.getString("name"));
                province.setCreatedAt(rs.getTimestamp("created_at"));
                province.setCreatedBy("created_by");
                province.setModifiedAt(rs.getTimestamp("modified_at"));
                province.setModifiedBy("modified_by");
                provinces.add(province);
            }
            
            return provinces;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Province> getProvincesById(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_PROVINCE WHERE id LIKE ? ORDER BY id");
            stmt.setString(1, "%" + id + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getProvincesById: There is no provinces found!");
                return null;
            }
            
            ArrayList<Province> provinces = new ArrayList();
            
            while(rs.next()) {
                Province province = new Province();
                province.setId(rs.getString("id"));
                province.setName(rs.getString("name"));
                province.setCreatedAt(rs.getTimestamp("created_at"));
                province.setCreatedBy("created_by");
                province.setModifiedAt(rs.getTimestamp("modified_at"));
                province.setModifiedBy("modified_by");
                provinces.add(province);
            }
            
            return provinces;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Province> getProvincesByName(String name) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_PROVINCE WHERE name LIKE ? ORDER BY id");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getProvincesByName: There is no provinces found!");
                return null;
            }
            
            ArrayList<Province> provinces = new ArrayList();
            
            while(rs.next()) {
                Province province = new Province();
                province.setId(rs.getString("id"));
                province.setName(rs.getString("name"));
                province.setCreatedAt(rs.getTimestamp("created_at"));
                province.setCreatedBy("created_by");
                province.setModifiedAt(rs.getTimestamp("modified_at"));
                province.setModifiedBy("modified_by");
                provinces.add(province);
            }
            
            return provinces;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Province> getProvincesByIdName(String id, String name) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_PROVINCE WHERE id LIKE ? AND name LIKE ? ORDER BY id");
            stmt.setString(1, "%" + id + "%");
            stmt.setString(2, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("There is no provinces found!");
                return null;
            }
            
            ArrayList<Province> provinces = new ArrayList();
            
            while(rs.next()) {
                Province province = new Province();
                province.setId(rs.getString("id"));
                province.setName(rs.getString("name"));
                province.setCreatedAt(rs.getTimestamp("created_at"));
                province.setCreatedBy("created_by");
                province.setModifiedAt(rs.getTimestamp("modified_at"));
                province.setModifiedBy("modified_by");
                provinces.add(province);
            }
            
            return provinces;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== INSERT =====
    */
    public Integer insertProvince(String id, String name, String created_by) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO M_PROVINCE VALUES(?, ?, CURRENT_TIMESTAMP, ?, null, null)"
            );
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, created_by);
            Integer result = stmt.executeUpdate();
            return result;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== UPDATE =====
    */
    public Integer updateProvince(String id, String name, String modified_by) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE M_PROVINCE SET name=?, modified_at=CURRENT_TIMESTAMP, modified_by=? WHERE id = ?"
            );
            stmt.setString(1, name);
            stmt.setString(2, modified_by);
            stmt.setString(3, id);
            Integer result = stmt.executeUpdate();
            return result;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
