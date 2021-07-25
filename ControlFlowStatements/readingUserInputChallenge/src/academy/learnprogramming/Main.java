package academy.learnprogramming;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int sum=0;

        while(counter<=10) {
            System.out.println("Enter Number #"+counter+": ");
            boolean isInt = scanner.hasNextInt();

            if(isInt) {
                int enteredValues = scanner.nextInt();
                sum+=enteredValues;
                counter++;
            } else {
                System.out.println("Invalid Value Entered.");
            }
            scanner.nextLine();
        }

        System.out.println("The Sum Of Entered Numbers is: "+sum);
        scanner.close();
    }

}
