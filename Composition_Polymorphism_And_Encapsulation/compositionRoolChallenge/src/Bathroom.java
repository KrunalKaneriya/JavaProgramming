public class Bathroom {
    private boolean bathroomCleaned;
    private int bathroomSize;
    private String bathroomType;

    public void calculateBathroomType() {
        if(this.bathroomSize <= 40) {
            bathroomType = "Small Size.";
            System.out.println("The Bathroom Size is: "+bathroomType);
        }
        else if(this.bathroomSize <= 50) {
            bathroomType = "Medium Size.";
            System.out.println("The Bathroom Size is: "+bathroomType);
        }
        else if(this.bathroomSize <= 60) {
            bathroomType = "Large Size.";
            System.out.println("The Bathroom Size is: "+bathroomType);
        }
    }

    Bathroom(int bathroomSize) {
        this.bathroomSize = bathroomSize;
        calculateBathroomType();
    }

    public void isBathroomCleaned(boolean isCleaned) {
        if(!isCleaned) {
            System.out.println("The Bathroom is Not Cleaned.Cleaning it Now..");
            bathroomCleaned = true;
        }
        else {
            System.out.println("The Bathroom is Cleaned.Good Work..");
            bathroomCleaned = false;
        }
    }


}
