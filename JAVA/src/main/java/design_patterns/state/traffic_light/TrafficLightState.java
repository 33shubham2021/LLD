package design_patterns.state.traffic_light;

interface TrafficLightState {
    /**
     * Handles the behavior for the current state and triggers the transition.
     */
    void handle(TrafficLight context);
}