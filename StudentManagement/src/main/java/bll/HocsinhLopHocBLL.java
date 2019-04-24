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
            return true; // Học sinh chưa có lớp
        } else {
            return false; // Học sinh đã có lớp
        }
    }

    /*
    Kiểm tra sỉ sổ lớp
     */
    public static boolean checkMaximumStudentInClass(Namhoc namhoc, Lop lop, int SiSoToiTa) {

        int Size = new HocsinhLophocDAL().getByNamHocLop(namhoc, lop).size();
        if (Size == SiSoToiTa) {
            return true; //lớp đã đủ sỉ số
        } else {
            return false; //lớp chưa đủ sỉ số
        }
    }

}
