package com.example.game;

import java.util.ArrayList;
public class Player implements ISaveable {
    public String playerName;
    public String playerWeapon;
    public int playerHealth;



    @Override
    public ArrayList<String> writeValues() {
        ArrayList<String>values = new ArrayList<String>();
            values.add(0, this.playerName);
            values.add(1, this.playerWeapon);
//            values.add(2, ""+this.playerHealth);  //We can use this type of trick also
            values.add(2, Integer.toString(this.playerHealth));
            return values;
    }

    @Override
    public void readValues(ArrayList<String> values) {
        if(values!=null) {
            this.playerName = values.get(0);
            this.playerWeapon = values.get(1);
            this.playerHealth = Integer.parseInt( values.get(2));
        }
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