package sample;

import javafx.collections.ObservableList;

public class Password {
    private String value;
    private String username;
    private String website;
    private String title;

    public Password(String title, String username, String value, String website) {
        this.value = value;
        this.username = username;
        this.website = website;
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title + " - " + username;
    }
}
