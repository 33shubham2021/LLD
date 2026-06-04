package design_patterns.state.traffic_light;

public class TrafficLightController {
    public static void main(String[] args) {
        // Initialize the traffic light with a Red state
        TrafficLight intersectionLight = new TrafficLight(new RedState());

        System.out.println("Starting Traffic Light Controller...\n");

        // Run the traffic light through 6 state changes
        for (int i = 0; i < 6; i++) {
            intersectionLight.operate();
        }

        System.out.println("Stopping Traffic Light Controller...\n");
    }
}
