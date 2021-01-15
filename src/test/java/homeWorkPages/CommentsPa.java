package homeWorkPages;

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

    public void getTitle() {

        String title = baFu.getTitle(TITLE_COM_PAGE);
        LOGGER.info("Title from comments page: " + title);
    }

    public int countComments() {
        int com = baFu.findElements(COMMENTS_LIST).size();
        LOGGER.info("Comments count from list: " + com);
        return com;
    }
}
