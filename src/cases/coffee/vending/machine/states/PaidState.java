package cases.coffee.vending.machine.states;

import cases.coffee.vending.machine.CoffeeVendingMachine;
import cases.coffee.vending.machine.model.Item;
import cases.coffee.vending.machine.model.StateType;

import java.util.List;

public class PaidState extends AbstractState {
    public PaidState(StateType stateType) {
        super(stateType);
    }

    @Override
    public State dispenseItems(CoffeeVendingMachine coffeeVendingMachine) {
        coffeeVendingMachine.prepareItems();
        List<Item> preparedItems = coffeeVendingMachine.getPreparedItems();
        for (Item preparedItem : preparedItems) {
            System.out.printf("Dispensing %s...%n", preparedItem.getName());
        }

        return coffeeVendingMachine.getPossibleStates().get(StateType.DISPENSED);
    }
}
