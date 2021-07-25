import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location>locations = new LinkedHashMap<Integer,Location>();

    public static void main(String[] args) throws IOException,NullPointerException {
        
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try(BufferedWriter locFile = Files.newBufferedWriter(locPath); BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
//
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for(String direction:location.getExits().keySet()) {
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("IOException : " + e.getMessage());
//        }

        Path locPath = FileSystems.getDefault().getPath("locations.dat");
//        Path dirPath = FileSystems.getDefault().getPath("directions.dat");
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for(Location location: locations.values()) {
                locFile.writeObject(location);
            }
        }

    }
    static {

//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");

//        try (Scanner scanner= new Scanner(Files.newBufferedReader(locPath))) {
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported Location " + loc + " : " + description);
//                locations.put(loc,new Location(loc,description));
//
//            }
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        try(BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//            String input;
//            while((input = dirFile.readLine())!=null) {
//                String []data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction  = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println(loc + ": " + direction + ": "+ destination);
//                Location location = locations.get(loc);
//                location.addExit(direction,destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        Path dirPath = FileSystems.getDefault().getPath("directions.dat");

        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;

            while(!eof) {
                try {
                    Location location = (Location)locFile.readObject();
                    locations.put(location.getLocationID(),location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }   catch (InvalidClassException | ClassNotFoundException e) {
            e.printStackTrace();
        }   catch (IOException e) {
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
