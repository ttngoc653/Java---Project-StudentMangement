/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Jossion
 */
public class HocsinhDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public HocsinhDAO() {

        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(dto.Hocsinh.class);
        config.addResource("dto/Hocsinh.hbm.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }
    
    public List listUsers()
    {
        Session sesn = factory.openSession();
        Transaction tx = null;
        List l = new ArrayList();
        try{
            tx = sesn.beginTransaction();
            l = (List)sesn.createQuery("From Hocsinh").list();
            tx.commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sesn.close();
        }
         
        return l;
    }
}
