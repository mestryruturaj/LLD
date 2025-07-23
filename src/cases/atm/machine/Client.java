package cases.atm.machine;

import cases.atm.machine.model.Card;
import cases.atm.machine.service.BankService;
import cases.atm.machine.strategy.dispensing.CashWithdrawStrategy;
import cases.atm.machine.strategy.dispensing.GreedyStrategy;

public class Client {
    public static void main(String[] args) {
        CashWithdrawStrategy cashWithdrawStrategy = new GreedyStrategy();
        BankService bankService = new BankService();
        ATM atm = new ATM(cashWithdrawStrategy, bankService);

        Card card = new Card("1234 5678 9123", "Test User", 123);
        atm.insertCard(card);
        atm.verifyPin("1234");
        atm.withdrawCash(100);
        atm.reset();
    }
}
