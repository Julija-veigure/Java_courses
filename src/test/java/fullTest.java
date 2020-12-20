import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class fullTest {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@class = 'notification__button']");
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private final By TITLE_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENTS_BLOCK = By.xpath(".//div[contains(@class, 'button-list flex flex--align-items-center')]");
    private final By COMMENTS_COUNT = By.xpath(".//span[@class = 'article-share__item--count']");

    @Test

    public void titleCommentsCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        //Find article
        WebElement currentArticle = driver.findElements(ARTICLE).get(1);

        //Store Title
        String titleToCheck = currentArticle.findElement(TITLE).getText();

        //Comments count from homepage
        // Mans ieraksts

        //Store comments count
        int commentCount = 0;

        if (!currentArticle.findElements(COMMENTS).isEmpty()) {
            String commentsToParse = currentArticle.findElement(COMMENTS).getText();    //Title text (36)
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); //(36) -> 36
            commentCount = Integer.parseInt(commentsToParse);
        }

        //Open article
        currentArticle.findElement(TITLE).click();

        //Check title
        String titleFromOpenPage = driver.findElement(TITLE_PAGE).getText();
        Assertions.assertEquals(titleToCheck, titleFromOpenPage, "Incorrect Title!");

// _________________________If comments are not empty - delete comments count____________________________________
//1        if (!currentArticle.findElements(COMMENTS).isEmpty()) {
//1            currentArticle.findElement(TITLE).click();
//1            titleToCheck = titleToCheck.substring(0, titleToCheck.lastIndexOf(" ("));
//1            String titleFromOpenPage = driver.findElement(TITLE_PAGE).getText();
//1            Assertions.assertEquals(titleToCheck, titleFromOpenPage, "Incorrect Title!");
//1        }
// _________________________If comments are not empty - replace comments count____________________________________
//2        if (!currentArticle.findElements(COMMENTS).isEmpty()) {
//2        currentArticle.findElement(TITLE).click();
//2        String delComCount = (" (" + commentsToParse + ")");
//2        titleToCheck = titleToCheck.replace(delComCount, "" );
//2        Assertions.assertEquals(titleToCheck, titleFromOpenPage, "Incorrect Title!");

// ______________________If starts with "titleToCheck" print True, if not, print Fuck__________________________
//3        if (titleFromOpenPage.startsWith(titleToCheck)) {
//3            System.out.println("True");
//3        }   else  {System.out.println("Fuck"); }

// ______________________________________boolean equals - print result ____________________________________________
//4        boolean res = titleToCheck.equals(titleFromOpenPage);
//4        System.out.println(res);

        //Check comments

        //Check title

        //Check comments count
//
        driver.quit();
    }
}

