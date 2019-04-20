/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.Namhoc;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class NamhocDAL {
    
    private Session session = null;
    private Transaction tst = null;
    private List<Namhoc> list;

    public NamhocDAL() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            session.clear();
        } finally {
            super.finalize();
        }
    }

    public Integer add(Namhoc p) {
        int result = -1;
        try {
            tst = session.beginTransaction();
            result = (Integer) session.save(p);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Namhoc p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Namhoc n = (Namhoc) session.get(Namhoc.class, p.getIdNamHoc());

            n.setTenNamHoc(p.getTenNamHoc().length()>0 ? p.getTenNamHoc(): n.getTenNamHoc());
            
            session.update(n);
            tst.commit();
            result = true;
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Namhoc n = (Namhoc) session.get(Namhoc.class, id);
            session.delete(n);
            tst.commit();
            result = true;
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<Namhoc> getAll() {
        list = new ArrayList<Namhoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Namhoc as t "
                    + "join fetch t.hocsinhLophocs "
                    + "join fetch t.chitietCauhinhLops");
            list = (List<Namhoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Namhoc getById(int id) {
        Namhoc n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Namhoc as t "
                    + "join fetch t.hocsinhLophocs "
                    + "join fetch t.chitietCauhinhLops "
                    + "where t.idNamhoc = :id");
            q.setParameter("id", id);
            n = (Namhoc) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Namhoc getByTen(String ten) {
        Namhoc n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Namhoc as t "
                    + "join fetch t.hocsinhLophocs "
                    + "join fetch t.chitietCauhinhLops "
                    + "where t.tenNamHoc = :name");
            q.setParameter("name", ten);
            n = (Namhoc) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }
}
