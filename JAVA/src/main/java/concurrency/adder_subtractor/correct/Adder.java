package concurrency.adder_subtractor.correct;

import concurrency.adder_subtractor.faulty.Number;
import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private concurrency.adder_subtractor.faulty.Number n;
    private Lock lock;

    Adder(Number n, Lock lock) {
        this.n = n;
        this.lock = lock;
    }

    @Override
    public void run() {

        for (int i = 1;i <= 10000;i++) {
            lock.lock();
            int temp = n.getX();
            temp += i;
            n.setX(temp);
            System.out.println("Adder : " + "Value is " + n.getX());
            lock.unlock();
        }

    }
}
