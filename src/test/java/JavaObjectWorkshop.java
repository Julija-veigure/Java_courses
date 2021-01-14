import model.Course;
import model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaObjectWorkshop {
    @Test
    public void workWithObjects()   {
        Student lena = new Student();

        lena.setFirstName("Jeļena");
        lena.setLastName("Stauta");
        lena.setAge(18);
        lena.setEmail("lapusjka@inbox.lv");

        Student raimonds = new Student("Raimonds", "Dārziņš", 19, "boy@gmail.com");

//        raimonds.setFirstName("Raimonds");
//        raimonds.setLastName("Dārziņš");
//        raimonds.setAge(35);
//        raimonds.setEmail("boy@gmail.com");


//        System.out.println(lena.getFullName());
//        System.out.println(raimonds.getFullName());

        List<Student> students = new ArrayList<Student>();
        students.add(lena);
        students.add(raimonds);
        students.add(new Student("Liga", "Uzvārds", 18, "liga@fmt.lv"));

        Course qa2 = new Course("QA2 - Automation", 3, students);
        qa2.addStudent(new Student("Jūlija", "Veigure", 34, "julija@gmail.com"));
        qa2.printInfo();
    }
}
