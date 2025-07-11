package vending.machine.factory;

import vending.machine.enums.MachineState;
import vending.machine.state.*;

import java.util.HashMap;
import java.util.Map;

public class StateRegistry {
    private Map<MachineState, State> registry;

    public StateRegistry() {
        this.registry = new HashMap<>();
        this.registry.put(MachineState.IDLE, new IdleState(MachineState.IDLE));
        this.registry.put(MachineState.ITEM_SELECTED, new ItemSelectedState(MachineState.ITEM_SELECTED));
        this.registry.put(MachineState.PAID, new PaidState(MachineState.PAID));
        this.registry.put(MachineState.DISPENSED, new DispensedState(MachineState.DISPENSED));
    }

    public State getState(MachineState state) {
        return registry.get(state);
    }


}
