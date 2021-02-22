import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BaFu;
import pages.CommentsPa;
import pages.HomePa;
import pages.ArticlePa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PageObjectJuliaTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void tvnetPagesObjectTest() {
        LOGGER.info("This test checks article titles and the number of comments");

        BaFu baFu = new BaFu();
        baFu.openUrl("http://tvnet.lv");

        HomePa homePa = new HomePa(baFu);
        homePa.acceptCookies();
        String homePageTitle = homePa.getArticleTextById(5);
        int commentsHomePage = homePa.getCommCount();

        ArticlePa articlePa = homePa.openArticle();
        String articlePageTitle = articlePa.getText();
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Error in article page");
        int commentsArticlePage = articlePa.countComments();
        Assertions.assertEquals(commentsHomePage, commentsArticlePage, "Different comments count in article page");

        CommentsPa commentsPa = articlePa.openComments();
        String commentsPageTitle =  commentsPa.getText();
        Assertions.assertEquals(articlePageTitle, commentsPageTitle, "Error in comments page");
        int commentsCount = commentsPa.countComments();
        Assertions.assertEquals(commentsHomePage, commentsCount, "Different comments count");

        baFu.closeWindow();
    }
}
