public class Main {

    public static void main(String[] args) {
        Furniture furniture = new Furniture("Sofa",15000);
        Bathroom bathroom = new Bathroom(58);
        Television television = new Television("Plasma TV","W35200",true);

        Room roomA1 = new Room(furniture,new Bed("King Size","2 People",true),television,bathroom);

        roomA1.getBed().calculateBedArea(90,50);
        roomA1.isRoomCleaned(true);

        furniture.isFurnitureCleaned(false);

    }
}
