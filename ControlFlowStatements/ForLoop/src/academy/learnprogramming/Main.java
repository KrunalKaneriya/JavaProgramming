package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

//        for(int i=2;i<9;i++) {
//            System.out.println("10000 at " + i + "% Interest = " + String.format("%.2f",calculateInterest(10000.0,i)));
//        }
//
//        System.out.println("Now Reverse Side");
//
//        for(int i=8;i>1;i--) {
//            System.out.println("10000 at " + i + "% Interest = " + String.format("%.2f",calculateInterest(10000.0,i)));
//        }

        int counter=0;
        for (int i=10;i<=50;i++) {
            if(isPrime(i)) {
                counter+=1;
                System.out.println("The Prime Number is " + i);
            }
            if(counter==10)
                break;
        }

    }

    public static double calculateInterest(double amount,double interestRate) {
        return (amount*(interestRate/100));
    }

    public static boolean isPrime(int n) {
        if(n==1) {
            return false;
        }

        for(int i=2; i<=(long) Math.sqrt(n); i++) {
            if(n % i ==0) {
                return false;
            }
        }

        return true;
    }

}
