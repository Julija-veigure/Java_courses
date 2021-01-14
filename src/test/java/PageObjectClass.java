import org.junit.jupiter.api.Test;
import pages.BaseFunс;
import pages.HomePage;

public class PageObjectClass {
    @Test
    public void tvnetPagesObjectTest() {
        BaseFunс baseFunс = new BaseFunс();
        baseFunс.openUrl("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunс);
        homePage.acceptCookies();
        homePage.openArticleById(3);
    }
}
