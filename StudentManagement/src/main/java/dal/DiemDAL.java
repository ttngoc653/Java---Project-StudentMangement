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
            n.setDiemCuoiKy(p.getDiemCuoiKy());
            n.setDiem15phut(p.getDiem15phut());
            n.setDiem1tiet(p.getDiem1tiet());
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
            Query q = session.createQuery("select distinct d "
                    + "from Diem d "
                    + "left join fetch d.hocky "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch hl.id hid "
                    + "left join fetch d.monhoc "
                    + "left join fetch d.chitietCauhinhDiems");
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
            Query q = session.createQuery("select distinct d "
                    + "from Diem as d "
                    + "left join fetch d.hocky "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch hl.id hid "
                    + "left join fetch d.monhoc "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where d.idDiem = :id");
            q.setParameter("id", id);
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
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct d "
                    + "from Diem as d "
                    + "left join fetch d.hocky "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch hl.id hid "
                    + "left join fetch d.monhoc "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where m.idMonHoc = :monhoc");
            q.setParameter("monhoc", mh.getIdMonHoc());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Diem> getByHocSinhLopHoc(HocsinhLophoc p) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct d "
                    + "from Diem as d "
                    + "left join fetch d.hocky "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch hl.id hid "
                    + "left join fetch d.monhoc "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where hl.idHocSinhLopHoc = :hocsinhlophoc");
            q.setParameter("hocsinhlophoc", p.getIdHocSinhLopHoc());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Diem> getByHocSinhLopHocMonHoc(HocsinhLophoc hl, Monhoc mh) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct d "
                    + "from Diem as d "
                    + "left join fetch d.hocky "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch hl.id hid "
                    + "left join fetch d.monhoc "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where hl.idHocSinhLopHoc = :hocsinhlophoc "
                    + "and m.idMonHoc = :monhoc");
            q.setParameter("hocsinhlophoc", hl.getIdHocSinhLopHoc());
            q.setParameter("monhoc", mh.getIdMonHoc());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Diem> getByHocSinhLopHocHocKy(HocsinhLophoc hl, Hocky h) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Diem as d "
                    + "left join fetch d.hocky k "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch d.monhoc "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where hl.idHocSinhLopHoc = :hocsinhlophoc "
                    + "and k.idHocKy = :hocky");
            q.setParameter("hocsinhlophoc", hl.getIdHocSinhLopHoc());
            q.setParameter("hocky", h.getIdHocKy());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Diem> getByLopHocHocKy(Lop l, dto.Namhoc n, Hocky h) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Diem as d "
                    + "left join fetch d.hocky k "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop l "
                    + "left join fetch hl.namhoc nh"
                    + "left join fetch d.monhoc "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where l.idLop = :lop "
                    + "and nh.idNamHoc = :namhoc "
                    + "and k.idHocKy = :hocky");
            q.setParameter("lop", l.getIdLop());
            q.setParameter("namhoc", n.getIdNamHoc());
            q.setParameter("hocky", h.getIdHocKy());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Diem> getByLopHocHocKyMonHoc(Lop l, dto.Namhoc n, Hocky h, dto.Monhoc m) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct d "
                    + "from Diem as d "
                    + "left join fetch d.hocky k "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc nh "
                    + "left join fetch d.monhoc m "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where hid.idLopHoc = :lop "
                    + "and nh.idNamHoc = :namhoc "
                    + "and k.idHocKy = :hocky "
                    + "and m.idMonHoc = :monhoc");
            q.setParameter("lop", l.getIdLop());
            q.setParameter("namhoc", n.getIdNamHoc());
            q.setParameter("hocky", h.getIdHocKy());
            q.setParameter("monhoc", m.getIdMonHoc());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Diem getByLopHocHocKyMonHocHocSinh(Lop l, dto.Namhoc n, Hocky h, dto.Monhoc m, dto.Hocsinh hs) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct d "
                    + "from Diem as d "
                    + "left join fetch d.hocky k "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh hs "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc nh "
                    + "left join fetch d.monhoc m "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where hid.idLopHoc = :lop "
                    + "and nh.idNamHoc = :namhoc "
                    + "and k.idHocKy = :hocky "
                    + "and m.idMonHoc = :monhoc "
                    + "and hs.hoTen like :hocsinh");
            q.setParameter("lop", l.getIdLop());
            q.setParameter("namhoc", n.getIdNamHoc());
            q.setParameter("hocky", h.getIdHocKy());
            q.setParameter("monhoc", m.getIdMonHoc());
            q.setParameter("hocsinh", hs.getHoTen());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
     public Diem getByLopHocHocKyMonHocHocSinh(HocsinhLophoc hl, Hocky h, dto.Monhoc m) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("select distinct d "
                    + "from Diem as d "
                    + "left join fetch d.hocky k "
                    + "left join fetch d.hocsinhLophoc hl "
                    + "left join fetch hl.hocsinh "
                    + "left join fetch hl.lop "
                    + "left join fetch hl.namhoc "
                    + "left join fetch d.monhoc m "
                    + "left join fetch d.chitietCauhinhDiems "
                    + "where hl.idHocSinhLopHoc = :hocsinhlophoc "
                    + "and k.idHocKy = :hocky "
                    + "and m.idMonHoc = :monhoc");
            q.setParameter("hocsinhlophoc", hl.getIdHocSinhLopHoc());
            q.setParameter("hocky", h.getIdHocKy());
            q.setParameter("monhoc", m.getIdMonHoc());
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
