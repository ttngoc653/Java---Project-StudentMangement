/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class HocsinhLophocDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<HocsinhLophoc> list;

    public HocsinhLophocDAL() {
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

    public Integer add(HocsinhLophoc q) {
        Integer result = null;
        try {
            tst = session.beginTransaction();
            result = (Integer) session.save(q);
            System.out.println(result.toString());
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    public boolean update(HocsinhLophoc q) {

        Boolean result = false;
        try {
            tst = session.beginTransaction();
            HocsinhLophoc n = (HocsinhLophoc) session.get(HocsinhLophoc.class, q.getIdHocSinhLopHoc());

            n.setDiems(q.getDiems());
            n.setHocsinh(q.getHocsinh());
            n.setLop(q.getLop());
            n.setNamhoc(q.getNamhoc());

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

    public boolean delete(Integer id) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            HocsinhLophoc n = (HocsinhLophoc) session.get(HocsinhLophoc.class, id);
            session.delete(n);
            tst.commit();
            result = true;
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<HocsinhLophoc> getAll() {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct hl "
                    + "from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch hl.diems");
            list = (List<HocsinhLophoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public HocsinhLophoc get(Integer id) {
        HocsinhLophoc n = null;
        try {
            tst = session.beginTransaction();
            n = (HocsinhLophoc) session.get(HocsinhLophoc.class, id);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public List<HocsinhLophoc> getByNamHoc(Namhoc p) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct hl "
                    + "from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc n "
                    + "left join fetch hl.diems "
                    + "where n.idNamHoc = :namhoc");
            q.setParameter("namhoc", p.getIdNamHoc());
            list = (List<HocsinhLophoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public HocsinhLophoc getByIdHocSinh(int id) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHocsinh().getIdHocSinh() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<HocsinhLophoc> getByNamHocLop(Namhoc n, Lop l) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct hl "
                    + "from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop l "
                    + "left join fetch hl.namhoc n "
                    + "left join fetch hl.diems "
                    + "where n.idNamHoc = :namhoc "
                    + "and l.idLop = :lop");
            q.setParameter("namhoc", n.getIdNamHoc());
            q.setParameter("lop", l.getIdLop());
            list = (List<HocsinhLophoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<HocsinhLophoc> getByHocsinh(Hocsinh hs) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct hl "
                    + "from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh hs "
                    + "left join fetch hl.lop l "
                    + "left join fetch hl.namhoc n "
                    + "left join fetch hl.diems "
                    + "where hs.idHocSinh = :hocsinh");
            q.setParameter("hocsinh", hs.getIdHocSinh());
            list = (List<HocsinhLophoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public HocsinhLophoc getByNamHocLopHocSinh(Namhoc n, Lop l, Hocsinh h) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct hl "
                    + "from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh h "
                    + "left join fetch hl.lop l "
                    + "left join fetch hl.namhoc n "
                    + "left join fetch hl.diems "
                    + "where n.idNamHoc = :namhoc "
                    + "and l.idLop = :lop "
                    + "and h.idHocSinh = :hocsinh");
            q.setParameter("namhoc", n.getIdNamHoc());
            q.setParameter("lop", l.getIdLop());
            q.setParameter("hocsinh", h.getIdHocSinh());
            list = (List<HocsinhLophoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list.size() > 0 ? list.get(0) : null;
    }

}
