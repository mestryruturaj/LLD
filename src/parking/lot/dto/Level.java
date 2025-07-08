package parking.lot.dto;

import java.util.List;

public class Level {
    private int levelId;
    private List<ParkingSpot> parkingSpots;

    public Level(int levelId, List<ParkingSpot> parkingSpots) {
        this.levelId = levelId;
        this.parkingSpots = parkingSpots;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
