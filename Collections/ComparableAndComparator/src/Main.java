import java.util.ArrayList;
import java.util.Collection;
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

        List<Theatre.Seat>copyOfSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(copyOfSeats);
//        printList(copyOfSeats);


        List<Theatre.Seat>priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00",13.00));
        priceSeats.add(theatre.new Seat("A00",13.00));
//        Collections.sort(priceSeats,Theatre.PRICE_ORDER);
        Collections.sort(priceSeats);

        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat:list) {
            System.out.print(" " + seat.getSeatNumber() + " $ " + seat.getPrice());
        }
        System.out.println();
        System.out.println("=========================================================");
    }

}
