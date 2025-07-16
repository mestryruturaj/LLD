package cases.coffee.vending.machine.model;

import cases.coffee.vending.machine.recipe.Recipe;

import java.util.Map;

public class ItemDetail {
    private String name;
    private int price;
    private Map<Ingredients, Integer> ingredientsQtyMap;
    private Recipe recipe;

    public ItemDetail(String name, int price, Map<Ingredients, Integer> ingredientsQtyMap, Recipe recipe) {
        this.name = name;
        this.price = price;
        this.ingredientsQtyMap = ingredientsQtyMap;
        this.recipe = recipe;
    }

    public Item prepare() {
        return recipe.prepare(ingredientsQtyMap);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<Ingredients, Integer> getIngredientsQtyMap() {
        return ingredientsQtyMap;
    }

    public void setIngredientsQtyMap(Map<Ingredients, Integer> ingredientsQtyMap) {
        this.ingredientsQtyMap = ingredientsQtyMap;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
