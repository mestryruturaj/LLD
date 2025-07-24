package cases.book.my.show.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int counter = 0;
    private int id;
    private String name;
    private List<Ticket> bookedTickets;

    //constructor
    public User(String name) {
        this.id = counter++;
        this.name = name;
        this.bookedTickets = new ArrayList<>();
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }
}
