package cases.book.my.show.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {
    private static int counter = 0;
    private final int id;
    private Screen screen;
    private LocalDate showDate;
    private LocalTime showTime;
    private Movie movie;

    //constructor
    public Show(Screen screen, LocalDate showDate, LocalTime showTime, Movie movie) {
        this.id = counter++;
        this.screen = screen;
        this.showDate = showDate;
        this.showTime = showTime;
        this.movie = movie;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
