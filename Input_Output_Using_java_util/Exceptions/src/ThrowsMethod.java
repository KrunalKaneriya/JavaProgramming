import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsMethod {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try{
            System.out.println(divide_m());
        } catch (ArithmeticException e) {
            System.out.println("Division Error..");
            System.out.println(e);

        }
    }
    static int divide_m() throws ArithmeticException {
        System.out.println("Enter Number 1: ");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Number 2: ");
        int b= scanner.nextInt();
        return a/b;
    }
}
