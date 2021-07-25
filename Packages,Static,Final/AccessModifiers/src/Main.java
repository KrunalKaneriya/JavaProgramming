public class Main {

    public static void main(String[] args) {

        Account kaccount = new Account("Krunal");
        kaccount.deposit(10000);
        kaccount.withdraw(5000);
        kaccount.withdraw(-2000);
        kaccount.deposit(-2500);
        kaccount.calculateBalance();
        kaccount.balance = 2000000;

        System.out.println("Balance on account is " + kaccount.getBalance());
    }
}
