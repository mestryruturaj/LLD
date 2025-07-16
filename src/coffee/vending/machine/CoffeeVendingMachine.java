package coffee.vending.machine;

import coffee.vending.machine.model.Item;
import coffee.vending.machine.model.ItemDetail;
import vending.machine.enums.Coin;

import java.util.List;
import java.util.Map;

public class CoffeeVendingMachine {
    private Map<String, ItemDetail> items;
    private List<Coin> coins;
    private Map<ItemDetail, Integer> selectedItems;
    private ItemMaker itemMaker;
    private List<Item> preparedItems;

    public void prepareItems() {
        this.preparedItems = itemMaker.prepareItems(selectedItems);
    }

    public void displayItems() {
        for (Map.Entry<String, ItemDetail> entry : items.entrySet()) {
            System.out.printf("Item: %s, Price: %d%n", entry.getKey(), entry.getValue().getPrice());
        }
    }
}
//Receive a list of ItemDetails and qty //when at Ready
//User has passed enough coins //when at Item selected
//Prepare Items (done) //when at Paid
//Dispense //when at Prepared
//Reset to ideal state //when Dispensed
