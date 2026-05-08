import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        Document doc = Jsoup.connect("https://books.toscrape.com").get();

        System.out.println("Scrapping has been done");
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write(doc.toString());
            writer.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}