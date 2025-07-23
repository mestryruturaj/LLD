package cases.atm.machine.state;

import cases.atm.machine.ATM;
import cases.atm.machine.enums.Denomination;
import cases.atm.machine.enums.MachineState;
import cases.atm.machine.exception.AtmException;
import cases.atm.machine.model.Card;
import cases.atm.machine.service.BankService;

import java.util.Map;

public class AtmStateAdapter implements AtmState {
    private final MachineState machineState;

    public AtmStateAdapter(MachineState machineState) {
        this.machineState = machineState;
    }

    @Override
    public AtmState insertCard(ATM atm, Card card) {
        throw new AtmException(String.format("Can not insert card at this state [%s].", machineState.name()));
    }

    @Override
    public AtmState checkBalance(ATM atm) {
        throw new AtmException(String.format("Can not check balance at this state [%s].", machineState.name()));
    }

    @Override
    public AtmState insertPin(ATM atm, BankService bankService, String pin) {
        throw new AtmException(String.format("Can not insert pin at this state [%s].", machineState.name()));
    }

    @Override
    public AtmState withdrawCash(ATM atm, BankService bankService, int amount) {
        throw new AtmException(String.format("Can not withdraw cash at this state [%s].", machineState.name()));
    }

    @Override
    public AtmState depositCash(ATM atm, BankService bankService, Map<Denomination, Integer> depositedCash) {
        throw new AtmException(String.format("Can not deposit at this state [%s].", machineState.name()));
    }

    @Override
    public AtmState reset(ATM atm) {
        atm.setInsertedCard(null);
        atm.setInsertedPin(null);
        atm.setDepositedAmount(0);
        atm.setWithdrawnAmount(0);
        return atm.getPossibleStates().get(MachineState.READY);
    }
}
