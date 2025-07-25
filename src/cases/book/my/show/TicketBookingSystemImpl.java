package cases.book.my.show;

import cases.book.my.show.exception.TicketBookingSystemException;
import cases.book.my.show.model.*;
import cases.book.my.show.model.enums.TicketStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static cases.book.my.show.model.enums.SeatStatus.BOOKED;

public class TicketBookingSystemImpl implements TicketBookingSystem {
    private Map<Show, List<ShowSeat>> bookedShowSeats;

    @Override
    public synchronized Booking bookTicket(Show show, Screen screen, List<int[]> seats, User user) {
        if (!checkWhetherSeatsAvailable(show, seats)) {
            throw new TicketBookingSystemException("Selected seats are unavailable.");
        }
        List<ShowSeat> bookedSeats = new ArrayList<>();
        bookedShowSeats.putIfAbsent(show, new ArrayList<>());
        for (int[] cell : seats) {
            for (Seat seat : screen.getSeats()) {
                if (seat.getRow() == cell[0] && seat.getCol() == cell[1]) {
                    ShowSeat curShowSeat = new ShowSeat(show, seat);
                    curShowSeat.setSeatStatus(BOOKED);
                    bookedSeats.add(curShowSeat);
                    break;
                }
            }
        }

        bookedShowSeats.get(show).addAll(bookedSeats);
        return new Booking(bookedSeats, user);
    }

    private boolean checkWhetherSeatsAvailable(Show show, List<int[]> seats) {
        if (!bookedShowSeats.containsKey(show)) {
            return true;
        }

        for (int[] cell : seats) {
            for (ShowSeat showSeat : bookedShowSeats.get(show)) {
                if (cell[0] == showSeat.getSeat().getRow() && cell[1] == showSeat.getSeat().getCol()) {
                    return false;
                }
            }
        }

        return true;
    }

    //make payment
    public Ticket makePayment(Booking booking) {
        //payment logic
        return new Ticket(booking, TicketStatus.PAID);
    }

    @Override
    public List<Ticket> getAllTicketsForUser(User user) {
        return user.getBookedTickets();
    }
}