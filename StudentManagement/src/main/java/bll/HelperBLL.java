/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author Normal_User
 */
public class HelperBLL {

    public static String randomPassword() {
        String str = "";
        Random rd = new Random();
        for (int i = 0; i < 8; i++) {
            // r from 32 to 126 by type char
            str += Character.toString((char) (rd.nextInt(126 - 32) + 32));
        }
        return str;
    }

    /*
     convert string to MD5
     source: https://www.geeksforgeeks.org/md5-hash-in-java/
     */
    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
     */
    public static boolean checkEmail(String emailStr) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (emailStr == null) {
            return false;
        }
        return pat.matcher(emailStr).matches();
    }
}
