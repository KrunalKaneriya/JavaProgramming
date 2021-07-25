package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        bank b1 = new bank();
        b1.setAll(101,12000,"Krunal Kaneria","9925809188","prokillerkk@outlook.com");

        b1.deposit(15000);
        b1.withdraw(4500);
        b1.withdraw(30000);

        System.out.println(b1.getCustomerName());
        System.out.println(b1.getCustomerEmail());
        }
}
