package design_patterns.decorator.coffee_machine;

import design_patterns.decorator.ice_cream.IceCreamType;

public class Coffee implements Beverage {

    @Override
    public String getDescription() {
        return " COFFEE ";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
