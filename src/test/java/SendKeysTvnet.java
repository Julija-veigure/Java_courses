
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class SendKeysTvnet {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@class = 'notification__button']");
    private final By NEWS = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_NEWS = By.xpath(".//a[contains(@class,'-share__item article-share__item--comments')]");
    private final By ALL_NEWS = By.cssSelector(".//list-article__headline");


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

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println("Title: " + title  + "\nUrl: " + url);
        driver.findElement(By.xpath(".//*[contains(@id,'search')]")).click();
        driver.findElement(By.xpath(".//input[@name = 'query']")).sendKeys("Taizemē atklāts tūkstošiem");

        driver.findElement(By.xpath(".//input[@name = 'query']")).sendKeys(Keys.RETURN);
        //Assert.assertTrue(driver.getTitle().contains("'seit rakstam virsrakstu"));

        //driver.quit();

        System.out.println("Test DONE!");

    }}
