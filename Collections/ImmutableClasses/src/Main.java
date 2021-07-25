import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> directionWord = new HashMap<>();

        directionWord.put("QUIT", "Q");
        directionWord.put("NORTH", "N");
        directionWord.put("SOUTH", "S");
        directionWord.put("EAST", "E");
        directionWord.put("WEST", "W");

        Map<String,Integer>tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of computer learning Java.",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W",2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of the hill",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));
        tempExit.remove("W");

        int loc = 1;

        while (true) {
            System.out.println(locations.get(loc).getDescription()); //Printing descriptions for location
            if (loc == 0) { //If exit is 0 then quit
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits(); //Creating new exits map for displaying available exits for location passed
            System.out.print("Available exits are ");

            for (String exit : exits.keySet()) { //Printing available exits for each location that was passed
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase(); //Taking input to change the direction
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String i : words) {
                    if (directionWord.containsKey(i)) {
                        direction = directionWord.get(i);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction); //We are setting the value of loc based on the direction that was passed in. and the return type will be exits value
            } else {
                System.out.println("You cannot go in that direction");
            }
            Location.returnMessage(direction);
        }
    }
}