/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.Lop;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

            n.setKhoi(p.getKhoi() > -1 ? p.getKhoi() : n.getKhoi());
            n.setTenLop(p.getTenLop().length() > 0 ? p.getTenLop() : n.getTenLop());
            n.setTinhTrang(p.getTinhTrang() != null ? p.getTinhTrang() : n.getTinhTrang());

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

    @SuppressWarnings("unchecked")
    public List<Lop> getAll() {
        list = new ArrayList<Lop>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Lop");
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
            n = (Lop) session.get(Lop.class, id);
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
            Query q = session.createQuery("from Lop as t where t.tenLop = '" + name + "'");
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

    public List<Lop> getByKhoi(int khoi) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Lop as t where t.khoi = '" + khoi + "'");
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
            Query q = session.createQuery("from Lop as t where t.tinhTrangi = '" + tinhTrang + "'");
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
