

import dal.HocsinhDAL;
import dto.Hocsinh;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Hocsinh> lHs = new HocsinhDAL().getAll();
        for (Hocsinh hs : lHs) {
            System.out.println(hs.getIdHocSinh() + " " + hs.getHoTen());
        }

        Hocsinh hsN = new HocsinhDAL().getByName("Hoàng Văn C");
        if (hsN != null) {
            System.out.println(hsN.getIdHocSinh() + " " + hsN.getHoTen() + " " + hsN.getEmail() + " " + hsN.getGioiTinh());
        }
    }
}
