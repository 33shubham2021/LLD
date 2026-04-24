package solid_principles.v2;

public class Pigeon extends Bird{
    @Override
    public void fly() {
        System.out.println("Pigeon is Flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Pigeon is making sound");
    }
}
