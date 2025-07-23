package cases.atm.machine.strategy.dispensing;

import cases.atm.machine.ATM;

public class GreedyStrategy implements CashWithdrawStrategy {
    @Override
    public void withdrawCash(ATM atm, int amount) {
        System.out.println("Withdrawing cash");
    }
}
