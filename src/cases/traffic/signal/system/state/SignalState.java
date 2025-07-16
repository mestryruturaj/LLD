package cases.traffic.signal.system.state;

import cases.traffic.signal.system.TrafficLight;
import cases.traffic.signal.system.TrafficSignalController;

public interface SignalState {
    public void handle(TrafficLight trafficLight, TrafficSignalController trafficSignalController);
}
