import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int myIntValue = 10;
        int anotherValue = myIntValue;
        System.out.println("My Int Value = " +myIntValue);
        System.out.println("My Another Value = "+ anotherValue);

        anotherValue++;
        System.out.println("My Int Value = " +myIntValue);
        System.out.println("My Another Value = "+ anotherValue);

        int[] myIntArrays = new int[5];
        int[] anotherArray = myIntArrays;
        System.out.println("MyIntArrays "+ Arrays.toString(myIntArrays));
        System.out.println("AnotherArray = "+Arrays.toString(anotherArray));

        anotherArray[0] = 1;
        System.out.println("After Change MyIntArrays "+ Arrays.toString(myIntArrays));
        System.out.println("After Change AnotherArray = "+Arrays.toString(anotherArray));
        anotherArray= new int[] {4,5,6,7,8};
        modifyArray(myIntArrays);

        System.out.println("After Modify MyIntArrays "+ Arrays.toString(myIntArrays));
        System.out.println("After Modigy AnotherArray = "+Arrays.toString(anotherArray));

    }


    private static void modifyArray(int[] array) {
        array[0] = 2;
        array = new int[] {1,2,3,4,5};
    }
}
