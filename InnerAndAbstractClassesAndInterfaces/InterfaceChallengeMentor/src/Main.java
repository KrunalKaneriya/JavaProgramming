import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Krunal","Sword",50);
        objectToSave(p1);
        System.out.println(p1);

        Player p2 = new Player("Kawasaki","Machete",100);

        objectToSave(p2);
        System.out.println(p2);

        ISaveable werewolf  =new Monster("Wolf",20,40);
        System.out.println("The Strength is: " + ((Monster)werewolf).getStrength());
        System.out.println(werewolf);
        objectToSave(werewolf);

    }

    public static void objectToSave(ISaveable objectToSave) {
        for(int i=0;i<objectToSave.writeValues().size();i++) {
            System.out.println("Saving " + objectToSave.writeValues().get(i) + " to storage Device.");
        }
    }

    public static void objectToRead (ISaveable objectToRead) {
       ArrayList<String>values = objectToRead.writeValues();
       objectToRead.readValues(values);
//        System.out.println("Player Name: "  +values.get(0));
//        System.out.println("Player Weapon: "+values.get(1));
//        System.out.println(objectToRead.toString());

    }
}
