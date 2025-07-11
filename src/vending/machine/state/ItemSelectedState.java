package vending.machine.state;

import vending.machine.enums.MachineState;

public class ItemSelectedState extends StateAdapter {

    public ItemSelectedState(MachineState machineState) {
        super(machineState);
    }

    @Override
    public MachineState makePayment(int amountPaid, int amountToPay) {
        if (amountToPay < amountPaid) {
            int change = amountPaid - amountToPay;
            System.out.println("Payment complete");
            System.out.println("Returning changes of " + change);
            return MachineState.PAID;
        } else if (amountToPay == amountPaid) {
            System.out.println("Payment complete");
            return MachineState.PAID;
        } else {
            System.out.println("Insufficient amount paid. Returning amount");
            return MachineState.IDLE;
        }
    }
}
