package parking.lot.dto;

import parking.lot.dto.enums.VehicleType;

public class Vehicle {
    private VehicleType vehicleType;
    private String licencePlate; //unique
    private Driver driver;
    private ParkingSpot parkingSpot;

    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType, String licencePlate, Driver driver) {
        this.vehicleType = vehicleType;
        this.licencePlate = licencePlate;
        this.driver = driver;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                ", licencePlate='" + licencePlate + '\'' +
                '}';
    }
}
