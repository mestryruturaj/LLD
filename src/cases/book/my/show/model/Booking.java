package cases.book.my.show.model;

import cases.book.my.show.model.enums.SeatCategory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private static int counter = 0;
    private final int bookingId;
    private List<ShowSeat> showSeats;
    private User user;
    private final Timestamp createdAt;
    private double bookingTotal;

    //constructor
    public Booking(List<ShowSeat> showSeats, User user) {
        this.bookingId = counter++;
        this.showSeats = showSeats;
        this.user = user;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.bookingTotal = calculateBookingTotal();
    }

    //helper
    private double calculateBookingTotal() {
        double total = 0D;
        for (ShowSeat curShowSeat : showSeats) {
            Show curShow = curShowSeat.getShow();
            Seat curSeat = curShowSeat.getSeat();
            SeatCategory seatCategory = curSeat.getSeatCategory();
            Double price = curShow.getSeatPrice().get(seatCategory);

            total += price;
        }

        return total;
    }

    //getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public double getBookingTotal() {
        return bookingTotal;
    }

    public void setBookingTotal(double bookingTotal) {
        this.bookingTotal = bookingTotal;
    }
}
