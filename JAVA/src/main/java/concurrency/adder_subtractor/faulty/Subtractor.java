package concurrency.adder_subtractor.faulty;

public class Subtractor implements Runnable {
    private Number n;

    Subtractor(Number n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1;i <= 10000;i++) {
            int temp = n.getX();
            temp -= i;
            n.setX(temp);
            System.out.println("Subtractor : " + "Value is " + n.getX());
        }
    }
}
