package traffic.signal.system;

import traffic.signal.system.enums.Direction;
import traffic.signal.system.enums.Light;
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

    public void scheduleStateChange(TrafficLight trafficLight, SignalState nextState, int durationOfCurState) {
        scheduledExecutorService.schedule(() -> {
            trafficLight.setState(nextState);
            trafficLight.handle(this);
        }, durationOfCurState, TimeUnit.SECONDS);
    }

    public void start(Direction startDirection) {
        int startDirectionOrdinal = startDirection.ordinal();
        int greenTimeElapsed = 0;
        for (int i = 0; i < Direction.values().length; i++) {
            int curOrdinal = (startDirectionOrdinal + i) % Direction.values().length;
            Direction curDirection = Direction.values()[curOrdinal];
            TrafficLight curTrafficLight = directionTrafficLightMap.get(curDirection);

            scheduleStateChange(curTrafficLight, curTrafficLight.getPossibleStates().get(Light.GREEN), greenTimeElapsed);

            greenTimeElapsed += curTrafficLight.getDurations().get(Light.GREEN);
        }
    }
}
