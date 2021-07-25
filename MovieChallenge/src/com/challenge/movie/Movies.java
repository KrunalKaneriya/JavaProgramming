package com.challenge.movie;
import java.util.ArrayList;
import java.util.Scanner;

public class Movies<T>{
    static Scanner scanner = new Scanner(System.in);

    private ArrayList<Movie>movieArrayList = new ArrayList<>();
    public Movies() {
        this.movieArrayList = new ArrayList<>();
    }

    public void addMovie(T Movie) {
        System.out.print("Enter The Movie Name: ");
        String movieName = scanner.nextLine();
        System.out.print("Enter The Movie Release Year: ");
        int releaseDate = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter The Genre (Seperated By Comma): ");
        String genre=  scanner.nextLine();
        System.out.print("Enter The Movies Cast (Seperated By Comma): ");
        String cast = scanner.nextLine();
        Movie movie = new Movie(movieName,releaseDate,genre,cast);
        movieArrayList.add(movie);
    }

    private boolean addMovie(Movie movie) {
        if(findMovie(movie) >0) {
            System.out.println("Movie Already Exists....");
            return false;
        }
        else {
                movieArrayList.add(movie);
            System.out.println("Movie Added....");
            return true;
        }
    }

    public int findMovie(Movie movie) {
        return movieArrayList.indexOf(movie);
    }



    public int findMovie(String movieName) {
        for(int i=0;i<movieArrayList.size();i++) {
            Movie movie = this.movieArrayList.get(i);
            if(movie.movieName.equals(movieName)) {
                return i;
            }
        }
        return -1;
    }

    public void printMovie(Movies movies) {
        for (int i = 0; i < movies.movieArrayList.size(); i++) {
            Movie movie = movieArrayList.get(i);
            System.out.println("Name: " + movie.getMovieName());
            System.out.println("Release Year: " + movie.getReleaseDate());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Cast: " + movie.getCast());
        }
    }


}
