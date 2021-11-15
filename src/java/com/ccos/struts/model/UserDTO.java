/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import com.ccos.struts.model.bean.User;
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
public class UserDTO {
    
    public UserDTO() {
        
    }
    
    /*
        ===== GET ONE RESULT =====
    */
    public User getUserById(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM S_USER WHERE id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("getUserById: There is no user found!");
                return null;
            }
            
            rs.next();
            
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setBranch(rs.getString("branch"));
            user.setCreatedAt(rs.getTimestamp("created_at"));
            user.setCreatedBy("created_by");
            user.setModifiedAt(rs.getTimestamp("modified_at"));
            user.setModifiedBy("modified_by");
            
            return user;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== GET Multiple Results & One Condition =====
    */
    public List<User> getUsersAll() {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM S_USER");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("There is no user found!");
                return null;
            }
            
            ArrayList<User> users = new ArrayList();
            
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setBranch(rs.getString("branch"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedBy("created_by");
                user.setModifiedAt(rs.getTimestamp("modified_at"));
                user.setModifiedBy("modified_by");
                users.add(user);
            }
            
            return users;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<User> getUsersById(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM S_USER WHERE id LIKE ?");
            stmt.setString(1, "%" + id + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("There is no user found!");
                return null;
            }
            
            ArrayList<User> users = new ArrayList();
            
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setBranch(rs.getString("branch"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedBy("created_by");
                user.setModifiedAt(rs.getTimestamp("modified_at"));
                user.setModifiedBy("modified_by");
                users.add(user);
            }
            
            return users;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<User> getUsersByName(String name) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM S_USER WHERE name LIKE ?");
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("There is no user found!");
                return null;
            }
            
            ArrayList<User> users = new ArrayList();
            
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setBranch(rs.getString("branch"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedBy("created_by");
                user.setModifiedAt(rs.getTimestamp("modified_at"));
                user.setModifiedBy("modified_by");
                users.add(user);
            }
            
            return users;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<User> getUsersByBranch(String branch) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM S_USER WHERE branch LIKE ?");
            stmt.setString(1, "%" + branch + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("There is no user found!");
                return null;
            }
            
            ArrayList<User> users = new ArrayList();
            
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setBranch(rs.getString("branch"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedBy("created_by");
                user.setModifiedAt(rs.getTimestamp("modified_at"));
                user.setModifiedBy("modified_by");
                users.add(user);
            }
            
            return users;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== GET Multiple Results & Multiple Conditions =====
    */
    public List<User> getUsersByIdNameBranch(String id, String name, String branch) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM S_USER WHERE id LIKE ? AND name LIKE ? AND branch LIKE ? ORDER BY id");
            stmt.setString(1, "%" + id + "%");
            stmt.setString(2, "%" + name + "%");
            stmt.setString(3, "%" + branch + "%");
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.isBeforeFirst()) {
                System.out.println("There is no user found!");
                return null;
            }
            
            ArrayList<User> users = new ArrayList();
            
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setBranch(rs.getString("branch"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedBy("created_by");
                user.setModifiedAt(rs.getTimestamp("modified_at"));
                user.setModifiedBy("modified_by");
                users.add(user);
            }
            
            return users;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
        ===== INSERT =====
    */
    public Integer insertUser(String id, String name, String password, String role, String branch, String created_by) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO S_USER VALUES(?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, null, null)"
            );
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, password);
            stmt.setString(4, role);
            stmt.setString(5, branch);
            stmt.setString(6, created_by);
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
    public Integer updateUser(String id, String name, String password, String role, String branch, String modified_by) {
        try {
            Connection conn = DBConnection.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE S_USER SET name=?, password=?, role=?, branch=?, modified_at=CURRENT_TIMESTAMP, modified_by=? WHERE id=?"
            );
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, role);
            stmt.setString(4, branch);
            stmt.setString(5, modified_by);
            stmt.setString(6, id);
            Integer result = stmt.executeUpdate();
            return result;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
