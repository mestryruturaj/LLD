package cases.coffee.vending.machine.states;

import cases.coffee.vending.machine.CoffeeVendingMachine;
import cases.coffee.vending.machine.model.Coin;
import cases.coffee.vending.machine.model.ItemDetail;
import cases.coffee.vending.machine.model.StateType;
import cases.vending.machine.exception.VendingMachineException;

import java.util.List;
import java.util.Map;

public class ItemsSelectedState extends AbstractState {
    public ItemsSelectedState(StateType stateType) {
        super(stateType);
    }

    @Override
    public State makePayment(CoffeeVendingMachine coffeeVendingMachine, List<Coin> coins) {
        Map<ItemDetail, Integer> selectedItems = coffeeVendingMachine.getSelectedItems();
        int valueOfInsertedCoins = 0;
        for (Coin coin : coins) {
            int coinValue = coin.getValue();
            valueOfInsertedCoins += coinValue;
        }

        int itemsGrandTotal = 0;
        for (Map.Entry<ItemDetail, Integer> entry : selectedItems.entrySet()) {
            int price = entry.getKey().getPrice();
            int count = entry.getValue();
            itemsGrandTotal += price * count;
        }

        if (valueOfInsertedCoins < itemsGrandTotal) {
            throw new VendingMachineException("Inserted amount is not enough. Please insert more coins worth RS." + (itemsGrandTotal - valueOfInsertedCoins));
        } else if (valueOfInsertedCoins > itemsGrandTotal) {
            System.out.println("Returning change worth RS. " + (valueOfInsertedCoins - itemsGrandTotal));
        }

        return coffeeVendingMachine.getPossibleStates().get(StateType.PAID);
    }
}
