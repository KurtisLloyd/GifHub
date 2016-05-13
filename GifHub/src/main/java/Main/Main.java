package Main; /**
 * Created by Kurtis Lloyd on 5/3/2016.
 */
import java.net.URL;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Table;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import javax.transaction.*;
import javax.transaction.xa.XAResource;

import static spark.Spark.*;

public class Main {

    public static void main(String [] args){
        port(8082);
        staticFileLocation("http://localhost:8081/Images/GifHubBackground.jpg");
        staticFileLocation("http://localhost:8081/styles/style.css");

//        HibernateQuery hibernateQuery = new HibernateQuery();
//
//        hibernateQuery.makeTransaction();
//
//        User user = new User();
//        user.setId(3);
//        user.setPassword("ThisTestPasswordAgain");
//        user.setUserName("SecondTestUsernameAgain");
//
//        hibernateQuery.getSession().save(user);
//        hibernateQuery.getSession().getTransaction().commit();
//        hibernateQuery.endTrasaction();

      Map map = new HashMap<>();
        map.put("Username", "Grab from ORM database");
        map.put("id", "UserID");

        get("/hello", ((request, response) -> new ModelAndView(map,"Templates/hello.mustache")), new MustacheTemplateEngine());
        get("/login", (((request, response) -> new ModelAndView(map,"Templates/login.mustache"))), new MustacheTemplateEngine());


    }
}
