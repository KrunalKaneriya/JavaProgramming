import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //Create a new object of Locations class that implements the hashMap
    private static Locations locations = new Locations();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String,String>directionWord = new HashMap<>();

        directionWord.put("QUIT","Q");
        directionWord.put("NORTH","N");
        directionWord.put("SOUTH","S");
        directionWord.put("EAST","E");
        directionWord.put("WEST","W");



        int loc=64;
        Location currentLocation = locations.getLocation(loc);
        while(true) {
            System.out.println(currentLocation.getDescription()); //Printing descriptions for location
            if(currentLocation.getLocationID()==0) { //If exit is 0 then quit
                break;
            }

            Map<String,Integer>exits = currentLocation.getExits(); //Creating new exits map for displaying available exits for location passed
            System.out.print("Available exits are ");

            for(String exit:exits.keySet()) { //Printing available exits for each location that was passed
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase(); //Taking input to change the direction

            if(direction.length()>1) {
                String []words = direction.split(" ");
                for(String i:words){
                    if(directionWord.containsKey(i)) {
                        direction = directionWord.get(i);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                currentLocation = locations.getLocation(currentLocation.getExits().get(direction)); //We are setting the value of loc based on the direction that was passed in. and the return type will be exits value

            }
            else {
                System.out.println("You cannot go in that direction");
            }
            Location.returnMessage(direction);
        }
        locations.close();

    }
}
