package cases.book.my.show.model;

import cases.book.my.show.model.enums.SeatStatus;

public class ShowSeat {
    private static int counter = 0;
    private final int id;
    private Show show;
    private Seat seat;
    private SeatStatus seatStatus;

    //constructor
    public ShowSeat(Show show, Seat seat) {
        this.id = counter++;
        this.show = show;
        this.seat = seat;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
