/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Normal_User
 */
public class HelperBLL {

    public static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

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

    /*
    check phone number
    source: https://kenhlaptrinh.net/kiem-tra-so-dien-thoai-trong-java/
     */
    public static String checkPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            return "Chuỗi nhập vào không phải là số!";
        } else if (number.length() == 10) {
            return "Chuỗi nhập vào là số điện thoại!";
        } else {
            return "Độ dài số điện thoại không hợp lệ!";
        }
    }

    /*
    check email
    source: https://kenhlaptrinh.net/kiem-tra-so-dien-thoai-trong-java/
     */
    public static String checkEmail(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(email);
        if (matcher.find()) {
            return "Email của bạn hợp lệ!";
        } else {
            return "Email của bạn chưa hợp lệ!";
        }
    }

    public static boolean checkAge(String ngaySinh, int TuoiToiDa, int TuoiToiThieu) {
        // Lấy năm hiện tại
        long millis = System.currentTimeMillis();
        Date NgayHienTai = new Date(millis);
        String Nam = dateFormat.format(NgayHienTai).substring(6);
        int NamHienTai = Integer.parseInt(Nam);

        // Lấy năm sinh
        String NamCuaNgaySinh = ngaySinh.substring(6);
        int NamSinh = 0;
        try {
            NamSinh = Integer.parseInt(NamCuaNgaySinh);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Tính tuổi
        int Tuoi = NamHienTai - NamSinh;
        if (Tuoi < TuoiToiThieu || Tuoi > TuoiToiDa) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkDate(String ngaySinh) {
        //boolean isDate = false;
        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
        //isDate = ngaySinh.matches(datePattern);
        if (ngaySinh.length() == 10 && ngaySinh.matches(datePattern)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDate2(String ngaySinh) {
        boolean q = true;
        String ds;
        Date pDob = null;
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
        while (q) {
            try {
                //ds = getString("nhap ngay sinh co dang dd-MM-yyyy:" + "\t");
                pDob = fm.parse(ngaySinh);
                q = false;
                //return true;
            } catch (ParseException e) {
            }
        }
        //return pDob;
        return true;
    }
}
