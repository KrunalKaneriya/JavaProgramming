package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        double milestokm = SpeedConverter.toMilesPerHour(10.5);
        System.out.println("Miles = " + milestokm);

        SpeedConverter.printConverter(10.5);
    }
}
