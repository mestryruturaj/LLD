package cases.vending.machine.model;

import cases.vending.machine.enums.ItemType;

public class Item {
    private static int serialNum = 0;
    private int id;
    private ItemType itemType;

    public Item(ItemType itemType) {
        this.id = serialNum++;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
