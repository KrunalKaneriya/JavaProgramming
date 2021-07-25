import java.util.HashMap;
import java.util.Map;

public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer>exits;

    public Location(int locationID, String description,Map<String,Integer>exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits == null) {
            this.exits = new HashMap<>();
        }else {
            this.exits = new HashMap<>(exits); //Creating new map exits for every instance of location
        }
        this.exits.put("Q",0);  //for adding Q,0 for into every exits map
    }

    //Ability to add an exit
//    public void addExit(String direction,int location) {
//        exits.put(direction,location);
//    }

    //Returning LocationID
    public int getLocationID() {
        return locationID;
    }

    //Returning Description
    public String getDescription() {
        return description;
    }

    //Returning every new instance of exits and copying old values into new exits to avoid manipulating field directly.
    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exits);
    }

    public static final void returnMessage(String word) {
        if(word.equalsIgnoreCase("q") || word.equalsIgnoreCase("Quit")) {
            System.out.println("Now Quitting");
        }
        else if(word.equalsIgnoreCase("S") || word.equalsIgnoreCase("south")) {
            System.out.println("Going South..");
        }
        else if(word.equalsIgnoreCase("W") || word.equalsIgnoreCase("west")) {
            System.out.println("Going West..");
        }
        else if(word.equalsIgnoreCase("E") || word.equalsIgnoreCase("east")) {
            System.out.println("Going East Side..");
        }
        else if(word.equalsIgnoreCase("N") || word.equalsIgnoreCase("north")) {
            System.out.println("Going North Direction..");
        }
    }
}
