package coffee.vending.machine.recipe;

import coffee.vending.machine.model.Ingredients;
import coffee.vending.machine.model.Item;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CappuccinoRecipe implements Recipe {
    @Override
    public Item prepare(Map<Ingredients, Integer> ingredientsQtyMap) {
        try {
            System.out.println("Started Preparing Cappuccino...");
            TimeUnit.MINUTES.sleep(4);
            System.out.println("Completed Preparing Cappuccino...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Item("Cappuccino");
    }
}
