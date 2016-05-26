package Main; /**
 * Created by Kurtis Lloyd on 5/3/2016.
 */
import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Mod;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import javax.management.Query;

import static spark.Spark.*;


public class Main {
   static String FinalUsername;

    public static void main(String [] args){
        port(8082);
        
        String layout = "layout.vtl";
        List<User> queryResults = new ArrayList<>();

       HibernateQuery hibernateQuery = new HibernateQuery();
       queryResults = hibernateQuery.writeQuery("FROM User E WHERE E.id = 5");
            User EndUser = new User();
        for (User u: queryResults
             ) {
            EndUser = u;
        }
        final User endEnduser = EndUser;



       get("/", (request, response) -> {
           Map model = new HashMap();
           model.put("Username", endEnduser.getUserName());
           model.put("Password", endEnduser.getPassword());
           model.put("template", "hello.vtl");

           return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

        get("/login", (request, response) -> {
        Map model = new HashMap();
            model.put("template", "login.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



        get("/form", (request, response) -> {
            Map model = new HashMap();
            model.put("template", "form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/detector", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "detector.vtl");
            writeUserToDatabase(request.queryParams("Username"));
            String Username =  getUsername(request.queryParams("Username"));
            boolean isUsername =  loginUser(Username);

            model.put("loginUser", isUsername);
            model.put("Username", Username);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }


    public static Boolean loginUser(String username) {

        writeUserToDatabase(username);
        HibernateQuery hibernateQuery = new HibernateQuery();
        List<User> userList = hibernateQuery.writeQuery("From User E where E.Username =" + username);
        User user = new User();
        for (User u : userList
                ) {
            user = u;
        }
        final User finalUser = user;


        if (username.equals(finalUser.getUserName())) {
            return true;
        } else {
            return false;
        }
    }
    public static String getUsername(String username) {
        HibernateQuery hibernateQuery = new HibernateQuery();
        List<User> userList = hibernateQuery.writeQuery("From User E where E.Username =" + username);
        User user = new User();
        for (User u : userList
                ) {
            user = u;
        }
        final User finalUser = user;

        return finalUser.getUserName();
    }
        public static void writeUserToDatabase(String username) {
        User user = new User();
            user.setUserName(username);

            HibernateQuery hibernate = new HibernateQuery();
            hibernate.getSession().save(user);
            hibernate.getSession().getTransaction().commit();
            hibernate.endTrasaction();

    }

    }

