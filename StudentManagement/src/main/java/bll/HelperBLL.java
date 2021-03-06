package bll;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

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

    public static String PasswordMD5(String password) throws NoSuchAlgorithmException {
        String kq = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        //System.out.println(sb.toString());
        kq = sb.toString();
        return kq;
    }


    /**
     * source: https://www.geeksforgeeks.org/check-email-address-valid-not-java/
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

    /**
     * source: https://stackoverflow.com/questions/33348481/restrict-input-of-jtextfield-to-double-numbers
     */
    public static MaskFormatter getMaskFormatter(String format) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(format);
            mask.setPlaceholderCharacter('0');
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return mask;
    }
    
    public static boolean IsInteger(String string){
        try {
            Integer.valueOf(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean IsDouble(String string){
        try {
            Double.valueOf(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
