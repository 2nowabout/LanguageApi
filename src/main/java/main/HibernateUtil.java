package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    final Session session = HibernateUtil.getHibernateSession();

    public static Session getHibernateSession() {

        final SessionFactory sf = new Configuration()
                .configure(new File("src/main/resources/hibernate.cfg.xml")).buildSessionFactory();

        // factory = new Configuration().configure().buildSessionFactory();
        final Session session = sf.openSession();
        return session;
    }
}
