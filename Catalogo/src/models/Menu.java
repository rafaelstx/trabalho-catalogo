package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import repositories.ArtistRepositoryImpl;
import repositories.CatalogRepositoryImpl;

public class Menu {

    public Menu (){

    }

    public static void menu(){

        int option=0;
        int StayorDie=1;
        int artistsearch=0;
        int mediasearch=0;
        
        Scanner scan = new Scanner(System.in);

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
        CatalogRepositoryImpl catalogRepo = new CatalogRepositoryImpl();
        catalogRepo.addCatalog(catalog);

        List<Artist> artists = new ArrayList<>();

        Artist a1 = new Singer(1, "Daniel", 10);
        Artist a2 = new Singer(2, "Marilia Mendonca", 1);
        Artist a3 = new Band(3, "Calcinha Preta", 7);
        
        artists.add(a1);
        artists.add(a2);
        artists.add(a3);

        ArtistRepositoryImpl artistRepo = new ArtistRepositoryImpl();

        artistRepo.addArtist(artists);

        do {

            System.out.println("-------------------------------");
            System.out.println("1 - Registro de midia (CD ou DVD)");
            System.out.println("2 - Registro de artista (cantor ou banda)");
            System.out.println("3 - Mostrar catalogo de midias");
            System.out.println("4 - Mostrar artistas");
            System.out.println("5 - Procurar artista pela midia");
            System.out.println("6 - Procurar musica por artista");
            System.out.println("7 - Remover midia");
            System.out.println("8 - Remover artista");
            System.out.println("9 - Sair");
            System.out.println("-------------------------------");

            do{
                option = scan.nextInt();
                System.out.println("\n");
            }while(option>9 || option<1);

            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    catalogRepo.showCatalog();
                    break;
                case 4:
                    artistRepo.showArtist();
                    break;
                case 5:
                    System.out.println("Escolha uma musica:");
                    catalogRepo.showCatalog();

                    do{
                        mediasearch = scan.nextInt();
                    }while(mediasearch>medias.size() || mediasearch<1);

                    artistRepo.searchAux(catalogRepo.findArtistByMedia(mediasearch));

                    break;
                case 6:
                    System.out.println("Escolha um artista:");
                    artistRepo.showArtist();

                    do{
                        artistsearch = scan.nextInt();
                    }while(artistsearch>artists.size() || artistsearch<1);

                    catalogRepo.findMediasByArtist(artistsearch);
                    break;
                case 7:

                    

                    break;
                case 8:

                    break;
                default:
                    StayorDie = 0;
                    break;
            }
        } while (StayorDie != 0);
        
        
    }

    /*
     * Scanner scan = new Scanner();
     * 
     * 1 - Register (CD or DVD)
     * {
     * 1 - CD
     * {
     * name, price, (barcode), tracks, (Artist)
     * }
     * 2 - DVD
     * {
     * name, price, (barcode), duration, (Artist)
     * }
     * 
     * }
     * 
     * 2 - Register (Singer or Band)
     * {
     * 1 - Singer
     * {
     * (id), name, carrerTime
     * }
     * 2 - Band
     * {
     * (id), name, numMembers
     * }
     * }
    (Foi) 3 - Show AllMedias - Printa midia falando sua posicao no catalogo
    (Foi) 4 - Show AllArtists
    (Foi) 5 - Search ForArtists
    (Foi) 6 - Search ForMedias
     * 7 - Remove (CD or DVD)
     * 8 - Remove (Singer or Band)
    (Foi) 9 - Exit (0)
     */
}
