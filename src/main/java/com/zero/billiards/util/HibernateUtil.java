package com.zero.billiards.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;

    static {
        try {
            //用xxx.hbm.xml形式配置实体映射
            //sessionFactory = new Configuration().configure().buildSessionFactory();
            //用Annotation形式配置实体映射
        	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        	//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}