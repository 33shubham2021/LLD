package exceptions;

public class Main {
    public static void main(String[] args) {
        Doer d = new Doer();
        //below line throws unchecked exception, so it is not forced to be handled
        //d.doSomething();

        try {
            d.findStudentByRollNumber(35);
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid Roll Number ");
        }


    }
}
