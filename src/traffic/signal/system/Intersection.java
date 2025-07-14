package traffic.signal.system;

import traffic.signal.system.enums.Direction;

import java.util.Map;

public class Intersection {
    private Map<Direction, TrafficLight> directionTrafficLightMap;
    private TrafficSignalController trafficSignalController;
}
