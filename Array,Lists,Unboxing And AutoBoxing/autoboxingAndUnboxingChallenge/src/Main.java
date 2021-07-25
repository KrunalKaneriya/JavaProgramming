// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("State Bank of India");
    private static Customers customers = new Customers();
    private static Branches branches = new Branches("Katargam");
    public static void main(String[] args) {
//	    Bank sbi = new Bank("State Bank of India");
//	    Branches katargam = new Branches("Katargam");
//	    sbi.addBranch(katargam);
//        katargam.newCustomer("Krunal",5650.00);
//        katargam.newCustomer("Mona",25000.00);
//        Branches Dabholi = new Branches("Dabholi");
//        sbi.addBranch(Dabholi);
//        Dabholi.newCustomer("Nanji",250.56);
//        Dabholi.newCustomer("Rajesh Patel",9956.052);
//        Dabholi.newCustomer("Jignesh",789.45);
//        Dabholi.printBranchesandCustomers(Dabholi);
//        katargam.printBranchesandCustomers(katargam);

        int choice;
        boolean quit = false;

        while(!quit) {
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printIndex();
                    break;
                case 2:
                    addBranch();
                    break;
                case 3:
                    System.out.println("Enter The Customer Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Enter The Initial Transaction: ");
                    Double amount = scanner.nextDouble();
                    branches.newCustomer(name,amount);
                    break;
                case 4:
                    bank.printBranches(branches);
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Enter The Choice Again..");
                    break;
            }
        }
    }

    private static void printIndex() {
        System.out.println("1. To Print The Index.\n2.To Create A New Branch\n3.To Create A New Customer.\n4.To Print The Available Branches.\n5." +
                "To Print The Available Customers.\n6.To Find The Customer.");
    }

    private static void addBranch() {
        System.out.print("Enter The Name Of The Branch You Want to Add: ");
        scanner.nextLine();
        String branchName = scanner.nextLine();
        bank.addBranch(branchName);
    }

//    private static boolean newCustomer() {
//        System.out.print("Enter The New Name Of The Customer: ");
//        scanner.nextLine();
//        String customerName = scanner.nextLine();
//        Double amount = scanner.nextDouble();
//        Customers customer = new Customers(customerName,amount);
//        if(customer.getCustomerName()!=null) {
//            System.out.println("New Customer Has Been Added Into "+ branches.getBranchName());
//            return true;
//        }
//        else {
//            System.out.println("Error Adding New Customer");
//            return false;
//        }
//    }

    private void printBranches() {
        System.out.print("The Branch Name is: " + branches.getBranchName());
    }
}


