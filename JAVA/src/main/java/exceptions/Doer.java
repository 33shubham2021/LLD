package exceptions;

public class Doer {

    public Object findStudentByRollNumber(int rollNumber) throws ClassNotFoundException {
        if (rollNumber >= 30) {
            throw new ClassNotFoundException();
        }
        return new Object();
    }

    public int doSomething(){
        return 1/0;
    }
}
