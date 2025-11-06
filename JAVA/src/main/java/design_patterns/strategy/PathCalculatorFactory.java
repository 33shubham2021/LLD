package design_patterns.strategy;

public class PathCalculatorFactory {
    public static PathCalculator getPathCalculatorBasedOnMode(ModeType mode) {
        return switch (mode) {
            case BIKE -> new BikePath();
            case WALK -> new WalkPath();
            case CAR -> new CarPath();
            default -> null;
        };
    }
}
