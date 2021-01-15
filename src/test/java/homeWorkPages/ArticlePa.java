package homeWorkPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ArticlePa {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By TITLE_OPEN_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COM_OPEN_PAGE = By.xpath(".//a[contains(@class, 'article-share__item article-share__item--comments')]");

    private BaFu baFu;

    public ArticlePa(BaFu baFu) {
        this.baFu = baFu;
    }

    public void getTitle() {

        String title = baFu.getTitle(TITLE_OPEN_PAGE);
        LOGGER.info("Title from article page: " + title);
    }

    public void openComments() {
        baFu.click(COM_OPEN_PAGE);
    }
}

