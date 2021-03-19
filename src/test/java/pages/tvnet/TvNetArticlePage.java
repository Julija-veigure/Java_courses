package pages.tvnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.BaseFunctions;

public class TvNetArticlePage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    int count;

    private final By TITLE_OPEN_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COM_OPEN_PAGE = By.xpath(".//a[contains(@class, 'article-share__item article-share__item--comments')]");


    private BaseFunctions baseFunctions;

    public TvNetArticlePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getText() {
        LOGGER.info("Title from article page: " + baseFunctions.getText(TITLE_OPEN_PAGE));
       return baseFunctions.getText(TITLE_OPEN_PAGE);

    }

    public int countComments() {
            LOGGER.info("Comments count: " + baseFunctions.getText(COM_OPEN_PAGE));
            String comCount = baseFunctions.getText(COM_OPEN_PAGE);
            return count = Integer.parseInt(comCount);
    }
//    public int countComments() {
//
//        int count = 0;
//        if (!baseFunctions.getText(COM_OPEN_PAGE).isEmpty()) {
//            String comCount = baseFunctions.getText(COM_OPEN_PAGE);
//            LOGGER.info("Comments count: " + baseFunctions.getText(COM_OPEN_PAGE));
//        }
//        return count = Integer.parseInt(comCount);
//    }

    public TvNetCommentsPage openComments() {
        LOGGER.info("Opens new page");
        baseFunctions.click(COM_OPEN_PAGE);
        return new TvNetCommentsPage(baseFunctions);
    }
}

