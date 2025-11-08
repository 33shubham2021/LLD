package concurrency.hello_world_printer;

public class Main {
    public static void main(String[] args) {
        //Printing from main thread
        System.out.println("Hello World from " +
                Thread.currentThread().getName());

        //Printing from a new thread
        HelloWorldPrinter printer = new HelloWorldPrinter();

        Thread t = new Thread(printer);
        t.start();


    }
}
