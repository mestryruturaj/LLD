package traffic.signal.system;

import traffic.signal.system.enums.Direction;

import java.util.Map;

public class Intersection {
    private Map<Direction, TrafficLight> directionTrafficLightMap;
    private TrafficSignalController trafficSignalController;

    public Intersection(Map<Direction, TrafficLight> directionTrafficLightMap, TrafficSignalController trafficSignalController) {
        this.directionTrafficLightMap = directionTrafficLightMap;
        this.trafficSignalController = trafficSignalController;
    }

    public Map<Direction, TrafficLight> getDirectionTrafficLightMap() {
        return directionTrafficLightMap;
    }

    public void setDirectionTrafficLightMap(Map<Direction, TrafficLight> directionTrafficLightMap) {
        this.directionTrafficLightMap = directionTrafficLightMap;
    }

    public TrafficSignalController getTrafficSignalController() {
        return trafficSignalController;
    }

    public void setTrafficSignalController(TrafficSignalController trafficSignalController) {
        this.trafficSignalController = trafficSignalController;
    }

    public void start(Direction startDirection) {
        trafficSignalController.start(startDirection);
    }
}
