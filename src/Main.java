import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            String url = "http://hiring.axreng.com/internship/example1.html";
            System.out.println(HtmlProcess.fetchHTML(url));
        } catch (IOException e) {
            System.out.println("Error acessing the URL");
        }
    }
}