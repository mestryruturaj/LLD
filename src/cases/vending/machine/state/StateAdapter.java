package cases.vending.machine.state;

import cases.vending.machine.enums.ItemType;
import cases.vending.machine.enums.MachineState;
import cases.vending.machine.exception.VendingMachineException;
import cases.vending.machine.model.Inventory;

import java.util.Map;

public abstract class StateAdapter extends State {
    public StateAdapter(MachineState machineState) {
        super(machineState);
    }

    @Override
    public MachineState selectItem(Map<ItemType, Integer> selectedItems, Inventory inventory, int itemCode) {
        throw new VendingMachineException("Can not perform select item operation operation at state " + getMachineState().name());
    }

    @Override
    public MachineState makePayment(int amountPaid, int amountToPay) {
        throw new VendingMachineException("Can not perform make payment operation operation at state " + getMachineState().name());
    }

    @Override
    public MachineState dispense(Map<ItemType, Integer> selectedItems) {
        throw new VendingMachineException("Can not perform dispensing operation operation at state " + getMachineState().name());
    }

    @Override
    public MachineState refund(int amountToRefund) {
        throw new VendingMachineException("Can not perform refund operation operation at state " + getMachineState().name());
    }
}
