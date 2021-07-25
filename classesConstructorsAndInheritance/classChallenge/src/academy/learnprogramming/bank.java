package academy.learnprogramming;

public class bank {
    private int accountNumber;
    private int accountBalance;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;


    public void setAccountNumber(int number) {
        this.accountNumber = number;
        System.out.println("The Account Number Has Been Initialized as " + this.accountNumber);
    }

    public void setAccountBalance(int balance) {
        this.accountBalance = balance;
        System.out.println("The Account Balance is "+this.accountBalance + " of the Number " + accountNumber + " And the Name is "+ customerName);
    }

    public void setCustomerName (String Name) {
        this.customerName = Name;
        System.out.println("The Customer Name is "+this.customerName);
    }

    public void setCustomerEmail (String email) {
        this.customerEmail = email;
        System.out.println("So The Customer " + customerName + " Email is "+customerEmail);
    }

    public void setCustomerPhoneNumber (String phone_number) {
        this.customerPhoneNumber = phone_number;
        System.out.println("The Customer "+customerName + " Phone Number is "+customerPhoneNumber);
    }

    public void setAll (int number,int balance,String name,String phone_number,String email) {
        this.accountNumber = number;
        this.accountBalance = balance;
        this.customerName = name;
        this.customerPhoneNumber = phone_number;
        this.customerEmail = email;

        System.out.println("So The Account Number: "+ accountNumber + " with Rs."+accountBalance + " Named: "+customerName + " and Phone Number: "
        +customerPhoneNumber + " and Email: "+customerEmail);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
    public int getAccountBalance() {
        return this.accountBalance;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return this.customerPhoneNumber;
    }

    public void deposit (int balance) {
        int previousBalance = this.accountBalance;
        this.accountBalance +=balance;
        System.out.println("The Account Name is: "+ this.customerName);
        System.out.println("The Balance Was "+previousBalance + " and Rs."+balance + " are deposited.");
        System.out.println("The Updated Balance is "+ this.accountBalance);
    }

    public boolean withdraw (int balance) {
        if((balance > this.accountBalance) || (balance < 0)) {
            System.out.println("The Entered value is either Invalid or Account Balance is Insufficient...");
            return false;
        }
        else {
            accountBalance-=balance;
            System.out.println("The Amount to Withdraw is "+ balance + " and Updated Balance is " + this.accountBalance);
            return true;
        }
    }

}
