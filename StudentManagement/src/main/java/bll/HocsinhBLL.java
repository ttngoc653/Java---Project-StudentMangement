/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.HocsinhDAL;
import dto.Hocsinh;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author tuhuy
 */
public class HocsinhBLL {

    public static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static boolean checkStudentExists(String hoTen, String diaChi, String ngaySinh) {
        HocsinhDAL hsDAL = new HocsinhDAL();
        Hocsinh hs = hsDAL.getByName2(hoTen);
        if (hs == null) {
            return true;
        } else {
            if (hs.getNgaySinh().equals(ngaySinh) && hs.getDiaChi().equals(diaChi)) {
                return false; //Tên học sinh đã tồn tại
            } else {
                return true; //Tên học sinh chưa tồn tại
            }
        }
    }

    /*
    check phone number
    source: https://kenhlaptrinh.net/kiem-tra-so-dien-thoai-trong-java/
     */
    public static boolean checkPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(number);
//        if (!matcher.matches()) {
//            return "Chuỗi nhập vào không phải là số!";
//        } else if (number.length() == 10) {
//            return "Chuỗi nhập vào là số điện thoại!";
//        } else {
//            return "Độ dài số điện thoại không hợp lệ!";
//        }
        if ((matcher.matches() && number.length() == 10) || number.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /*
    check email
    source: https://kenhlaptrinh.net/kiem-tra-so-dien-thoai-trong-java/
     */
    public static boolean checkEmail(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(email);
        if (matcher.find() || email.equals("")) {
            return true; //Email hợp lệ
        } else {
            return false; //Email không hợp lệ
        }
    }

    public static boolean checkAge(String ngaySinh, int tuoiToiDa, int tuoiToiThieu) {

        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        String year1 = dateFormat.format(date).substring(6);
        int year = Integer.parseInt(year1);

        String NamSinh1 = ngaySinh.substring(6);
        int NamSinh = 0;
        try {
            NamSinh = Integer.parseInt(NamSinh1);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: NamSinh");
        }

        int tuoi = year - NamSinh;
        if (tuoi < tuoiToiThieu || tuoi > tuoiToiDa) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkDateOfBirth(Date ngaySinh) {
        if (ngaySinh != null) {
            String NamSinh = dateFormat.format(ngaySinh);
            if (NamSinh.length() < 10) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean checkInfoUpdateStudent(int maHS, String hoTen, String diaChi, String ngaySinh) {
        HocsinhDAL hsDALCu = new HocsinhDAL();
        Hocsinh HocSinhCu = hsDALCu.getByName(hoTen);

        if (HocSinhCu == null) {
            return true; //Thông tin học sinh này chưa tồn tại
        } else {
            if (HocSinhCu.getIdHocSinh() != maHS && HocSinhCu.getNgaySinh().equals(ngaySinh) && HocSinhCu.getDiaChi().equals(diaChi)) {
                return false; //Thông tin học sinh này trùng với học sinh khác
            } else {
                return true; //Thông tin học sinh này chưa tồn tại
            }
        }
    }

    public static int getYearDOB(String ngaySinh) {
        int year = Integer.parseInt(ngaySinh.substring(6));
        return year - 1900;
    }

    public static int getMonthDOB(String ngaySinh) {
        int month = Integer.parseInt(ngaySinh.substring(3, 5));
        return month - 1;
    }

    public static int getDateDOB(String ngaySinh) {
        int date = Integer.parseInt(ngaySinh.substring(0, 2));
        return date;
    }

    public static Date setDatejDateChooser(String ngaySinh) {
        return new Date(getYearDOB(ngaySinh), getMonthDOB(ngaySinh), getDateDOB(ngaySinh));
        /* public Date(int year, int month, int date)
         * @param   year    the year minus 1900.
         * @param   month   the month between 0-11.
         * @param   date    the day of the month between 1-31.
         */
    }
}
