package cases.atm.machine.state;

import cases.atm.machine.ATM;
import cases.atm.machine.enums.Denomination;
import cases.atm.machine.enums.MachineState;
import cases.atm.machine.service.BankService;

import java.util.Map;

public class PinVerifiedState extends AtmStateAdapter {
    public PinVerifiedState(MachineState machineState) {
        super(machineState);
    }

    @Override
    public AtmState withdrawCash(ATM atm, BankService bankService, int amount) {
        atm.getCashWithdrawStrategy().withdrawCash(atm, amount);
        bankService.withdrawCash(atm.getInsertedCard(), amount);
        return atm.getPossibleStates().get(MachineState.WITHDRAWN);
    }

    @Override
    public AtmState depositCash(ATM atm, BankService bankService, Map<Denomination, Integer> depositedCash) {
        atm.depositCashInBankAccount(atm.getInsertedCard(), depositedCash);
        bankService.depositCash(atm.getInsertedCard(), calculateDepositedCash(depositedCash));
        return atm.getPossibleStates().get(MachineState.DEPOSITED);
    }

    private int calculateDepositedCash(Map<Denomination, Integer> depositedCash) {
        int amount = 0;
        for (Map.Entry<Denomination, Integer> entry : depositedCash.entrySet()) {
            amount += entry.getKey().getValue() * entry.getValue();
        }

        return amount;
    }
}
