import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x=89;
//        int y=0;
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        int x= getInt();
//        System.out.println("X is " + x);
        System.out.println(getIntEAFP() );
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please Enter an Integer: ");
        String input = s.next();
        for(int i=0;i<input.length();i++) {
            if(!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        } if(isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an Integer");
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int divideLBYL(int x,int y) {
        if(y!=0) {
            return x/y;
        }
        else {
            return 0;
        }
    }

    private static int divideEAFP(int x,int y){
        try {
            return x/y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
