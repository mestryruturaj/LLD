package cases.book.my.show.model;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private static int counter = 0;
    private final int id;
    private List<Screen> screens;
    private Address address;

    //constructor
    public Theater(Address address) {
        this.id = counter++;
        this.screens = new ArrayList<>();
        this.address = address;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
