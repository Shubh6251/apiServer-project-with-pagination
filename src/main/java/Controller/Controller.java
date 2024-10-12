package Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class Controller {

    @RestController
    @RequestMapping("/api")
    public class ReviewScraperController {

        @Autowired
        private ReviewScraperService scraperService;

        @PostMapping("/scrape-reviews")
        public String scrapeReviews(@RequestBody String url) {
            try {
                scraperService.scrapeAllReviews(url);
                return "Scraping completed successfully.";
            } catch (Exception e) {
                return "Error occurred: " + e.getMessage();
            }
        }
    }

}
