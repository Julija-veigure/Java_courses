import model.QaCourses;
import model.QaStudent;
import model.QaguruRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.tvnet.BaseFunctions;
import pages.qaguru.QaHomePage;
import pages.qaguru.QaRegistrationPage;

public class QAGuruTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private String URL = "qaguru.lv/totest/";

    @Test
    public void registrationTest() {
        LOGGER.info("This test will check registration happy path");
        BaseFunctions baseFunc = new BaseFunctions();
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

    }
}
