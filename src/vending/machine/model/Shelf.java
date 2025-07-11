package vending.machine.model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private static int serialNum = 0;
    private int shelfId;
    private List<Rack> racks;

    public Shelf() {
        this.shelfId = serialNum++;
        this.racks = new ArrayList<>();
    }

    public void addRack(Rack rack) {
        racks.add(rack);
    }

    public void removeRack(int rackId) {
        racks.removeIf(rack -> rack.getRackCode() == rackId);
    }

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public List<Rack> getRacks() {
        return racks;
    }

    public void setRacks(List<Rack> racks) {
        this.racks = racks;
    }
}
