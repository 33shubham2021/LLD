package concurrency.number_printer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Printing this start message from Main");

        //printing numbers 1 t 100 all from differen threads

        for (int i = 1;i <= 100;i++){
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);
            t.start();
        }

        //Printing using thread pool
        Executor e = Executors.newFixedThreadPool(10);
        for (int i = 1;i <= 100;i++){
            NumberPrinter np = new NumberPrinter(i);
            e.execute(np);
            System.out.println(i + " printed from a thread pool");
        }
    }
}
