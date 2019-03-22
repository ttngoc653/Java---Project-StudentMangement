package com.studentmanagement;

import com.bll.HocsinhController;
import hibernate.Hocsinh;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Hocsinh> lHs=new HocsinhController().getList();
        for (Hocsinh hs : lHs) {
            System.out.println(hs.getIdHocSinh()+" "+hs.getHoTen());
        }
    }
}
