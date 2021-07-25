import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Krunal","Sword",50);
        objectToSave(p1);
        objectToRead(p1);

        Player p2 = new Player("Kawasaki","Machete",100);

        objectToSave(p2);
        objectToRead(p2);
    }
    public static void objectToSave(Player objectToSave) {
        for(int i=0;i<objectToSave.writeValues().size();i++) {
            System.out.println("Saving " + objectToSave.writeValues().get(i) + " to storage Device.");
        }
    }

    public static void objectToRead (Player objectToRead) {
        ArrayList<String>values = objectToRead.writeValues();
        objectToRead.readValues(values);
//        System.out.println("Player Name: "  +values.get(0));
//        System.out.println("Player Weapon: "+values.get(1));
//        System.out.println(objectToRead.toString());

    }


}
