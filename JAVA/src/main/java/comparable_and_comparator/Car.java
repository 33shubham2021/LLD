package comparable_and_comparator;

public class Car implements Comparable<Car> {
    @Override
    public int compareTo(Car c) {
        return this.price - c.price;
    }

    String brand;
    int price;
    public Car(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }
}
