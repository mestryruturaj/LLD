package cases.traffic.signal.system;

import cases.traffic.signal.system.enums.Direction;
import cases.traffic.signal.system.enums.Light;
import cases.traffic.signal.system.state.GreenState;
import cases.traffic.signal.system.state.RedState;
import cases.traffic.signal.system.state.SignalState;
import cases.traffic.signal.system.state.YellowState;

import java.util.HashMap;
import java.util.Map;

public class TrafficLight {
    private SignalState state;
    private Map<Light, Integer> durations;
    private Map<Light, SignalState> possibleStates;
    private Direction direction;

    public TrafficLight(Direction direction, Map<Light, Integer> durations) {
        this.direction = direction;
        this.durations = durations;
        this.possibleStates = new HashMap<>();
        possibleStates.put(Light.GREEN, new GreenState());
        possibleStates.put(Light.YELLOW, new YellowState());
        possibleStates.put(Light.RED, new RedState());
    }

    public void handle(TrafficSignalController trafficSignalController) {
        state.handle(this, trafficSignalController);
    }

    public SignalState getState() {
        return state;
    }

    public void setState(SignalState state) {
        this.state = state;
    }

    public Map<Light, Integer> getDurations() {
        return durations;
    }

    public void setDurations(Map<Light, Integer> durations) {
        this.durations = durations;
    }

    public Map<Light, SignalState> getPossibleStates() {
        return possibleStates;
    }

    public void setPossibleStates(Map<Light, SignalState> possibleStates) {
        this.possibleStates = possibleStates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
