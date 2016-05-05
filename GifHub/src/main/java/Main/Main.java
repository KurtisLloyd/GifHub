package Main; /**
 * Created by Kurtis Lloyd on 5/3/2016.
 */
import static spark.Spark.*;
public class Main {

    public static void main(String [] args){
        port(Integer.valueOf(System.getenv("PORT")));
        String startingString = "Welcome to HEROKU THING I DID IT!";
        get("home", (req, res) -> startingString);


    }
    public static int getHerokuAssignedPort(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        if(processBuilder.environment().get("PORT") != null){
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
}
