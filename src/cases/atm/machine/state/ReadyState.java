package cases.atm.machine.state;

import cases.atm.machine.ATM;
import cases.atm.machine.enums.MachineState;
import cases.atm.machine.model.Card;

import static cases.atm.machine.enums.MachineState.CARD_INSERTED;

public class ReadyState extends AtmStateAdapter {
    public ReadyState(MachineState machineState) {
        super(machineState);
    }

    @Override
    public AtmState insertCard(ATM atm, Card card) {
        atm.setInsertedCard(card);
        return atm.getPossibleStates().get(CARD_INSERTED);
    }

    @Override
    public AtmState reset(ATM atm) {
        return atm.getPossibleStates().get(CARD_INSERTED);
    }
}
