package scraper;

import com.google.common.base.Preconditions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Scraper {

    String targetUrl;

    public Scraper(){

    }

    public Scraper(String targetUrl){
        this.targetUrl = targetUrl;
    }

    public Document scrape() {
        Preconditions.checkNotNull(this.targetUrl, "Starting targetUrl not defined");
        return this.scrape(this.targetUrl);
    }

    public Document scrape(String targetUrl) {
        try {
            Document doc = Jsoup.connect(targetUrl).get();
            return doc;
        } catch (IOException e) {
            return null;
        }
    }
}
