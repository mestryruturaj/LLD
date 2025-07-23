package cases.atm.machine.state;

import cases.atm.machine.enums.MachineState;

public class DepositedState extends AtmStateAdapter {
    public DepositedState(MachineState machineState) {
        super(machineState);
    }
}
