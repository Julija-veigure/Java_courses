package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class OpenPage {

    private final By TITLE_OPEN_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");

    private BaseFunс baseFunc;

    public OpenPage(BaseFunс baseFunс) {
        this.baseFunc = baseFunс;
    }

    public void getTitle () {
     String title = baseFunc.getText(TITLE_OPEN_PAGE);
    }
//    public void contains() {
//        Assertions.assertTrue( );
//    }
}

