package concurrency.callable_number_printer;

import java.util.concurrent.Callable;

public class NumberPrinter implements Callable<Boolean> {
    private int n;
    public NumberPrinter(int n) {
        this.n = n;
    }

    @Override
    public Boolean call() throws Exception {
        printNumber();
        return true;
    }

    private void printNumber() {
        System.out.print("\n" + n + " printed from thread " +
                Thread.currentThread().getName());
    }
}
