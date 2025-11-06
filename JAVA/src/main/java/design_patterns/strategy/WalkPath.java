package design_patterns.strategy;

public class WalkPath implements PathCalculator {
    @Override
    public void findPath(String to, String from) {
        System.out.println("Finding WALK path from " + from + " to " + to) ;
    }
}
