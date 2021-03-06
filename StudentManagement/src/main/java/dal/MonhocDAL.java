/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.HibernateUtil;
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
public class MonhocDAL {
    
    private Session session = null;
    private Transaction tst = null;
    private List<Monhoc> list;
    
    public MonhocDAL() {
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
    
    public Integer add(Monhoc p) {
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
    
    public boolean update(Monhoc p) {
        Boolean result = false;
        try {
            tst = session.beginTransaction();
            Monhoc n = (Monhoc) session.get(Monhoc.class, p.getIdMonHoc());
            
            n.setTenMh(p.getTenMh().length() > 0 ? p.getTenMh() : n.getTenMh());
            n.setDangGiangDay(p.isDangGiangDay());
            n.setHeSo(p.getHeSo() > 0 ? p.getHeSo() : n.getHeSo());
            
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
            Monhoc n = (Monhoc) session.get(Monhoc.class, id);
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
        return "select distinct mh "
                + "from Monhoc as mh "
                + "left join fetch mh.diems d "
                + where
                + " order by mh.tenMh";
    }
    
    @SuppressWarnings("unchecked")
    public List<Monhoc> getAll() {
        list = new ArrayList<Monhoc>();
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable(""));
            list = (List<Monhoc>) q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }
    
    public Monhoc getById(int id) {
        Monhoc n = null;
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where mh.idMonhoc = :id"));
            q.setParameter("id", id);
            n = (Monhoc) q.uniqueResult();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return n;
    }
    
    public Monhoc getByTen(String ten) {
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where mh.tenMh = :ten"));
            q.setParameter("ten", ten);
            list = q.list();
            tst.commit();
        } catch (Exception e) {
            if (tst != null) {
                tst.rollback();
            }
            e.printStackTrace();
        }
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<Monhoc> getByTinhTrang(boolean GiangDay) {
        try {
            tst = session.beginTransaction();
            Query q = session.createQuery(getTable("where mh.dangGiangDay = :check"));
            q.setParameter("check", GiangDay);
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
