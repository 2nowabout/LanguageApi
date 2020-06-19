package main;

import main.models.Assignment;
import main.models.Language;
import main.models.User;
import org.hibernate.Session;

import java.awt.*;
import java.util.Collection;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
        Language english = new Language();
        english.setName("English");
        english.setPictureName("not defined");
        Assignment assignment1 = new Assignment();
        Assignment assignment2 = new Assignment();
        Assignment assignment3 = new Assignment();
        Assignment assignment4 = new Assignment();
        assignment1.setTitle("Assignment 1");
        assignment1.setDescription("Welcome! First Lesson English");
        assignment1.setPictureName("Not Defined");
        assignment1.setLanguage(english);
        assignment2.setTitle("Assignment 1");
        assignment2.setDescription("Welcome! First Lesson English");
        assignment2.setPictureName("Not Defined");
        assignment2.setLanguage(english);
        assignment3.setTitle("Assignment 1");
        assignment3.setDescription("Welcome! First Lesson English");
        assignment3.setPictureName("Not Defined");
        assignment3.setLanguage(english);
        assignment4.setTitle("Assignment 1");
        assignment4.setDescription("Welcome! First Lesson English");
        assignment4.setPictureName("Not Defined");
        assignment4.setLanguage(english);
        Language japanese = new Language();
        japanese.setName("Japanese");
        japanese.setPictureName("not defined");
        session.save(english);
        session.save(japanese);
        session.getTransaction().commit();
    }
}
