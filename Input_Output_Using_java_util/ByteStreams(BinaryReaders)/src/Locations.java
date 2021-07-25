import java.util.Collection;
import java.util.Set;

import java.io.*;
        import java.util.*;
import java.util.function.Function;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location>locations = new LinkedHashMap<Integer,Location>();

    public static void main(String[] args) throws IOException,NullPointerException {

        try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for(Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing Location " + location.getLocationID() +" : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size()-1) + " exits.");
                locFile.writeInt(location.getExits().size()-1);
                for(String direction:location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }


    }
    static {

        try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof =false;
            while(!eof) {
                try {
                    Map<String,Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read Location " + locID  + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for(int i=0;i<numExits;i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction,destination);
                        System.out.println("\t\t " + direction + " : " + destination);
                    }
                    locations.put(locID,new Location(locID,description,exits));
                } catch (EOFException e) {
                    eof = true;
                }

            }
        }catch (IOException e) {
            e.printStackTrace();
        }

//        Function to Read the Locations Data Via Buffered Reader
//        try(BufferedReader locationBuffer = new BufferedReader(new FileReader("locations_big.txt"))) {
//            String input;
//            while((input = locationBuffer.readLine())!=null) {
//                String[] locationarray = input.split(",");
//                int locationNumber = Integer.parseInt(locationarray[0]);
//                String description = locationarray[1];
//                locations.put(locationNumber,new Location(locationNumber,description));
//            }
//        } catch(IOException e) {
//            System.out.println("Error In Reading Data From Locations File Via BufferedReader.");
//            e.printStackTrace();
//        }
//
//
//        //Read the exits from file Via BufferedReader
//        try(BufferedReader exitsBuffer = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//
//            while((input = exitsBuffer.readLine())!=null) {
//
//                String []data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction,destination);
//            }
//        } catch (IOException e) {
//            System.out.println("Error in  Exits FileReader");
//            e.printStackTrace();
//        }


    }

    //This function returns the Current Size of hashMap
    @Override
    public int size() {
        return locations.size();
    }

    //This function checks that is the HashMap empty or Not?
    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    //This functions checks whether the Key which is passed is present in HashMap or Not.
    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    //This functions checks whether the Value which is passed is present in HashMap or Not.
    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    /*This function returns the Object which is passed as parameter and if it is present
    then it returns the Location(Value) Object*/
    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    /*This functions insert a new Object of class Location in the HashMap and returns the Value (Location) of it*/
    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    /*This functions remove the object of location via the Parameter of key which is passed and returns the
    removed object of Location*/
    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    //Removes all of the mappings from this map. The map will be empty after this call returns.
    @Override
    public void clear() {
        locations.clear();
    }

    //It returns the Set of the keys of Hashmap (Integer)
    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    //Returns a Collection view of the values contained in this map.
    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    //The method call returns a set view of the mappings contained in this map.
    //Eg: [1=tutorials, 2=point, 3=is best]
    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
