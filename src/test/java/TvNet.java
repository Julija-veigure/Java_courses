
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.NewSessionPayload;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TvNet {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@class = 'notification__button']");
    private final By NEWS = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_NEWS = By.xpath(".//a[contains(@class,'-share__item article-share__item--comments')]");
    private final By ALL_NEWS = By.cssSelector(".//list-article__headline");


    @Test
    public void homeworkTvnet() {
        String title = "Nosaukti turīgākie cilvēki Latvijā";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        List<WebElement> articles = driver.findElements(NEWS);

 //       for (int i = 0; i < articles.size(); i++) {
 //           String currentTitle = articles.get(i).getText();

 //           if (currentTitle.startsWith(title)) {
  //          articles.get(i).click();
 //               break;
 //                 }
 //       }
        //System.out.println(i + " " + articles.get(i).getText());
        for (WebElement we : articles)  {
            if (we.getText().startsWith(title)) {
                we.click();
                break;
            }
        }

        //driver.quit();

        System.out.println("Test DONE!");

        }
    }
