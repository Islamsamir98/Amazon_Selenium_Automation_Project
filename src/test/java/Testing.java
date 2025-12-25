import org.example.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class Testing {
    private WebDriver driver;
    private HomePage homePage;

    private String amazonzeurl = "https://www.amazon.eg/";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.navigateToURL(amazonzeurl);
    }

    @Test
    public void Test() throws InterruptedException {
        homePage.clickOnArrowButton();
        homePage.clickOnSignInButton();
        homePage.clickOnLogin_Mail("islamsamir615@gmail.com");
        homePage.clickOnContinueButton();
        homePage.clickOnPassword("Islam@461998");
        homePage.clickOnLoginButton();
       // homePage.clickOnNotNowButton();      // use this if the website asked about add phone number
        homePage.clickOnAllMenu();
        Thread.sleep(1500);
        homePage.clickOnSeeMore();
        Thread.sleep(1500);
        homePage.clickOnVideoGames();
        Thread.sleep(1500);
        List<WebElement> links = driver.findElements(
                By.xpath("//div[@id='hmenu-content']//a[normalize-space()='All Video Games']")
        );

// Click the FIRST VISIBLE one
        for (WebElement link : links) {
            if (link.isDisplayed()) {

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", link);

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", link);

                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage.clickOnFreeShipping();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage.clickOnNew();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage.clickOnDropDown();
        homePage.clickOnHighToLow();
        int maxPages = 5;
        boolean productAdded = false;

        for (int page = 1; page <= maxPages; page++) {

            // get all products on current page
            List<WebElement> products = driver.findElements(
                    By.cssSelector("div[data-component-type='s-search-result']")
            );

            for (int i = 0; i < products.size(); i++) {

                // re-fetch products to avoid stale elements
                products = driver.findElements(
                        By.cssSelector("div[data-component-type='s-search-result']")
                );

                WebElement product = products.get(i);

                try {
                    // get price
                    String priceText = product.findElement(By.cssSelector("[class='a-price-whole']"))
                            .getText().replace(",", "").trim();

                    int price = Integer.parseInt(priceText);

                    // check price condition
                    if (price < 15000) {

                        WebElement addToCartBtn =
                                product.findElement(By.xpath(".//button[@name='submit.addToCart']"));

                        // scroll into view
                        ((JavascriptExecutor) driver)
                                .executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);

                        addToCartBtn.click();



                        // small wait for Amazon overlay
                        Thread.sleep(1500);

                         // Close side cart if appears
                        List<WebElement> closeBtn =
                                driver.findElements(By.id("attach-close_sideSheet-link"));
                        if (!closeBtn.isEmpty()) {
                            closeBtn.get(0).click();
                        }

                    }

                } catch (Exception e) {
                    // skip products without price or button
                    continue;
                }
            }


            // move to next page
            try {
                WebElement nextPage = driver.findElement(By.cssSelector("[class='s-pagination-item s-pagination-next s-pagination-button s-pagination-button-accessibility s-pagination-separator']"));
                nextPage.click();
                Thread.sleep(2000);
            } catch (Exception e) {
                break; // no more pages
            }
        }
        homePage.AddToCart();
        homePage.ProceedToBuy();
        homePage.DeliverButton();
        homePage.PaymentButton();

    }
}
