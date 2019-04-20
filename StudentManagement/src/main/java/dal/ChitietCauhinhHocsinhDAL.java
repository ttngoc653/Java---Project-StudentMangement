/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.*;
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
public class ChitietCauhinhHocsinhDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<ChitietCauhinhHocsinh> list;

    public ChitietCauhinhHocsinhDAL() {
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

    public ChitietCauhinhHocsinhId add(ChitietCauhinhHocsinh q) {
        ChitietCauhinhHocsinhId result = null;
        try {
            tst = session.beginTransaction();
            result = (ChitietCauhinhHocsinhId) session.save(q);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(ChitietCauhinhHocsinh q) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            ChitietCauhinhHocsinh n = (ChitietCauhinhHocsinh) session.get(ChitietCauhinhHocsinh.class, q.getId());

            n.setApDung(q.getApDung() != null ? q.getApDung() : n.getApDung());
            n.setCauhinh(q.getCauhinh() != null ? q.getCauhinh() : n.getCauhinh());
            n.setHocsinh(q.getHocsinh() != null ? q.getHocsinh() : n.getHocsinh());

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

    public boolean delete(ChitietCauhinhHocsinhId idChitietCauhinhHocsinhId) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            ChitietCauhinhHocsinh n = (ChitietCauhinhHocsinh) session.get(ChitietCauhinhHocsinh.class, idChitietCauhinhHocsinhId);
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
    public List<ChitietCauhinhHocsinh> getAll() {
        list = new ArrayList<ChitietCauhinhHocsinh>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhHocsinh c join fetch c.hocsinh join fetch c.cauhinh");
            list = (List<ChitietCauhinhHocsinh>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public ChitietCauhinhHocsinh getById(ChitietCauhinhHocsinhId idChitietCauhinhHocsinh) {
        ChitietCauhinhHocsinh hs=null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhHocsinh c join fetch c.hocsinh join fetch c.cauhinh join fetch c.id key where key.idHocSinh = :hocsinh and key.idCauHinh = :cauhinh");
            q.setParameter("hocsinh", idChitietCauhinhHocsinh.getIdHocSinh());
            q.setParameter("cauhinh", idChitietCauhinhHocsinh.getIdCauHinh());
            hs=(ChitietCauhinhHocsinh) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }

    public List<ChitietCauhinhHocsinh> getByCauhinh(Cauhinh ch) {
        list = new ArrayList<ChitietCauhinhHocsinh>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhHocsinh c join fetch c.hocsinh join fetch c.cauhinh ch where ch.idCauHinh = :cauhinh");
            q.setParameter("cauhinh", ch.getIdCauHinh());
            list = (List<ChitietCauhinhHocsinh>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<ChitietCauhinhHocsinh> getByHocsinh(Hocsinh hs) {
        list = new ArrayList<ChitietCauhinhHocsinh>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from ChitietCauhinhHocsinh c join fetch c.hocsinh hs join fetch c.cauhinh where hs.idHocSinh = :hocsinh");
            q.setParameter("hocsinh", hs.getIdHocSinh());
            list = (List<ChitietCauhinhHocsinh>) q.list();
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
