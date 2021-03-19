package pages.qaguru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.BaseFunctions;

public class QaSuccessPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By SUCCES_BLOCK = By.xpath(".//div[@class = 'successTxt']");

    private BaseFunctions baseFunc;

    public QaSuccessPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
        LOGGER.info("RWe are on success registration page ");
    }

    public String getSuccessMsg() {
        LOGGER.info("Getting success message");
        return baseFunc.getText(SUCCES_BLOCK);
    }
}
