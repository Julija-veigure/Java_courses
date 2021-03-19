package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.util.List;

public class BaseFunctions {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunctions() {
        LOGGER.info("Setting webdriver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void openUrl(String url) {
        LOGGER.info("Opening " + url + " web page");

        // || -> OR; && -> AND;

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);

//        if (url.startsWith("http://") || url.startsWith("https://")) {
//
//        } else {
//            url = "http://";
//        }
//        driver.get(url);
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

    public WebElement findElement(By locator) {
        LOGGER.info("Getting all elements by " + locator);
        return driver.findElement(locator);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(By locator, String text) {
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void select(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }


    public void closeBrowser() {
        LOGGER.info("Test done!");
        driver.quit();
    }
}

