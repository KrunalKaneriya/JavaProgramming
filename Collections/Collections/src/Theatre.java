import java.util.*;

public class Theatre {
    private final String theatreName;
    public List<Seat> seats  = new ArrayList<>();



    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows-1); //This is the Char Data which is converted to int to keep track of A,B,C,D(Row letters)
        for(char row = 'A'; row<=lastRow;row++) { //Outer loop goes until the lastRow Character
            for(int seatNum = 1;seatNum<=seatsPerRow;seatNum++) { //Inner Loop goes until the seatsPerRow
                Seat seat = new Seat(row + String.format("%02d",seatNum)); //Allocating new seats as A(lastRow Iterator)01(seatsPerRow)
                seats.add(seat); //Adding seats to ArrayList
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat" + seatNumber);
            return false;
        }
//        for(Seat seat:seats){
//            System.out.println(".");
//            if(seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if(requestedSeat == null ){
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }

//        return requestedSeat.reserve();
    }



    public boolean cancelSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat>=0) {
            return seats.get(foundSeat).cancel();
        } else {
            System.out.println("There is not seat " + seatNumber);
            return false;
        }
    }

    //For testing
    public void getSeats() {
        for(Seat seat:seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    //Find Seat
    public Seat findSeat(String seatNumber) {
        Seat foundSeat = new Seat(seatNumber);
        int foundedSeat = Collections.binarySearch(seats,foundSeat,null);
        if(foundedSeat>=0) {
            System.out.println("Seat " + seats.get(foundedSeat).getSeatNumber() +" Founded ");
            return seats.get(foundedSeat);
        } else {
            System.out.println("Seat Not Found....");
            return null;
        }

    }

    //Inner Class Seat
    public class Seat implements Comparable<Seat>{
//    private class Seat{
        private final String seatNumber;
        private boolean reserved=false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());

        }
//
//        Comparator<Seat>comparator = new Comparator<>() {
//            @Override
//            public int compare(Seat seat1, Seat seat2) {
//                return seat1.getSeatNumber().compareToIgnoreCase(seat2.getSeatNumber());
//            }
//        };



        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            else {
                System.out.println("Sorry Seat is already Taken.");
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            }
            else {
                System.out.println("Seat " + seatNumber + " is not reserved.");
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }

}

