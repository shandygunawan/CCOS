/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import com.ccos.struts.model.bean.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author shand
 */
public class CustomerDTO {
    private ResidenceDTO residto;
    
    public CustomerDTO() {
        residto = new ResidenceDTO();
    }
    
    /*
        ===== SELECT ONE RESULT =====
    */
    public Customer getCustomerById(Integer id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_CUSTOMER WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getCustomerById: There is no customer found!");
                return null;
            }
            
            rs.next();
            
            Customer cust = new Customer();
            cust.setId(rs.getInt("id"));
            cust.setName(rs.getString("name"));
            cust.setFullName(rs.getString("full_name"));
            cust.setIdType(rs.getString("id_type"));
            cust.setIdNum(rs.getString("id_num"));
            cust.setIdExpiryDate(rs.getDate("id_expiry_date"));
            cust.setGender(rs.getString("gender"));
            cust.setBirthDate(rs.getDate("birth_date"));
            cust.setBirthPlace(rs.getString("birth_place"));
            cust.setBirthCity(rs.getString("birth_city"));
            cust.setBirthProvince(rs.getString("birth_province"));
            cust.setMaritalStatus(rs.getString("marital_status"));
            cust.setDependentNum(rs.getInt("dependent_num"));
            cust.setMotherName(rs.getString("mother_name"));
            cust.setEducation(rs.getString("education"));
            cust.setCreatedAt(rs.getTimestamp("created_at"));
            cust.setCreatedBy("created_by");
            cust.setModifiedAt(rs.getTimestamp("modified_at"));
            cust.setModifiedBy("modified_by");
            
            cust.setResidence(residto.getResidenceByCustId(id));
            
