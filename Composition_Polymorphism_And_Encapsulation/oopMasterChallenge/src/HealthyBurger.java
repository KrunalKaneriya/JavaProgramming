public class HealthyBurger extends Hamburger {
    public HealthyBurger( String meatType, double burgerPrice) {
        super("Healthy", "Brown Rye", meatType, burgerPrice);
    }

    private String healthyextras1Name;
    private double healthyextras1Price;

    private String healthyextras2Name;
    private double healthyextras2Price;

    public void addHealthyExtras1(String name,double price) {
        this.healthyextras1Name = name;
        this.healthyextras1Price = price;
    }

    public void addHealthyExtras2(String name,double price) {
        this.healthyextras2Name = name;
        this.healthyextras2Price = price;
    }

    @Override
    public double hamburgerCalculation() {
        double hamburgerPrice = super.hamburgerCalculation();
        if(this.healthyextras1Name!=null) {
            System.out.println("The Item Added is : " + this.healthyextras1Name);
            System.out.println("The Item Price is: "+this.healthyextras1Price);
        }
        if(this.healthyextras2Name!=null) {
            System.out.println("The Item Added is : " + this.healthyextras2Name);
            System.out.println("The Item Price is: "+this.healthyextras2Price);
        }
        hamburgerPrice = (hamburgerPrice +  this.healthyextras1Price + this.healthyextras2Price);
        return hamburgerPrice;
    }
}