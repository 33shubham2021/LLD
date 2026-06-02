package design_patterns.decorator.coffee_machine;

public class IceCoffee implements Beverage {
    Beverage beverage;

    public IceCoffee(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " Ice Coffee ";
    }

    @Override
    public int getCost() {
        return this.beverage.getCost() + 20;
    }
}
