import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location>locations = new LinkedHashMap<Integer,Location>();

    public static void main(String[] args) throws IOException,NullPointerException{

        try(BufferedWriter locationWriter = new BufferedWriter(new FileWriter("locations.txt"));
           BufferedWriter dirWriter = new BufferedWriter(new FileWriter("directions.txt"))) {
            for (Location location : locations.values()) {
                locationWriter.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction:location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        dirWriter.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }


    }
    static {

//        try(Scanner scanner = new Scanner(new FileReader("locations_big.txt"))) {
//            scanner = new Scanner(new FileReader("locations_big.txt"));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported location: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //Function to Read the Locations Data Via Buffered Reader
        try(BufferedReader locationBuffer = new BufferedReader(new FileReader("locations_big.txt"))) {
            String input;
            while((input = locationBuffer.readLine())!=null) {
                String[] locationarray = input.split(",");
                int locationNumber = Integer.parseInt(locationarray[0]);
                String description = locationarray[1];
                locations.put(locationNumber,new Location(locationNumber,description));
            }
        } catch(IOException e) {
            System.out.println("Error In Reading Data From Locations File Via BufferedReader.");
            e.printStackTrace();
        }

//        } finally {
//            if(scanner != null) {
//                scanner.close();
//            }
//        }
//        locations.put(0,new Location(0,"You are sitting in front of computer learning Java."));
//        locations.put(1,new Location(1,"You are standing at the end of a road before a small brick building"));
//        locations.put(2,new Location(2,"You are at the top of the hill"));
//        locations.put(3,new Location(3,"You are inside a building, a well house for a small spring"));
//        locations.put(4,new Location(4,"You are in a valley beside a stream"));
//        locations.put(5,new Location(5,"You are in the forest"));
//
//        locations.get(1).addExit("W",2);
//        locations.get(1).addExit("E",3);
//        locations.get(1).addExit("S",4);
//        locations.get(1).addExit("N",5);
//
//        locations.get(2).addExit("N",5);
//
//        locations.get(3).addExit("W",1);
//
//        locations.get(4).addExit("N",1);
//        locations.get(4).addExit("W",2);
//
//        locations.get(5).addExit("S",1);
//        locations.get(5).addExit("W",2);

        //Read the exits from file Via BufferedReader
        try(BufferedReader exitsBuffer = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
//            scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
            while((input = exitsBuffer.readLine())!=null) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction  = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);
                String []data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction,destination);
            }
        } catch (IOException e) {
            System.out.println("Error in  Exits FileReader");
            e.printStackTrace();
        }


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
