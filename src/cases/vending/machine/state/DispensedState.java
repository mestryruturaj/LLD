package cases.vending.machine.state;

import cases.vending.machine.enums.MachineState;

public class DispensedState extends StateAdapter {
    public DispensedState(MachineState machineState) {
        super(machineState);
    }
}
