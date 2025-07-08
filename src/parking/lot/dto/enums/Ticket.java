package parking.lot.dto.enums;

import parking.lot.dto.ParkingSpot;
import parking.lot.dto.Vehicle;

public class Ticket {
    private int ticketId;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private long parkedAt;
    private long unParkedAt;

    public Ticket(int ticketId, ParkingSpot parkingSpot, Vehicle vehicle, long parkedAt) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.parkedAt = parkedAt;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getParkedAt() {
        return parkedAt;
    }

    public void setParkedAt(long parkedAt) {
        this.parkedAt = parkedAt;
    }

    public long getUnParkedAt() {
        return unParkedAt;
    }

    public void setUnParkedAt(long unParkedAt) {
        this.unParkedAt = unParkedAt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", parkingSpot=" + parkingSpot +
                ", vehicle=" + vehicle +
                ", parkedAt=" + parkedAt +
                ", unParkedAt=" + unParkedAt +
                '}';
    }
}
