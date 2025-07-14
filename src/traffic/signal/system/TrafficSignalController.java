package traffic.signal.system;

import traffic.signal.system.enums.Direction;
import traffic.signal.system.state.SignalState;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSignalController {
    private Map<Direction, TrafficLight> directionTrafficLightMap;
    private ScheduledExecutorService scheduledExecutorService;

    public TrafficSignalController(Map<Direction, TrafficLight> directionTrafficLightMap) {
        this.directionTrafficLightMap = directionTrafficLightMap;
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void scheduleStateChange(TrafficLight trafficLight, SignalState nextState, int duration) {
        scheduledExecutorService.schedule(() -> {
            trafficLight.setState(nextState);
            trafficLight.handle(this);
        }, duration, TimeUnit.SECONDS);
    }
}
