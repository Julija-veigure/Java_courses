import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWork2 {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//div[@class = 'button cookie-notif__content--button']");
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private final By TITLE_OPEN_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COM_OPEN_PAGE = By.xpath(".//a[contains(@class, 'article-share__item article-share__item--comments')]");

    private final By COMMENTS_LIST = By.xpath(".//div[@class = 'article-comment__container']");
    private final By TITLE_COM_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");

    private final Logger LOGGER = LogManager.getLogger(FullTest.class);

    @Test

    public void titleCommentsCheck() {
        LOGGER.info("This test is checking titles and comments");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("We are opening browser window");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        LOGGER.info("Find article");
        WebElement currentArticle = driver.findElements(ARTICLE).get(2);

        LOGGER.info("Story title");
        String titleToCheck = currentArticle.findElement(TITLE).getText();

        LOGGER.info("Story comment count");
        int commentCount = 0;

        if (!currentArticle.findElements(COMMENTS_COUNT).isEmpty()) {
            String commentsToParse = currentArticle.findElement(COMMENTS_COUNT).getText();    //Title text (36)
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); //(36) -> 36
            commentCount = Integer.parseInt(commentsToParse);
        }

        LOGGER.info("Open article");
        currentArticle.findElement(TITLE).click();

        LOGGER.info("Find story title in open page");
        String titleFromOpenPage = driver.findElement(TITLE_OPEN_PAGE).getText();

        LOGGER.info("Compare titles:\n" + titleFromOpenPage + "\n" + titleToCheck);

        LOGGER.info("Open comments page");
        driver.findElement(COM_OPEN_PAGE).click();

        LOGGER.info("Find story title in comments page");
        String titleFromCommentPage = driver.findElement(TITLE_COM_PAGE).getText();

        LOGGER.info("Compare titles:\n" + titleFromCommentPage + "\n" + titleToCheck);
        Assertions.assertTrue(titleToCheck.startsWith(titleFromCommentPage));

        LOGGER.info("Count real comments");
        List<WebElement> comments = driver.findElements(COMMENTS_LIST);

        LOGGER.info("Compare comments count : " + "\n" + commentCount + "\n" + comments.size());
        Assertions.assertEquals(commentCount, comments.size());

        driver.quit();

        //1 _________________________If comments are not empty - delete comments count____________________________________
//        if (!currentArticle.findElements(COMMENTS).isEmpty()) {
//            currentArticle.findElement(TITLE).click();
//            titleToCheck = titleToCheck.substring(0, titleToCheck.lastIndexOf(" ("));
//            String titleFromOpenPage = driver.findElement(TITLE_PAGE).getText();
//            Assertions.assertEquals(titleToCheck, titleFromOpenPage, "Incorrect Title!");
//        }

//2 _________________________If comments are not empty - replace comments count____________________________________
//        if (!currentArticle.findElements(COMMENTS).isEmpty()) {
//        currentArticle.findElement(TITLE).click();
//        String delComCount = (" (" + commentsToParse + ")");
//        titleToCheck = titleToCheck.replace(delComCount, "" );
//        Assertions.assertEquals(titleToCheck, titleFromOpenPage, "Incorrect Title!");

    }
}

