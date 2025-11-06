package design_patterns.strategy;

public class BikePath implements PathCalculator {
    @Override
    public void findPath(String to, String from) {
        System.out.println("Finding BIKE path from " + from + " to " + to) ;
    }
}
