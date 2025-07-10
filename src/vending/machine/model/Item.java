package vending.machine.model;

import vending.machine.model.enums.ItemType;

public class Item {
    private static int count = 1;

    private String id;
    private ItemType itemType;

    public Item(ItemType itemType) {
        this.id = itemType.name() + "000" + (count++);
        this.itemType = itemType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", itemType=" + itemType +
                '}';
    }
}
