
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ReviewScraperService {

    public Elements scrapeStaticReviews(String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        // Assuming reviews are inside elements with class 'review'
        return doc.select(".review");
    }
}

