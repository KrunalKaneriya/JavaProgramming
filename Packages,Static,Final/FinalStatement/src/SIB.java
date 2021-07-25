public class SIB {
    public static final String owner;
    public String name;

    static {
        owner = "TIM";
        System.out.println("SIB static initialization block called");
    }

    public SIB() {
        System.out.println("SIB Constructor called");
    }

    static {
        System.out.println("Second initialization block called");
    }

    public void somemethod() {
        System.out.println("Some method called");
    }
}
