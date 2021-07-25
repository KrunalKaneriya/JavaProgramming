import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats  = new ArrayList<>();

    static final Comparator<Seat>PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if(seat1.getPrice()>seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }

        }
    };

    static final Comparator<Seat>SEAT_ORDER  = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            return seat1.getSeatNumber().compareToIgnoreCase(seat2.getSeatNumber());
        }
    };


    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows-1); //This is the Char Data which is converted to int to keep track of A,B,C,D(Row letters)
        for(char row = 'A'; row<=lastRow;row++) { //Outer loop goes until the lastRow Character
            for(int seatNum = 1;seatNum<=seatsPerRow;seatNum++) { //Inner Loop goes until the seatsPerRow
                double price = 12.00;

                if((row<'D') && (seatNum>=4 && seatNum<=9)) { //If the seat is at First 3 Rows and it is not at edges then it will take price of 14 because it is consider as premium
                    price = 14.00;
                } else if((row>'F') || (seatNum<4) || seatNum>9){ //If the seat is at last and the edges then the price will be less
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d",seatNum),price); //Allocating new seats as A(lastRow Iterator)01(seatsPerRow)
                seats.add(seat); //Adding seats to ArrayList
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber,0);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }



    public boolean cancelSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber,0);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat>=0) {
            return seats.get(foundSeat).cancel();
        } else {
            System.out.println("There is not seat " + seatNumber);
            return false;
        }
    }

    //For testing
    public Collection<Seat> getSeats() {
        return seats;
    }



//    Find Seat
//    public Seat findSeat(String seatNumber) {
//        Seat foundSeat = new Seat(seatNumber);
//        int foundedSeat = Collections.binarySearch(seats,foundSeat,null);
//        if(foundedSeat>=0) {
//            System.out.println("Seat " + seats.get(foundedSeat).getSeatNumber() +" Founded ");
//            return seats.get(foundedSeat);
//        } else {
//            System.out.println("Seat Not Found....");
//            return null;
//        }
//
//    }

    //Inner Class Seat
    public class Seat implements Comparable<Seat>{
        //    private class Seat{
        private double price;
        private final String seatNumber;
        private boolean reserved=false;

        public Seat(String seatNumber,double price) {
            this.seatNumber = seatNumber;
            this.price=price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());

        }

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

        public double getPrice() {
            return price;
        }
    }

}

