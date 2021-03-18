import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.tvnet.BaseFunctions;
import pages.tvnet.TvNetCommentsPage;
import pages.tvnet.TvNetHomePage;
import pages.tvnet.TvNetArticlePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TvNetPageObjectsTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void tvnetPagesObjectTest() {
        LOGGER.info("This test checks article titles and the number of comments");

        BaseFunctions baseFunctions = new BaseFunctions();
        baseFunctions.openUrl("http://tvnet.lv");

        TvNetHomePage tvNetHomePage = new TvNetHomePage(baseFunctions);
        tvNetHomePage.acceptCookies();
        String homePageTitle = tvNetHomePage.getArticleTextById(2);
        int commentsHomePage = tvNetHomePage.getCommCount();

        TvNetArticlePage tvNetArticlePage = tvNetHomePage.openArticle();
        String articlePageTitle = tvNetArticlePage.getText();
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Error in article page");
        int commentsArticlePage = tvNetArticlePage.countComments();
        Assertions.assertEquals(commentsHomePage, commentsArticlePage, "Different comments count in article page");

        TvNetCommentsPage commentsPa = tvNetArticlePage.openComments();
        String commentsPageTitle =  commentsPa.getText();
        Assertions.assertEquals(articlePageTitle, commentsPageTitle, "Error in comments page");
        int commentsCount = commentsPa.countComments();
        Assertions.assertEquals(commentsHomePage, commentsCount, "Different comments count");

        baseFunctions.closeWindow();
    }
}
