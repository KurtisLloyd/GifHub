package Main;

/**
 * Created by Kurtis Lloyd on 5/16/2016.
 */
import static spark.Spark.*;
public class Login {
    User user;

    public Login(){
        staticFileLocation("/hello");
        webSocket("/login", LoginSocketHandler.class);
    }
}
