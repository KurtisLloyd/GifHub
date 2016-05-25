package Main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.net.URL;
import java.util.List;

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

    public void saveTransaction(Object o){
        session.save(o);
        session.getTransaction().commit();
    }

    public List writeQuery(String s){
        String hql = s;
        Query query = getSession().createQuery(hql);
        List results = query.list();

        return results;
    }

}
