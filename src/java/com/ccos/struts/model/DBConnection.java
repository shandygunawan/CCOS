/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author shand
 */
public class DBConnection {
    private static Connection con = null;
    
    public static Connection getConnection() {
        if(con == null) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost/ccos", "postgres", "postgres");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return con;
    }
    
    public static void closeConnection() throws SQLException {
        con.close();
    }
}
