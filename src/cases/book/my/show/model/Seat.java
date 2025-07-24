package cases.book.my.show.model;

import cases.book.my.show.model.enums.SeatCategory;
import cases.book.my.show.model.enums.SeatStatus;

public class Seat {
    private static int counter = 0;
    private final int id;
    private int row;
    private int col;
    private SeatCategory seatCategory;
    private Screen screen;

    //constructor
    public Seat(int row, int col, SeatCategory seatCategory, Screen screen) {
        this.id = counter++;
        this.row = row;
        this.col = col;
        this.seatCategory = seatCategory;
        this.screen = screen;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
