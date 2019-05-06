/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.HocsinhLophocDAL;
import dal.LopDAL;
import dal.NamhocDAL;
import dto.Lop;
import dto.Namhoc;

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
    public static boolean checkMaximumStudentInClass(int idNamHoc, int idLop, int SiSoToiTa) {

        Namhoc a = new NamhocDAL().getById(idNamHoc);
        Lop b = new LopDAL().getById(idLop);
        //int Size = new HocsinhLophocDAL().getByNamHocLop(a, b).size();

        int Size = new HocsinhLophocDAL().getByNamHocLop(namhoc, lop).size();
        if (Size == SiSoToiTa) {
            return true; //lớp đã đủ sỉ số
        } else {
            return false; //lớp chưa đủ sỉ số
        }
    }

}
