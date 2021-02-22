package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ArticlePa {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    int count;

    private final By TITLE_OPEN_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COM_OPEN_PAGE = By.xpath(".//a[contains(@class, 'article-share__item article-share__item--comments')]");


    private BaFu baFu;

    public ArticlePa(BaFu baFu) {
        this.baFu = baFu;
    }

    public String getText() {
        LOGGER.info("Title from article page: " + baFu.getText(TITLE_OPEN_PAGE));
       return baFu.getText(TITLE_OPEN_PAGE);

    }

    public int countComments() {
            LOGGER.info("Comments count: " + baFu.getText(COM_OPEN_PAGE));
            String comCount = baFu.getText(COM_OPEN_PAGE);
            return count = Integer.parseInt(comCount);
    }
//    public int countComments() {
//
//        int count = 0;
//        if (!baFu.getText(COM_OPEN_PAGE).isEmpty()) {
//            String comCount = baFu.getText(COM_OPEN_PAGE);
//            LOGGER.info("Comments count: " + baFu.getText(COM_OPEN_PAGE));
//        }
//        return count = Integer.parseInt(comCount);
//    }

    public CommentsPa openComments() {
        LOGGER.info("Opens new page");
        baFu.click(COM_OPEN_PAGE);
        return new CommentsPa(baFu);
    }
}

