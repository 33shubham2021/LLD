package design_patterns.decorator.ice_cream;

import java.util.List;

public class OrangeCone implements IceCreamCone{
    IceCreamCone cone;
    IceCreamType type = IceCreamType.ORANGE_CONE;
    List<IceCreamType> ingredients;

    public OrangeCone(IceCreamCone cone) {
        this.cone = cone;
        cone.getIngredients().add(IceCreamType.ORANGE_CONE);
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
