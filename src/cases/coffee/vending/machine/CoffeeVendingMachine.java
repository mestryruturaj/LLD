package cases.coffee.vending.machine;

import cases.coffee.vending.machine.model.Coin;
import cases.coffee.vending.machine.model.Item;
import cases.coffee.vending.machine.model.ItemDetail;
import cases.coffee.vending.machine.model.StateType;
import cases.coffee.vending.machine.states.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeVendingMachine {
    private Map<String, ItemDetail> items;
    private List<Coin> coins;
    private Map<ItemDetail, Integer> selectedItems;
    private ItemMaker itemMaker;
    private List<Item> preparedItems;
    private Map<StateType, State> possibleStates;
    private State currentState;

    public CoffeeVendingMachine(Map<String, ItemDetail> items, ItemMaker itemMaker, Map<StateType, State> possibleStates) {
        this.items = items;
        this.itemMaker = itemMaker;
        this.possibleStates = possibleStates;
        this.currentState = possibleStates.get(StateType.READY);
        this.coins = new ArrayList<>();
        this.selectedItems = new HashMap<>();
        this.preparedItems = new ArrayList<>();
    }

    //Service
    public void prepareItems() {
        this.preparedItems = itemMaker.prepareItems(selectedItems);
    }

    public void displayItems() {
        for (Map.Entry<String, ItemDetail> entry : items.entrySet()) {
            System.out.printf("Item: %s, Price: %d%n", entry.getKey(), entry.getValue().getPrice());
        }
    }

    public void selectItems(Map<ItemDetail, Integer> selectedItems) {
        System.out.println("Selecting items started");
        currentState = currentState.selectItems(this, selectedItems);
        System.out.println("Selecting items ended.");
    }

    public void makePayment(List<Coin> coins) {
        System.out.println("Making payments started.");
        currentState = currentState.makePayment(this, coins);
        System.out.println("Making payments ended.");
    }

    public void dispense() {
        System.out.println("Dispensing started.");
        currentState = currentState.dispenseItems(this);
        System.out.println("Dispensing ended.");
    }

    public void reset() {
        System.out.println("Reset started.");
        currentState = currentState.reset(this);
        System.out.println("Reset end.");
    }


    //Getters and Setters
    public Map<String, ItemDetail> getItems() {
        return items;
    }

    public void setItems(Map<String, ItemDetail> items) {
        this.items = items;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public Map<ItemDetail, Integer> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(Map<ItemDetail, Integer> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public ItemMaker getItemMaker() {
        return itemMaker;
    }

    public void setItemMaker(ItemMaker itemMaker) {
        this.itemMaker = itemMaker;
    }

    public List<Item> getPreparedItems() {
        return preparedItems;
    }

    public Map<StateType, State> getPossibleStates() {
        return possibleStates;
    }

    public void setPossibleStates(Map<StateType, State> possibleStates) {
        this.possibleStates = possibleStates;
    }
}
//Receive a list of ItemDetails and qty //when at Ready
//User has passed enough coins //when at Item selected
//Prepare Items (done) //when at Paid
//Dispense //when at Paid
//Reset to ideal state //when Dispensed
