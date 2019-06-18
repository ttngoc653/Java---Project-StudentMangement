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
            n.setEmail(hs.getEmail().length() > 0 ? hs.getEmail() : n.getEmail());
            n.setGioiTinh(hs.getGioiTinh().length() > 0 ? hs.getGioiTinh() : n.getGioiTinh());
            n.setHoTen(hs.getHoTen().length() > 0 ? hs.getHoTen() : n.getHoTen());
            n.setHocsinhLophocs(hs.getHocsinhLophocs().isEmpty() ? hs.getHocsinhLophocs() : n.getHocsinhLophocs());
            n.setNgaySinh(hs.getNgaySinh() != null ? hs.getNgaySinh() : n.getNgaySinh());
            //n.setSdtCaNhan(hs.getSdtCaNhan().length() > 0 ? hs.getSdtCaNhan() : n.getSdtCaNhan());
            n.setSdtCaNhan(hs.getSdtCaNhan());
            n.setSdtGiamHo(hs.getSdtGiamHo());
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

    private String getTable(String where) {
        return "select distinct hs "
                + "from Hocsinh as hs "
                + "left join fetch hs.hocsinhLophocs hl "
                + "left join fetch hs.chitietCauhinhHocsinhs ct "
                + where
                + " order by hs.hoTen";
    }

    @SuppressWarnings("unchecked")
    public List<Hocsinh> getAll() {
        lHs = new ArrayList<Hocsinh>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable(""));
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

    @SuppressWarnings("unchecked")
    public List<Hocsinh> Search(String key) {
        lHs = new ArrayList<Hocsinh>();
        String keyId = key;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("WHERE hs.idHocSinh = :keyId "
                    + "or hs.hoTen like :key "
                    + "or hs.ngaySinh like :key "
                    + "or hs.gioiTinh like :key "
                    + "or hs.diaChi like :key "
                    + "or hs.email like :key "
                    + "or hs.sdtCaNhan like :key "
                    + "or hs.sdtGiamHo like :key"));
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
            Query q = session.createQuery(getTable("where hs.idHocSinh = :idHocSinh"));
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
            Query q = session.createQuery(getTable("where hs.hoTen like :name"));
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

    public Hocsinh getByName2(String name) {
        Hocsinh n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable(" where hs.hoTen = '" + name + "'"));
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

    public List getByGender(String gender) {
        lHs = new ArrayList();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where hs.gioiTinh like :sex"));
            q.setParameter("sex", gender);
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

    public List getByStatus(byte status) {
        lHs = new ArrayList();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where hs.tinhTrang = :tus"));
            q.setParameter("tus", status);
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

}
