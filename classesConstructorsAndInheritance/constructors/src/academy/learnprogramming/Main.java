package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
//        Account b2 = new Account(102,1000,"Jack Sparrow","7598164126","jack@email.com");
//        System.out.println(b2.getCustomerName());
//        System.out.println(b2.getAccountBalance());
//        System.out.println(b2.getAccountNumber());
////        Account b1 = new Account();
////
////        System.out.println(b1.getAccountNumber());
////        System.out.println(b1.getAccountBalance());
////        System.out.println(b1.getCustomerName());
////        System.out.println(b1.getCustomerEmail());
//
//        Account james = new Account("James Spebber","james@email.com","42487891");
//        System.out.println(james.getCustomerName());
//        System.out.println(james.getCustomerEmail());

        VipNumber v1 = new VipNumber("Krunal",1500,"gb@email.com");
        System.out.println(v1.getName());
        System.out.println(v1.getCreditLimit());
        System.out.println(v1.getEmailAddress());

        System.out.println("******************************");

        VipNumber v2 = new VipNumber();
        System.out.println(v2.getName());
        System.out.println(v2.getCreditLimit());
        System.out.println(v2.getEmailAddress());

        System.out.println("******************************");

        VipNumber v3 = new VipNumber("Jignesh",1500);
        System.out.println(v3.getName());
        System.out.println(v3.getCreditLimit());
        System.out.println(v3.getEmailAddress());
    }
}