package pages.qaguru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.BaseFunctions;

public class QaHomePage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By REGISTRATION_BTN = By.xpath(".//div[@ class = 'cRegistrationBtn']");
    private BaseFunctions baseFunc;

    public QaHomePage(BaseFunctions baseFunc) {

        this.baseFunc = baseFunc;
        LOGGER.info("We are on Home Page");
    }
    public QaRegistrationPage openRegistrationPage () {
        LOGGER.info("Trying to open registration page");
    baseFunc.click(REGISTRATION_BTN);
    return new QaRegistrationPage(baseFunc);
    }
}
