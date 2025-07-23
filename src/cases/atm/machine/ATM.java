package cases.atm.machine;

import cases.atm.machine.enums.Denomination;
import cases.atm.machine.enums.MachineState;
import cases.atm.machine.model.Card;
import cases.atm.machine.service.BankService;
import cases.atm.machine.state.*;
import cases.atm.machine.strategy.dispensing.CashWithdrawStrategy;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private static int counter = 0;
    private int id;
    private final Map<Denomination, Integer> cashBox;
    private AtmState currentState;
    private Map<MachineState, AtmState> possibleStates;
    private Card insertedCard;
    private String insertedPin;
    private int withdrawnAmount;
    private int depositedAmount;
    private CashWithdrawStrategy cashWithdrawStrategy;
    private BankService bankService;

    //constructor
    public ATM(CashWithdrawStrategy cashWithdrawStrategy, BankService bankService) {
        this.id = counter++;
        this.cashBox = setupCashbox();
        this.possibleStates = new HashMap<>();
        this.possibleStates.put(MachineState.READY, new ReadyState(MachineState.READY));
        this.possibleStates.put(MachineState.CARD_INSERTED, new CardInsertedState(MachineState.CARD_INSERTED));
        this.possibleStates.put(MachineState.PIN_VERIFIED, new PinVerifiedState(MachineState.PIN_VERIFIED));
        this.possibleStates.put(MachineState.WITHDRAWN, new WithdrawnState(MachineState.WITHDRAWN));
        this.possibleStates.put(MachineState.DEPOSITED, new DepositedState(MachineState.DEPOSITED));
        this.cashWithdrawStrategy = cashWithdrawStrategy;
        this.bankService = bankService;
        this.currentState = this.possibleStates.get(MachineState.READY);
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Denomination, Integer> getCashBox() {
        return cashBox;
    }

    public AtmState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AtmState currentState) {
        this.currentState = currentState;
    }

    public Map<MachineState, AtmState> getPossibleStates() {
        return possibleStates;
    }

    public void setPossibleStates(Map<MachineState, AtmState> possibleStates) {
        this.possibleStates = possibleStates;
    }

    public Card getInsertedCard() {
        return insertedCard;
    }

    public void setInsertedCard(Card insertedCard) {
        this.insertedCard = insertedCard;
    }

    public String getInsertedPin() {
        return insertedPin;
    }

    public void setInsertedPin(String insertedPin) {
        this.insertedPin = insertedPin;
    }

    public int getWithdrawnAmount() {
        return withdrawnAmount;
    }

    public void setWithdrawnAmount(int withdrawnAmount) {
        this.withdrawnAmount = withdrawnAmount;
    }

    public int getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(int depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public CashWithdrawStrategy getCashWithdrawStrategy() {
        return cashWithdrawStrategy;
    }

    public void setCashWithdrawStrategy(CashWithdrawStrategy cashWithdrawStrategy) {
        this.cashWithdrawStrategy = cashWithdrawStrategy;
    }

    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    //services
    private Map<Denomination, Integer> setupCashbox() {
        Map<Denomination, Integer> cashbox = new HashMap<>();
        cashbox.put(Denomination.ONE_HUNDRED, 0);
        cashbox.put(Denomination.TWO_HUNDRED, 0);
        cashbox.put(Denomination.FIVE_HUNDRED, 0);
        cashbox.put(Denomination.TWO_THOUSAND, 0);
        return cashbox;
    }

    public void insertCard(Card card) {
        System.out.printf("card inserted start: %s%n", card);
        currentState = currentState.insertCard(this, card);
        System.out.printf("card inserted end: %s%n", card);
    }

    public void verifyPin(String pin) {
        System.out.printf("verify pin start%n");
        currentState = currentState.insertPin(this, bankService, pin);
        System.out.printf("verify pin end%n");
    }

    public void withdrawCash(int amount) {
        System.out.printf("withdraw cash start: %d%n", amount);
        currentState = currentState.withdrawCash(this, bankService, amount);
        System.out.printf("withdraw cash end:%n");
    }

    public void depositCash(Map<Denomination, Integer> depositedCash) {
        System.out.printf("deposit cash start: %s%n", depositedCash);
        currentState = currentState.depositCash(this, bankService, depositedCash);
        System.out.printf("deposit cash end: %n");
    }

    public void reset() {
        System.out.printf("reset start. %n");
        currentState = currentState.reset(this);
        System.out.printf("reset end. %n");
    }

    public void depositCashInBankAccount(Card card, Map<Denomination, Integer> depositedCash) {
        System.out.println("Adding cash to account.");
    }
}
