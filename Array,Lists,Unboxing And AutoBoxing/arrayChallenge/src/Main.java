import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myVariables = getIntegers(5);
        int[] sortedArray= sortArray(myVariables);
//        sortArray(myVariables);
//        printArray(myVariables);
        printArray(sortedArray);




    }
    public static int[] getIntegers(int number) {
        int[] array = new int[number];
        System.out.println("Enter Elements \r" );
        for(int i=0;i<array.length;i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        for(int i=0;i< array.length;i++) {
            System.out.println("The "+ i + " Element is "+ array[i]);
        }
    }

//    public static int[] sortArray(int [] array) {
//        int[] sortedArray = new int[array.length];
//        for(int i=0;i<array.length;i++) {
//                    sortedArray[i] = array[i];
//        }
//    int[] sortedArray = Arrays.copyOf(array,array.length);
//        boolean flag = true;
//        int temp;
//
//        while(flag) {
//            flag= false;
//            for(int i=0;i<sortedArray.length-1;i++) {
//                if(sortedArray[i] < sortedArray[i+1]) {
//                    temp = sortedArray[i];
//                    sortedArray[i] = sortedArray[i+1];
//                    sortedArray[i+1] = temp;
//                    flag = true;
//                }
//            }
//        }
//        return sortedArray;
//    }

    public static int[] sortArray(int [] array) {
        int[] sortedArray = Arrays.copyOf(array,array.length);
//        for(int i=0;i<array.length;i++) {
//            sortedArray[i] = array[i];
//        }


        int temp;

        for (int i=0;i< sortedArray.length;i++) {
            for (int j=i+1 ; j< sortedArray.length ; j++) {
                if(sortedArray[i] < sortedArray[j]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }
}
