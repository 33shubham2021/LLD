package concurrency;

public class ConcurrencyMain {
    public static void main(String[] args) {
        for (int i = 0;i < 10;i++){
            System.out.println("Hello World!");
        }
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
