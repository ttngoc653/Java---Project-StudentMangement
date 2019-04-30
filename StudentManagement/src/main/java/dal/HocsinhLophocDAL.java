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

    public HocsinhLophocId add(HocsinhLophocId p) {
        HocsinhLophocId result = null;
        try {
            tst = session.beginTransaction();
            result = (HocsinhLophocId) session.save(new HocsinhLophoc(p, null, null, null));
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

    public boolean update(HocsinhLophocId idNew, HocsinhLophocId idOld) {
        return (delete(idOld)) && (add(idNew) != null);
    }

    public boolean delete(HocsinhLophocId id) {
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
            Query q = session.createQuery("from HocsinhLophoc hl "
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

    public HocsinhLophoc get(HocsinhLophocId id) {
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

    public HocsinhLophoc getById(int id) {
        HocsinhLophoc hl = null;

        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch hl.diems "
                    + "where hl.idHocSinhLopHoc = :id");
            q.setParameter("id", id);
            hl = (HocsinhLophoc) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hl;
    }

    public List<HocsinhLophoc> getByNamHoc(Namhoc p) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from HocsinhLophoc hl "
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
            Query q = session.createQuery("from HocsinhLophoc hl "
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

    public List<HocsinhLophoc> findStudentByNamHocLop(int idHS, Namhoc n, Lop l) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh h "
                    + "left join fetch hl.lop l "
                    + "left join fetch hl.namhoc n "
                    + "left join fetch hl.diems "
                    + "where h.idHocSinh = :idHS "
                    + "and n.idNamHoc = :namhoc "
                    + "and l.idLop = :lop");
            q.setParameter("idHS", idHS);
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

    public List<HocsinhLophoc> findStudentByNamHoc(int idHS, Namhoc n) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from HocsinhLophoc hl "
                    + "left join fetch hl.hocsinh h "
                    + "left join fetch hl.lop l "
                    + "left join fetch hl.namhoc n "
                    + "left join fetch hl.diems "
                    + "where h.idHocSinh = :idHS "
                    + "and n.idNamHoc = :namhoc ");
            q.setParameter("idHS", idHS);
            q.setParameter("namhoc", n.getIdNamHoc());
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
            Query q = session.createQuery("from HocsinhLophoc hl "
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

}
