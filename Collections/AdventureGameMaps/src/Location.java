import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer>exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>(); //Creating new map exits for every instance of location
        this.exits.put("Q",0);  //for adding Q,0 for into every exits map
    }

    //Ability to add an exit
    public void addExit(String direction,int location) {
        exits.put(direction,location);
    }

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

}
