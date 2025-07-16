package cases.parking.lot.service;

import cases.parking.lot.dto.enums.Ticket;

import java.util.concurrent.TimeUnit;

public class TicketService {
    public long calculateParkingDuration(Ticket ticket) {
        return TimeUnit.MILLISECONDS.toSeconds(ticket.getUnParkedAt() - ticket.getParkedAt());
    }
}
