/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.Nguoidung;

/**
 *
 * @author Jossion
 */
public class ForgotPasswordBLL {
    public static Nguoidung getInfo(String tenDangNhap,String soDienThoai, String email){
        if(tenDangNhap!=null){
            Nguoidung nd=new dal.NguoidungDAL().getByTenDangNhap(tenDangNhap);
            if(email.equals(nd.getEmail())){
                
            }
        }
        return null;
    }
}
