package com.example.game;

import java.util.ArrayList;
public interface ISaveable{
    void readValues(ArrayList<String>values);
    ArrayList<String> writeValues();
}
