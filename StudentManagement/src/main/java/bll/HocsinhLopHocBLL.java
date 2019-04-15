/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.HocsinhLophocDAL;
import dto.HocsinhLophoc;
import dto.HocsinhLophocId;
import java.util.List;

/**
 *
 * @author tuhuy
 */
public class HocsinhLopHocBLL {

    /*
    Kiểm tra học sinh đã được xếp lớp chưa
     */
    public static boolean checkStudentArrangedClass(int idHS, int idLop, int idNamHoc) {
        HocsinhLophocDAL hslopDAL = new HocsinhLophocDAL();
        HocsinhLophocId hslopid = new HocsinhLophocId(idHS, idLop, idNamHoc);

        if (hslopDAL.get(hslopid) == null) {
            return true; // Học sinh chưa có lớp
        } else {
            return false; // Học sinh đã có lớp
        }
    }

    /*
    Kiểm tra sỉ sổ lớp
     */
    public static boolean checkMaximumStudentInClass(int idLop, int SiSoToiTa) {
        
        int Size = new HocsinhLophocDAL().getAllStudentByIdLopHoc(idLop).size();
        
        if(Size == SiSoToiTa){
            return true; // Lớp đã đủ sỉ số
        }else{
            return false; // Lớp chưa đủ sỉ số
        }
    }
}
