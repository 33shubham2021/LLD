package design_patterns.state.traffic_light;

public class YellowState implements TrafficLightState {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("🟡 Traffic Light is YELLOW. Slow down!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Transition to Red
        context.setState(new RedState());
    }
}
