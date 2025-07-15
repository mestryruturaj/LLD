package traffic.signal.system.state;

import traffic.signal.system.TrafficLight;
import traffic.signal.system.TrafficSignalController;
import traffic.signal.system.enums.Light;

public class YellowState implements SignalState {
    @Override
    public void handle(TrafficLight trafficLight, TrafficSignalController trafficSignalController) {
        System.out.printf("Direction: %s | State: YELLOW%n", trafficLight.getDirection());
        int duration = trafficLight.getDurations().get(Light.YELLOW);
        SignalState nextState = trafficLight.getPossibleStates().get(Light.RED);
        trafficSignalController.scheduleStateChange(trafficLight, nextState, duration);
    }
}
