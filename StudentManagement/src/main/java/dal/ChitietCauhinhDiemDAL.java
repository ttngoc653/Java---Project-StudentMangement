/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.ChitietCauhinhDiem;
import dto.ChitietCauhinhDiemId;
import dto.Cauhinh;
import dto.Diem;
import dto.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class ChitietCauhinhDiemDAL {

    Session session = null;
    Transaction tst = null;
    List<ChitietCauhinhDiem> lHs;

    public ChitietCauhinhDiemDAL() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Integer add(ChitietCauhinhDiem q) {
        int result = -1;
        try {
            tst = session.beginTransaction();
            result = (Integer) session.save(q);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean update(ChitietCauhinhDiem q) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            ChitietCauhinhDiem n = (ChitietCauhinhDiem) session.get(ChitietCauhinhDiem.class, q.getId());

            n.setApDung(q.getApDung() != null ? q.getApDung() : n.getApDung());
            n.setCauhinh(q.getCauhinh() != null ? q.getCauhinh() : n.getCauhinh());
            n.setDiem(q.getDiem() != null ? q.getDiem() : n.getDiem());

            session.update(n);
            tst.commit();
            result = true;
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public boolean delete(ChitietCauhinhDiemId idChitietCauhinhDiemId) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            ChitietCauhinhDiem n = (ChitietCauhinhDiem) session.get(ChitietCauhinhDiem.class, idChitietCauhinhDiemId);
            session.delete(n);
            tst.commit();
            result = true;
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<ChitietCauhinhDiem> getAll() {
        lHs = new ArrayList<ChitietCauhinhDiem>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhDiem");
            lHs = (List<ChitietCauhinhDiem>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lHs;
    }

    public ChitietCauhinhDiem getById(ChitietCauhinhDiemId idChitietCauhinhDiem) {
        ChitietCauhinhDiem hs = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhDiem as q where q.ChitietCauhinhDiemId = " + idChitietCauhinhDiem);
            hs = (ChitietCauhinhDiem) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return hs;
    }

    public List<ChitietCauhinhDiem> getByCauHinh(Cauhinh ch) {
        List<ChitietCauhinhDiem> pL = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhDiem as q where q.Cauhinh like '" + ch + "'");
            pL = (List<ChitietCauhinhDiem>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pL;
    }

    public List<ChitietCauhinhDiem> getByDiem(Diem d) {
        List<ChitietCauhinhDiem> pL = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhDiem as q where q.Diem like '" + d + "'");
            pL = (List<ChitietCauhinhDiem>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pL;
    }
}
