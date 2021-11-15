/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import java.util.List;
import com.ccos.struts.model.bean.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author shand
 */
public class CityDTO {

    public CityDTO() {}
    
    /*
        ===== SELECT ONE RESULT =====
    */
    public City getCityById(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_CITY WHERE id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getCityById: There is no province found!");
                return null;
            }
            
            rs.next();
            
            City city = new City();
            city.setId(rs.getString("id"));
            city.setName(rs.getString("name"));
            city.setProvId(rs.getString("prov_id"));
            city.setCreatedAt(rs.getTimestamp("created_at"));
            city.setCreatedBy("created_by");
            city.setModifiedAt(rs.getTimestamp("modified_at"));
            city.setModifiedBy("modified_by");
            
            return city;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== SELECT MULTIPLE RESULTS =====
    */
    public List<City> getCitiesAll() {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_CITY ORDER BY id");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getCitiesAll: There is no cities found!");
                return null;
            }
            
            ArrayList<City> cities = new ArrayList();
            
            while(rs.next()) {
                City city = new City();
                city.setId(rs.getString("id"));
                city.setName(rs.getString("name"));
                city.setProvId(rs.getString("prov_id"));
                city.setCreatedAt(rs.getTimestamp("created_at"));
                city.setCreatedBy("created_by");
                city.setModifiedAt(rs.getTimestamp("modified_at"));
                city.setModifiedBy("modified_by");
                cities.add(city);
            }
            
            return cities;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<City> getCitiesById(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM M_CITY WHERE id LIKE ? ORDER BY id");
            stmt.setString(1, "%" + id + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getCitiesById: There is no cities found!");
                return null;
            }
            
            ArrayList<City> cities = new ArrayList();
            
            while(rs.next()) {
                City city = new City();
                city.setId(rs.getString("id"));
                city.setName(rs.getString("name"));
                city.setProvId(rs.getString("prov_id"));
                city.setCreatedAt(rs.getTimestamp("created_at"));
                city.setCreatedBy("created_by");
                city.setModifiedAt(rs.getTimestamp("modified_at"));
                city.setModifiedBy("modified_by");
                cities.add(city);
            }
            
            return cities;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<City> getCitiesByNameProvId(String name, String prov_id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt;
            if(prov_id.equals("0")) { // All Provinces
                stmt = conn.prepareStatement("SELECT * FROM M_CITY WHERE name LIKE ? ORDER BY id");
                stmt.setString(1, "%" + name + "%");
            } else { // Specific Provinces
                stmt = conn.prepareStatement("SELECT * FROM M_CITY WHERE name LIKE ? AND prov_id = ? ORDER BY id");
                stmt.setString(1, "%" + name + "%");
                stmt.setString(2, prov_id);
            }
            
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getCitiesByNameProvId: There is no cities found!");
                return null;
            }
            
            ArrayList<City> cities = new ArrayList();
            
            while(rs.next()) {
                City city = new City();
                city.setId(rs.getString("id"));
                city.setName(rs.getString("name"));
                city.setProvId(rs.getString("prov_id"));
                city.setCreatedAt(rs.getTimestamp("created_at"));
                city.setCreatedBy("created_by");
                city.setModifiedAt(rs.getTimestamp("modified_at"));
                city.setModifiedBy("modified_by");
                cities.add(city);
            }
            
            return cities;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== INSERT =====
    */
    public Integer insertCity(String id, String name, String prov_id, String created_by) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO M_CITY VALUES(?, ?, ?, CURRENT_TIMESTAMP, ?, null, null)"
            );
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, prov_id);
            stmt.setString(4, created_by);
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
    public Integer updateCity(String id, String name, String prov_id, String modified_by) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE M_CITY SET name=?, prov_id=?, modified_at=CURRENT_TIMESTAMP, modified_by=? WHERE id = ?"
            );
            stmt.setString(1, name);
            stmt.setString(2, prov_id);
            stmt.setString(3, modified_by);
            stmt.setString(4, id);
            Integer result = stmt.executeUpdate();
            return result;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
