package cases.parking.lot.strategy;

import cases.parking.lot.dto.enums.Ticket;

public interface FeeCalculationStrategy {
    public double calculateFee(Ticket ticket);
}
