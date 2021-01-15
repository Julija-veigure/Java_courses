package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.locks.Condition;

public class BaseFunс {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;
    private String title;



    public BaseFunс() {
        LOGGER.info("Setting webdriver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void openUrl(String url) {
        LOGGER.info("Opening " + url + " web page");
        driver.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void click(WebElement we) {
        wait.until(ExpectedConditions.elementToBeClickable(we));
        we.click();

    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Getting all elements by " + locator);
        return driver.findElements(locator);
    }

    public String getText(By locator) {
        title = driver.findElement(locator).getText();
        LOGGER.info(title);
        return title;
    }


//    int commentCount = 0;
//
//        if (!currentArticle.findElements(COMMENTS_COUNT).isEmpty()) {
//                String commentsToParse = currentArticle.findElement(COMMENTS_COUNT).getText();    //Title text (36)
//                commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); //(36) -> 36
//                commentCount = Integer.parseInt(commentsToParse);
//                }
}