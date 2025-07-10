package vending.machine;

import vending.machine.model.Inventory;
import vending.machine.model.VendingMachine;
import vending.machine.model.enums.ItemType;
import vending.machine.model.enums.PaymentType;
import vending.machine.strategy.PaymentFactory;

public class Client {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        PaymentFactory paymentFactory = new PaymentFactory();
        VendingMachine vendingMachine = new VendingMachine(inventory, paymentFactory);
        System.out.println("Vending Machine Installed.");

        vendingMachine.addItems(ItemType.CHIPS_A, 10D, 20);
        vendingMachine.addItems(ItemType.CHIPS_B, 7.75D, 20);
        System.out.println("Items added in Vending Machine.");

        vendingMachine.selectItem(ItemType.CHIPS_A, 3);
        vendingMachine.selectItem(ItemType.CHIPS_B, 3);


        vendingMachine.makePayment(PaymentType.ONLINE, vendingMachine.getAmountToPay());

        vendingMachine.dispense();
    }
}
