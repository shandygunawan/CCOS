/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.utils;

import com.ccos.utils.Encryption;

/**
 *
 * @author shand
 */
public class UtilTest {
    public static void main(String args[]) {
        Encryption encryption = new Encryption();
        System.out.println(encryption.encryptText("Test123"));
        
        // String encryptedText = encryption.decryptText("ZZiovqdyVt35ioPn3d1LhIu0KFNFIQUY3SBLwCbTBnl5ic7LLgReQPYWdBdiBA3Z");
        // System.out.println(encryptedText);
    }
}
