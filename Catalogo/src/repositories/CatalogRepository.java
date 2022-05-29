package repositories;

import models.Catalog;
import models.Media;

public interface CatalogRepository {
    void addCatalog(Catalog catalog);
    void addMidia(Media media);
    void showCatalog();
    void findMediasByArtist(int id);
    int findArtistByMedia(int num);
    int isValidBarcode(Media media);
    int isValidName(String name);
}
