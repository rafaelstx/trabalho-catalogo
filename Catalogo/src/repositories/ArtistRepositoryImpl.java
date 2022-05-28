package repositories;

import models.Artist;

public class ArtistRepositoryImpl implements ArtistRepository {

    Artist artist = new Artist();

    @Override
    public void createArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public void showArtist() {
        System.out.println(artist.toString());
    }
    
}
