package design_patterns.state.traffic_light;

public class RedState implements  TrafficLightState {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("🔴 Traffic Light is RED. Stop!");

        // Simulating time passing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Transition to Green
        context.setState(new GreenState());
    }
}
