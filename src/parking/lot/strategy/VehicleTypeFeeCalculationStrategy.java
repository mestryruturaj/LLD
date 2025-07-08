package parking.lot.strategy;

import parking.lot.dto.enums.Ticket;
import parking.lot.dto.enums.VehicleType;
import parking.lot.service.TicketService;

import java.util.Map;

public class VehicleTypeFeeCalculationStrategy implements FeeCalculationStrategy {
    private Map<VehicleType, Double> vehicleTypeToRatePerMinute;
    private final TicketService ticketService;

    public VehicleTypeFeeCalculationStrategy(TicketService ticketService, Map<VehicleType, Double> vehicleTypeToRatePerMinute) {
        this.ticketService = ticketService;
        this.vehicleTypeToRatePerMinute = vehicleTypeToRatePerMinute;
    }

    public Map<VehicleType, Double> getVehicleTypeToRatePerMinute() {
        return vehicleTypeToRatePerMinute;
    }

    public void setVehicleTypeToRatePerMinute(Map<VehicleType, Double> vehicleTypeToRatePerMinute) {
        this.vehicleTypeToRatePerMinute = vehicleTypeToRatePerMinute;
    }

    public TicketService getTicketService() {
        return ticketService;
    }

    @Override
    public double calculateFee(Ticket ticket) {
        return vehicleTypeToRatePerMinute.get(ticket.getParkingSpot().getVehicleType()) * ticketService.calculateParkingDuration(ticket);
    }
}
