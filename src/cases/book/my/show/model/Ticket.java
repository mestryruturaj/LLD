package cases.book.my.show.model;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    private static int counter = 0;
    private int id;
    private List<ShowSeat> showSeats;
    private User user;
    private final Timestamp createdAt;

    //constructor
    public Ticket(List<ShowSeat> showSeat, User user) {
        this.showSeats = showSeat;
        this.user = user;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
