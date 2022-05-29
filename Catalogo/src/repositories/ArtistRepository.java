package repositories;

import java.util.List;

import models.Artist;

public interface ArtistRepository {
    void addArtist(List<Artist> artist);
    void showArtist();
    void searchAux(int aux);
    int isValidName(String name);
}
