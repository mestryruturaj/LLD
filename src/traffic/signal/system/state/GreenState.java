package traffic.signal.system.state;

import traffic.signal.system.TrafficLight;
import traffic.signal.system.TrafficSignalController;
import traffic.signal.system.enums.Light;

public class GreenState implements SignalState {
    @Override
    public void handle(TrafficLight trafficLight, TrafficSignalController trafficSignalController) {
        System.out.printf("Direction: %s | State: GREEN", trafficLight.getDirection());
        int duration = trafficLight.getDurations().get(Light.GREEN);
        SignalState nextState = trafficLight.getPossibleStates().get(Light.YELLOW);
        trafficSignalController.scheduleStateChange(trafficLight, nextState, duration);
    }
}
