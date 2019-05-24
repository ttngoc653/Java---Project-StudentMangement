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

            n.setChitietCauhinhDiems(ch.getChitietCauhinhDiems());
            n.setChitietCauhinhHocsinhs(ch.getChitietCauhinhHocsinhs());
            n.setLops(ch.getLops());
            n.setGiaTri(ch.getGiaTri());
            n.setLoaiThuocTinh(ch.getLoaiThuocTinh());
            n.setTenDayDu(ch.getTenDayDu());
            n.setTenThuocTinh(ch.getTenThuocTinh());

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

    private String getTable(String where) {
        return "select distinct ch "
                + "from Cauhinh ch "
                + "left join fetch ch.lops l "
                + "left join fetch l.hocsinhLophocs"
                + "left join fetch ch.chitietCauhinhHocsinhs cths "
                + "left join fetch ch.chitietCauhinhDiems ctd "
                + where
                + " order by ch.tenThuocTinh ";
    }

    @SuppressWarnings("unchecked")
    public List<Cauhinh> getAll() {
        lHs = new ArrayList<Cauhinh>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable(""));
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
            Query q = session.createQuery(getTable("where ch.idCauHinh = :id"));
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
            Query q = session.createQuery(getTable("where ch.tenThuocTinh like :name"));
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

    public Cauhinh getByType(String type) {
        Cauhinh hs = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where ch.loaiThuocTinh like ':name'"));
            q.setParameter("name", type);
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

    public Cauhinh getByNameDetail(String name_detail) {
        Cauhinh hs = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where ch.tenDayDu like ':name'"));
            q.setParameter("name", name_detail);
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
