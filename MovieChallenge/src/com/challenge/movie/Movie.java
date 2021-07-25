package com.challenge.movie;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie{

    String movieName;
    int releaseDate;
    String genre;
    String cast;


    public Movie(String movieName, int releaseDate, String genre, String cast) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.cast = cast;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }



}
