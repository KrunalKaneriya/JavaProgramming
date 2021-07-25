import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian",8,12);
//        theatre.getSeats();
//        theatre.reserveSeat("H12");
//        theatre.reserveSeat("A02");
//        theatre.cancelSeat("A02");
//        theatre.cancelSeat("A02");
//        theatre.findSeat("B02").reserve();
//        theatre.findSeat("B02").reserve();
//        theatre.findSeat("B02").cancel();
//        theatre.findSeat("B02").cancel();
//        theatre.findSeat("Z02");
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//        printList(seatCopy);
//        seatCopy.get(1).reserve();
//        if(theatre.reserveSeat("A02")) {
//            System.out.println("Please Pay For it.");
//        } else {
//            System.out.println("Seat ALready Reserved");
//        }

        Collections.shuffle( seatCopy);
        System.out.println("Printing SeatCopy");
        printList(seatCopy);
        System.out.println("Printing OG Copy");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min Seat Number is " + minSeat.getSeatNumber());
        System.out.println("Max Seat Number is " + maxSeat.getSeatNumber());
        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

//        List<Theatre.Seat>copyOfSeats = new ArrayList<>(theatre.seats.size());
//        Collections.copy(copyOfSeats,theatre.seats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat:list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=========================================================");
    }
    public static void sortList(List<? extends Theatre.Seat> list) {
        for(int i=0;i<list.size() -1;i++) {
            for(int j=i+1;j<list.size();j++) {
                if(list.get(i).compareTo(list.get(j))>0) {
                    Collections.swap(list,i,j);
                }
            }
        }
    }
}
