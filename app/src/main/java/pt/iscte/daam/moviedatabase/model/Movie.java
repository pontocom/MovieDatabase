package pt.iscte.daam.moviedatabase.model;

/**
 * Created by cserrao on 29/03/2017.
 */

public class Movie {
    public String movieName;
    public String movieYear;
    public String movieImdbId;
    public String moviePoster;

    public Movie(String movieName, String movieYear, String movieImdbId, String moviePoster) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieImdbId = movieImdbId;
        this.moviePoster = moviePoster;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public String getMovieImdbId() {
        return movieImdbId;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public void setMovieImdbId(String movieImdbId) {
        this.movieImdbId = movieImdbId;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
}
