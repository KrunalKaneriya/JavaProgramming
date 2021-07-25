package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PasswordData {
    private static PasswordData instance = new PasswordData();
    public ObservableList<Password> passwordList = FXCollections.observableArrayList();
    private static String filename = "PasswordList.txt";

    public static PasswordData getInstance() {
        return instance;
    }

    public void addPasswordList(Password item) {
        passwordList.add(item);
    }

    public void deletePasswordList(Password item) {
        passwordList.remove(item);
    }



    //Function to write the passwords which are in observable list to text file..
    public void writePassword() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<Password>iterator = passwordList.iterator();
            while(iterator.hasNext()) {
                Password item = iterator.next();
                bw.write(String.format("%s,%s,%s,%s",item.getTitle(),item.getUsername(),item.getValue(),item.getWebsite()));
                bw.newLine();
            }
        } finally {
            if(bw!=null) {
                bw.close();
            }
        }
    }

    public void loadPassword() throws IOException {

        passwordList = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        File passwordFile = new File(String.valueOf(path));
        BufferedReader br = Files.newBufferedReader(path);
        String passwordtext;
        try {
            if(passwordFile.length()==0) {
                System.out.println("The Password File is Empty");
                return;
            }
            while((passwordtext = br.readLine()) !=null) {
                String [] password = passwordtext.split(",");
                String passwordTitle = password[0];
                String passwordUsername = password[1];
                String passwordValue = password[2];
                String passwordWebsite = password[3];
                Password item = new Password(passwordTitle,passwordUsername,passwordValue,passwordWebsite);
                passwordList.add(item);
            }
        } finally {
            if(br!=null) {
                br.close();
            }
        }

    }



}
