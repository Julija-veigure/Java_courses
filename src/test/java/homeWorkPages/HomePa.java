package homeWorkPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePa {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private WebElement articleToClick;
    private BaFu baFu;

    public HomePa(BaFu baFu) {
        this.baFu = baFu;
    }

    public void acceptCookies() {
        baFu.click(ACCEPT_COOKIE_BTN);
    }

    public void findArticleById(int id) {
        articleToClick = baFu.findElements(ARTICLE).get(id);
    }

    public void getTitle() {
        String titleToCheck = articleToClick.findElement(TITLE).getText();
        LOGGER.info("Title from home: " + titleToCheck);
    }

    public void getCommCount() {
        int commentCount = 0;

        if (!articleToClick.findElements(COMMENTS_COUNT).isEmpty()) {
            String commentsToParse = articleToClick.findElement(COMMENTS_COUNT).getText();    //Title text (36)
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); //(36) -> 36
            commentCount = Integer.parseInt(commentsToParse);
            LOGGER.info("Comments count: " + commentCount);
        }
    }

    public void openArticle() {
        baFu.click(articleToClick);
    }
}
