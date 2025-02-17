import java.io.IOException;
import java.util.Scanner;

public class HtmlAnalyzer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            String url = scanner.next();
            String htmlContent = HtmlProcess.fetchHTML(url);
            String resultText = HtmlProcess.readHTML(htmlContent);

            System.out.println(resultText);
        } catch (IOException e) {
            System.out.println("URL connection error");
        }
    }
}