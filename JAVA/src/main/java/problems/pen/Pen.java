package problems.pen;

public abstract class Pen {
    public String name;
    public String brand;
    public int price;
    public ClosingMethodType closingMethodType;
    public PenType type;

    public abstract void write();

}
