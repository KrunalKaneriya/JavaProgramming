import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String,HeavenlyBody>solarSystem = new HashMap<>();
    private static Set<HeavenlyBody>planets = new HashSet<>();
    public static void main(String[] args) {

        //Mercury Planet
        HeavenlyBody temp = new HeavenlyBody("Mercury",88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Venus Planet
        temp = new HeavenlyBody("Venus",225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Earth Planet
        temp = new HeavenlyBody("Earth",365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon",27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        //Mars Planet
        temp = new HeavenlyBody("Mars",687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos",1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); //Adding Moon to Mars

        tempMoon = new HeavenlyBody("Phobos",0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); //Adding Moon to Mars

        //Jupiter Planet
        temp = new HeavenlyBody("Jupiter",4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io",1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); //Adding Moon to Jupiter

        tempMoon = new HeavenlyBody("Europa",3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); //Adding Moon to Jupiter

        tempMoon = new HeavenlyBody("GanyMede",7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); //Adding Moon to Jupiter

        tempMoon = new HeavenlyBody("Callisto",16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); //Adding Moon to Jupiter

        //Saturn Planet
        temp = new HeavenlyBody("Saturn",10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Uranus Planet
        temp = new HeavenlyBody("Uranus",30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Neptune Planet
        temp = new HeavenlyBody("Neptune",165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Pluto Planet
        temp = new HeavenlyBody("Pluto",248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet:planets) {
            System.out.println("\t" + planet.getName());
            for(HeavenlyBody moon:planet.getSatelites()) {
                System.out.println("\t\t" + moon.getName());
            }

        }

        Set<HeavenlyBody>moons = new HashSet<>();

        for(HeavenlyBody planet:planets){
            moons.addAll(planet.getSatelites());
        }

        System.out.println();
        System.out.println("All Moons");
        for (HeavenlyBody moon:moons){
            System.out.println("\t\t" + moon.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto",550);
        planets.add(pluto);
        for(HeavenlyBody planet:planets){
            System.out.println(planet.getName() + " " + planet.getOrbitalPeriod());
        }

//        String pluto1 = "Pluto";
//        String pluto2 = "Pluto";
//        System.out.println("Hashcode of Pluto 1 is " + pluto1.hashCode() + " Hashcode of Pluto 2  is" + pluto2.hashCode());
    }
}
