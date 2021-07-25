package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minimumNumber=0;
        int maximumNumber=0;
        boolean first =true;
        while(true) {
            System.out.println("Enter The Number:");
            boolean isInt = scanner.hasNextInt();

            if(isInt) {
                int value = scanner.nextInt();
                if(first) {
                    first=false;
                    minimumNumber=value;
                    maximumNumber=value;
                }

                if(value < maximumNumber) {
                    minimumNumber = value;
                } else {
                    maximumNumber = value;
                }
            } else {
                System.out.println("Invalid Number is Entered.....");
                System.out.println("Exiting Loop.....");
                break;
            }
            scanner.nextLine();
        }
        System.out.println("The Minimum Number is "+minimumNumber);
        System.out.println("The Maximum Number is "+maximumNumber);
        scanner.close();
    }
}
