package vending.machine.model;

import vending.machine.enums.ItemType;
import vending.machine.exception.VendingMachineException;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private int rackCode;
    private ItemType itemType;
    private int price;
    private List<Item> items;

    public Rack(int rackCode, ItemType itemType, int price) {
        this.rackCode = rackCode;
        this.itemType = itemType;
        this.price = price;
        this.items = new ArrayList<>();
    }

    public void changeItemType(ItemType itemType, int price) {
        this.itemType = itemType;
        this.price = price;
        this.items.clear();
    }

    public void changePrice(int price) {
        this.price = price;
    }

    public void addItem(Item item) {
        if (!itemType.equals(item.getItemType())) {
            throw new VendingMachineException("INCORRECT_ITEM_TYPE_ON_RACK");
        }

        items.add(item);
    }

    public Item removeItem() {
        if (items.isEmpty()) {
            throw new VendingMachineException("INSUFFICIENT_ITEMS_ON_RACK");
        }

        return items.remove(items.size() - 1);
    }

    public int getRackCode() {
        return rackCode;
    }

    public void setRackCode(int rackCode) {
        this.rackCode = rackCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
