package design_patterns.decorator.coffee_machine;

public class Main {
    public static void main(String[] args) {
        Beverage item = new Lattee(
                new IceCoffee(
                        new Coffee()
                )
        );

        System.out.println("Ingredients : " + item.getDescription());
        System.out.println("Cost : " + item.getCost());

    }
}
