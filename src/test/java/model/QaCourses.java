package model;

public enum QaCourses {
    QA1(1), QA2(3), WEB(5);

    private int value;

    QaCourses(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
