import java.io.IOException;
import java.net.URL;

public class HtmlProcess {

    // This class is responsible for manipulating the HTML from the user

    // This method recieves an URL and
    public static  String fetchHTML(String urlRecieved) throws IOException {

        // This object will be used to store the HTML structure
        StringBuilder contentHTML = new StringBuilder();
        URL url = new URL(urlRecieved);
    }
}
