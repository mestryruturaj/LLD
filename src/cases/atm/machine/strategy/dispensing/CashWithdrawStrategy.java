package cases.atm.machine.strategy.dispensing;

import cases.atm.machine.ATM;

public interface CashWithdrawStrategy {
    public void withdrawCash(ATM atm, int amount);
}
