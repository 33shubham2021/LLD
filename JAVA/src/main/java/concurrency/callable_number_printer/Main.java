package concurrency.callable_number_printer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello printed from thread " +
                Thread.currentThread().getName());
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i = 1;i <= 100;i++){
            NumberPrinter np = new NumberPrinter(i);
            Future<Boolean> future = executor.submit(np);
            if (!future.get()) { //future.get() keeps waiting until the thread returns its value
                System.out.println("Returned False from the thread");
            }
        }
    }
}
