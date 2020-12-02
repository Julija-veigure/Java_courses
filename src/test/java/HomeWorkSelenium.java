
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class HomeWorkSelenium   {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@class = 'notification__button']");
    private final By NEWS = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_NEWS = By.xpath(".//a[@class = 'article-share__item article-share__item--comments article-share__item-with-count']");
    // .//span[@class = 'article-share__item--count']
    // .//a[@class = 'article-share__item article-share__item--comments article-share__item-with-count']
    private final By ALL_NEWS = By.xpath(".//span[@itemprop = 'headline name']");


    @Test
    public void homeworkTvnet()  {
        //"Homework Nr.1
        // Open web www.tvnet.lv; Click accept bt`n; Open the news; Open new comments;

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        WebElement openNews = driver.findElement(NEWS);
        openNews.click();

        WebElement listOfComments = driver.findElement(COMMENTS_NEWS);
        listOfComments.click();



        driver.quit();

        System.out.println("Test DONE!");

    }}
