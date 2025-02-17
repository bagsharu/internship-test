import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            String url = "http://hiring.axreng.com/internship/example1.html";
            String htmlContent = HtmlProcess.fetchHTML(url);
            String resultText = HtmlProcess.readHTML(htmlContent);

            System.out.println(resultText);
        } catch (IOException e) {
            System.out.println("Error acessing the URL");
        }
    }
}