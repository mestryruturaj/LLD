package cases.book.my.show.model;

import cases.book.my.show.model.enums.ScreenFeature;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private static int counter = 0;
    private final int id;
    private List<Seat> seats;
    private List<ScreenFeature> screenFeatures;
    private Theater theater;

    //constructor
    public Screen(List<ScreenFeature> screenFeatures, Theater theater) {
        this.id = counter++;
        this.seats = new ArrayList<>();
        this.screenFeatures = screenFeatures;
        this.theater = theater;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<ScreenFeature> getScreenFeatures() {
        return screenFeatures;
    }

    public void setScreenFeatures(List<ScreenFeature> screenFeatures) {
        this.screenFeatures = screenFeatures;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
