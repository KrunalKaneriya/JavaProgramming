public class Bed {
    private String bedType;
    private String bedCapacity;
    private boolean bedCleaned;

    public Bed(String bedType, String bedCapacity, boolean bedCleaned) {
        this.bedType = bedType;
        this.bedCapacity = bedCapacity;
        this.bedCleaned = bedCleaned;
    }

    public void calculateBedArea(double firstInch,double secondInch ) {
        this.bedCapacity = firstInch + " x " + secondInch;
        System.out.println("The Size of Bed is: "+bedCapacity);
    }


}
