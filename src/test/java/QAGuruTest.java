import model.QaCourses;
import model.QaStudent;
import model.QaguruRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.qaguru.QaSuccessPage;
import pages.BaseFunctions;
import pages.qaguru.QaHomePage;
import pages.qaguru.QaRegistrationPage;

public class QAGuruTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private String URL = "qaguru.lv/totest/";
    private final String SUCCESS_TEXT = "Paldies! Reģistrācija ir veiksmīga. Tuvākajā laikā mēs sazināsimies ar jums un piedāvāsim detalizēto informāciju par kursu, laiku un norises vietu :)";
    private BaseFunctions baseFunc = new BaseFunctions();

    @Test
    public void registrationTest() {
        LOGGER.info("This test will check registration happy path");

        baseFunc.openUrl(URL);

        QaHomePage qaHomePage = new QaHomePage(baseFunc);
        QaRegistrationPage qaRegistrationPage = qaHomePage.openRegistrationPage();

        QaStudent student = new QaStudent();
        student.setFirstName("AT FN");
        student.setLastName("AT LN");
        student.setEmail("ats@ats.lv");
        student.setPhone("222222");


        QaguruRegistration registration = new QaguruRegistration();
        registration.setStudent(student);
        registration.setCode("CODE");
        registration.setComment("I'm happy");
        registration.setCourses(QaCourses.QA2);

        qaRegistrationPage.fillInRegistrationForm(registration);
        qaRegistrationPage.submitForm();

        QaSuccessPage qaSuccessPage = new QaSuccessPage(baseFunc);
        Assertions.assertEquals(SUCCESS_TEXT, qaSuccessPage.getSuccessMsg(), "Problem with success message!");
    }

    @AfterEach
    public void close() {
        baseFunc.closeBrowser();
    }
}
