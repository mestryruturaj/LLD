package parking.lot.strategy;

import parking.lot.dto.enums.Ticket;

public interface FeeCalculationStrategy {
    public double calculateFee(Ticket ticket);
}
