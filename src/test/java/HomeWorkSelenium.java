
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomeWorkSelenium   {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@class = 'notification__button']");
    private final By NEWS = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_NEWS = By.xpath(".//a[contains(@class,'-share__item article-share__item--comments')]");
    // .//span[@class = 'article-share__item--count']
    // .//a[contains(@class, 'article-share__item article-share__item--comments']
      private final By ALL_NEWS = By.cssSelector(".list-article__headline");


     @Test
    public void homeworkTvnet()  {
        //"Homework Nr.1
        // Open web www.tvnet.lv; Click accept bt`n; Open the news; Open new comments;

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        String titleFromWeb = driver.getTitle();
        System.out.println("Page title: " + titleFromWeb);

        WebElement openNews = driver.findElement(NEWS);
        openNews.click();

        String titleNews = driver.getTitle();
        String titleText = driver.findElement(NEWS).getText();
        System.out.println("getTitle: " + titleNews);
        System.out.println("getText: " + titleText);

        String title = "Covid-19: reģistrēts līdz šim lielākais saslimšanas gadījumu " +
                "skaits - 930 - Latvijā - Ziņas - TVNET";

         System.out.println("From List: " + title);
        boolean titleRes = titleNews.equals(title);
        boolean titleResultat = titleNews.contains(title);
         System.out.println("The title is spelled correctly: " + titleRes);




        WebElement listOfComments = driver.findElement(COMMENTS_NEWS);
        listOfComments.click();


       // driver.quit();

        System.out.println("Test DONE!");

    }}
