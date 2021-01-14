package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//div[@class = 'button cookie-notif__content--button']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private BaseFunс baseFunc;

    public HomePage(BaseFunс baseFunс) {
        this.baseFunc = baseFunс;
    }
    public void acceptCookies (){
        baseFunc.click(ACCEPT_COOKIE_BTN);
    }
    public void openArticleById(int id) {
       WebElement articleToClick = baseFunc.findElements(TITLE).get(id);
       baseFunc.click(articleToClick);

    }
}
