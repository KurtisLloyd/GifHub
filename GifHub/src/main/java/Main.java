/**
 * Created by Kurtis Lloyd on 5/3/2016.
 */
import static spark.Spark.*;
public class Main {

    public static void main(String [] args){
        get("/hello", (req, res) -> "Hello World");
    }
}
