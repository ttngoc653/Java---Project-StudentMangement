/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.Monhoc;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class MonhocDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Monhoc> list;

    public MonhocDAL() {
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

    public Integer add(Monhoc p) {
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

    public boolean update(Monhoc p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Monhoc n = (Monhoc) session.get(Monhoc.class, p.getIdMonHoc());

            n.setTenMh(p.getTenMh().length() > 0 ? p.getTenMh() : n.getTenMh());

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
            Monhoc n = (Monhoc) session.get(Monhoc.class, id);
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
    public List<Monhoc> getAll() {
        list = new ArrayList<Monhoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Monhoc as m "
                    + "join fetch m.diems");
            list = (List<Monhoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Monhoc getById(int id) {
        Monhoc n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Monhoc as t "
                    + "join fetch t.diems "
                    + "where t.idMonhoc = :id");
            q.setParameter("id", id);
            n = (Monhoc) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Monhoc getByTen(String ten) {
        Monhoc n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Monhoc as t "
                    + "join fetch t.diems "
                    + "where t.tenMh = :ten");
            q.setParameter("ten", ten);
            n = (Monhoc) q.uniqueResult();
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
