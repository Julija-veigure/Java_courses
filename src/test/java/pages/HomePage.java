package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By ACCEPT_COOKIE_BTN = By.xpath(".//div[@class = 'button cookie-notif__content--button']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");


    private BaseFunс baseFunc;
    //mans ieraksts //private WebElement articleToClick;
    private String title;

    public HomePage(BaseFunс baseFunс) {
        this.baseFunc = baseFunс;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIE_BTN);
    }

    public void openArticleById(int id) {
        WebElement articleToClick = baseFunc.findElements(TITLE).get(id);
        title = articleToClick.getText(); //mans ieraksts
        LOGGER.info(title); //mans ieraksts
        baseFunc.click(articleToClick);
    }
    //mans ieraksts
    public int comments() {
        int commentCount;
        commentCount = 0;
        title = title.substring(title.lastIndexOf("("), -1);
        //title = title.substring(0, title.indexOf(" (") - 1);
        commentCount = Integer.parseInt(title);
        LOGGER.info(commentCount);
        return commentCount;
    }
}