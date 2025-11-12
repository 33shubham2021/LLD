package problems.pen;

public class FountainPen extends Pen{
    public Refill refill;

    FountainPen (){
        this.type = PenType.FOUNTAIN;
    }

    @Override
    public void write() {
        System.out.println("Writing using pen of type " + this.type);
    }
}
