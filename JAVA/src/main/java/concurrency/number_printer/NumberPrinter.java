package concurrency.number_printer;

public class NumberPrinter implements Runnable {
    private int x;

    NumberPrinter(int n){
        this.x = n;
    }
    public void run() {
        printNumber();
    }

    private void printNumber() {
        System.out.println(x + " printed from thread "+
                Thread.currentThread().getName());
    }
}
