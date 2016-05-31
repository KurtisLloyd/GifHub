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
        port(4567);
        String layout = "layout.vtl";
        List<User> queryResults = new ArrayList<>();

       HibernateQuery hibernateQuery = new HibernateQuery();
       queryResults = hibernateQuery.writeQuery("FROM User E WHERE E.id = 35 ");
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

        get("/usercreation", (request, response) -> {
            Map model = new HashMap();
            model.put("template", "usercreation.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/form", (request, response) -> {
            Map model = new HashMap();
            model.put("template", "form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/userdetector", (request, response) -> {
            UserCreation userCreation1 = new UserCreation();
            Map model = new HashMap();
            model.put("template", "userdetector.vtl");
            boolean createUser = userCreation1.userCreated(request.queryParams("Username"), request.queryParams("Password"));
            model.put("userCreated", createUser);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/detector", (request, response) -> {
            Login login = new Login();
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "detector.vtl");

            String Username = request.queryParams("Username");
            boolean isUsername =  login.loginUser(Username);
            model.put("loginUser", isUsername);
            model.put("Username", Username);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }

}

