import org.junit.jupiter.api.Test;
import pages.BaseFunс;
import pages.HomePage;
import pages.OpenPage;

public class PageObjectTest {
    @Test
    public void tvnetPagesObjectTest() {
        BaseFunс baseFunс = new BaseFunс();
        baseFunс.openUrl("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunс);
        homePage.acceptCookies();
        homePage.openArticleById(3);
        //homePage.comments();

        OpenPage openPage = new OpenPage(baseFunс);
        openPage.getTitle();
        //baseFunс.contains();

    }
}
