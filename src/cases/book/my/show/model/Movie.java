package cases.book.my.show.model;

import cases.book.my.show.model.enums.Genre;
import cases.book.my.show.model.enums.MovieCategory;

import java.util.List;

public class Movie {
    private static int counter = 0;
    private final int id;
    private String movieName;
    private MovieCategory movieCategory;
    private int movieDuration;
    private List<Genre> genres;

    //constructor
    public Movie(String movieName, MovieCategory movieCategory, int movieDuration, List<Genre> genres) {
        this.id = counter++;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.movieDuration = movieDuration;
        this.genres = genres;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
