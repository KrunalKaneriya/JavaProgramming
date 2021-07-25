package academy.learnprogramming;

public class VipNumber {
    private String name;
    private double creditLimit;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public VipNumber(String name,double limit,String email) {
        this.name = name;
        this.creditLimit = limit;
        this.emailAddress = email;
        System.out.println("Vip Number Constructor With 3 Parameters Is Called");
    }

   public VipNumber() {
        this("Default Value",0.00,"default@none.com");
        System.out.println("Vip Number Constructor With No Paremeters Called");
    }

   public VipNumber(String name,double limit) {
        this(name,limit,"default@email.com");
       System.out.println("Vip Number Constructor With 2 Paremeters Called");
   }
}
