package Main;

/**
 * Created by Kurtis Lloyd on 5/16/2016.
 */
import java.util.List;

import static spark.Spark.*;
public class Login {


    public static Boolean loginUser(String username) {

        HibernateQuery hibernateQuery = new HibernateQuery();
        List<User> userList = hibernateQuery.writeQuery("FROM User E WHERE E.userName = " + username );
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
}
