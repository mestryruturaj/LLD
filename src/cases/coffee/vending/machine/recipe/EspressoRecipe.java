package cases.coffee.vending.machine.recipe;

import cases.coffee.vending.machine.model.Ingredients;
import cases.coffee.vending.machine.model.Item;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EspressoRecipe implements Recipe {
    @Override
    public Item prepare(Map<Ingredients, Integer> ingredientsQtyMap) {
        try {
            System.out.println("Started Preparing Espresso...");
            TimeUnit.MINUTES.sleep(4);
            System.out.println("Completed Preparing Espresso...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Item("Espresso");
    }
}
