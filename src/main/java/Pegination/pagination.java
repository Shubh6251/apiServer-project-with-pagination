package Pegination;

public class pagination {

    public void scrapeAllReviews(String url) {
        WebDriver driver = seleniumConfig.getDriver();
        driver.get(url);

        boolean hasNextPage = true;
        while (hasNextPage) {
            // Scrape reviews on the current page
            List<WebElement> reviews = driver.findElements(By.className("review"));

            for (WebElement review : reviews) {
                System.out.println("Review: " + review.getText());
            }

            // Check if "Next" button exists and click it
            List<WebElement> nextButton = driver.findElements(By.className("next-button"));
            if (!nextButton.isEmpty()) {
                nextButton.get(0).click();
            } else {
                hasNextPage = false;
            }
        }

        seleniumConfig.closeDriver();
    }
}
