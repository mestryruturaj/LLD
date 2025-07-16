package cases.traffic.signal.system.state;

import cases.traffic.signal.system.TrafficLight;
import cases.traffic.signal.system.TrafficSignalController;
import cases.traffic.signal.system.enums.Light;

public class RedState implements SignalState {
    @Override
    public void handle(TrafficLight trafficLight, TrafficSignalController trafficSignalController) {
        System.out.printf("Direction: %s | State: RED%n", trafficLight.getDirection());
        int duration = trafficLight.getDurations().get(Light.RED);
        SignalState nextState = trafficLight.getPossibleStates().get(Light.GREEN);
        trafficSignalController.scheduleStateChange(trafficLight, nextState, duration);
    }
}
