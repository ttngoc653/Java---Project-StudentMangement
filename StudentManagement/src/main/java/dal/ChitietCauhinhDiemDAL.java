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

    private Session session = null;
    private Transaction tst = null;
    private List<ChitietCauhinhDiem> list;

    public ChitietCauhinhDiemDAL() {
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
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<ChitietCauhinhDiem> getAll() {
        list = new ArrayList<ChitietCauhinhDiem>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhDiem");
            list = (List<ChitietCauhinhDiem>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public ChitietCauhinhDiem getById(ChitietCauhinhDiemId idChitietCauhinhDiem) {
        ChitietCauhinhDiem hs = null;
        try {
            tst = session.beginTransaction();
            hs = (ChitietCauhinhDiem) session.get(ChitietCauhinhDiem.class, idChitietCauhinhDiem);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }

    public List<ChitietCauhinhDiem> getByCauHinh(Cauhinh ch) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getCauhinh().equals(ch)) {
                list.get(i);
                i--;
            }
        }
        return list;
    }

    public List<ChitietCauhinhDiem> getByDiem(Diem d) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getDiem().equals(d)) {
                list.get(i);
                i--;
            }
        }
        return list;
    }
}
