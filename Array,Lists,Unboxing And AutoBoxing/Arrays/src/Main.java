import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //	int []myIntArray  = {1,2,3,4,5,6,7,8,9,10} ;
//    //	myIntArray[5] = 50;
//    //	myIntArray[0] = 10;
//    //	myIntArray[1] = 40;
//        System.out.println("My Int Array: " + myIntArray[5]);
//        System.out.println("My Int Array: " + myIntArray[2]);
//        System.out.println("My Int Array: " + myIntArray[0]);
//        double []myDoubleArray  = new double [25];
//        for(int i=0 ;i<myDoubleArray.length;i++) {
//            myDoubleArray[i] = i*10;
//        }
//        printArray(myDoubleArray);
        int[] myIntegers = getIntegers(5);
        for(int i=0;i<myIntegers.length;i++) {
            System.out.println("Element: " + i + " Typed Value Was: "+myIntegers[i]);
        }

        System.out.println("The Average is: "+ getAverage(myIntegers));
    }

    public static int[] getIntegers (int number) {
        System.out.println("Enter " + number + " Integer Values \r");
        int[] values = new int[number];
        for(int i=0;i<values.length;i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }



    public static void printArray(double[] myDoubleArray) {
        for (int i=0;i<myDoubleArray.length;i++) {
            System.out.println("The Value Of My Double Array is: "+ myDoubleArray[i]);
        }
    }

    public static double getAverage(int[] array) {
        int sum = 0;
        for(int i=0;i<array.length;i++) {
            sum += array[i];
        }
        return (double) sum/(double)array.length;
    }
}
