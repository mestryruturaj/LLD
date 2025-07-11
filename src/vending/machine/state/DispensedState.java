package vending.machine.state;

import vending.machine.enums.MachineState;

public class DispensedState extends StateAdapter {
    public DispensedState(MachineState machineState) {
        super(machineState);
    }
}
