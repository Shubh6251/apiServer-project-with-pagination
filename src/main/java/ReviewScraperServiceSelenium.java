import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class ReviewScraperServiceSelenium {
        @Autowired
        private SeleniumConfig seleniumConfig;

        public void scrapeDynamicReviews(String url) {
            WebDriver driver = seleniumConfig.getDriver();
            driver.get(url);

            // Wait for reviews section to load (this might require fine-tuning)
            List<WebElement> reviews = driver.findElements(By.className("review"));

            for (WebElement review : reviews) {
                System.out.println("Review: " + review.getText());
            }

            seleniumConfig.closeDriver();
        }
    }

}
