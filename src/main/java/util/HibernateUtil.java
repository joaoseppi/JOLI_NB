/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import crud.DaoGenerico;
import crud.DaoLogs;
import model.Error_logs;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author JGSS
 */
public class HibernateUtil {

    private static Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
    configuration.getProperties()).build();
    
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            String er = "util.HibernateUtil.SessionFactory";
            DaoLogs dl = new DaoLogs();
            dl.insert(er, ex.toString());
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
