package com.klu.HibernateCRUDoperation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Device device = new Device();
        device.setBrand("Generic");
        device.setModel("Model-X");
        device.setPrice(100.0);
        session.save(device);

        Smartphone sm = new Smartphone();
        sm.setBrand("Samsung");
        sm.setModel("Galaxy S23");
        sm.setPrice(999.0);
        sm.setOperatingSystem("Android");
        sm.setCameraResolution("108 MP");
        session.save(sm);

        Tablet t = new Tablet();
        t.setBrand("Apple");
        t.setModel("iPad");
        t.setPrice(1199.0);
        t.setScreenSize("12.9 inches");
        t.setBatteryLife("10 hours");
        session.save(t);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully");
    }
}
