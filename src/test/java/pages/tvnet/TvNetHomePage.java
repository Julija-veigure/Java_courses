package pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunctions;

public class TvNetHomePage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private BaseFunctions baseFunctions;
    private WebElement articleToClick;

    public TvNetHomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void acceptCookies() {
        baseFunctions.click(ACCEPT_COOKIE_BTN);
    }

    public String getArticleTextById(int id) {
        articleToClick = baseFunctions.findElements(ARTICLE).get(id);
        LOGGER.info("Title from home page: " + articleToClick.findElement(TITLE).getText());
        return articleToClick.findElement(TITLE).getText();
    }

    public int getCommCount() {
        int commentCount = 0;

        if (!articleToClick.findElements(COMMENTS_COUNT).isEmpty()) {
            String commentsToParse = articleToClick.findElement(COMMENTS_COUNT).getText();    //Title text (36)
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); //(36) -> 36
            commentCount = Integer.parseInt(commentsToParse);
            LOGGER.info("Comments count: " + commentCount);
        }
        return commentCount;
    }

    public TvNetArticlePage openArticle() {
        LOGGER.info("Opens new page");
        baseFunctions.click(articleToClick);
        return new TvNetArticlePage(baseFunctions);
    }
}
