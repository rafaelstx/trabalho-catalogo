package repositories;

import java.util.ArrayList;
import java.util.List;
import models.Catalog;
import models.Media;

public class CatalogRepositoryImpl implements CatalogRepository {

    List<Media> medias = new ArrayList<>();

    @Override
    public void addCatalog(Catalog catalog) {
        this.medias = catalog.getMedias();
    }

    @Override
    public void addMidia(Media media) {
        medias.add(media);
    }

    @Override
    public void showCatalog() {
        for (Media media : medias) {
            System.out.println(media.toString());
        }
    }

    @Override
    public void findMediasByArtist(int id) {

        System.out.println("-------------------------------");
        System.out.println("As mídias desse artista são: ");

        for (Media media : medias) {
            if (media.getArtistId() == id) {
                System.out.println(media.toString());
            }
        }

        System.out.println("-------------------------------");
    }

    @Override
    public void isValidBarcode(Media media) {
        for (Media m : medias) {
            m.equals(media);
        }
    }

}
