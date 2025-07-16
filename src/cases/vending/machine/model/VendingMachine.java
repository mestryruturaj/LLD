package cases.vending.machine.model;

import cases.vending.machine.enums.Coin;
import cases.vending.machine.enums.ItemType;
import cases.vending.machine.enums.MachineState;
import cases.vending.machine.exception.VendingMachineException;
import cases.vending.machine.factory.StateRegistry;
import cases.vending.machine.state.State;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VendingMachine {
    private Inventory inventory;
    private State machineState;
    private Map<Coin, Integer> bank;
    private Map<ItemType, Integer> selectedItems;
    private Map<Coin, Integer> paidCoins;
    private int charges;
    private StateRegistry stateRegistry;
    private Map<ItemType, Integer> prices;

    public VendingMachine(Inventory inventory, StateRegistry stateRegistry, Map<ItemType, Integer> prices) {
        this.inventory = inventory;
        this.stateRegistry = stateRegistry;
        this.prices = prices;
        this.machineState = stateRegistry.getState(MachineState.IDLE);
        this.bank = new HashMap<>();
        this.selectedItems = new HashMap<>();
        this.paidCoins = new HashMap<>();
        this.charges = 0;
    }

    public void addCoin(Coin coin, int count) {
        bank.put(coin, bank.getOrDefault(coin, 0) + count);
    }

    public void subtractCoin(Coin coin, int count) {
        if (!bank.containsKey(coin)) {
            throw new VendingMachineException("CURRENCY_DOES_NOT_EXIST_IN_BANK.");
        }
        if (bank.get(coin) < count) {
            throw new VendingMachineException("INSUFFICIENT_CURRENCY_IN_BANK.");
        }

        bank.put(coin, bank.get(coin) - count);
    }

    public void selectItem(int itemCode) {
        System.out.println("Selecting item started...");
        try {
            MachineState nextState = machineState.selectItem(selectedItems, inventory, itemCode);
            machineState = stateRegistry.getState(nextState);
            System.out.println("Selecting item completed...");
        } catch (VendingMachineException e) {
            machineState = stateRegistry.getState(MachineState.IDLE);
        }
    }

    public void insertCoin(Coin coin) {
        System.out.println("Inserted coin with amount RS. " + coin.getValue());
        paidCoins.put(coin, paidCoins.getOrDefault(coin, 0) + 1);
    }

    public void makePayment() {
        try {
            MachineState nextState = machineState.makePayment(calculatePaidAmount(), calculateCharges());
            machineState = stateRegistry.getState(nextState);
        } catch (VendingMachineException e) {
            //TODO:Initiate refund
            refundProcess();
            machineState = stateRegistry.getState(MachineState.IDLE);
        }
    }

    private int calculatePaidAmount() {
        int total = 0;
        for (Map.Entry<Coin, Integer> entry : paidCoins.entrySet()) {
            total += entry.getKey().getValue() * entry.getValue();
        }

        return total;
    }

    private int calculateCharges() {
        int total = 0;
        for (Map.Entry<ItemType, Integer> entry : selectedItems.entrySet()) {
            int pricePerPiece = prices.get(entry.getKey());
            total += pricePerPiece * entry.getValue();
        }

        return total;
    }

    public void dispense() {
        try {
            MachineState nextState = machineState.dispense(selectedItems);
            machineState = stateRegistry.getState(nextState);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            machineState = stateRegistry.getState(MachineState.IDLE);
            selectedItems.clear();
            for (Map.Entry<Coin, Integer> entry : paidCoins.entrySet()) {
                Coin c = entry.getKey();
                int freq = entry.getValue();
                bank.put(c, bank.getOrDefault(c, 0) + freq);
            }
            paidCoins.clear();
        } catch (VendingMachineException e) {
            //TODO:Initiate refund
            refundProcess();
            machineState = stateRegistry.getState(MachineState.IDLE);
        }
    }

    private void refundProcess() {
        System.out.println("Refund Initiated...");
        for (Map.Entry<Coin, Integer> entry : paidCoins.entrySet()) {
            System.out.println("Refunded " + entry.getKey().getValue() + " * " + entry.getValue());
        }

        inventory.reStock(selectedItems);
        this.charges = 0;
        System.out.println("Refund completed.");
    }

}
