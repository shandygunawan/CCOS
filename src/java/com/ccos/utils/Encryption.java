/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccos.utils;

import javax.crypto.Cipher;
import org.jasypt.util.text.AES256TextEncryptor;


/**
 *
 * @author shand
 */
public class Encryption {
    private String ENCRYPT_PASSWORD = "Shandy";
    
    public String encryptText(String text) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(this.ENCRYPT_PASSWORD);
        String encryptedText = textEncryptor.encrypt(text);
        return encryptedText;
    }
    
    public String decryptText(String encryptedText) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(this.ENCRYPT_PASSWORD);
        String plain_text = textEncryptor.decrypt(encryptedText);
        return plain_text;
    }
}
