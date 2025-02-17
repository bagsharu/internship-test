import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlProcess {

    // This class is responsible for manipulating the HTML from the user

    // This method recieves an URL and
    public static String fetchHTML(String urlRecieved) throws IOException {

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

        // These variables are used in the process of reading the HTML and finding the text

        // transforms the html in string format into an array separating the lines into indexes
        String[] linesHTML = htmlRecieved.split("\n");

        // This stack is used to organize the multiple lines of the HTML
        Stack<String> stack = new Stack<>();

        // These "depth" variables control the level of the html, it's helpful for managing which text will be output
        // The values will be changed as the program reads through the various levels of the html
        int currentDepth = 0;
        int maxDepth = -1;

        // These are used to store the text found and control if there's a malformation in the html structure
        String textFound = null;
        boolean malformed = false;

        // With the usage of regular expressions we can identify the multiple tags and help the program identify it.
        Pattern openTag = Pattern.compile("<(\\w+)>");
        Pattern closeTag = Pattern.compile("</(\\w+)>");

        // This loop goes through the entire HTML, ignoring blank spaces
        for (String line : linesHTML) {
            line = line.trim();

            if(line.isEmpty())
                continue;

            // The Matcher objects compare the tags to the regular expressions
            Matcher openMatcher = openTag.matcher(line);
            Matcher closeMatcher = closeTag.matcher(line);

            // This checks if there's an open tag, if it's true, the tag is pushed into the stack and the depth is increaed
            if (openMatcher.find()) {
                stack.push(openMatcher.group(1));
                currentDepth++;
            }
            // If there's a close Tag, it's compared to the open Tag, if there's a match, it will consider the tag closed and removed from the stack
            else if (closeMatcher.find()) {
                if (!stack.isEmpty() && stack.peek().equals(closeMatcher.group(1))) {
                    // Tag is removed from the stack since it's closed properly
                    stack.pop();
                    // Decrease the depth because the tags were closed
                    currentDepth--;
                } else {
                    // If there's no matching tags, the HTML is considered malformed
                    malformed = true;
                    break;
                }
            }

            else {
                // If the line is not a tag, it's a text.
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                    textFound = line;
                }
            }



        }
    }
}
