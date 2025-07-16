package cases.parking.lot.service;

import cases.parking.lot.dto.Level;
import cases.parking.lot.dto.ParkingLot;
import cases.parking.lot.dto.ParkingSpot;
import cases.parking.lot.dto.Vehicle;
import cases.parking.lot.dto.enums.ParkingSpotStatus;
import cases.parking.lot.dto.enums.Ticket;
import cases.parking.lot.dto.enums.VehicleType;
import cases.parking.lot.strategy.FlatRateFeeCalculationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingLotService {

    private final TicketService ticketService;

    public ParkingLotService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ParkingLot createParkingLot(int levelCount, int spotCount) {
        return ParkingLot.createInstance(loadParkingLevels(levelCount, spotCount), new FlatRateFeeCalculationStrategy(100, ticketService));
    }

    public List<Level> loadParkingLevels(int levelCount, int parkingSpotCount) {
        List<Level> levels = new ArrayList<>();
        for (int i = 0; i < levelCount; i++) {
            levels.add(new Level(i, loadParkingSpots(parkingSpotCount, i)));
        }

        return levels;
    }

    public List<ParkingSpot> loadParkingSpots(int parkingSpotCount, int level) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        VehicleType[] vehicleTypes = VehicleType.values();
        Random random = new Random();
        for (int i = 0; i < parkingSpotCount; i++) {
            VehicleType vehicleType = vehicleTypes[random.nextInt(vehicleTypes.length)];
            String id = vehicleType.name() + level + "000" + i;
            parkingSpots.add(new ParkingSpot(id, vehicleType, ParkingSpotStatus.AVAILABLE));
        }

        return parkingSpots;
    }

    public synchronized List<ParkingSpot> getAvailableParkingSpots(ParkingLot parkingLot) {
        List<ParkingSpot> availableParkingSpots = new ArrayList<>();

        for (Level level : parkingLot.getParkingLevels()) {
            for (ParkingSpot parkingSpot : level.getParkingSpots()) {
                if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE) {
                    availableParkingSpots.add(parkingSpot);
                }
            }
        }

        return availableParkingSpots;
    }

    public synchronized List<ParkingSpot> getAvailableParkingSpotsOfType(ParkingLot parkingLot, VehicleType vehicleType) {
        List<ParkingSpot> availableParkingSpots = new ArrayList<>();

        for (Level level : parkingLot.getParkingLevels()) {
            for (ParkingSpot parkingSpot : level.getParkingSpots()) {
                if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE && parkingSpot.getVehicleType().equals(vehicleType)) {
                    availableParkingSpots.add(parkingSpot);
                }
            }
        }

        return availableParkingSpots;
    }

    public synchronized Ticket park(ParkingLot parkingLot, Vehicle vehicle, int ticketId) {
        VehicleType vehicleType = vehicle.getVehicleType();
        List<ParkingSpot> availableParkingSpots = getAvailableParkingSpotsOfType(parkingLot, vehicleType);
        if (availableParkingSpots.isEmpty()) {
            //exception
        }

        ParkingSpot parkingSpot = availableParkingSpots.get(0);
        Ticket ticket = new Ticket(ticketId, parkingSpot, vehicle, System.currentTimeMillis());

        //consequences
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.UNAVAILABLE);
        parkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(parkingSpot);
        parkingLot.getActiveParkingSpots().put(vehicle.getLicencePlate(), parkingSpot);

        return ticket;
    }

    public synchronized double unPark(ParkingLot parkingLot, Ticket ticket) {
        ticket.setUnParkedAt(System.currentTimeMillis());
        double amount = ticketService.calculateParkingDuration(ticket);

        //consequences
        ticket.getParkingSpot().setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        ticket.getParkingSpot().setVehicle(null);
        ticket.getVehicle().setParkingSpot(null);
        parkingLot.getActiveParkingSpots().remove(ticket.getVehicle().getLicencePlate());


        return amount;
    }
}
