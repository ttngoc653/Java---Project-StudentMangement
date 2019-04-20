/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.Cauhinh;
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
public class CauHinhDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Cauhinh> lHs;

    public CauHinhDAL() {
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

    public Integer add(Cauhinh ch) {
        int result = -1;
        try {
            tst = session.beginTransaction();
            result = (Integer) session.save(ch);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Cauhinh ch) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Cauhinh n = (Cauhinh) session.get(Cauhinh.class, ch.getIdCauHinh());

            n.setChitietCauhinhDiems(ch.getChitietCauhinhDiems().size() > 0 ? ch.getChitietCauhinhDiems() : n.getChitietCauhinhDiems());
            n.setChitietCauhinhHocsinhs(ch.getChitietCauhinhHocsinhs().size() > 0 ? ch.getChitietCauhinhHocsinhs() : n.getChitietCauhinhHocsinhs());
            n.setChitietCauhinhLops(ch.getChitietCauhinhLops().size() > 0 ? ch.getChitietCauhinhLops() : n.getChitietCauhinhLops());
            n.setGiaTri(ch.getGiaTri().length() > 0 ? ch.getGiaTri() : n.getGiaTri());
            n.setLoaiThuocTinh(ch.getLoaiThuocTinh().length() > 0 ? ch.getLoaiThuocTinh() : n.getLoaiThuocTinh());
            n.setTenDayDu(ch.getTenDayDu().length() > 0 ? ch.getTenDayDu() : n.getTenDayDu());
            n.setTenThuocTinh(ch.getTenThuocTinh().length() > 0 ? ch.getTenThuocTinh() : n.getTenThuocTinh());

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

    public boolean delete(int idCauhinh) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Cauhinh n = (Cauhinh) session.get(Cauhinh.class, idCauhinh);
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
    public List<Cauhinh> getAll() {
        lHs = new ArrayList<Cauhinh>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Cauhinh as cauhinh");
            lHs = (List<Cauhinh>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return lHs;
    }

    public Cauhinh getById(int idCauHinh) {
        Cauhinh hs = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Cauhinh as ch join fetch ch.chitietCauhinhHocsinhs join fetch ch.chitietCauhinhLops join fetch ch.chitietCauhinhDiems  where ch.idCauHinh = :id");
            q.setParameter("id", idCauHinh);
            hs = (Cauhinh) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }

    public Cauhinh getByName(String name) {
        Cauhinh hs = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Cauhinh as ch where ch.tenCauHinh like ':name'");
            q.setParameter("name", name);
            hs = (Cauhinh) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }

}
