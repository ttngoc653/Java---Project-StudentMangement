/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.Hocky;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class HockyDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Hocky> list;

    public HockyDAL() {
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

    public Integer add(Hocky p) {
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

    public boolean update(Hocky p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Hocky n = (Hocky) session.get(Hocky.class, p.getIdHocKy());

            n.setTenHocKy(p.getTenHocKy() != -1 ? p.getTenHocKy() : n.getTenHocKy());

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
            Hocky n = (Hocky) session.get(Hocky.class, id);
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

    private String getTable(String where) {
        return "select distinct h "
                + "from Hocky h "
                + "left join fetch h.diems d "
                + where
                + " order by h.tenHocKy";
    }

    @SuppressWarnings("unchecked")
    public List<Hocky> getAll() {
        list = new ArrayList<Hocky>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable(""));
            list = (List<Hocky>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Hocky getById(int id) {
        Hocky n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable( "where h.idHocKy =  :id"));
            q.setParameter("id", id);
            n = (Hocky) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Hocky getByTen(int soHocKy) {
        Hocky n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where h.tenHocKy = :soHocKy"));
            q.setParameter("soHocKy", soHocKy);
            n = (Hocky) q.uniqueResult();
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
