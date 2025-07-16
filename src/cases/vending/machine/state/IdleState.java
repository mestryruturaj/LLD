package cases.vending.machine.state;

import cases.vending.machine.enums.ItemType;
import cases.vending.machine.enums.MachineState;
import cases.vending.machine.model.Inventory;
import cases.vending.machine.model.Item;

import java.util.Map;

public class IdleState extends StateAdapter {
    public IdleState(MachineState machineState) {
        super(machineState);
    }

    @Override
    public MachineState selectItem(Map<ItemType, Integer> selectedItems, Inventory inventory, int itemCode) {
        Item selectedItem = inventory.selectItemWithCode(itemCode);
        selectedItems.put(selectedItem.getItemType(), selectedItems.getOrDefault(selectedItem.getItemType(), 0) + 1);
        return MachineState.ITEM_SELECTED;
    }
}
