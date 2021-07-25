import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian",8,12);

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please Pay For it.");
        } else {
            System.out.println("Seat Already Reserved");
        }
        if(theatre.reserveSeat("B13")) {
            System.out.println("Please Pay For it.");
        } else {
            System.out.println("Seat Already Reserved");
        }
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat:list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=========================================================");
    }

}
