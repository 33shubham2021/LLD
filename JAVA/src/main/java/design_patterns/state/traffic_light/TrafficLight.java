package design_patterns.state.traffic_light;

public class TrafficLight {
    private TrafficLightState state;

    public TrafficLight(TrafficLightState initialState) {
        this.state = initialState;
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void operate() {
        // Delegates the work to the current state object
        this.state.handle(this);
    }
}
