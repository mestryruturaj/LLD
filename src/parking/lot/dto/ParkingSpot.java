package parking.lot.dto;

import parking.lot.dto.enums.ParkingSpotStatus;
import parking.lot.dto.enums.VehicleType;

public class ParkingSpot {
    private String parkingSpotId;
    private VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle vehicle;

    public ParkingSpot(String parkingSpotId, VehicleType vehicleType, ParkingSpotStatus parkingSPotStatus) {
        this.parkingSpotId = parkingSpotId;
        this.vehicleType = vehicleType;
        this.parkingSpotStatus = parkingSPotStatus;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSpotId='" + parkingSpotId + '\'' +
                ", vehicleType=" + vehicleType +
                ", parkingSpotStatus=" + parkingSpotStatus +
                ", vehicle=" + vehicle +
                '}';
    }
}
