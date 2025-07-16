package cases.vending.machine;

import cases.vending.machine.enums.Coin;
import cases.vending.machine.enums.ItemType;
import cases.vending.machine.factory.StateRegistry;
import cases.vending.machine.model.*;
import vending.machine.model.*;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Item item1 = new Item(ItemType.COKE);
        Item item2 = new Item(ItemType.PROTEIN_BAR);
        Item item3 = new Item(ItemType.MOUNTAIN_DEW);

        Rack rack1 = new Rack(101, ItemType.COKE, 3);
        Rack rack2 = new Rack(102, ItemType.PROTEIN_BAR, 7);
        Rack rack3 = new Rack(103, ItemType.MOUNTAIN_DEW, 1);
        rack1.addItem(item1);
        rack2.addItem(item2);
        rack3.addItem(item3);

        Shelf shelf = new Shelf();
        shelf.addRack(rack1);
        shelf.addRack(rack2);
        shelf.addRack(rack3);

        Inventory inventory = new Inventory();
        inventory.addShelf(shelf);

        Map<ItemType, Integer> prices = new HashMap<>();
        prices.put(ItemType.COKE, 3);
        prices.put(ItemType.PROTEIN_BAR, 7);
        prices.put(ItemType.MOUNTAIN_DEW, 1);

        VendingMachine vendingMachine = new VendingMachine(inventory, new StateRegistry(), prices);

        vendingMachine.selectItem(101);

        vendingMachine.insertCoin(Coin.ONE);
        vendingMachine.insertCoin(Coin.ONE);
        vendingMachine.insertCoin(Coin.ONE);
        vendingMachine.insertCoin(Coin.TEN);

        vendingMachine.makePayment();

        vendingMachine.dispense();
    }
}

