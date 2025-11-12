package problems.pen;

public class BallPen extends Pen {
    public Refill refill;


    BallPen (){
        this.type = PenType.BALL;
    }

    @Override
    public void write() {
        System.out.println("Writing using pen of type " + this.type);
    }
}
