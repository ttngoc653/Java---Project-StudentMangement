/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.Diem;
import dto.HibernateUtil;
import dto.Hocky;
import dto.HocsinhLophoc;
import dto.Lop;
import dto.Monhoc;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class DiemDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Diem> list;

    public DiemDAL() {
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

    public Integer add(Diem p) {
        int result = -1;
        try {
            tst = session.beginTransaction();
            result = (Integer) session.save(p);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Diem p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Diem n = (Diem) session.get(Diem.class, p.getIdDiem());

            n.setIdDiem(p.getIdDiem());
            n.setChitietCauhinhDiems(p.getChitietCauhinhDiems().size() >= 0 ? p.getChitietCauhinhDiems() : n.getChitietCauhinhDiems());
            n.setDiemCuoiKy(p.getDiemCuoiKy() != null ? p.getDiemCuoiKy() : n.getDiemCuoiKy());
            n.setDiem15Phut(p.getDiem15Phut() != null ? p.getDiem15Phut() : n.getDiem15Phut());
            n.setDiem1Tiet(p.getDiem1Tiet() != null ? p.getDiem1Tiet() : n.getDiem1Tiet());
            n.setHocky(p.getHocky() != null ? p.getHocky() : n.getHocky());
            n.setHocsinhLophoc(p.getHocsinhLophoc() != null ? p.getHocsinhLophoc() : n.getHocsinhLophoc());
            n.setMonhoc(p.getMonhoc() != null ? p.getMonhoc() : n.getMonhoc());

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

    public boolean delete(int id) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Diem n = (Diem) session.get(Diem.class, id);
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
    public List<Diem> getAll() {
        list = new ArrayList<Diem>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Diem");
            list = (List<Diem>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Diem getById(int id) {
        Diem n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Diem as t where t.idDiem = " + id);
            n = (Diem) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public List<Diem> getByMonHoc(Monhoc mh) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getMonhoc().equals(mh)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<Diem> getByHocSinhLopHoc(HocsinhLophoc p) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getHocsinhLophoc().equals(p)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<Diem> getByLopHocMonHoc(Lop l, Monhoc mh) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getHocsinhLophoc().getLop().equals(l) || !list.get(i).getMonhoc().equals(mh)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<Diem> getByHocSinhLopHocMonHoc(HocsinhLophoc hl, Monhoc mh) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getHocsinhLophoc().equals(hl) || !list.get(i).getMonhoc().equals(mh)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public List<Diem> getByHocSinhLopHocHocKy(HocsinhLophoc hl, Hocky h) {
        list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getHocsinhLophoc().equals(hl) || !list.get(i).getHocky().equals(h)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

}
