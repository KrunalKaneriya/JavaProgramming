import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer,Location>locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        locations.put(0,new Location(0,"You are sitting in front of computer learning Java."));
        locations.put(1,new Location(1,"You are standing at the end of a road before a small brick building"));
        locations.put(2,new Location(2,"You are at the top of the hill"));
        locations.put(3,new Location(3,"You are inside a building, a well house for a small spring"));
        locations.put(4,new Location(4,"You are in a valley beside a stream"));
        locations.put(5,new Location(5,"You are in the forest"));

        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);
//        locations.get(1).addExit("Q",0);

        locations.get(2).addExit("N",5);
//        locations.get(2).addExit("Q",0);

        locations.get(3).addExit("W",1);
//        locations.get(3).addExit("Q",0);

        locations.get(4).addExit("N",1);
        locations.get(4).addExit("W",2);
//        locations.get(4).addExit("Q",0);

        locations.get(5).addExit("S",1);
        locations.get(5).addExit("W",2);
//        locations.get(5).addExit("Q",0);


        int loc=1;
        while(true) {
            System.out.println(locations.get(loc).getDescription()); //Printing descriptions for location
            if(loc==0) { //If exit is 0 then quit
                break;
            }

            Map<String,Integer>exits = locations.get(loc).getExits(); //Creating new exits map for displaying available exits for location passed
            System.out.print("Available exits are ");

            for(String exit:exits.keySet()) { //Printing available exits for each location that was passed
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase(); //Taking input to change the direction
            if(exits.containsKey(direction)) {
                loc = exits.get(direction); //We are setting the value of loc based on the direction that was passed in. and the return type will be exits value
            }
            else {
                System.out.println("You cannot go in that direction");
            }

        }

//        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
//        for(String i:road){
//            System.out.println(i);
//        }
//
//        String []building = "You are inside a building, a well house for a small spring".split(",");
//        for(String s:building){
//            System.out.println(s);
//        }
    }
}
