package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float Min Value = " + myMinFloatValue);
        System.out.println("Float Max Value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double Min Value = " + myMinDoubleValue);
        System.out.println("Double Max Value = " + myMaxDoubleValue);

        int myIntValue = 5/3;
        float myFloatValue = 5f / 3f; // 5.25f
        double myDoubleValue = 5d / 3d; //We can also do that double myDoubleValue = 5d;

        System.out.println("My Int Value = " + myIntValue);
        System.out.println("My float Value = " + myFloatValue);
        System.out.println("My Double Value = " + myDoubleValue);

        //Challenge
        double poundValue = 5;
        double kiloGrams = 0.45359237;
        double poundtokg = poundValue * kiloGrams;
        System.out.println(poundtokg);

        double Number = 3_000_000.5_689_564_234;
        System.out.println(Number);

    }
}
