package design_patterns.decorator.coffee_machine;

public class ColdDrink implements Beverage{
    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public int getCost() {
        return 0;
    }
}
