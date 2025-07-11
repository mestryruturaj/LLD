package vending.machine.state;

import vending.machine.enums.ItemType;
import vending.machine.enums.MachineState;

import java.util.Map;

public class PaidState extends StateAdapter {
    public PaidState(MachineState machineState) {
        super(machineState);
    }

    @Override
    public MachineState dispense(Map<ItemType, Integer> selectedItems) {
        System.out.println("Dispensing in progress...");
        for (Map.Entry<ItemType, Integer> entry : selectedItems.entrySet()) {
            System.out.println("Dispensed item : " + entry.getKey() + " with qty " + entry.getValue() + ".");
        }
        System.out.println("Dispensing completed.");
        return MachineState.DISPENSED;
    }

    @Override
    public MachineState refund(int amountToRefund) {
        System.out.println("Amount of RS. " + amountToRefund + " is refunded.");
        return MachineState.IDLE;
    }
}
