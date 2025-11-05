package design_patterns.prototype;

public class Client {
    public static void main(String[] args) {
        Student st = new Student("Shaivalini" , 26 , "Female");
        Student ist = new IntelligentStudent("Shubham" , 30 , "Male" , 69);


        Student copy1 = st.copy();
        Student copy2 = ist.copy();
        System.out.println("This is the end line, just for testing");
    }
}
