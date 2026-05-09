import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.FileWriter;
import java.io.IOException;

public class Scraper {
    private String link;
    private String filePath;
    public Scraper(String link, String filePath){
        this.filePath = filePath;
        this.link = link;
    }
    public void start_scrape(){
        try {
            Document doc = Jsoup.connect(this.link).get();
            System.out.println("Scrapping has been done");

            FileWriter writer = new FileWriter(this.filePath);
            writer.write(doc.toString());
            writer.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}