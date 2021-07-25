import java.util.ArrayList;

class Customers {
    private ArrayList<Double>transactions = new ArrayList<Double>();
    private String customerName;

    Customers() {
        this.transactions = new ArrayList<Double>();
    }

    Customers(String customerName,Double transactionAmount) {
        this.customerName = customerName;
        this.transactions = new ArrayList<Double>();
        addTransaction(transactionAmount);
    }

    public void printCustomers(Customers customers) {
        for (int i=0;i< transactions.size();i++) {
            System.out.print("The Customer Name is: " + customers.getCustomerName());
            System.out.print("The Customer Balance is: "+ customers.transactions.get(i));
        }
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

    public Customers returnCustomers (String Name,double amount) {
        return new Customers(Name,amount);
    }


}