public class DeluxeBurger extends Hamburger{
    public DeluxeBurger() {
        super("Deluxe", "White", "Sausage & Bacon", 14.53);
        super.addExtras1("Chips",2.75);
        super.addExtras2("Drinks",1.81);
    }

    @Override
    public void addExtras1(String Name, double price) {
        System.out.println("Cannot Add Additional Items To Deluxe Burger");
    }

    @Override
    public void addExtras2(String Name, double price) {
        System.out.println("Cannot Add Additional Items To Deluxe Burger");

    }

    @Override
    public void addExtras3(String Name, double price) {
        System.out.println("Cannot Add Additional Items To Deluxe Burger");
    }

    @Override
    public void addExtras4(String Name, double price) {
        System.out.println("Cannot Add Additional Items To Deluxe Burger");
    }
}
