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
import org.hibernate.SessionFactory;
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

    public boolean SaveOrUpdate(Hocsinh hs) {
        try {
            tst = session.beginTransaction();
            session.saveOrUpdate(hs);
            tst.commit();
            return true;
        } catch (Exception e) {
            tst.rollback();
            return false;
        }
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

    public boolean update2(Hocsinh hs) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            session.update(hs);
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

//    @SuppressWarnings("unchecked")
//    public List<Hocsinh> Search(String key) {
//        lHs = new ArrayList<Hocsinh>();
//        try {
//            tst = session.beginTransaction();
////            Query q = session.createQuery("select * from Hocsinh as a where a.idHocSinh = " + key + 
////                                          " or a.hoTen like '%" + key + "%' or a.ngaySinh like '%" + key + "%'");
//            //String query = "SELECT FROM hocsinh WHERE idHocSinh = " + key + " OR hoTen LIKE '%" + key + "%' or ngaySinh LIKE '%" + key + "%'";
//            Query q = session.createQuery("SELECT FROM hocsinh WHERE idHocSinh = " + key + " OR hoTen LIKE '%" + key + "%' or ngaySinh LIKE '%" + key + "%'");
//            lHs = (List<Hocsinh>) q.list();
//            tst.commit();
//        } catch (Exception e) {
//            if (tst != null) {
//                tst.rollback();
//            }
//            e.printStackTrace();
//        }
//        return lHs;
//    }
//        @SuppressWarnings("unchecked")
//    public List<Hocsinh> Search(String key) {
//        List<Hocsinh> l = new ArrayList<Hocsinh>();
//        String keyId = key;
//        try {
//            tst = session.beginTransaction();
//            Query q = session.createQuery("FROM Hocsinh WHERE idHocSinh = :keyId or hoTen like :key or ngaySinh like :key or gioiTinh like :key or diaChi like :key or email like :key");
//            q.setString("keyId", keyId);
//            q.setString("key", "%" + key + "%");
//            l = q.list();
//            tst.commit();
//        } catch (Exception e) {
//            if (tst != null) {
//                tst.rollback();
//            }
//            e.printStackTrace();
//        }
//        return l;
//    }
    
    /*
    * Tra cứu học sinh theo nhiều tiêu chí
    */
    @SuppressWarnings("unchecked")
    public List<Hocsinh> Search(String key) {
        lHs = new ArrayList<Hocsinh>();
        String keyId = key;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("FROM Hocsinh WHERE idHocSinh = :keyId "
                                           + "or hoTen like :key "
                                           + "or ngaySinh like :key "
                                           + "or gioiTinh like :key "
                                           + "or diaChi like :key "
                                           + "or email like :key "
                                           + "or sdtCaNhan like :key "
                                           + "or sdtGiamHo like :key");
            q.setString("keyId", keyId);
            q.setString("key", "%" + key + "%");
            lHs = q.list();
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
            Query q = session.createQuery("from Hocsinh as hocsinh where hocsinh.idHocSinh = " + idHocSinh);
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
            //Query q = session.createQuery("from Hocsinh as hs where hs.hoTen like '" + name + "'");
            Query q = session.createQuery("from Hocsinh as hs where hs.hoTen = '" + name + "'");
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

    public Hocsinh getByName2(String name) {
        Hocsinh n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as t where t.hoTen = '" + name + "'");
            n = (Hocsinh) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }
}
