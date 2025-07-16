package cases.parking.lot.dto;

import cases.parking.lot.strategy.FeeCalculationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot INSTANCE;
    private List<Level> parkingLevels;
    private Map<String, ParkingSpot> activeParkingSpots;
    private FeeCalculationStrategy feeCalculator;

    private ParkingLot(List<Level> parkingLevels, Map<String, ParkingSpot> activeParkingSpots, FeeCalculationStrategy feeCalculator) {
        this.parkingLevels = parkingLevels;
        this.activeParkingSpots = activeParkingSpots;
        this.feeCalculator = feeCalculator;
    }

    public List<Level> getParkingLevels() {
        return parkingLevels;
    }

    public void setParkingLevels(List<Level> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    public Map<String, ParkingSpot> getActiveParkingSpots() {
        return activeParkingSpots;
    }

    public void setActiveParkingSpots(Map<String, ParkingSpot> activeParkingSpots) {
        this.activeParkingSpots = activeParkingSpots;
    }

    public FeeCalculationStrategy getFeeCalculator() {
        return feeCalculator;
    }

    public void setFeeCalculator(FeeCalculationStrategy feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public static ParkingLot createInstance(List<Level> parkingLevels, FeeCalculationStrategy feeCalculator) {
        if (INSTANCE == null) {
            synchronized (ParkingLot.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ParkingLot(parkingLevels, new HashMap<>(), feeCalculator);
                }
            }
        }

        return INSTANCE;
    }
}
