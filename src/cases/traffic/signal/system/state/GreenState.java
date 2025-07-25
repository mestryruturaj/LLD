package cases.traffic.signal.system.state;

import cases.traffic.signal.system.TrafficLight;
import cases.traffic.signal.system.TrafficSignalController;
import cases.traffic.signal.system.enums.Light;

public class GreenState implements SignalState {
    @Override
    public void handle(TrafficLight trafficLight, TrafficSignalController trafficSignalController) {
        System.out.printf("Direction: %s | State: GREEN%n", trafficLight.getDirection());
        int duration = trafficLight.getDurations().get(Light.GREEN);
        SignalState nextState = trafficLight.getPossibleStates().get(Light.RED);
        trafficSignalController.scheduleStateChange(trafficLight, nextState, duration);
    }
}
