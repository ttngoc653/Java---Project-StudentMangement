/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
import dto.Nguoidung;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
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

    public boolean updateRole(Nguoidung p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Nguoidung n = (Nguoidung) session.get(Nguoidung.class, p.getIdNguoiDung());

            n.setLoaiNguoiDung(p.getLoaiNguoiDung());

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
            Query q = session.createQuery("from Nguoidung as t where t.idNguoiDung = " + id);
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

    public Nguoidung getByTen(String ten) {
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.hoTen = '" + ten + "'");
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

    public Nguoidung logIn(String userName, String passWord) {
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where MD5(t.tenTaiKhoan) LIKE MD5( '" + userName + "')"
                    + "AND MD5(matKhau) LIKE MD5('" + passWord + "')");
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
    
    public String PasswordMD5(String password) throws NoSuchAlgorithmException {
        String kq = ""; 
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        //System.out.println(sb.toString());
        kq = sb.toString();
        return kq;
    }
    
    public Nguoidung LogIn(String userName, String passWord) throws NoSuchAlgorithmException  {
        String password = PasswordMD5(passWord);
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.tenTaiKhoan LIKE '" + userName + "' "
                    + "AND matKhau LIKE '" + password + "' ");
            n = (Nguoidung) q.uniqueResult();
            tst.commit();
        } catch (HibernateException e) {
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
            Query q = session.createQuery("from Nguoidung as t where t.loaiNguoiDung = '" + loaiNguoidung + "'");
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

    public List<Nguoidung> getByTrinhTrang(byte tinhTrang) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.tinhTrang = '" + tinhTrang + "'");
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

    public Object getByTenDangNhap(String ten) {
        
        Nguoidung n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Nguoidung as t where t.tenTaiKhoan = '" + ten + "'");
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
