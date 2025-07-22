package cases.atm.machine.state;

import cases.atm.machine.ATM;
import cases.atm.machine.enums.MachineState;
import cases.atm.machine.service.BankService;

public class CardInsertedState extends AtmStateAdapter {
    public CardInsertedState(MachineState machineState) {
        super(machineState);
    }

    @Override
    public AtmState insertPin(ATM atm, BankService bankService, String pin) {
        atm.setInsertedPin(pin);
        bankService.authenticate(atm.getInsertedCard(), atm.getInsertedPin());
        return atm.getPossibleStates().get(MachineState.PIN_VERIFIED);
    }

    @Override
    public AtmState reset(ATM atm) {
        return super.reset(atm);
    }
}
