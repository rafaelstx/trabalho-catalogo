package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Artist;

public class ArtistRepositoryImpl implements ArtistRepository {

    List<Artist> artist = new ArrayList<>();

    @Override
    public void addArtist(List<Artist> artist) {
        this.artist = artist;
    }

    @Override
    public void showArtist() {
        System.out.println(artist.toString());
    }
    
}
