package cases.coffee.vending.machine;

import cases.coffee.vending.machine.model.Coin;
import cases.coffee.vending.machine.model.Ingredients;
import cases.coffee.vending.machine.model.ItemDetail;
import cases.coffee.vending.machine.model.StateType;
import cases.coffee.vending.machine.recipe.CappuccinoRecipe;
import cases.coffee.vending.machine.recipe.EspressoRecipe;
import cases.coffee.vending.machine.recipe.LatteRecipe;
import cases.coffee.vending.machine.recipe.RegularCoffeeRecipe;
import cases.coffee.vending.machine.states.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        //item maker
        ItemMaker itemMaker = new ItemMaker();

        //item details
        ItemDetail regularCoffeeDetail = new ItemDetail("Regular Coffee", 6, Map.of(Ingredients.COFFEE_BEANS, 10, Ingredients.MILK, 5), new RegularCoffeeRecipe());
        ItemDetail cappuccinoDetail = new ItemDetail("Cappuccino", 5, Map.of(Ingredients.COFFEE_BEANS, 8, Ingredients.MILK, 7), new CappuccinoRecipe());
        ItemDetail LatteDetail = new ItemDetail("Latte", 4, Map.of(Ingredients.COFFEE_BEANS, 11, Ingredients.MILK, 2), new LatteRecipe());
        ItemDetail espressoDetail = new ItemDetail("Espresso", 8, Map.of(Ingredients.COFFEE_BEANS, 11, Ingredients.MILK, 3), new EspressoRecipe());
        Map<String, ItemDetail> items = new HashMap<>();
        items.put(regularCoffeeDetail.getName(), regularCoffeeDetail);
        items.put(cappuccinoDetail.getName(), cappuccinoDetail);
        items.put(LatteDetail.getName(), LatteDetail);
        items.put(espressoDetail.getName(), espressoDetail);

        //possible states
        State readyState = new ReadyState(StateType.READY);
        State itemSelectedState = new ItemsSelectedState(StateType.ITEMS_SELECTED);
        State paidState = new PaidState(StateType.PAID);
        State dispensedState = new DispensedState(StateType.DISPENSED);
        Map<StateType, State> possibleState = new HashMap<>();
        possibleState.put(StateType.READY, readyState);
        possibleState.put(StateType.ITEMS_SELECTED, itemSelectedState);
        possibleState.put(StateType.PAID, paidState);
        possibleState.put(StateType.DISPENSED, dispensedState);

        CoffeeVendingMachine coffeeVendingMachine = new CoffeeVendingMachine(items, itemMaker, possibleState);

        coffeeVendingMachine.displayItems();
        System.out.println();

        coffeeVendingMachine.selectItems(new HashMap<>(Map.of(regularCoffeeDetail, 1, LatteDetail, 1)));
        System.out.println();
        coffeeVendingMachine.makePayment(new ArrayList<>(List.of(Coin.FIVE, Coin.FIVE, Coin.TWO, Coin.ONE, Coin.FIVE)));
        System.out.println();
        coffeeVendingMachine.dispense();
        System.out.println();
        coffeeVendingMachine.reset();
        System.out.println();

    }
}
