package design_patterns.state.traffic_light;

public class GreenState implements TrafficLightState{
    @Override
    public void handle(TrafficLight context) {
        System.out.println("🟢 Traffic Light is GREEN. Go!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Transition to Yellow
        context.setState(new YellowState());
    }
}
