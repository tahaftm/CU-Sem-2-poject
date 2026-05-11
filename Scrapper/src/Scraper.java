import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Scraper {
    private String link;
    private String filePath;
    private Document doc;

    public Scraper(String link, String filePath) {
        this.filePath = filePath;
        this.link = link;
        System.out.println("FILE PATH = " + filePath);

        try {
            this.doc = Jsoup.connect(this.link).get();
        } catch (IOException e) {
            System.out.println("Failed to load page: " + e.getMessage());
        }
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
    private void saveToFile(String data, String type) {
        try (FileWriter writer = new FileWriter(filePath + "\\" + type + ".txt", true)) {
            System.out.println("Writing file in progress");
            writer.write(data);
            writer.write("\n");
            System.out.println("Writing file completed");


        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }

    public String scrapeH1() {
        StringBuilder result = new StringBuilder();
        Elements h1Tags = doc.select("h1");
        if (h1Tags.isEmpty()) {
            result.append("No H1 tags found");
        } else {
            for (Element h1 : h1Tags) {
                result.append(h1.text()).append("\n");
            }
        }
        saveToFile("H1 TAGS:\n" + result, "H1");
        return result.toString();
    }


    public String scrapeH3() {
        StringBuilder result = new StringBuilder();
        Elements h3Tags=doc.select("h3");
        if (h3Tags.isEmpty()) {
            result.append("No H3 tags found");
        } else {
            for (Element h3 : h3Tags) {
                result.append(h3.text()).append("\n");
            }
        }
        saveToFile("H3 TAGS:\n" + result , "H3");
        return result.toString();
    }

    public String scrapeLinks() {
        StringBuilder result = new StringBuilder();
        Elements links = doc.select("a[href]");
        if (links.isEmpty()) {
            result.append("No links found");
        } else {
            for (Element link : links) {
                result.append("Text : ").append(link.text()).append("\n");
                result.append("URL : ").append(link.attr("abs:href")).append("\n\n");
            }
        }
        saveToFile("Links:\n" + result, "Links");
        return result.toString();
    }

}