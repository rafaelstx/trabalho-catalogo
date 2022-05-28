package models;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    
    List<Media> medias = new ArrayList<Media>();

    public Catalog() {

    }

    public Catalog(List<Media> medias) {
        this.medias = medias;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    @Override
    public String toString() {
        return "{" +
            " medias='" + getMedias() + "'" +
            "}";
    }
    
}
