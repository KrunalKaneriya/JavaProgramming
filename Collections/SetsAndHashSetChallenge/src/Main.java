import java.util.*;

public class Main {
    private static final Set<HeavenlyBody>planets = new HashSet<>();
    private static final Set<HeavenlyBody>moons = new HashSet<>();
    private static final Map<HeavenlyBody.Key,HeavenlyBody>solarSystem = new HashMap<>();
    public static void main(String[] args) {


        //Defining Objects
        HeavenlyBody earth = new Planet("Earth",365);
        solarSystem.put(earth.getKey(), earth);
        HeavenlyBody earthMoon = new Moon("Moon",27);
        solarSystem.put(earthMoon.getKey(), earthMoon);
        HeavenlyBody mercury = new Planet("Mercury",88);
        solarSystem.put(mercury.getKey(), mercury);
        HeavenlyBody venus = new Planet("Venus",225);
        solarSystem.put(venus.getKey(), venus);
        HeavenlyBody mars = new Planet("Mars",687);
        solarSystem.put(mars.getKey(), mars);
        HeavenlyBody marsMoon1 = new Moon("Deimos",1.3);
        solarSystem.put(marsMoon1.getKey(), marsMoon1);
        HeavenlyBody marsMoon2 = new Moon("Phobos",0.3);
        solarSystem.put(marsMoon2.getKey(), marsMoon2);
        HeavenlyBody jupiter = new Planet("Jupiter",4332);
        solarSystem.put(jupiter.getKey(), jupiter);
        HeavenlyBody jupiterMoon1 = new Moon("Io",1.8);
        solarSystem.put(jupiterMoon1.getKey(), jupiterMoon1);
        HeavenlyBody jupiterMoon2 = new Moon("Europa",3.5);
        solarSystem.put(jupiterMoon2.getKey(), jupiterMoon2);
        HeavenlyBody jupiterMoon3 = new Moon("GanyMede",7.1);
        solarSystem.put(jupiterMoon3.getKey(), jupiterMoon3);
        HeavenlyBody jupiterMoon4 = new Moon("Callisto",16.7);
        solarSystem.put(jupiterMoon4.getKey(), jupiterMoon4);
        HeavenlyBody saturn = new Planet("Saturn",10759);
        solarSystem.put(saturn.getKey(), saturn);
        HeavenlyBody uranus = new Planet("Uranus",30660);
        solarSystem.put(uranus.getKey(), uranus);
        HeavenlyBody neptune = new Planet("Neptune",165);
        solarSystem.put(neptune.getKey(), neptune);
        HeavenlyBody pluto = new Planet("Pluto",248);
        solarSystem.put(pluto.getKey(), pluto);


        //Adding objects to Sets
        planets.add(earth);
        earth.addMoon(earthMoon);
        planets.add(mercury);
        planets.add(venus);
        planets.add(mars);
        mars.addMoon(marsMoon1);
        mars.addMoon(marsMoon2);
        planets.add(jupiter);
        jupiter.addMoon(jupiterMoon1);
        jupiter.addMoon(jupiterMoon2);
        jupiter.addMoon(jupiterMoon3);
        jupiter.addMoon(jupiterMoon4);
        planets.add(saturn);
        planets.add(uranus);
        planets.add(neptune);
        planets.add(pluto);

        //Printing Planets in Set
        for(HeavenlyBody planet:planets){
            System.out.println(planet);
        }

        //Printing Moons of Specific Planet Via Maps
        System.out.println("***********************************");
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.Planet));
        System.out.println("Moons of " + body.getKey());

        for(HeavenlyBody planetMoons:body.getSatelites()){
            System.out.println("\t" + planetMoons);
        }
        System.out.println("\n***********************************");
        //Ending Printing Block

        //Adding all Moons to Moons Set

        for (HeavenlyBody planet:planets){
            moons.addAll(planet.getSatelites());
        }
        System.out.println("All Moons");
        for(HeavenlyBody moon:moons){
            System.out.println(moon);
        }
        HeavenlyBody duplicateMoon  = new Planet("Earth",345);
        solarSystem.put(duplicateMoon.getKey(), duplicateMoon);

        printMaps();


        //Adding Objects to Solarsystem
//        printMaps();
//        for(HeavenlyBody moon:planets){
//            moons.addAll(moon.getSatelites());
//        }
//        printList();
//        for(HeavenlyBody moon :moons){
//            System.out.println(moon);
//        }

//        HeavenlyBody earth1 = new Planet("Earth",365);
//        HeavenlyBody earth2 = new Planet("Earth",365);
//        System.out.println(earth1.equals(earth2));
//        System.out.println(earth2.equals(jupiter));
    }

//    public static final void printList(){
//        for(HeavenlyBody planet:planets){
//            System.out.println("\t" + planet.getKey());
//            for(HeavenlyBody moons:planet.getSatelites()) {
//                System.out.println("\t\t" + moons.getKey());
//            }
//        }
//    }


    public static void printMaps() {
        System.out.println("***********************************");
        System.out.println("The Solar System Contains");
        for(HeavenlyBody obj : solarSystem.values()){
            System.out.println(obj);
        }
    }

}
