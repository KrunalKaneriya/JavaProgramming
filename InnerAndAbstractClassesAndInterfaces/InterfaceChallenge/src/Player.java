import java.util.ArrayList;
import java.util.Scanner;
public class Player implements ISaveable {
    public String playerName;
    public String playerWeapon;
    public int playerHealth;

    @Override
    public void readValues(ArrayList<String> values) {
        if(values!=null) {
            System.out.println("Player Name: " + this.playerName + " || Player Weapon: " + this.playerWeapon + " || Player Health: " + this.playerHealth);
        }
    }

    @Override
    public ArrayList<String> writeValues() {
        ArrayList<String>values = new ArrayList<String>();
        if(values != null && values.size()>=0) {
            values.add(0, this.playerName);
            values.add(1, this.playerWeapon);
            values.add(2, Integer.toString(this.playerHealth));
            return values;
        }
        return null;
    }

    public Player(String playerName, String playerWeapon,int playerHealth) {
        this.playerName = playerName;
        this.playerWeapon = playerWeapon;
        this.playerHealth = playerHealth;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    @Override
    public String toString() {
        return "Player Name: " + this.playerName + " || Player Weapon: "+ this.playerWeapon + " || Player Health: " + this.playerHealth;
    }
}