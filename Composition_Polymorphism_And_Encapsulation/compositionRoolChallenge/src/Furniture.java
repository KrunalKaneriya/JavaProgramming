public class Furniture {
    private String furnitureType;
    private int furnitureCost;
    private boolean furnitureCleaned;


    public Furniture(String furnitureType, int furnitureCost) {
        this.furnitureType = furnitureType;
        this.furnitureCost = furnitureCost;
        //this.furnitureCleaned = furnitureCleaned;
    }

    public void isFurnitureCleaned(boolean furnitureCleaned) {
        if(!furnitureCleaned) {
            System.out.println("The Furniture is Dirty. Please Clean it.....");
        }
        else {
            System.out.println("The Furniture is Cleaned. Good Work.....");
        }
    }

    public String getFurnitureType() {
        return furnitureType;
    }

    public int getFurnitureCost() {
        return furnitureCost;
    }




}
