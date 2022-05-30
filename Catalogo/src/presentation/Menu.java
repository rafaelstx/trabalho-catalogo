package presentation;

import java.util.Scanner;
import models.Artist;
import models.Band;
import models.Cd;
import models.Dvd;
import models.Media;
import models.Singer;
import repositories.ArtistRepositoryImpl;
import repositories.CatalogRepositoryImpl;
import utils.Mock;

public class Menu {

    // set repositories with mock
    private static Mock mock = new Mock();

    private static CatalogRepositoryImpl catalogRepo = mock.getCatalogMock();
    private static ArtistRepositoryImpl artistRepo = mock.getArtistMock();
    private static Scanner scan = new Scanner(System.in);

    public Menu() {

    }

    public static void menu() {

        int option, stayOrDie = 1;

        System.out.println("Programa iniciado com mídias e artistas padrões!");

        do {

            showMenu();

            do {
                option = scan.nextInt();
                System.out.println("\n");
            } while (option > 9 || option < 1);

            switch (option) {
                case 1:
                    registerMedia();
                    break;
                    
                case 2:
                    registerArtist();
                    break;

                case 3:
                    catalogRepo.showCatalog();
                    break;

                case 4:
                    artistRepo.showArtist();
                    break;
                case 5:
                    findArtistByMedia();
                    break;

                case 6:
                    findMediaByArtist();
                    break;

                case 7:
                    removeMedia();
                    break;

                case 8:
                    removeArtist();
                    break;

                default:
                    stayOrDie = 0;
                    scan.close();
                    break;
            }
        } while (stayOrDie != 0);

    }

    private static void showMenu() {
        System.out.println("-------------------------------");
        System.out.println("1 - Registro de midia (CD ou DVD)");
        System.out.println("2 - Registro de artista (cantor ou banda)");
        System.out.println("3 - Mostrar catálogo de midias");
        System.out.println("4 - Mostrar artistas");
        System.out.println("5 - Procurar artista pela midia");
        System.out.println("6 - Procurar música por artista");
        System.out.println("7 - Remover mídia");
        System.out.println("8 - Remover artista");
        System.out.println("9 - Sair");
        System.out.println("-------------------------------");
    }

    private static void registerMedia() {
        
        int cdAndDvd = 0;

        Media media;
        Cd cd;
        Dvd dvd;

        System.out.println("O registro será de CD(1) ou DVD(2)?");
        do {
            try {
                cdAndDvd = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {

            }
        } while (cdAndDvd > 2 || cdAndDvd < 1);

        if (cdAndDvd == 1) {

            media = baseMediaRegister();
            cd = new Cd();
            cd.setName(media.getName());
            cd.setPrice(media.getPrice());
            cd.setBarcode(media.getBarcode());
            cd.setArtistId(media.getArtistId());

            System.out.println("Digite quantas tracks possui:");
            cd.setTracks(scan.nextInt());

            catalogRepo.addMidia(cd);

        } else {

            media = baseMediaRegister();
            dvd = new Dvd();

            dvd.setName(media.getName());
            dvd.setPrice(media.getPrice());
            dvd.setBarcode(media.getBarcode());
            dvd.setArtistId(media.getArtistId());

            System.out.println("Digite o tempo de duração(segundos):");
            dvd.setDuration(scan.nextLong());

            catalogRepo.addMidia(dvd);

        }      
    }

    private static Media baseMediaRegister() {

        Media media = new Media();

        System.out.println("Digite o nome:");
        
        do {
            media.setName(scan.nextLine());
        } while (catalogRepo.isValidName(media.getName()));

        System.out.println("Digite o preço:");
        media.setPrice(scan.nextFloat());

        do {
            media.setBarcode(1);
        } while (catalogRepo.isValidBarcode(media));

        System.out.println("Digite o número do(a) compositor(a):");
        artistRepo.showArtist();

        do {
            media.setArtistId(scan.nextInt());
        } while (media.getArtistId() > artistRepo.len() || media.getArtistId() < 1);


        return media;
    }
 private static void registerArtist() {

        int singerAndBand = 0;

        System.out.println("O registro será de Cantor(1) ou Banda(2)?");
        do {
            try {
                singerAndBand = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) { }
        } while (singerAndBand > 2 || singerAndBand < 1);

        if (singerAndBand == 1) {

            Artist artist = baseRegisterArtist();

            Singer singer = new Singer();

            singer.setId(artistRepo.len() + 1);
            singer.setName(artist.getName());

            
            System.out.println("Digite o tempo de carreira em anos:");
            singer.setCarrerTime(scan.nextInt());

            artistRepo.addArtist(singer);

        } else {

            Artist artist = baseRegisterArtist();

            Band band = new Band();

            band.setId(artistRepo.len() + 1);
            band.setName(artist.getName());

            System.out.println("Digite o número de integrantes na banda:");
            band.setMembersNumb(scan.nextInt());

            artistRepo.addArtist(band);
        }

    }
private static Artist baseRegisterArtist() {

        Artist artist = new Artist();

        System.out.println("Digite o nome: ");
            
        do {
            artist.setName(scan.nextLine());
        } while (artistRepo.isValidName(artist.getName()));

        return artist;
    }

    private static void findArtistByMedia() {
        int  mediaSearch = 0;

        System.out.println("Escolha uma musica:");
        catalogRepo.showCatalog();

        do {
            mediaSearch = scan.nextInt();
        } while (mediaSearch > catalogRepo.len() || mediaSearch < 1);

        artistRepo.searchAux(catalogRepo.findArtistByMedia(mediaSearch));
    }

    private static void findMediaByArtist() {
        int artistSearch = 0;

        System.out.println("Escolha um artista:");
        artistRepo.showArtist();

        do {
            artistSearch = scan.nextInt();
        } while (artistSearch > artistRepo.len() || artistSearch < 1);

        catalogRepo.findMediasByArtist(artistSearch);
    }
private static void removeMedia() {
        int rmCdAndDvd = -1;

        System.out.println("A remoção será de qual mídia?");
        System.out.println("Digite (0) para parar o processo!");
        catalogRepo.showCatalog();

        do {
            rmCdAndDvd = scan.nextInt();
            rmCdAndDvd = rmCdAndDvd - 1;

        } while (rmCdAndDvd < -1 || rmCdAndDvd > (catalogRepo.len() - 1));

        if (rmCdAndDvd != -1) {
            catalogRepo.removeMedia(rmCdAndDvd);
            System.out.println("Remoção concluída com sucesso!");
        } else
            System.out.println("Remoção interrompida!");
    }

    private static void removeArtist() {
        int rmSingerAndBand = -1;

        System.out.println("A remoção será de qual artista?");
        System.out.println("Digite (0) para parar o processo!");
        artistRepo.showArtist();

        do {
            rmSingerAndBand = scan.nextInt();
            rmSingerAndBand = rmSingerAndBand - 1;

        } while (rmSingerAndBand < -1 || rmSingerAndBand > (artistRepo.len()  - 1));

        if (rmSingerAndBand != -1) {
            artistRepo.removeArtist(rmSingerAndBand);
            System.out.println("Remoção concluída com sucesso!");
        } else
            System.out.println("Remoção interrompida!");
    }
}