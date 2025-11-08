package design_patterns.decorator.ice_cream;

public enum IceCreamType {
    ORANGE_CONE(10),
    GRAY_CONE(15),
    CHOCOLATE_SCOOP(30),
    VANILLA_SCOOP(40);


    public int price;

    IceCreamType(int price){
        this.price = price;
    }
}
