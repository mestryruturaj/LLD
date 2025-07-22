package cases.atm.machine.state;

import cases.atm.machine.ATM;
import cases.atm.machine.enums.MachineState;

import java.util.Map;

public class PinVerifiedState extends AtmStateAdapter {
    public PinVerifiedState(MachineState machineState) {
        super(machineState);
    }

    @Override
    public AtmState withdrawCash(ATM atm, int amount) {
        atm.getCashWithdrawStrategy().withdrawCash(atm, amount);
        return atm.getPossibleStates().get(MachineState.WITHDRAWN);
    }

    @Override
    public AtmState depositCash(ATM atm, Map<ATM.Denomination, Integer> depositedCash) {
        atm.depositCashInBankAccount(atm.getInsertedCard(), depositedCash);
        return atm.getPossibleStates().get(MachineState.DEPOSITED);
    }
}
