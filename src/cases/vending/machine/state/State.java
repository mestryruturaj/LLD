package cases.vending.machine.state;

import cases.vending.machine.enums.ItemType;
import cases.vending.machine.enums.MachineState;
import cases.vending.machine.model.Inventory;

import java.util.Map;

public abstract class State {
    private final MachineState machineState;

    public State(MachineState machineState) {
        this.machineState = machineState;
    }

    public abstract MachineState selectItem(Map<ItemType, Integer> selectedItems, Inventory inventory, int itemCode);

    public abstract MachineState makePayment(int amountPaid, int amountToPay);

    public abstract MachineState dispense(Map<ItemType, Integer> selectedItems);

    public abstract MachineState refund(int amountToRefund);

    public MachineState getMachineState() {
        return machineState;
    }
}
