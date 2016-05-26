package Main; /**
 * Created by Kurtis Lloyd on 5/3/2016.
 */
import java.util.*;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import javax.management.Query;

import static spark.Spark.*;

public class Main {

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
//
//      hibernateQuery.makeTransaction();
//
//        User user = new User();
//        user.setId(3);
//        user.setPassword("ThisTestPasswordAgain");
//        user.setUserName("SecondTestUsernameAgain");
//
//        hibernateQuery.getSession().save(user);
//        hibernateQuery.getSession().getTransaction().commit();
//        hibernateQuery.endTrasaction();


//      Map map = new HashMap<>();
//        map.put("Username", "Grab from ORM database");
//        map.put("id", "UserID");

//        get("/hello", ((request, response) -> new ModelAndView(map,"Templates/hello.vtl")), new MustacheTemplateEngine());
      //  get("/login", (((request, response) -> new ModelAndView(map,"Templates/login.vtl"))), new MustacheTemplateEngine());


    }
}
