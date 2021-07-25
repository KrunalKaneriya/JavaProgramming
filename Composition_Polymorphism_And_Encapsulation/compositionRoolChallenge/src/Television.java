public class Television {
    private String televisionType;
    private String televisionModel;
    private boolean televisionPower;

    public Television(String televisionType, String televisionModel, boolean televisionPower) {
        this.televisionType = televisionType;
        this.televisionModel = televisionModel;
        this.televisionPower = televisionPower;
    }

    public void changeTelevisionMode(boolean isCleaned) {
        if(isCleaned) {
            this.televisionPower = false;
            System.out.println("The Television Was Turned On And Now Switching it Off");
        }
        else {
            this.televisionPower = true;
            System.out.println("The Television Was Off And Now Turning it On");
        }
    }


}
