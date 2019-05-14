

import dal.HocsinhDAL;
import dal.HocsinhLophocDAL;
import dto.*;
import java.io.File;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*List<Hocsinh> lHs = new HocsinhDAL().getAll();
        for (Hocsinh hs : lHs) {
            System.out.println(hs.getIdHocSinh() + " " + hs.getHoTen());
        }

        Hocsinh hsN = new HocsinhDAL().getByName("Hoàng Văn C");
        if (hsN != null) {
            System.out.println(hsN.getIdHocSinh() + " " + hsN.getHoTen() + " " + hsN.getEmail() + " " + hsN.getGioiTinh());
        }*/
        
        //new gui.EditUserFrame(22).setVisible(true);
       // List<HocsinhLophoc> lHsLh=new dal.HocsinhLophocDAL().getByNamHocLop(new dal.NamhocDAL().getByTen("2018-2019"), new dal.LopDAL().getByTen("10A1"));
       // System.out.println("Size: "+lHsLh.size());
       List<Diem> list=new dal.DiemDAL().getAll();
        for (Diem list1 : list) {
        }
    }
}
