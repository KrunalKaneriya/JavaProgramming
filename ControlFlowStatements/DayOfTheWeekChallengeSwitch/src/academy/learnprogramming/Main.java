package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        printDayOfTheWeek(12);

    }

    public static void printDayOfTheWeek(int day) {
        switch (day) {
            case 1:
                System.out.println("It's Monday");
                break;
            case 2:
                System.out.println("It's Tuesday");
                break;
            case 3:
                System.out.println("It's Wednesday");
                break;
            case 4:
                System.out.println("It's Thursday");
                break;
            case 5:
                System.out.println("It's Friday");
                break;
            case 6:
                System.out.println("It's Saturday");
                break;
            case 7:
                System.out.println("It's Sunday");
                break;
            default:
                System.out.println("Invalid Day Entered");
                break;
        }
    }
}
