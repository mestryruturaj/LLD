package cases.coffee.vending.machine;

import cases.coffee.vending.machine.model.Item;
import cases.coffee.vending.machine.model.ItemDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemMaker {
    public List<Item> prepareItems(Map<ItemDetail, Integer> selectedItems) {
        ArrayList<Item> preparedItems = new ArrayList<>();
        for (Map.Entry<ItemDetail, Integer> entry : selectedItems.entrySet()) {
            ItemDetail itemDetail = entry.getKey();
            int qty = entry.getValue();
            for (int i = 0; i < qty; i++) {
                preparedItems.add(itemDetail.prepare());
            }
        }

        return preparedItems;
    }

}
