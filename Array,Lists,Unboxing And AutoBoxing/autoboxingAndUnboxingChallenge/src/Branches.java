import java.util.ArrayList;
import java.util.Scanner;
class Branches {
    private ArrayList<Customers>customersArrayList;
    private String branchName;
    private Customers customers = new Customers();
    private Scanner scanner = new Scanner(System.in);

    Branches(String branchName) {
        this.branchName = branchName;
        this.customersArrayList = new ArrayList<Customers>();
    }

    Branches() {
        this.customersArrayList = new ArrayList<Customers>();
    }

    public String getBranchName() {
        return this.branchName;
    }

    public boolean newCustomer(String customerName,double transactionAmount) {
        if(findCustomers(customerName) <0) {
            this.customersArrayList.add(customers.returnCustomers(customerName,transactionAmount)); //Adding a new customer
            System.out.println("Added New Customer: " + customerName + " in Branch: " + this.branchName);
            return true;
        } else {
            System.out.println("Customer Already Exists Named: "+ customerName);
        }
        return false;
    }

    public void printCustomers() {
        System.out.println("The Branch Name is: " + getBranchName());
        for (int i=0;i<customersArrayList.size();i++) {
            System.out.println("The Name is: "+ customersArrayList.get(i).getCustomerName());
            System.out.println("The Balance is: " + customersArrayList.get(i).getTransactions());
        }
    }
    public void addTransaction(String customerName) {
        int position = findCustomers(customerName);
        System.out.println("The Position is: "+position);
        if(position>=0) {
            System.out.println("Enter The Amount To Add: ");
            double amount = scanner.nextDouble();
            customersArrayList.get(position).addTransaction(amount);
        }
        else {
            System.out.println("Customer Doesn't Exist...");
        }
    }

    private int findCustomers(String name) {
        int position;
        for (int i=0;i<customersArrayList.size();i++) {
            Customers customers = customersArrayList.get(i);
            if(customers.getCustomerName().equals(name)) {
                return i;
            }
        }
        return -1;
    }



    public int findCustomers(Customers customers) {
        return customersArrayList.indexOf(customers);
    }




}