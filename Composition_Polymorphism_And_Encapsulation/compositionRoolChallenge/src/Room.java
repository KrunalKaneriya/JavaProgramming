public class Room {


    private String roomSize;
      private boolean roomCleaned;
    private int roomArea;
    private int roomLength;
    private int roomWidth;

    //Classes Variables
    private Furniture furniture;
    private Bed bed;
    private Television television;
    private Bathroom bathroom;

    public Furniture getFurniture() {
        return furniture;
    }

    public Bed getBed() {
        return bed;
    }

    public Television getTelevision() {
        return television;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public Room(Furniture furniture, Bed bed, Television television, Bathroom bathroom) {
        this.furniture = furniture;
        this.bed = bed;
        this.television = television;
        this.bathroom = bathroom;
    }

    //    public Room(String roomSize, boolean roomCleaned, int roomLength, int roomWidth) {
//        this.roomSize = roomSize;
//        this.roomCleaned = roomCleaned;
//        this.roomArea = roomLength*roomWidth;
//        this.roomLength = roomLength;
//        this.roomWidth = roomWidth;
//    }
//
      public void isRoomCleaned(boolean isCleaned) {
        furniture.isFurnitureCleaned(isCleaned);
        bathroom.isBathroomCleaned(isCleaned);
        television.changeTelevisionMode(isCleaned);
        System.out.println("isRoomCleaned: The Room Function is Called And Cleaning The Room Now");
        roomCleaned = true;
        calculateRoomArea(60,60);
      }
//
    private void calculateRoomArea(int roomWidth,int roomLength) {
        roomArea = roomWidth + roomLength;
        System.out.println("The Room Area is Calculated And The Size is: "+roomArea);
        if(roomArea <=100 ) {
            this.roomSize = "1 BHK";
        }
        else if(roomArea<=200) {
            this.roomSize = "2 BHK";
        }
        else if(roomArea <=300) {
            this.roomSize = "3 BHK";
        }
        else if(roomArea<=400) {
            this.roomSize = "4 BHK";
        }
        else {
            this.roomSize = "Bungalow";
        }
        System.out.println("The Room Type is: "+this.roomSize);
    }


}
