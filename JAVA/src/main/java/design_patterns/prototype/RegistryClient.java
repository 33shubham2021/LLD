package design_patterns.prototype;

public class RegistryClient {
    public static void main(String[] args) {
        StudentRegistry reg = new StudentRegistry();
        Student prototype = new Student("Shaivalini" , 26 , "Female");
        reg.addStudent("Female" , prototype);

        Student copy = reg.getStudent("Female").copy();
        System.out.println("This is the end");
    }
}
