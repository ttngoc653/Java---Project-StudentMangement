/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dal;

import com.dto.HibernateUtil;
import com.dto.Hocsinh;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jossion
 */
public class HocsinhHibernate {

    Session session = null;
    List<Hocsinh> lHs;

    public HocsinhHibernate() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Hocsinh> getAll() {
        lHs = new ArrayList<Hocsinh>();
        try {
            Transaction tst = session.beginTransaction();
            Query q = session.createQuery("from Hocsinh as hocsinh");
            lHs = (List<Hocsinh>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lHs;
    }
    
    public Hocsinh getById(int idHocSinh){
        Hocsinh hs=null;
        try {
            Transaction tst=session.beginTransaction();
            Query q=session.createQuery("from Hocsinh as hocsinh where hocsinh.idHocsinh="+idHocSinh);
            hs=(Hocsinh)q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hs;
    }
}
