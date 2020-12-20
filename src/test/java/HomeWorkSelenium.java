
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;


public class HomeWorkSelenium {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@class = 'notification__button']");
    private final By NEWS = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS = By.xpath(".//span[@class,'list-article__comment section-font-color']");

    private final By NEWS_PAGE = By.xpath(".//h1[@itemprop = 'headline name']");

    @Test

    public void homeworkTvnet() {
        //"Homework Nr.1
        // Open web www.tvnet.lv; Click accept bt`n; Open the news; Open new comments;

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        //       String titleFromWeb = driver.getTitle();
        //       System.out.println("Page title: " + titleFromWeb);

        List<WebElement> articles = driver.findElements(NEWS);
        {

            //Find article Nr2, get text (title name)
          String titleFromHomePage = articles.get(1).getText();
//            String comCountHomePage = articles.get(3).findElement(COMMENTS).getText();
            // Open article Nr2
            articles.get(1).click();
            //Get text from opened article Nr4 (title)
            String titleFromOpenPage = driver.findElement(NEWS_PAGE).getText();
            //Compare titles
            //for ()
            Assertions.assertEquals(titleFromHomePage, titleFromOpenPage, "Incorrect Title (Nr2)!");
        }

            {
                //Find article by text an open it
                String title = "Kamaniņbraucēji Šici izcīna pirmo Pasaules kausa medaļu šosezon?";
                for (int i = 0; i < 10; i++) {
                    if (articles.get(i).getText().startsWith(title)) {
                        articles.get(i).click();
                        break;
                    }
                }
                //Get text from opened article (title)
                String titleForCompare = driver.findElement(NEWS_PAGE).getText();
                //Compare titles
                Assertions.assertEquals(title, titleForCompare, "Incorrect Title (by name)!");
            }

/*


            for (int i = 0; i < articles.size(); i++) {
            // Izdrukā visu sarakstu.uzdrukā saraksta tekstu.
            System.out.println(i + articles.get(i).getText());
            if (articles.get(i).getText().startsWith(TITLE)) {
                articles.get(i).click();
                break;
            }
        }

 /*        for (WebElement we : articles)  {
            if (we.getText().startsWith(TITLE)) {
                we.click();
                break;
            }
       }

*        System.out.println("TITLE: " + TITLE);
        String titleText = driver.findElement(NEWS).getText();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENTS));
        WebElement listOfComments = driver.findElement(COMMENTS);
        listOfComments.click();
*/

/*        for (int i = 0; i < articles.size(); i++) {
            String currentTitle = articles.get(i).getText();
            if (currentTitle.startsWith(TITLE)) {
                articles.get(i).click();
                break;
        }
            System.out.println("Kas drukājas te?" + currentTitle);
        }

        String titleText = driver.findElement(NEWS).getText();

        boolean res = titleText.equals(TITLE);
        System.out.println("From WEB: " + titleText);
        System.out.println("The title is spelled correctly: " + res);

         WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENTS));
        WebElement listOfComments = driver.findElement(COMMENTS);
        listOfComments.click();



        String titleNews = driver.getTitle();
        String titleText = driver.findElement(NEWS).getText();
        System.out.println("getTitle: " + titleNews);
        System.out.println("getText: " + titleText);

        for (WebElement we : articles) {
            if (we.getText().startsWith(title)) {
                we.click();
                break;
            }

         System.out.println("From List: " + title);
        boolean titleRes = titleNews.equals(title);
        boolean titleResultat = titleNews.contains(title);
         System.out.println("The title is spelled correctly: " + titleRes);


                    WebDriverWait wait = new WebDriverWait(driver, 10);

 */
            driver.quit();

            System.out.println("Test DONE!");
        }
    }


