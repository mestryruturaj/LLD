package cases.coffee.vending.machine.states;

import cases.coffee.vending.machine.CoffeeVendingMachine;
import cases.coffee.vending.machine.model.Coin;
import cases.coffee.vending.machine.model.ItemDetail;
import cases.coffee.vending.machine.model.StateType;
import cases.vending.machine.exception.VendingMachineException;

import java.util.List;
import java.util.Map;

public class AbstractState implements State {
    private StateType stateType;

    public AbstractState(StateType stateType) {
        this.stateType = stateType;
    }

    @Override
    public State selectItems(CoffeeVendingMachine coffeeVendingMachine, Map<ItemDetail, Integer> selectedItems) {
        throw new VendingMachineException("Not Allowed: selectItems(...) is not allowed at " + stateType.name() + ".");
    }

    @Override
    public State makePayment(CoffeeVendingMachine coffeeVendingMachine, List<Coin> coins) {
        throw new VendingMachineException("Not Allowed: makePayment(...) is not allowed at " + stateType.name() + ".");
    }

    @Override
    public State dispenseItems(CoffeeVendingMachine coffeeVendingMachine) {
        throw new VendingMachineException("Not Allowed: dispenseItems(...) is not allowed at " + stateType.name() + ".");
    }

    @Override
    public State reset(CoffeeVendingMachine coffeeVendingMachine) {
        coffeeVendingMachine.getCoins().clear();
        coffeeVendingMachine.getSelectedItems().clear();
        return coffeeVendingMachine.getPossibleStates().get(StateType.READY);
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }
}
