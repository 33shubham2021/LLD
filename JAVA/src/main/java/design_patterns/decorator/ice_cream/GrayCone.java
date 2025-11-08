package design_patterns.decorator.ice_cream;

import java.util.List;

public class GrayCone implements IceCreamCone {
    IceCreamCone cone;
    IceCreamType type = IceCreamType.GRAY_CONE;
    List<IceCreamType> ingredients;

    public GrayCone(IceCreamCone cone) {
        this.cone = cone;
        cone.getIngredients().add(IceCreamType.GRAY_CONE);
        ingredients = cone.getIngredients();
    }


    @Override
    public int getPrice() {
        return type.price + cone.getPrice();
    }

    @Override
    public List<IceCreamType> getIngredients() {
        return ingredients;
    }
}
