package design_patterns.decorator.ice_cream;

import java.util.List;

public interface IceCreamCone {
    public int getPrice();
    public List<IceCreamType> getIngredients();
}
