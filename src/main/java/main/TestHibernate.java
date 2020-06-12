package main;

import main.models.Language;
import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
        Language english = new Language();
        english.setName("english");
        english.setPictureName("not defined");
        Language japanese = new Language();
        japanese.setName("japanese");
        japanese.setPictureName("not defined");
        session.save(english);
        session.save(japanese);
        session.getTransaction().commit();
    }
}
