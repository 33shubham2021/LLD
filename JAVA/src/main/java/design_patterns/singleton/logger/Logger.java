package design_patterns.singleton.logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

    public static Logger l;

    //private constructor
    private Logger(){};

    //method to get instance of Logger
    public static Logger getInstance(){
        if (l == null){
            Lock lock = new ReentrantLock();
            lock.lock();
            if (l == null) return new Logger();
            lock.unlock();
        }
        return l;
    }

    public void log(String s){
        System.out.println(s);
    }
}
