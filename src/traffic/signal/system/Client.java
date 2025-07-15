package traffic.signal.system;

import traffic.signal.system.enums.Direction;
import traffic.signal.system.enums.Light;
import traffic.signal.system.utils.TimePrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        TrafficLight t1 = new TrafficLight(Direction.NORTH, Map.of(Light.GREEN, 4, Light.YELLOW, 4, Light.RED, 12));
        TrafficLight t2 = new TrafficLight(Direction.EAST, Map.of(Light.GREEN, 4, Light.YELLOW, 4, Light.RED, 12));
        TrafficLight t3 = new TrafficLight(Direction.SOUTH, Map.of(Light.GREEN, 4, Light.YELLOW, 4, Light.RED, 12));
        TrafficLight t4 = new TrafficLight(Direction.WEST, Map.of(Light.GREEN, 4, Light.YELLOW, 4, Light.RED, 12));
        Map<Direction, TrafficLight> trafficLightMap = new HashMap<>();
        trafficLightMap.put(Direction.NORTH, t1);
        trafficLightMap.put(Direction.EAST, t2);
        trafficLightMap.put(Direction.SOUTH, t3);
        trafficLightMap.put(Direction.WEST, t4);

        TrafficSignalController trafficSignalController = new TrafficSignalController(trafficLightMap);

        Intersection intersection = new Intersection(trafficLightMap, trafficSignalController);
        intersection.start(Direction.NORTH);
        new TimePrinter().start();
    }
}
