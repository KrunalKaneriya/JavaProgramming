package academy.learnprogramming;

public class SpeedConverter {
    public static double toMilesPerHour (double kilometresPerHour) {

        if(kilometresPerHour < 0) {
            return -1;
        }
        return Math.round(kilometresPerHour/1.609);

    }

    public static void printConverter (double kilometeresPerHour) {
        if(kilometeresPerHour < 0) {
            System.out.println("Invalid Value");
        }
        else {
            double milesPerHour = toMilesPerHour(kilometeresPerHour);
            System.out.println(kilometeresPerHour + "km/h = " + milesPerHour + "mi/h");

        }
    }
}
