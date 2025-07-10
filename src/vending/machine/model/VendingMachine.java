package vending.machine.model;

import vending.machine.exception.VendingMachineException;
import vending.machine.model.enums.ItemType;
import vending.machine.model.enums.PaymentStatus;
import vending.machine.model.enums.PaymentType;
import vending.machine.model.enums.VendingMachineState;
import vending.machine.strategy.PaymentFactory;
import vending.machine.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static vending.machine.model.enums.VendingMachineState.*;

public class VendingMachine {
    private Inventory inventory;
    private VendingMachineState vendingMachineState;
    private Map<ItemType, Integer> selectedItems;
    private PaymentFactory paymentFactory;
    private double amountToPay;

    public VendingMachine(Inventory inventory, PaymentFactory paymentFactory) {
        this.inventory = inventory;
        this.vendingMachineState = IDLE;
        this.selectedItems = new HashMap<>();
        this.paymentFactory = new PaymentFactory();
        this.amountToPay = 0D;
    }

    public void selectItem(ItemType itemType, int freq) {
        if (vendingMachineState.equals(IDLE) || vendingMachineState.equals(ITEM_SELECTED)) {
            inventory.checkStock(itemType, freq);
            vendingMachineState = VendingMachineState.ITEM_SELECTED;
            selectedItems.put(itemType, freq);
            calculateAmountToPay();
            return;
        }
        throw new VendingMachineException("Can not start new activity as Vending Machine is already involved in a transaction.");
    }

    private void calculateAmountToPay() {
        amountToPay = inventory.calculateAmount(selectedItems);
    }

    public PaymentStatus makePayment(PaymentType paymentType, double paidAmount) {
        PaymentStrategy paymentStrategy = paymentFactory.getPaymentStrategy(paymentType);
        PaymentStatus paymentStatus = paymentStrategy.makePayment(amountToPay, paidAmount);
        if (paymentStatus.equals(PaymentStatus.SUCCESS)) {
            vendingMachineState = VendingMachineState.PAID;
        }
        return paymentStatus;
    }

    public void dispense() {
        vendingMachineState = DISPENSING;
        System.out.printf("Vending Machine State: %s%n", vendingMachineState);
        inventory.dispenseItems(selectedItems);
        vendingMachineState = DISPENSED;
        System.out.printf("Vending Machine State: %s%n", vendingMachineState);
        selectedItems.clear();
        vendingMachineState = IDLE;
        System.out.println("Thank you for using Vending Machine. Visit Again.");
        System.out.printf("Vending Machine State: %s%n", vendingMachineState);
    }

    public void addItems(ItemType itemType, double price, int qty) {
        inventory.addItemType(itemType, price);
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            items.add(new Item(itemType));
        }
        inventory.stockItems(itemType, items);
    }

    public double getAmountToPay() {
        return amountToPay;
    }
}
