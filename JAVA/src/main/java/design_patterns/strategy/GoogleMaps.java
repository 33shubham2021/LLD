package design_patterns.strategy;

public class GoogleMaps {
    public void findPath(String from, String to,ModeType mode) {
        PathCalculator pathCalculator = PathCalculatorFactory
                                        .getPathCalculatorBasedOnMode(mode);

        pathCalculator.findPath(from, to);
    }
}
