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

    public ChitietCauhinhDiemId add(ChitietCauhinhDiem q) {
        dto.ChitietCauhinhDiemId result = new ChitietCauhinhDiemId(-1, -1);
        try {
            tst = session.beginTransaction();
            result = (ChitietCauhinhDiemId) session.save(q);
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

            n.setApDung(q.getApDung());
            n.setCauhinh(q.getCauhinh());
            n.setDiem(q.getDiem());

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

    private String getTable(String where) {
        return "select distinct c "
                + "from ChitietCauhinhDiem c "
                + "left join fetch c.cauhinh ch "
                + "left join fetch c.diem d "
                + "left join fetch d.hocky "
                + "left join fetch d.hocsinhLophoc "
                + "left join fetch d.monhoc "
                + "left join fetch d "
                + where;
    }

    @SuppressWarnings("unchecked")
    public List<ChitietCauhinhDiem> getAll() {
        list = new ArrayList<ChitietCauhinhDiem>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable(""));
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
            Query q = session.createQuery(getTable("where d.idDiem = :diem "
                    + "and ch.idCauHinh = :cauhinh"));
            q.setParameter("diem", idChitietCauhinhDiem.getIdDiem());
            q.setParameter("cauhinh", idChitietCauhinhDiem.getIdCauHinh());
            hs = (ChitietCauhinhDiem) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }

    public List getByCauHinh(Cauhinh ch) {
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where ch.idCauHinh = :cauhinh"));
            q.setParameter("cauhinh", ch.getIdCauHinh());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
            return new ArrayList();
        }
        return list;
    }

    public List<ChitietCauhinhDiem> getByDiem(Diem d) {
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where d.idDiem = :diem"));
            q.setParameter("diem", d.getIdDiem());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
            return new ArrayList();
        }
        return list;
    }
}
