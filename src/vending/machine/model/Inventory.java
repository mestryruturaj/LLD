package vending.machine.model;

import vending.machine.enums.ItemType;
import vending.machine.exception.VendingMachineException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Shelf> shelves;

    public Inventory() {
        this.shelves = new ArrayList<>();
    }

    public void addShelf(Shelf shelf) {
        shelves.add(shelf);
    }

    public void removeShelf(int shelfId) {
        shelves.removeIf(shelf -> shelf.getShelfId() == shelfId);
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public Item selectItemWithCode(int itemCode) {
        for (Shelf shelf : shelves) {
            for (Rack rack : shelf.getRacks()) {
                if (rack.getRackCode() == itemCode) {
                    return rack.removeItem();
                }
            }
        }

        throw new VendingMachineException("Item does not exist.");
    }

    public void reStock(Map<ItemType, Integer> stock) {
        for (Shelf shelf : shelves) {
            for (Rack rack : shelf.getRacks()) {
                if (stock.containsKey(rack.getItemType())) {
                    for (int i = 0; i < stock.get(rack.getItemType()); i++) {
                        rack.addItem(new Item(rack.getItemType()));
                    }

                    stock.remove(rack.getItemType());
                }
            }
        }
    }
}
