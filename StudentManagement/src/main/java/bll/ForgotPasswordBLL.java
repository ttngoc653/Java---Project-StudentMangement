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

    private static Nguoidung getInfo(String tenDangNhap, String soDienThoai, String email) {
        Nguoidung nd = null;
        if (tenDangNhap != null) {
            nd = new dal.NguoidungDAL().getByTenDangNhap(tenDangNhap);
            if (nd != null && email.equals(nd.getEmail())) {
                return nd;
            }
        } else {
            nd = new dal.NguoidungDAL().getByEmail(email);
        }
        return nd;
    }

    /**
     *
     * @param nd
     * @return 
     * 0. Success
     * 1. Incorrect user
     * 2. Didn't sent infomation account by email
     * 3. Error when update password to db
     */
    public static int RecoveryPass(Nguoidung nd) {
        nd.setTinhTrang(Byte.valueOf((nd.getTenTaiKhoan() == null) ? "quentaikhoan" : "quenmaykhau"));
        nd = getInfo(nd.getTenTaiKhoan(), nd.getSdt(), nd.getEmail());
        if (nd == null) {
            return 1;
        } else {
            String passNew = HelperBLL.randomPassword();
            nd.setMatKhau(passNew);
            if (!EmailBLL.sendPasswordNew(nd)) {
                return 2;
            }
            passNew = HelperBLL.getMd5(passNew);
            nd.setMatKhau(passNew);
            if (!new dal.NguoidungDAL().updatePassword(nd)) {
                return 3;
            }
        }

        return 0;
    }
}
