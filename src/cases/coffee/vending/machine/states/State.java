package cases.coffee.vending.machine.states;

import cases.coffee.vending.machine.CoffeeVendingMachine;
import cases.coffee.vending.machine.model.Coin;
import cases.coffee.vending.machine.model.ItemDetail;

import java.util.List;
import java.util.Map;

public interface State {
    public State selectItems(CoffeeVendingMachine coffeeVendingMachine, Map<ItemDetail, Integer> selectedItems);

    public State makePayment(CoffeeVendingMachine coffeeVendingMachine, List<Coin> coins);

    public State dispenseItems(CoffeeVendingMachine coffeeVendingMachine);

    public State reset(CoffeeVendingMachine coffeeVendingMachine);
}
