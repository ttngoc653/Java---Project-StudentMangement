/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.Hocsinh;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class HocsinhDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Hocsinh> lHs;

    public HocsinhDAL() {
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

    public Integer add(Hocsinh hs) {
        int result = -1;
        try {
            tst = session.beginTransaction();
            result = (Integer) session.save(hs);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Hocsinh hs) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Hocsinh n = (Hocsinh) session.get(Hocsinh.class, hs.getIdHocSinh());

            n.setChitietCauhinhHocsinhs(hs.getChitietCauhinhHocsinhs() != null ? hs.getChitietCauhinhHocsinhs() : n.getChitietCauhinhHocsinhs());
            n.setDiaChi(hs.getDiaChi().length() > 0 ? hs.getDiaChi() : n.getDiaChi());
            n.setEmail(hs.getEmail().length() > 0 ? hs.getEmail() : n.getDiaChi());
            n.setGioiTinh(hs.getGioiTinh().length() > 0 ? hs.getGioiTinh() : n.getGioiTinh());
            n.setHoTen(hs.getHoTen().length() > 0 ? hs.getHoTen() : n.getHoTen());
            n.setHocsinhLophocs(hs.getHocsinhLophocs().isEmpty() ? hs.getHocsinhLophocs() : n.getHocsinhLophocs());
            n.setNgaySinh(hs.getNgaySinh() != null ? hs.getNgaySinh() : n.getNgaySinh());
            n.setSdtCaNhan(hs.getSdtCaNhan().length() > 0 ? hs.getSdtCaNhan() : n.getSdtCaNhan());
            n.setSdtGiamHo(hs.getSdtGiamHo().length() > 0 ? hs.getSdtGiamHo() : n.getSdtGiamHo());
            n.setTinhTrang(hs.getTinhTrang() != -1 ? hs.getTinhTrang() : n.getTinhTrang());

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

    public boolean delete(int idHocsinh) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Hocsinh n = (Hocsinh) session.get(Hocsinh.class, idHocsinh);
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
    public List<Hocsinh> getAll() {
        lHs = new ArrayList<Hocsinh>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as hocsinh");
            lHs = (List<Hocsinh>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return lHs;
    }

    public Hocsinh getById(int idHocSinh) {
        Hocsinh hs = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as h "
                    + "join fetch h.hocsinhLophocs "
                    + "join fetch h.chitietCauhinhHocsinhs c "
                    + "join fetch c.cauhinh "
                    + "where h.idHocSinh :idHocSinh");
            q.setParameter("idHocSinh", idHocSinh);
            hs = (Hocsinh) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }

    public Hocsinh getByName(String name) {
        Hocsinh hs = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as h "
                    + "join fetch h.hocsinhLophocs "
                    + "join fetch h.chitietCauhinhHocsinhs c "
                    + "join fetch c.cauhinh "
                    + "where h.hoTen like :name");
            q.setParameter("name", name);
            hs = (Hocsinh) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return hs;
    }
    
    public List getByGender(String gender) {
        lHs= new ArrayList();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as h "
                    + "join fetch h.hocsinhLophocs "
                    + "join fetch h.chitietCauhinhHocsinhs c "
                    + "join fetch c.cauhinh "
                    + "where h.gioiTinh like :sex");
            q.setParameter("sex", gender);
            lHs=q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return lHs;
    }
    
    public List getByStatus(byte status) {
        lHs= new ArrayList();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as h "
                    + "join fetch h.hocsinhLophocs "
                    + "join fetch h.chitietCauhinhHocsinhs c "
                    + "join fetch c.cauhinh "
                    + "where h.tinhTrang = :tus");
            q.setParameter("tus", status);
            lHs=q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return lHs;
    }
    
}
