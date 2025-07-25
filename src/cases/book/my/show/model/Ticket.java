package cases.book.my.show.model;


import cases.book.my.show.model.enums.TicketStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    private static int counter = 0;
    private final int id;
    private Booking booking;
    private TicketStatus ticketStatus;

    //constructor
    public Ticket(Booking booking, TicketStatus ticketStatus) {
        this.id = counter++;
        this.booking = booking;
        this.ticketStatus = ticketStatus;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
