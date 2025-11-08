package design_patterns.decorator.ice_cream;

import java.util.List;

public class VanillaScoop implements IceCreamCone{
    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public List<IceCreamType> getIngredients() {
        return List.of();
    }
}
