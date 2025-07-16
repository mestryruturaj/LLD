package cases.coffee.vending.machine.recipe;

import cases.coffee.vending.machine.model.Ingredients;
import cases.coffee.vending.machine.model.Item;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RegularCoffeeRecipe implements Recipe {
    @Override
    public Item prepare(Map<Ingredients, Integer> ingredientsQtyMap) {
        try {
            System.out.println("Started Preparing Regular Coffee...");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("Completed Preparing Regular Coffee...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Item("Regular Coffee");
    }
}
