package design_patterns.strategy;

public class CarPath implements PathCalculator {
    @Override
    public void findPath(String to, String from) {
        System.out.println("Finding CAR path from " + from + " to " + to) ;
    }
}
