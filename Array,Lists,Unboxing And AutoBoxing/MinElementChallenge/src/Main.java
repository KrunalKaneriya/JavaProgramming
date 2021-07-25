import java.util.Scanner;
public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How Many Elements You Want To Enter: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] arrays = readIntegers(count);
        int element = findMin(arrays);
        System.out.println("The Minimum Element is " + element);

    }

    public static int[] readIntegers(int count) {
        int[] array = new int[count];
        System.out.println("Now Enter The Elements To Be Inserted Into Array...");
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int findMin(int[] array) {
        int minElement = Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++) {
            if(array[i] < minElement)
                minElement = array[i];
        }
        return minElement;
    }
}
