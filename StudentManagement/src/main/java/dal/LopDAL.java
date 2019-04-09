/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.*;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author Jossion
 */
public class LopDAL {

    private Session session = null;
    private Transaction tst = null;
    private List<Lop> list;

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    public LopDAL() {
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

    public List<Lop> findAll() {
        try {
            sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Lop.class).list();
        } catch (Exception e) {
            return null;
        }
    }

    public Lop find(String tenLop) {
        try {
            sf.getCurrentSession().beginTransaction();
            return (Lop) sf.getCurrentSession().get(Lop.class, tenLop);
        } catch (HibernateException e) {
            return null;
        }
    }

//    public Integer add(Lop p) {
//        int result = -1;
//        try {
//            tst = session.beginTransaction();
//            result = (Integer) session.save(p);
//            tst.commit();
//        } catch (Exception e) {
//            if (tst != null) {
//                tst.rollback();
//            }
//            e.printStackTrace();
//        }
//        return result;
//    }
//    public boolean SaveOrUpdate(Lop p) {
//        try {
//            tst = session.beginTransaction();
//            session.saveOrUpdate(p);
//            tst.commit();
//            return true;
//        } catch (Exception e) {
//            tst.rollback();
//            return false;
//        }
//    }    
    public boolean add(Lop p) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(p);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

//    public boolean update(Lop p) {
//        Boolean result = false;
//        try {
//            tst = session.beginTransaction();
//            Lop n = (Lop) session.get(Lop.class, p.getIdLop());
//
//            n.setKhoi(p.getKhoi() > -1 ? p.getKhoi() : n.getKhoi());
//            n.setTenLop(p.getTenLop().length() > 0 ? p.getTenLop() : n.getTenLop());
//            n.setTinhTrang(p.getTinhTrang() != null ? p.getTinhTrang() : n.getTinhTrang());
//
//            session.update(n);
//            tst.commit();
//            result = true;
//        } catch (Exception e) {
//            if (tst != null) {
//                tst.rollback();
//            }
//            e.printStackTrace();
//        }
//        return result;
//    }
    public boolean update(Lop p) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(p);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

//    public boolean delete(int id) {
//        Boolean result = false;
//        try {
//            tst = session.beginTransaction();
//            Lop n = (Lop) session.get(Lop.class, id);
//            session.delete(n);
//            tst.commit();
//            result = true;
//        } catch (Exception e) {
//            if (tst != null) {
//                tst.rollback();
//            }
//            e.printStackTrace();
//        }
//        return result;
//    }
    public boolean delete(int id) {
        try {
            sf.getCurrentSession().beginTransaction();
            Lop n = (Lop) sf.getCurrentSession().get(Lop.class, id);
            sf.getCurrentSession().delete(n);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }


//    public boolean delete4(Lop p) {
//        try {
//            sf.getCurrentSession().beginTransaction();
//            sf.getCurrentSession().delete(p);
//            sf.getCurrentSession().getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            sf.getCurrentSession().getTransaction().rollback();
//            return false;
//        }
//    }

    @SuppressWarnings("unchecked")
    public List<Lop> getAll() {
        list = new ArrayList<Lop>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Lop");
            list = (List<Lop>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public Lop getById(int id) {
        Lop n = null;
        try {
            tst = session.beginTransaction();
            n = (Lop) session.get(Lop.class, id);
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Lop getByTen(String name) {
        Lop n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Lop as t where t.tenLop = '" + name + "'");
            n = (Lop) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public Lop getByTen2(String name) {
        Lop n = null;
        try {
            sf.getCurrentSession().beginTransaction();
            Query q = sf.getCurrentSession().createQuery("from Lop as t where t.tenLop = '" + name + "'");
            n = (Lop) q.uniqueResult();
            sf.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }

    public List<Lop> getByKhoi(int khoi) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Lop as t where t.khoi = '" + khoi + "'");
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

    public List<Lop> getByTinhTrang(Byte tinhTrang) {
        list = new ArrayList<>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery("from Lop as t where t.tinhTrangi = '" + tinhTrang + "'");
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
}
