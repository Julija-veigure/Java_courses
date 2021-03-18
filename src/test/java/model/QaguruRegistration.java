package model;

public class QaguruRegistration {
    private QaStudent student;
    private String code;
    private String comment;
    private QaCourses courses;

    public QaStudent getStudent() {
        return student;
    }

    public void setStudent(QaStudent student) {
        this.student = student;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public QaCourses getCourses() {
        return courses;
    }

    public void setCourses(QaCourses courses) {
        this.courses = courses;
    }
}
