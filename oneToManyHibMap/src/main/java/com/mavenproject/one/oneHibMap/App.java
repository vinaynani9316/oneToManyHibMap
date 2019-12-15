package com.mavenproject.one.oneHibMap;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Configuration config= new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
       
      ServiceRegistry registry= new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
       
       SessionFactory sf= config.buildSessionFactory(registry);
       
       Session session=sf.openSession();
       
       session.beginTransaction();
       
       Alien a1= (Alien) session.get(Alien.class, 1);
       
       System.out.println(a1.getAname());
       
       Collection<Laptop> laps= a1.getLaps();
       
       for(Laptop l: laps)
       {
    	   System.out.println(l);
       }
//       session.update(a1);
       session.getTransaction().commit();
    }
}
