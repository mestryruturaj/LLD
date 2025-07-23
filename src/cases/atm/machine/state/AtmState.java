package cases.atm.machine.state;

import cases.atm.machine.ATM;
import cases.atm.machine.enums.Denomination;
import cases.atm.machine.model.Card;
import cases.atm.machine.service.BankService;

import java.util.Map;

public interface AtmState {
    public AtmState insertCard(ATM atm, Card card);

    public AtmState checkBalance(ATM atm);

    public AtmState insertPin(ATM atm, BankService bankService, String pin);

    public AtmState withdrawCash(ATM atm, BankService bankService, int amount);

    public AtmState depositCash(ATM atm, BankService bankService, Map<Denomination, Integer> dipositedCash);

    public AtmState reset(ATM atm);
}
