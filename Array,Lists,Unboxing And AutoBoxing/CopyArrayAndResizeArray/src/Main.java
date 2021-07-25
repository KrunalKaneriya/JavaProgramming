import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int[] baseArray = new int[10];


    public static void main(String[] args) {
        System.out.println("Enter The Number Of Elements");
        getInput();
        printArray();
        resizeArray();
        getInput();
        printArray();
    }

    private static void getInput() {
        for (int i=0;i< baseArray.length;i++) {
            baseArray[i] = scanner.nextInt();
        }
    }

    private static void printArray() {
        for (int i=0;i< baseArray.length;i++) {
            System.out.println("The Element " + i + " is: "+ baseArray[i]);
        }
    }

    private static void resizeArray() {
        int[] original = baseArray;
        baseArray = new int[12];
        for( int i=0; i< original.length;i++) {
            baseArray[i] = original[i];
        }
    }
}
