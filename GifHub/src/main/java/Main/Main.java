package Main; /**
 * Created by Kurtis Lloyd on 5/3/2016.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.ExportException;
import java.util.*;
import java.util.stream.Collectors;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import jdk.nashorn.internal.ir.RuntimeNode;
import spark.ModelAndView;
import spark.Request;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

public class Main {

    public static void main(String [] args){
        HTML html = new HTML();
        port(8080);
       //port(Integer.valueOf(System.getenv("PORT")));
       // String startingString = "Welcome to HEROKU THING I DID IT!";
       // get("home", (req, res) -> startingString);
        Map map = new HashMap<>();
        map.put("name", "Kurtis");
        map.put("object", "Object");
        get("/hello", ((request, response) -> new ModelAndView(map,"Templates/hello.mustache")), new MustacheTemplateEngine());
    }


}
