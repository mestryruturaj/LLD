package cases.coffee.vending.machine.states;

import cases.coffee.vending.machine.CoffeeVendingMachine;
import cases.coffee.vending.machine.model.ItemDetail;
import cases.coffee.vending.machine.model.StateType;

import java.util.Map;

public class ReadyState extends AbstractState {
    public ReadyState(StateType stateType) {
        super(stateType);
    }

    @Override
    public State selectItems(CoffeeVendingMachine coffeeVendingMachine, Map<ItemDetail, Integer> selectedItems) {
        coffeeVendingMachine.setSelectedItems(selectedItems);
        return coffeeVendingMachine.getPossibleStates().get(StateType.ITEMS_SELECTED);
    }
}
