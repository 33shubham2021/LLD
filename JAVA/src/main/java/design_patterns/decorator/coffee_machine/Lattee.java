package design_patterns.decorator.coffee_machine;

public class Lattee implements Beverage{
    Beverage beverage;

    public Lattee(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " LATTEE ";
    }

    @Override
    public int getCost() {
        return this.beverage.getCost() + 30;
    }
}
