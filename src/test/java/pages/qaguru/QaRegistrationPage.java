package pages.qaguru;

import model.QaguruRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.tvnet.BaseFunctions;

public class QaRegistrationPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By FIRST_NAME = By.id("firstName");
    private final By LAST_NAME = By.id("lastName");
    private final By EMAIL = By.id("email");
    private final By PHONE = By.id("phone");
    private final By COURSE = By.id("course");
    private final By DISCOUNT = By.id("discount");
    private final By COMMENT = By.id("comment");
    private final By ACCEPT_CB = By.id("dataProc");
    private final By REGISTER_BTN = By.xpath(".//input[@type = 'submit']");

    private BaseFunctions baseFunc;

    public QaRegistrationPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;

        LOGGER.info("We are on registratio page");
    }

    public void fillInRegistrationForm(QaguruRegistration reg) {
    LOGGER.info("Filling registration form");

    baseFunc.type(FIRST_NAME, reg.getStudent().getFirstName());
    baseFunc.type(LAST_NAME, reg.getStudent().getLastName());
    baseFunc.type(EMAIL, reg.getStudent().getEmail());
    baseFunc.type(PHONE, reg.getStudent().getPhone());
    baseFunc.select(COURSE, reg.getCourses().toString());
    baseFunc.type(DISCOUNT, reg.getCode());
    baseFunc.type(COMMENT,reg.getComment());
    baseFunc.click(ACCEPT_CB);
    }

    public void submitForm() {
        LOGGER.info("Submiting registration form");
        baseFunc.click(REGISTER_BTN);
    }

}
