package com.example.game;

import java.util.ArrayList;

public class Monster implements  ISaveable{
    private String name;
    private int hitpoints;
    private int strength;

    public Monster(String name, int hitpoints, int strength) {
        this.name = name;
        this.hitpoints = hitpoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override //This will print the Monster object directly
    public String toString() {
        return "Monster [" +
                "name='" + name + '\'' +
                ", hitpoints=" + hitpoints +
                ", strength=" + strength +
                ']';
    }

    @Override//This function is expecting arraylist and it will set the values to new instance of object.
    public void readValues(ArrayList<String> values) {
        if(values!=null && values.size() >0) {
            this.name = values.get(0);
            this.hitpoints = Integer.parseInt(values.get(1));
            this.strength = Integer.parseInt(values.get(2));
        }
    }

    @Override//This func is returning creating a new arraylist and returning the new arraylist created.
    public ArrayList<String> writeValues() {
        ArrayList<String>values = new ArrayList<>();
        values.add(0,this.name);
        values.add(1,""+this.hitpoints);
        values.add(2,""+this.strength);
        return values;
    }
}
