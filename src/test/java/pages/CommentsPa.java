package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CommentsPa {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By COMMENTS_LIST = By.xpath(".//div[@class = 'article-comment__container']");
    private final By TITLE_COM_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");

    private BaFu baFu;

    public CommentsPa(BaFu baFu) {
        this.baFu = baFu;
    }

    public String getText() {
        LOGGER.info("Title from comments page: " + baFu.getText(TITLE_COM_PAGE));
        return baFu.getText(TITLE_COM_PAGE);
    }

    public int countComments() {
        LOGGER.info("Comments count from list: " + baFu.findElements(COMMENTS_LIST).size());
        return baFu.findElements(COMMENTS_LIST).size();

    }
}
