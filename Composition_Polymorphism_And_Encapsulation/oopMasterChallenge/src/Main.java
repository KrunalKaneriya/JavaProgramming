import java.security.DigestException;

public class Main {

    public static void main(String[] args) {

        double total;
        Hamburger hamburger = new Hamburger("Basic","Cheese Rolls","Pork",50);
        hamburger.addExtras1("Cheese",15);
        hamburger.addExtras2("Onions",5);
        hamburger.addExtras3("Spinach",1);
        total = hamburger.hamburgerCalculation();
        System.out.println("The Total Is " +total);

        HealthyBurger healthyBurger = new HealthyBurger("Bacon",5.59);
        healthyBurger.addExtras1("Tomato",2.55);
        healthyBurger.addHealthyExtras1("Lentils",3.41);
        System.out.println("Total Healthy Burger Price is :" + healthyBurger.hamburgerCalculation());

        System.out.println("************************************************");
        DeluxeBurger db = new DeluxeBurger();
        db.addExtras1("Chicken",15);
        db.hamburgerCalculation();

    }
}
