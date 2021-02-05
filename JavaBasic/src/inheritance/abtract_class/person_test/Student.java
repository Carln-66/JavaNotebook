package inheritance.abtract_class.person_test;

public class Student extends Person {

    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public String getDescription() {
        return "a student major in " + major;
    }
}
