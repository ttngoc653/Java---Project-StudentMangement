/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.Hocsinh;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class HocsinhDAL {

    Session session = null;
    List<Hocsinh> lHs;

    public HocsinhDAL() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Hocsinh> getAll() {
        lHs = new ArrayList<Hocsinh>();
        try {
            Transaction tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as hocsinh");
            lHs = (List<Hocsinh>) q.list();
            tst.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lHs;
    }
    
    public Hocsinh getById(int idHocSinh){
        Hocsinh hs=null;
        try {
            Transaction tst=session.beginTransaction();
            Query q=session.createQuery("from Hocsinh as hocsinh where hocsinh.idHocSinh = "+idHocSinh);
            hs=(Hocsinh)q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hs;
    }
    
    public Hocsinh getByName(String name){
        Hocsinh hs=null;
        try {
            Transaction tst=session.beginTransaction();
            Query q=session.createQuery("from Hocsinh as hs where hs.hoTen like '"+name+"'");
            hs=(Hocsinh)q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hs;
    }
}