            return cust;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== SELECT MULTIPLE RESULTS =====
    */
    public List<Customer> getCustomersByNameIdNum(String name, String idNum) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_CUSTOMER WHERE name LIKE ? AND id_num LIKE ? ORDER BY name");
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + idNum + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getCustomersByNameIdNum: There is no customers found!");
                return null;
            }
            
            ArrayList<Customer> custs = new ArrayList();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            while(rs.next()) {
                Customer cust = new Customer();
                cust.setId(rs.getInt("id"));
                cust.setName(rs.getString("name"));
                cust.setFullName(rs.getString("full_name"));
                cust.setIdType(rs.getString("id_type"));
                cust.setIdNum(rs.getString("id_num"));
                cust.setIdExpiryDate(rs.getDate("id_expiry_date"));
                cust.setGender(rs.getString("gender"));
                cust.setBirthDate(rs.getDate("birth_date"));
                cust.setBirthPlace(rs.getString("birth_place"));
                cust.setBirthCity(rs.getString("birth_city"));
                cust.setBirthProvince(rs.getString("birth_province"));
                cust.setMaritalStatus(rs.getString("marital_status"));
                cust.setDependentNum(rs.getInt("dependent_num"));
                cust.setMotherName(rs.getString("mother_name"));
                cust.setEducation(rs.getString("education"));
                cust.setCreatedAt(rs.getTimestamp("created_at"));
                cust.setCreatedBy("created_by");
                cust.setModifiedAt(rs.getTimestamp("modified_at"));
                cust.setModifiedBy("modified_by");
                cust.setResidence(residto.getResidenceByCustId(cust.getId()));
                custs.add(cust);
            }
            
            return custs;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Customer> getCustomersByNameIdNumBirthDate(String name, String idNum, Date birthDate) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM T_CUSTOMER WHERE name LIKE ? AND id_num LIKE ? AND birth_date = ? ORDER BY name");
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + idNum + "%");
            stmt.setDate(3, birthDate);
            
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getCustomersByNameIdNumBirthDate: There is no customers found!");
                return null;
            }
            
            ArrayList<Customer> custs = new ArrayList();
            
            while(rs.next()) {
                Customer cust = new Customer();
                cust.setId(rs.getInt("id"));
                cust.setName(rs.getString("name"));
                cust.setFullName(rs.getString("full_name"));
                cust.setIdType(rs.getString("id_type"));
                cust.setIdNum(rs.getString("id_num"));
                cust.setIdExpiryDate(rs.getDate("id_expiry_date"));
                cust.setGender(rs.getString("gender"));
                cust.setBirthDate(rs.getDate("birth_date"));
                cust.setBirthPlace(rs.getString("birth_place"));
                cust.setBirthCity(rs.getString("birth_city"));
                cust.setBirthProvince(rs.getString("birth_province"));
                cust.setMaritalStatus(rs.getString("marital_status"));
                cust.setDependentNum(rs.getInt("dependent_num"));
                cust.setMotherName(rs.getString("mother_name"));
                cust.setEducation(rs.getString("education"));
                cust.setCreatedAt(rs.getTimestamp("created_at"));
                cust.setCreatedBy("created_by");
                cust.setModifiedAt(rs.getTimestamp("modified_at"));
                cust.setModifiedBy("modified_by");
                cust.setResidence(residto.getResidenceByCustId(cust.getId()));
                custs.add(cust);
            }
            
            return custs;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== INSERT =====
    */
    public Integer insertCustomerReturnId(
            String name,
            String full_name,
            String id_type,
            String id_num,
            Date id_expiry_date,
            String gender,
            Date birth_date,
            String birth_place,
            String birth_city,
            String birth_province,
            String marital_status,
            Integer dependent_num,
            String mother_name,
            String education,
            String created_by
            ) throws SQLException {
        
        Connection conn = DBConnection.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO T_CUSTOMER(name, full_name, id_type, id_num, id_expiry_date, gender, birth_date, birth_place, birth_city, birth_province, marital_status, dependent_num, mother_name, education, created_at, created_by) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        stmt.setString(1, name);
        stmt.setString(2, full_name);
        stmt.setString(3, id_type);
        stmt.setString(4, id_num);
        stmt.setDate(5, id_expiry_date);
        stmt.setString(6, gender);
        stmt.setDate(7, birth_date);
        stmt.setString(8, birth_place);
        stmt.setString(9, birth_city);
        stmt.setString(10, birth_province);
        stmt.setString(11, marital_status);
        stmt.setInt(12, dependent_num);
        stmt.setString(13, mother_name);
        stmt.setString(14, education);
        stmt.setString(15, created_by);
        
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Creating Customer Error. No rows affected");
        }
        
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        
        Integer inserted_id = (int) rs.getLong(1);
        return inserted_id;
        
    }
    
    
    /*
        ===== UPDATE =====
    */
    public void updateCustomer(
            Integer custId,
            String name,
            String full_name,
            String id_type,
            String id_num,
            Date id_expiry_date,
            String gender,
            Date birth_date,
            String birth_place,
            String birth_city,
            String birth_province,
            String marital_status,
            Integer dependent_num,
            String mother_name,
            String education,
            String modified_by
            ) throws SQLException {
        
        Connection conn = DBConnection.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE T_CUSTOMER SET name = ?, full_name = ?, id_type = ?, id_num = ?, id_expiry_date = ?, "
              + "gender = ?, birth_date = ?, birth_place = ?, birth_city = ?, birth_province = ?, marital_status = ?, "
              + "dependent_num = ?, mother_name = ?, education = ?, modified_at = CURRENT_TIMESTAMP, modified_by = ? "
              + "WHERE id = ?"
        );
        stmt.setString(1, name);
        stmt.setString(2, full_name);
        stmt.setString(3, id_type);
        stmt.setString(4, id_num);
        stmt.setDate(5, id_expiry_date);
        stmt.setString(6, gender);
        stmt.setDate(7, birth_date);
        stmt.setString(8, birth_place);
        stmt.setString(9, birth_city);
        stmt.setString(10, birth_province);
        stmt.setString(11, marital_status);
        stmt.setInt(12, dependent_num);
        stmt.setString(13, mother_name);
        stmt.setString(14, education);
        stmt.setString(15, modified_by);
        stmt.setInt(16, custId);
        
        Integer affectedRows = stmt.executeUpdate();
        
        if(affectedRows == 0) {
            throw new SQLException("Updating Customer Error. No rows affected");
        }
    }
}
