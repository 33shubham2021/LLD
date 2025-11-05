package design_patterns.prototype;

public class Student {

    private String name;
    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
        this.gender = other.gender;
    }


    public Student copy() {
        return new Student(this);
    }


}
