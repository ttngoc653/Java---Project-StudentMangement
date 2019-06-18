/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.*;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author Jossion
 */
public class LopDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Lop> list;

    public LopDAL() {
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

    public Integer add(Lop p) {
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

    public boolean update(Lop p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Lop n = (Lop) session.get(Lop.class, p.getIdLop());

            n.setKhoi(p.getKhoi());
            n.setTenLop(p.getTenLop());
            n.setTinhTrang(p.getTinhTrang());
            n.setCauhinhs(p.getCauhinhs());
            n.setHocsinhLophocs(p.getHocsinhLophocs());

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
            Lop n = (Lop) session.get(Lop.class, id);
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
        return "select distinct l "
                + "from Lop as l "
                + "left join fetch l.hocsinhLophocs hl "
                + "left join fetch l.cauhinhs ch "
                + where
                + " order by l.tenLop";
    }

    @SuppressWarnings("unchecked")
    public List<Lop> getAll() {
        list = new ArrayList<Lop>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable(""));
            list = (List<Lop>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Lop getById(int id) {
        Lop n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where l.idLop = :id"));
            q.setParameter("id", id);
            n = (Lop) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Lop getByTen(String name) {
        Lop n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where l.tenLop = :ten"));
            q.setParameter("ten", name);
            n = (Lop) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public List<Lop> getByKhoi(String khoi) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where l.khoi = :khoi"));
            q.setParameter("khoi", khoi);
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Lop> getByTinhTrang(Byte tinhTrang) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where l.tinhTrang = :status"));
            q.setParameter("status", tinhTrang);
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }
}
