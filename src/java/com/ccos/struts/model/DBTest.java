/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.struts.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ccos.struts.model.UserDTO;
import com.ccos.struts.model.bean.User;
import java.util.List;
/**
 *
 * @author shand
 */
public class DBTest {
    
    public static void main(String args[]) {
        UserDTO userdto = new UserDTO();
        
        User user = userdto.getUserById("SH-01");
        System.out.println(user.getName());

//        List<User> users = userdto.getUsersById("01");
//        
//        for(User user: users) {
//            System.out.println(user.toString());
//        }
        
        
    }
    
}
