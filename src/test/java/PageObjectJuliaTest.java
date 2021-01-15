import homeWorkPages.BaFu;
import homeWorkPages.CommentsPa;
import homeWorkPages.HomePa;
import homeWorkPages.ArticlePa;
import org.junit.jupiter.api.Test;

public class PageObjectJuliaTest {
    @Test
    public void tvnetPagesObjectTest() {
        BaFu baFu = new BaFu();
        baFu.openUrl("http://tvnet.lv");

        HomePa homePa = new HomePa(baFu);
        homePa.acceptCookies();
        homePa.findArticleById(1);
        homePa.getTitle();
        homePa.getCommCount();
        homePa.openArticle();

        ArticlePa articlePa = new ArticlePa(baFu);
        articlePa.getTitle();
        //???.compareTitles();
        articlePa.openComments();

        CommentsPa commentsPa = new CommentsPa(baFu);
        commentsPa.countComments();
        //???.compareComments();
        commentsPa.getTitle();
        //???.compareTitles();
    }
}
