package design_patterns.strategy;

public class Client {
    public static void main(String[] args) {
        GoogleMaps googleMaps = new GoogleMaps();
        String from = "Dhanbad";
        String to = "Patna";
        ModeType mode = ModeType.WALK;
        googleMaps.findPath(from , to , mode);
    }
}
