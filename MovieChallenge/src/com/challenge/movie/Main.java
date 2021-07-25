package com.challenge.movie;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
	    Movies<Movie> movieset1 = new Movies<>();
	    Movie tenet = new Movie("Tenet",2020,"Thriller","Christopher Nolan");
		Movie drstrange = new Movie("DR. Strange",2016,"Action","Benedict Cumbercatch");
	    movieset1.addMovie(tenet);
	    movieset1.addMovie(drstrange);
	    Movies<Movie>movieset2 = new Movies<>();


//	    while (true) {
//			System.out.println("********************************************");
//			System.out.println("1. To Add Movie");
//			System.out.println("2. To Print Movies");
//			System.out.println("Enter Your Choice: ");
//			int choice = scanner.nextInt();
//	    	switch (choice) {
//				case 1:
//					movieset1.addMovie();
//					break;
//				case 2:
//					movieset1.printMovie(movieset1);
//					break;
//				default:
//					System.out.println("Invalid Choice.....");
//
//			}
//		}


    }
}
