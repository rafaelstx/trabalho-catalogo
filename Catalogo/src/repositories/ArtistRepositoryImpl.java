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
    public void addArtist(Artist artist) {
        this.artist.add(artist);   
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

    @Override
    public boolean isValidName(String name) {
        for (Artist art : artist) {

            if(art.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeArtist(int position) {
        artist.remove(position);
    }

    @Override
    public int len() {
        return artist.size();
    }

}
