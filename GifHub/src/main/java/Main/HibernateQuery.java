package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.net.URL;

/**
 * Created by Kurtis Lloyd on 5/13/2016.
 */
public class HibernateQuery {

    SessionFactory sessionFactory;
    Session session;

    public HibernateQuery(){
        startHibernateQuery();
    }


    public void startHibernateQuery(){
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        URL configURL = Main.class.getResource("/hibernate.cfg.xml");
        configuration.configure(configURL);

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();

    }

    public void makeTransaction(){
        session.beginTransaction();

    }

    public void endTrasaction(){
        session.close();
    }

    public Session getSession(){
        return session;
    }

}
