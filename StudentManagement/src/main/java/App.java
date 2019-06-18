
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
        //       List list;
        //       list=new dal.CauHinhDAL().getAll();
        //       list=new dal.ChitietCauhinhDiemDAL().getAll();
        //       list=new dal.ChitietCauhinhHocsinhDAL().getAll();
        //       list=new dal.DiemDAL().getAll();
        //       list=new dal.HockyDAL().getAll();
        //       list=new dal.HocsinhDAL().getAll();
        //       list=new dal.HocsinhLophocDAL().getAll();
        //       list=new dal.LopDAL().getAll();
        //       list=new dal.MonhocDAL().getAll();
        //       list=new dal.NamhocDAL().getAll();
        //       list=new dal.NguoidungDAL().getAll();
/*        gui.EditUserFrame frame =new gui.EditUserFrame(4);
         frame.show();
         */
        Integer a = 1, b = 2;
        String s1 = a + " " + b,
                s2 = a + b + " ",
                s3 = " " + a + b;
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
