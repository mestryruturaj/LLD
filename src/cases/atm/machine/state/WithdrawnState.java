package cases.atm.machine.state;

import cases.atm.machine.ATM;
import cases.atm.machine.enums.MachineState;

import java.util.Map;

public class WithdrawnState extends AtmStateAdapter {
    public WithdrawnState(MachineState machineState) {
        super(machineState);
    }
}
