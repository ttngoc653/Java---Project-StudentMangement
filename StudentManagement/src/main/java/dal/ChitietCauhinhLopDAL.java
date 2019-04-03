/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.Cauhinh;
import dto.ChitietCauhinhLop;
import dto.ChitietCauhinhLopId;
import dto.HibernateUtil;
import dto.Lop;
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
public class ChitietCauhinhLopDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<ChitietCauhinhLop> list;

    public ChitietCauhinhLopDAL() {
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

    public ChitietCauhinhLopId add(ChitietCauhinhLop q) {
        ChitietCauhinhLopId result = null;
        try {
            tst = session.beginTransaction();
            result = (ChitietCauhinhLopId) session.save(q);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public ChitietCauhinhLopId add(Integer idCauHinh, Integer idLop, Integer idNamHoc) {
        ChitietCauhinhLopId result = null;
        try {
            tst = session.beginTransaction();
            result = (ChitietCauhinhLopId) session.save(new ChitietCauhinhLop(new ChitietCauhinhLopId(idLop, idNamHoc, idCauHinh), null, null, null));
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public boolean update(ChitietCauhinhLop q) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            ChitietCauhinhLop n = (ChitietCauhinhLop) session.get(ChitietCauhinhLop.class, q.getId());

            n.setCauhinh(q.getCauhinh() != null ? q.getCauhinh() : n.getCauhinh());
            n.setId(q.getId() != null ? q.getId() : n.getId());
            n.setLop(q.getLop() != null ? q.getLop() : n.getLop());
            n.setNamhoc(q.getNamhoc() != null ? q.getNamhoc() : n.getNamhoc());

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

    public boolean delete(ChitietCauhinhLopId idChitietCauhinhLopId) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            ChitietCauhinhLop n = (ChitietCauhinhLop) session.get(ChitietCauhinhLop.class, idChitietCauhinhLopId);
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
    public List<ChitietCauhinhLop> getAll() {
        list = new ArrayList<ChitietCauhinhLop>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhHocsinh");
            list = (List<ChitietCauhinhLop>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        } 
        return list;
    }

    public ChitietCauhinhLop getById(ChitietCauhinhLopId idChitietCauhinhLop) {
        ChitietCauhinhLop hs = null;
        try {
            tst = session.beginTransaction();
            hs = (ChitietCauhinhLop) session.get(ChitietCauhinhLop.class, idChitietCauhinhLop);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }

    public List<ChitietCauhinhLop> getByCauhinh(Cauhinh ch) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getCauhinh().equals(ch)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<ChitietCauhinhLop> getByLop(Lop l, Namhoc n) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getLop().equals(l) || !list.get(i).getNamhoc().equals(n)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }
}