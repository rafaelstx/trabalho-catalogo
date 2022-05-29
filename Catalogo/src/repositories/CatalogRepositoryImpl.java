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
        int i = 1;
        for (Media media : medias) {
            System.out.println(i + " - " + media.toString());
            i++;
        }
    }

    @Override
    public void findMediasByArtist(int id) {
        int vazio=0;
        System.out.println("-------------------------------");
        System.out.println("As mídias desse artista são: \n");

        for (Media media : medias) {
            if (media.getArtistId() == id) {
                System.out.println(media.toString());
                vazio++;
            }
        }
        if(vazio==0)
        {
            System.out.println("Esse artista não possui mídias!");
        }

        System.out.println("-------------------------------");
    }

    @Override
    public int findArtistByMedia(int num) {

        System.out.println("-------------------------------");
        System.out.println("O artista dessa música é: \n");

        int i = 1;
        int aux = 0;

        for (Media media : medias) {
            if (i == num) {
                aux = media.getArtistId();
                return aux;
            }
            i++;
        }

        System.out.println("-------------------------------");
        return 0;
    }

    @Override
    public int isValidBarcode(Media media) {
        for (Media m : medias) {
            if(m.equals(media)){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int isValidName(String name) {
        for (Media m : medias) {

            if(m.getName().equals(name)){
                return 1;
            }
        }
        return 0;
    }

}
