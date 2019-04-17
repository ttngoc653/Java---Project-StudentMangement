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
            result = (HocsinhLophocId) session.save(new HocsinhLophoc(p));
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
            Query q = session.createQuery("from HocsinhLophoc");
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

    @SuppressWarnings("unchecked")
    public List<HocsinhLophoc> getAllStudentByIdLopHoc(int id) {
        list = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from HocsinhLophoc as t where t.idLopHoc = '" + id + "'");
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

    @SuppressWarnings("unchecked")
    public List<HocsinhLophocId> getAllStudentByIdLopHocIdNamHoc(int idLop, int idNamHoc) {
        List<HocsinhLophocId> ds = new ArrayList<HocsinhLophocId>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from HocsinhLophoc as t where t.idLopHoc = '" + idLop + "' and t.idNamHoc = '" + idNamHoc + "'");
            ds = (List<HocsinhLophocId>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return ds;
    }

    @SuppressWarnings("unchecked")
    public List<HocsinhLophoc> getAllStudentByIdLopHocIdNamHoc2(int idLop, int idNamHoc) {
        List<HocsinhLophoc> ds = new ArrayList<HocsinhLophoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from HocsinhLophoc where idLopHoc = '" + idLop + "' and idNamHoc = '" + idNamHoc + "'");
            ds = (List<HocsinhLophoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return ds;
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

    public HocsinhLophoc get2(int id) {
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

    public HocsinhLophoc getByIdHocsinh(int id) {
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
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getNamhoc().equals(p)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public HocsinhLophoc getById(int id) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdHocSinhLopHoc() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<HocsinhLophoc> getByNamHocLop(Namhoc n, Lop l) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getLop().equals(l) || !list.get(i).getNamhoc().equals(n)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

        public List<HocsinhLophoc> getByLop(Lop l) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getLop().equals(l)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }
    
    public List<HocsinhLophoc> getByHocsinh(Hocsinh q) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getHocsinh().equals(q)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

}
