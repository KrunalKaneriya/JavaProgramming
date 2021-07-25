public class Hamburger {
    private String burgerName;
    private String breadRollType;
    private String meatType;
    private double burgerPrice;
    private double total;
    private String extras1Name;
    private double extras1Price;
    private String extras2Name;
    private double extras2Price;
    private String extras3Name;
    private double extras3Price;
    private String extras4Name;
    private double extras4Price;

    public Hamburger(String burgerName, String breadRollType, String meatType, double burgerPrice) {
        this.burgerName = burgerName;
        this.breadRollType = breadRollType;
        this.meatType = meatType;
        this.burgerPrice = burgerPrice;
    }

    public void addExtras1(String Name,double price) {
        this.extras1Name = Name;
        this.extras1Price = price;
    }

    public void addExtras2(String Name,double price) {
        this.extras2Name = Name;
        this.extras2Price = price;
    }
    public void addExtras3(String Name,double price) {
        this.extras3Name = Name;
        this.extras3Price = price;
    }
    public void addExtras4(String Name,double price) {
        this.extras4Name = Name;
        this.extras4Price = price;
    }

    public double hamburgerCalculation() {
        System.out.println("The Burger Name is "+this.burgerName + " on a " + this.breadRollType  + " with "+ this.meatType
                + " Price is "+ this.burgerPrice );
        if(extras1Name!=null) {
            System.out.println("The Item Added is : " + this.extras1Name);
            System.out.println("The Item Price is: "+this.extras1Price);
        }
        if(extras2Name!=null) {
            System.out.println("The Item Added is : " + this.extras2Name);
            System.out.println("The Item Price is: "+this.extras2Price);
        }
        if(extras3Name!=null) {
            System.out.println("The Item Added is : " + this.extras3Name);
            System.out.println("The Item Price is: "+this.extras3Price);
        }
        if(extras4Name!=null) {
            System.out.println("The Item Added is : " + this.extras4Name);
            System.out.println("The Item Price is: "+this.extras4Price);
        }
        this.total =this.burgerPrice+ this.extras1Price+this.extras2Price+this.extras3Price+this.extras4Price;
//        System.out.println("The Total Of Hamburger And Added Extras is: " + this.total);
        return total;

    }

    public String getBurgerName() {
        return burgerName;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeatType() {
        return meatType;
    }

    public double getBurgerPrice() {
        return burgerPrice;
    }

    public double getTotal() {
        return total;
    }
}
