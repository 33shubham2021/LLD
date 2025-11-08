package concurrency.adder_subtractor.faulty;

public class Adder implements Runnable {
    private Number n;

    Adder(Number n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1;i <= 10000;i++) {
            int temp = n.getX();
            temp += i;
            n.setX(temp);
            System.out.println("Adder : " + "Value is " + n.getX());
        }
    }


}
