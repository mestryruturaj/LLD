package cases.coffee.vending.machine.recipe;

import cases.coffee.vending.machine.model.Ingredients;
import cases.coffee.vending.machine.model.Item;

import java.util.Map;

public interface Recipe {
    public Item prepare(Map<Ingredients, Integer> ingredientsQtyMap);
}
