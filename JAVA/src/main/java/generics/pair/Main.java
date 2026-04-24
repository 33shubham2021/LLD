package generics.pair;

public class Main {
    public static void main(String[] args) {
        Pair<String , Integer> student = new Pair<>("Shubham" , 1);
        System.out.println("Name : " + student.getFirst());
        System.out.println("Second : " + student.getSecond());

        //Raw type
        Pair p = new Pair("Shaivalini", "Ravi");
        // below line will build/comile, but it will throw error while running
        // Raw Types work internally using the Object approach, mentioned in notes
        // This approach can create problems at runtime
        Integer s = (Integer)p.getFirst();
        System.out.println(s);
        System.out.println("First : " + p.getFirst());
        System.out.println("Second : " + p.getSecond());
    }



    /* Articles to read for Java generics
     https://docs.oracle.com/javase/tutorial/java/generics/why.html
     https://docs.oracle.com/javase/tutorial/java/generics/types.html
     https://docs.oracle.com/javase/tutorial/java/generics/rawTypes.html
     https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
     https://docs.oracle.com/javase/tutorial/java/generics/boundedTypeParams.html
     */
}
