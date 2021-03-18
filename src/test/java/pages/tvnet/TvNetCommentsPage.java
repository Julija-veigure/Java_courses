package pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.tvnet.BaseFunctions;

public class TvNetCommentsPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By COMMENTS_LIST = By.xpath(".//div[@class = 'article-comment__container']");
    private final By TITLE_COM_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");

    private BaseFunctions baseFunctions;

    public TvNetCommentsPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getText() {
        LOGGER.info("Title from comments page: " + baseFunctions.getText(TITLE_COM_PAGE));
        return baseFunctions.getText(TITLE_COM_PAGE);
    }

    public int countComments() {
        LOGGER.info("Comments count from list: " + baseFunctions.findElements(COMMENTS_LIST).size());
        return baseFunctions.findElements(COMMENTS_LIST).size();

    }
}
