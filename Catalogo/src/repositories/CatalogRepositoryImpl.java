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
        for (Media media : medias) {
            if (media.getArtistId() == id) {
                System.out.println(media.toString());
            }
        }
    }

}
