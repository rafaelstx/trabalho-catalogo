package repositories;

import models.Catalog;
import models.Media;

public interface CatalogRepository {
    void addCatalog(Catalog catalog);
    void addMidia(Media media);
    void removeMedia(int position);
    void showCatalog();
    void findMediasByArtist(int id);
    int findArtistByMedia(int num);
    boolean isValidBarcode(Media media);
    boolean isValidName(String name);
    int len();
}
