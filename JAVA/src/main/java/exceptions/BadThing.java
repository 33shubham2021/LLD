package exceptions;

public class BadThing {

    public static void call(int a){
        System.out.println(a);
        call(a*a);
    }

    public static void main(String[] args) {
        //Infinite recursion
        // Ideally we should not try catching errors, as they are fatal
        try{
            BadThing.call(100);
        }catch(StackOverflowError e){
            System.out.println("Stack Overflow has occurred");
        }

    }
}
