import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Scraper {
    private String link;
    private String filePath;

    public Scraper(String link, String filePath) {
        this.filePath = filePath;
        this.link = link;
    }

    public void start_scrape() {
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

    public void scrapeH1() {
        try {
            Document doc = Jsoup.connect(this.link).get();
            System.out.println("Scrapping has been done");

            FileWriter writer = new FileWriter(this.filePath+"\\h1_tags");

            Elements h3Tags = doc.select("h1");
            if (h3Tags.isEmpty()) {
                writer.write("No <h1> tags found\n\n");
            } else {
                for (Element h3 : h3Tags) {
                    writer.write(h3.text() + "\n");
                }
                writer.write("\n");
            }
            writer.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void scrapeH3() {
        try {
            Document doc = Jsoup.connect(this.link).get();
            System.out.println("Scrapping has been done");

            FileWriter writer = new FileWriter(this.filePath + "\\h3_tags");

            Elements h3Tags = doc.select("h3");
            if (h3Tags.isEmpty()) {
                writer.write("No <h3> tags found\n\n");
            } else {
                for (Element h3 : h3Tags) {
                    writer.write(h3.text() + "\n");
                }
                writer.write("\n");
            }
            writer.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void scrapeLinks() {
        try {
            Document doc = Jsoup.connect(this.link).get();
            System.out.println("Scrapping has been done");

            FileWriter writer = new FileWriter(this.filePath+"\\links");
            Elements links = doc.select("a[href]");
            if (links.isEmpty()) {
                writer.write("No <a> tags found\n");
            } else {
                for (Element link : links) {
                    writer.write("Text : " + link.text() + "\n");
                    writer.write("URL  : " + link.attr("abs:href") + "\n\n");
                }
            }
            writer.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}