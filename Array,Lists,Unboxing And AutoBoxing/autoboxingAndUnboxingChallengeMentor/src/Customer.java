import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> tranactions;

    public Customer(String name,double initial) {
        this.name = name;
        this.tranactions = new ArrayList<Double>();
        addTransaction(initial);
    }

    public void addTransaction(double amount) {
        this.tranactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTranactions() {
        return tranactions;
    }
}
