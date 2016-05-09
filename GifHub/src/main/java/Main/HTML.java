package Main;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Kurtis Lloyd on 5/5/2016.
 */
public class HTML {

    public String renderContent(String htmlFIle)
    {
        try{
            URL url = getClass().getResource(htmlFIle);

            Path path = Paths.get(url.toURI());
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
