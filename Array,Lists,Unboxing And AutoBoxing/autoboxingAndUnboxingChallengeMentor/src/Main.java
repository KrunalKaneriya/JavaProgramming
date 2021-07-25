public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("State Bank of India");
        bank.addBranch("Katargam");

        bank.addCustomer("Katargam","Krunal",50053.25);
        bank.addCustomer("Katargam","Jim",8089.00);
        bank.addCustomer("Katargam","Jack",4505.00);

        bank.addBranch("Rander");
        bank.addCustomer("Rander","Jillian",7580.025);
        bank.addCustomerTransaction("Katargam","Krunal",50.25);
        bank.addCustomerTransaction("Katargam","Krunal",5450.25);
        bank.addCustomerTransaction("Katargam","Jack",781.25);

        bank.listCustomer("Katargam",false );
        bank.listCustomer("Rander",false);

        bank.addBranch("Melbourne");
        if(!bank.addCustomer("Melbourne","Braian",5.53)) {
            System.out.println("Error Melbourne Branch Doesn't Exist");
        }

        if(!bank.addBranch("Katargam")) {
            System.out.println("Katargam Branch Already Exists.");
        }

        if(!bank.addCustomerTransaction("Katargam","Fergus",45.0)) {
            System.out.println("Customer Doesn't Exist.");
        }

        if(!bank.addCustomer("Katargam","Krunal",4.21)) {
            System.out.println("Customer Already Exists.");
        }


    }
}
