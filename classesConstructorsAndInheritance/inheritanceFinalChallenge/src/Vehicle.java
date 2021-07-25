public class Vehicle {
    private String name;
    private int size;

    private int currentvelocity;
    private int currentdirection;

    public Vehicle(String name, int size) {
        this.name = name;
        this.size = size;

        this.currentdirection=0;
        this.currentvelocity=0;
    }

    public void steer(int direction) {
        this.currentdirection+=direction;
        System.out.println("Vehicle.steer(): Steering at "+currentdirection+ " degrees.");
    }

    public void move(int velocity,int direction) {
        this.currentdirection =direction;
        this.currentvelocity = velocity;
        System.out.println("Vehicle.move(): Moving at "+currentvelocity + " in direction "+currentdirection);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentvelocity() {
        return currentvelocity;
    }

    public void setCurrentvelocity(int currentvelocity) {
        this.currentvelocity = currentvelocity;
    }

    public int getCurrentdirection() {
        return currentdirection;
    }

    public void setCurrentdirection(int currentdirection) {
        this.currentdirection = currentdirection;
    }

    public void stop() {
        currentvelocity = 0;
    }
}