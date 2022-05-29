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
        int i = 1;
        for (Artist art : artist) {
            System.out.println(i + " - " + art.toString());
            i++;
        }
    }

    @Override
    public void searchAux(int aux) {

        for (Artist art : artist) {
            if (art.getId() == aux) {
                System.out.println(art.toString());
            }
        }
    }

}
