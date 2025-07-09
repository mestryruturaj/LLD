package parking.lot;

import parking.lot.dto.ParkingLot;
import parking.lot.dto.Vehicle;
import parking.lot.dto.enums.Ticket;
import parking.lot.dto.enums.VehicleType;
import parking.lot.service.ParkingLotService;
import parking.lot.service.TicketService;

import java.util.concurrent.TimeUnit;

public class Client {
    private static int ticketCount = 1;

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        ParkingLotService parkingLotService = new ParkingLotService(ticketService);

        ParkingLot parkingLot = parkingLotService.createParkingLot(4, 100);

        Vehicle vehicle = new Vehicle(VehicleType.MEDIUM, "MH04 AF 0674", null);


        Ticket ticket = parkingLotService.park(parkingLot, vehicle, ticketCount++);

        System.out.println(ticket);
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double amount = parkingLotService.unPark(parkingLot, ticket);

        System.out.println(ticket);
        System.out.println(amount);
    }
}

