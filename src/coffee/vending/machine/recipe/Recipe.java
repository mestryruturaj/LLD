package coffee.vending.machine.recipe;

import coffee.vending.machine.model.Ingredients;
import coffee.vending.machine.model.Item;
import coffee.vending.machine.model.ItemDetail;

import java.util.Map;

public interface Recipe {
    public Item prepare(Map<Ingredients, Integer> ingredientsQtyMap);
}
