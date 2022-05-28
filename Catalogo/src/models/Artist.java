package models;

import java.util.ArrayList;
import java.util.List;

public class Artist {

    private String name;
    List<Media> media = new ArrayList<Media>();

    public Artist() {

    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
