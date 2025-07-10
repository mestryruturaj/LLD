package vending.machine.model;

import vending.machine.exception.VendingMachineException;
import vending.machine.model.enums.ItemType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<ItemType, Double> priceMap;
    private final Map<ItemType, List<Item>> stock;

    public Inventory() {
        this.priceMap = new HashMap<>();
        this.stock = new HashMap<>();
    }

    //add a type to inventory
    public void addItemType(ItemType itemType, double price) {
        if (priceMap.containsKey(itemType)) {
            throw new VendingMachineException(String.format("CAN_NOT_ADD_ITEM: Adding an item of type %s has failed. Item type %s already exists.", itemType, itemType));
        }
        priceMap.put(itemType, price);
        stock.put(itemType, new ArrayList<>());
    }

    public void removeItemType(ItemType itemType) {
        priceMap.remove(itemType);
        stock.remove(itemType);
    }

    private void updateItemPrize(ItemType itemType, double price) {
        if (!priceMap.containsKey(itemType)) {
            throw new VendingMachineException(String.format("CAN_NOT_UPDATE_ITEM_PRICE: Item type %s does not exists.", itemType, itemType));
        }
        priceMap.put(itemType, price);
    }

    //adding item type and its stock
    public void stockItems(ItemType itemType, List<Item> items) {
        if (!priceMap.containsKey(itemType)) {
            throw new VendingMachineException(String.format("CAN_NOT_STOCK_ITEM_AS_PRICE_ABSENT: Item type %s is absent from price registry", itemType));
        }

        if (!stock.containsKey(itemType)) {
            stock.put(itemType, new ArrayList<>());
        }
        stock.get(itemType).addAll(items);
        printStock();
    }

    private void printStock() {
        System.out.println("Stock");
        for (Map.Entry<ItemType, List<Item>> entry : stock.entrySet()) {
            System.out.printf("%s : %d%n", entry.getKey(), entry.getValue().size());
        }
    }

    //dispensing items
    public List<Item> dispenseItems(Map<ItemType, Integer> selectedItems) {
        for (Map.Entry<ItemType, Integer> entry : selectedItems.entrySet()) {
            checkStock(entry.getKey(), entry.getValue());
        }

        List<Item> dispensed = new ArrayList<>();
        for (Map.Entry<ItemType, Integer> entry : selectedItems.entrySet()) {
            ItemType itemType = entry.getKey();
            int qty = entry.getValue();

            for (int i = 0; i < qty; i++) {
                dispensed.add(stock.get(itemType).remove(stock.size() - 1));
            }
        }

        System.out.println(dispensed);

        return dispensed;
    }

    //reset inventory
    public void reset() {
        priceMap.clear();
        stock.clear();
    }

    //public void checkStock
    public void checkStock(ItemType itemType, int qty) {
        if (!stock.containsKey(itemType)) {
            throw new VendingMachineException(String.format("ITEM_DOES_NOT_EXIST: %s is not part of inventory.%n", itemType));
        }
        if (stock.get(itemType).size() < qty) {
            throw new VendingMachineException(String.format("INSUFFICIENT_QUANTITY: %s does not have sufficient quantity.%n", itemType));
        }
    }

    public double calculateAmount(Map<ItemType, Integer> selectedItems) {
        double amount = 0D;
        for (Map.Entry<ItemType, Integer> entry : selectedItems.entrySet()) {
            ItemType itemType = entry.getKey();
            int qty = entry.getValue();

            amount += priceMap.get(itemType) * qty;
        }

        return amount;
    }
}
