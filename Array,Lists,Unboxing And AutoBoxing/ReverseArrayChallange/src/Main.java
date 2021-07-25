import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arrays = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Arrays = "+ Arrays.toString(arrays));

        reverse(arrays);
        System.out.println("Arrays Reversed = "+ Arrays.toString(arrays));


    }

    public static void reverse(int [] array) {

        int temp;
        int arrayMaxLength = array.length-1;
        int halfLength = array.length/2;
        for(int i=0;i<halfLength;i++) {
           temp = array[i];
           array[i] = array[arrayMaxLength-i];
           array[arrayMaxLength-i] = temp;
        }

    }
}
