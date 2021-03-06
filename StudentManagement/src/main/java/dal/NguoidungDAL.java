/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import static bll.HelperBLL.*;
import dto.HibernateUtil;
import dto.Nguoidung;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class NguoidungDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Nguoidung> list;

    public NguoidungDAL() {
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

    public Integer add(Nguoidung p) {
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

    public boolean updateName(Nguoidung p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, p.getIdNguoiDung());

            n.setHoTen(p.getHoTen().length() > 0 ? p.getHoTen() : n.getHoTen());

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

    public boolean updatePassword(Nguoidung p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, p.getIdNguoiDung());

            n.setMatKhau(p.getMatKhau());

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
    public boolean updateSDT(Nguoidung p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, p.getIdNguoiDung());

            n.setSdt(p.getSdt());

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
    
    

    public boolean updateEmail(Nguoidung p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, p.getIdNguoiDung());

            n.setEmail(p.getEmail());

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
     public boolean updateNuoidung(Nguoidung p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, p.getIdNguoiDung());

            n.setEmail(p.getEmail());
            n.setHoTen(p.getHoTen());
            n.setMatKhau(p.getMatKhau());
            n.setSdt(p.getSdt());

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

    public boolean updateStatus(Nguoidung p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, p.getIdNguoiDung());

            n.setTinhTrang(p.getTinhTrang());

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
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, id);
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
    public List<Nguoidung> getAll() {
        list = new ArrayList<Nguoidung>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung");
            list = (List<Nguoidung>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Nguoidung getById(int id) {
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.idNguoiDung = :id");
            q.setParameter("id", id);
            n = (Nguoidung) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Nguoidung getByHoTen(String ten) {
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.hoTen = :ten");
            q.setParameter("ten", ten);
            n = (Nguoidung) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Nguoidung getByTenDangNhap(String tenDN) {
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.tenTaiKhoan = :user");
            q.setParameter("user", tenDN);
            n = (Nguoidung) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
                
            }
            e.printStackTrace();
            tst.commit();
        }
        return n;
    }

    public Nguoidung LogIn(String userName, String passWord) throws NoSuchAlgorithmException {
        userName = userName.trim();
        String password = PasswordMD5(passWord);
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.tenTaiKhoan LIKE :user "
                    + "AND t.matKhau LIKE :pass");
            q.setParameter("user", userName);
            q.setParameter("pass", password);
            n = (Nguoidung) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public List<Nguoidung> getByLoai(byte loaiNguoidung) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.loaiNguoiDung = :loai");
            q.setParameter("loai", loaiNguoidung);
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

    public List<Nguoidung> getByTinhTrang(byte tinhTrang) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.tinhTrang = :status");
            q.setParameter("status", tinhTrang);
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

    public Nguoidung getByEmail(String email) {
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.email = :mail");
            q.setParameter("mail", email);
            n = (Nguoidung) q.uniqueResult();
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
