
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class TvNet {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@class = 'notification__button']");
    private final By NEWS = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_NEWS = By.xpath(".//a[contains(@class,'-share__item article-share__item--comments')]");
    private final By ALL_NEWS = By.cssSelector(".//list-article__headline");
    private final String TITLE = "Tā Jauno gadu sagaidīja sabiedrībā pazīstami ļaudis ";


    @Test
    public void homeworkTvnet() {


        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        List<WebElement> articles = driver.findElements(NEWS);



            //      ja vēlos konkrētu skaitu ar virsrakstiem, piemēram 6, tad:
            //         for (int i = 0; i < articles.size(); i++) {
            for (int i = 0; i < articles.size(); i++) {
                // Izdrukā visu sarakstu.uzdrukā saraksta tekstu.
                //System.out.println(i + ": " + articles.get(i).getText());
                if (articles.get(i).getText().startsWith(TITLE)) {
                    articles.get(i).click();
                    break;
                }
            }
 /*       //System.out.println(i + " " + articles.get(i).getText());
        for (WebElement we : articles)  {
            if (we.getText().startsWith(title)) {
                we.click();

            }
        }

   */

        System.out.println(articles.size());
  //      System.out.println(articles.get(3).getText());
        System.out.println("Test DONE!");
 //       driver.quit();
    }
}



