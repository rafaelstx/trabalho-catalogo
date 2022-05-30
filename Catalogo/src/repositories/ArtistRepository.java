package repositories;

import java.util.List;

import models.Artist;

public interface ArtistRepository {
    void addArtist(List<Artist> artist);
    void addArtist(Artist artist);
    void removeArtist(int position);
    void showArtist();
    void searchAux(int aux);
    boolean isValidName(String name);
    int len();
}
