import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlProcess {

    // This class is responsible for manipulating the HTML from the user

    // This method recieves an URL and
    public static  String fetchHTML(String urlRecieved) throws IOException {

        // This object will be used to store the HTML structure
        StringBuilder contentHTML = new StringBuilder();
        URL url = new URL(urlRecieved);

        // This block is used for fecthing the HTML

        // With the usage of a BuffReader we efficiently read through the lines of the fectched data
        // The "url.openStream()" connects to the url and returns data (bytes) from it, which is converted
        // to text with the InputSream?Reader.
        try (BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()))) {

            // This while block reades the HTML content line by line, then it adds to the context variable
            // following the structure of a HTML block, by inputting the lines individually.
            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                contentHTML.append(inputLine).append("\n");
            }
        }

        // Returns a String with the HTML
        return contentHTML.toString();

    }

    // This method will read the HTML and find the text within the deepest level of the given HTML
    public static String readHTML(String htmlRecieved) {

    }
}
