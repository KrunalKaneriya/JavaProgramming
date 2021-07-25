package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        boolean isAlien=false;
        if(isAlien == false) {
            System.out.println("It is not an alien!");
            System.out.println("And I am scared of Aliens");
        }

        int topScore=80;
        if(topScore<100) {
            System.out.println("You Got The Highest Score!");
        }

        int secondTopScore = 60;
        if((topScore>secondTopScore) && (topScore < 100)){
            System.out.println("Greater Than Second Top Score and Less than 100");
        }

        if(topScore>secondTopScore || topScore>100){
            System.out.println("This Condidtion is True");
        }

        int newValue=50;
        if(newValue == 50) {
            System.out.println("This is true");
        }

        boolean isCar=false;
        if(isCar) {
            System.out.println("This is not suppose to happen");
        }
        isCar=true;
        boolean wasCar = isCar ? true :false;

        if(wasCar) {
            System.out.println("WasCar is True");
        }

        double variableOne = 20.00d;
        double varialbleSecond = 80.00d;
        double oneMultiplySecond = (variableOne+varialbleSecond) * 100.00d;
        System.out.println("The Addition is " + oneMultiplySecond);
        double remainder = oneMultiplySecond%40.00d;
        System.out.println("Remainder is " + remainder);
        boolean isRemainder = remainder == 0 ? true : false;
        System.out.println(isRemainder);
        if(!isRemainder) {
            System.out.println("Got Some Remainder");
        }

    }
}
