/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.HocsinhDAL;
import dal.HocsinhLophocDAL;
import dal.LopDAL;
import dal.NamhocDAL;
import dto.Hocsinh;
import dto.HocsinhLophoc;
import dto.HocsinhLophocId;
import dto.Lop;
import dto.Namhoc;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tuhuy
 */
public class HocsinhLopHocBLL {

    /*
    Kiểm tra học sinh đã được xếp lớp chưa
     */
    public static boolean checkStudentArrangedClass(int idHS) {

        if (new HocsinhLophocDAL().getByIdHocSinh(idHS) == null) {
            return false; // Học sinh chưa có lớp
        } else {
            return true; // Học sinh đã có lớp
        }
    }

    /*
    Kiểm tra sỉ sổ lớp
     */
    public static boolean checkMaximumStudentInClass(Namhoc namhoc, Lop lop, int SiSoToiDa) {

        int Size = new HocsinhLophocDAL().getByNamHocLop(namhoc, lop).size();
        if (Size == SiSoToiDa) {
            return true; //lớp đã đủ sỉ số
        } else {
            return false; //lớp chưa đủ sỉ số
        }
    }

    /*
    Kiểm tra tồn tại lớp và năm học
     */
    public static boolean checkExistNamHocLop(Namhoc namhoc, Lop lop) {

        if (new HocsinhLophocDAL().getByNamHocLop(namhoc, lop).size() == 0) {
            return false; //chưa có lớp và năm học này
        } else {
            return true; //đã có lớp và năm học này
        }
    }

    /*
    Tìm học sinh thuộc lớp và năm học
     */
    public static boolean findStudentByNamHocLop(int idHS, Namhoc namhoc, Lop lop) {
        if (new HocsinhLophocDAL().findStudentByNamHocLop(idHS, namhoc, lop).size() == 0) {
            return false; // học sinh ko thuộc lớp và năm học này
        } else {
            return true; // học sinh thuộc lớp và năm học này
        }
    }

    /*
    Tìm học sinh thuộc năm học
    */
    public static boolean findStudentByNamHoc(int idHS, Namhoc namhoc) {
        if (new HocsinhLophocDAL().findStudentByNamHoc(idHS, namhoc).size() == 0) {
            return false;  // trong năm học này học sinh chưa có lớp học
        } else {
            return true; // trong năm học này học sinh đã có lớp học
        } 
    }

}
