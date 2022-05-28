package repositories;

import models.Artist;

public interface ArtistRepository {
    void createArtist(Artist artist);
    void showArtist();
}
