package cases.book.my.show;

import cases.book.my.show.model.*;

import java.util.List;

public interface TicketBookingSystem {
    public Booking bookTicket(Show show, Screen screen, List<int[]> seats, User user);

    public List<Ticket> getAllTicketsForUser(User user);
}
