package concurrency.adder_subtractor.correct;

import concurrency.adder_subtractor.faulty.Number;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Number n = new Number();
        n.setX(0);

        Adder adder = new Adder(n , lock);
        Thread t1 = new Thread(adder);
        t1.start();

        Subtractor subtractor = new Subtractor(n , lock);
        Thread t2 = new Thread(subtractor);
        t2.start();




    }
}
