package parking.lot.strategy;

import parking.lot.dto.enums.Ticket;
import parking.lot.service.TicketService;

public class FlatRateFeeCalculationStrategy implements FeeCalculationStrategy{
    private double ratePerMinute;
    private final TicketService ti;

    public FlatRateFeeCalculationStrategy(double ratePerMinute, TicketService ti) {
        this.ratePerMinute = ratePerMinute;
        this.ti = ti;
    }

    public double getRatePerMinute() {
        return ratePerMinute;
    }

    public void setRatePerMinute(double ratePerMinute) {
        this.ratePerMinute = ratePerMinute;
    }

    @Override
    public double calculateFee(Ticket ticket) {
        return ratePerMinute * ti.calculateParkingDuration(ticket);
    }
}
