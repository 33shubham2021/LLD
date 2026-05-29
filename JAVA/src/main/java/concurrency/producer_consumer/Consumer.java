package concurrency.producer_consumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Object> store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;


    Consumer(Queue<Object> store, int maxSize, String name, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }


    @Override
    public void run() {
        while(true){
            try {
                this.consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumer "+ this.name +
                    " has consumed the shirt ans store size is " + store.size());
            store.remove();
            producerSemaphore.release();
        }

    }
}
