package concurrency.adder_subtractor.faulty;

public class Main {
    public static void main(String[] args) {
        Number n = new Number();
        n.setX(0);


        Adder adder = new Adder(n);
        Thread t1 = new Thread(adder);
        t1.start();

        Subtractor subtractor = new Subtractor(n);
        Thread t2 = new Thread(subtractor);
        t2.start();

        System.out.println("Final Value of x is " + n.getX());
    }
}
