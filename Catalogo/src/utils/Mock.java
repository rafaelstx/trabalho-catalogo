package utils;

import java.util.ArrayList;
import java.util.List;
import models.Artist;
import models.Band;
import models.Catalog;
import models.Cd;
import models.Dvd;
import models.Media;
import models.Singer;
import repositories.ArtistRepositoryImpl;
import repositories.CatalogRepositoryImpl;

public class Mock {

    public ArtistRepositoryImpl getArtistMock() {
        
        ArtistRepositoryImpl artistRepo = new ArtistRepositoryImpl();

        List<Artist> artists = new ArrayList<>();

        Artist a1 = new Singer(1, "Daniel", 10);
        Artist a2 = new Singer(2, "Marilia Mendonca", 1);
        Artist a3 = new Band(3, "Calcinha Preta", 7);

        artists.add(a1);
        artists.add(a2);
        artists.add(a3);

        artistRepo.addArtist(artists);


        return artistRepo;
    }

    public CatalogRepositoryImpl getCatalogMock() {

        CatalogRepositoryImpl catalogRepo = new CatalogRepositoryImpl();

        List<Media> medias = new ArrayList<>();


        Media m1 = new Cd("Album 1", 20.0, "111111", 1, 1);
        Media m2 = new Cd("Album 2", 40.0, "222222", 10, 1);
        Media m3 = new Dvd("Album 3", 50.0, "333333", 20000l, 2);
        Media m4 = new Dvd("Album 4", 60.0, "444444", 20000l, 2);
        Media m5 = new Dvd("Album 5", 70.0, "555555", 50000000l, 3);

        medias.add(m1);
        medias.add(m2);
        medias.add(m3);
        medias.add(m4);
        medias.add(m5);

        Catalog catalog = new Catalog(medias);

        catalogRepo.addCatalog(catalog);


        return catalogRepo;
    }
    
}