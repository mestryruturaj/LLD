package traffic.signal.system.state;

import traffic.signal.system.TrafficLight;
import traffic.signal.system.TrafficSignalController;
import traffic.signal.system.enums.Direction;

public interface SignalState {
    public void handle(TrafficLight trafficLight, TrafficSignalController trafficSignalController);
}
