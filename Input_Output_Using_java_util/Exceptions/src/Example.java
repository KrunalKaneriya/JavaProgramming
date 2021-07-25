import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println("The result is "+ result);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform Division. Autopilot is shutting down");
        }

    }
    private static int divide() {
        int x,y;
        try {
            x = getInt();
            y= getInt();
            System.out.println("X is " + x +  " and Y is " + y);
            return x/y;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No Suitable Input");
        } catch(ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }

    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter Number: ");
        while(true) {
            try {
                return s.nextInt();
            }   catch (InputMismatchException e) {
                //To get the input from user again. To read past the end of line of input first
                //Or handle the input of Integer
                s.nextLine();
                System.out.println("Please Enter Valid Number Of 0 - 9 Again: ");
            }
        }
    }
}
