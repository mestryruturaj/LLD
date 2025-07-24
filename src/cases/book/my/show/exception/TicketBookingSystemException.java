package cases.book.my.show.exception;

public class TicketBookingSystemException extends RuntimeException {
    public TicketBookingSystemException() {
    }

    public TicketBookingSystemException(String message) {
        super(message);
    }
}
