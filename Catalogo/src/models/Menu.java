package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import repositories.ArtistRepositoryImpl;
import repositories.CatalogRepositoryImpl;

public class Menu {

    public Menu() {

    }

    public static void menu() {

        int option = 0, StayorDie = 1, artistsearch = 0, mediasearch = 0, cd_dvd = 0, singer_band = 0;
        int tracks, auxid, singer_time, band_num, binario, rm_cd_dvd = 0, rm_singer_band = 0;
        long duration;
        float price;
        String name;

        Scanner scan = new Scanner(System.in);

        List<Media> medias = new ArrayList<>();

        Media m = new Media();

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

        System.out.println("Programa iniciado com mídias e artistas padrões!");

        do {

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

            do {
                option = scan.nextInt();
                System.out.println("\n");
            } while (option > 9 || option < 1);

            switch (option) {
                case 1:
                    cd_dvd = 0;
                    System.out.println("O registro será de CD(1) ou DVD(2)?");
                    do {
                        try {
                            cd_dvd = Integer.parseInt(scan.nextLine());
                        } catch (NumberFormatException e) {

                        }
                    } while (cd_dvd > 2 || cd_dvd < 1);

                    if (cd_dvd == 1) {

                        System.out.println("Digite o nome:");

                        do {
                            name = scan.nextLine();
                            binario = catalogRepo.isValidName(name);

                        } while (binario == 1);

                        System.out.println("Digite o preço:");
                        price = scan.nextFloat();

                        do {
                            m.setBarcode(1);
                            binario = catalogRepo.isValidBarcode(m);

                        } while (binario == 1);

                        System.out.println("Digite quantas tracks possui:");
                        tracks = scan.nextInt();
                        System.out.println("Digite o número do(a) compositor(a):");
                        artistRepo.showArtist();
                        do {
                            auxid = scan.nextInt();
                        } while (auxid > artists.size() || auxid < 1);

                        Media m7 = new Cd(name, price, m.getBarcode(), tracks, auxid);
                        medias.add(m7);

                    } else {

                        System.out.println("Digite o nome:");
                        
                        do {
                            name = scan.nextLine();
                            binario = catalogRepo.isValidName(name);

                        } while (binario == 1);

                        System.out.println("Digite o preço:");
                        price = scan.nextFloat();

                        do {
                            m.setBarcode(1);
                            binario = catalogRepo.isValidBarcode(m);

                        } while (binario == 1);

                        System.out.println("Digite o tempo de duração(segundos):");
                        duration = scan.nextLong();
                        System.out.println("Digite o número do(a) compositor(a):");
                        artistRepo.showArtist();
                        do {
                            auxid = scan.nextInt();
                        } while (auxid > artists.size() || auxid < 1);

                        Media m7 = new Dvd(name, price, m.getBarcode(), duration, auxid);
                        medias.add(m7);

                    }

                    break;
                case 2:
                    singer_band = 0;
                    System.out.println("O registro será de Cantor(1) ou Banda(2)?");
                    do {
                        try {
                            singer_band = Integer.parseInt(scan.nextLine());
                        } catch (NumberFormatException e) {
                        }
                    } while (singer_band > 2 || singer_band < 1);

                    if (singer_band == 1) {

                        System.out.println("Digite o nome do(a) cantor(a):");

                        do {
                            name = scan.nextLine();
                            binario = artistRepo.isValidName(name);

                        } while (binario == 1);
                        
                        System.out.println("Digite o tempo de carreira em anos:");
                        singer_time = scan.nextInt();

                        Artist a4 = new Singer((artists.size() + 1), name, singer_time);
                        artists.add(a4);

                    } else {
                        System.out.println("Digite o nome da banda:");
                        
                        do {
                            name = scan.nextLine();
                            binario = artistRepo.isValidName(name);

                        } while (binario == 1);

                        System.out.println("Digite o número de integrantes na banda:");
                        band_num = scan.nextInt();

                        Artist a4 = new Band((artists.size() + 1), name, band_num);
                        artists.add(a4);
                    }

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

                    do {
                        mediasearch = scan.nextInt();
                    } while (mediasearch > medias.size() || mediasearch < 1);

                    artistRepo.searchAux(catalogRepo.findArtistByMedia(mediasearch));

                    break;
                case 6:
                    System.out.println("Escolha um artista:");
                    artistRepo.showArtist();

                    do {
                        artistsearch = scan.nextInt();
                    } while (artistsearch > artists.size() || artistsearch < 1);

                    catalogRepo.findMediasByArtist(artistsearch);
                    break;
                case 7:
                    rm_cd_dvd = -1;
                    System.out.println("A remoção será de qual mídia?");
                    System.out.println("Digite (0) para parar o processo!");
                    catalogRepo.showCatalog();

                    do {
                        rm_cd_dvd = scan.nextInt();
                        rm_cd_dvd = rm_cd_dvd - 1;

                    } while (rm_cd_dvd < -1 || rm_cd_dvd > (medias.size() - 1));

                    if (rm_cd_dvd != -1) {
                        medias.remove(rm_cd_dvd);
                        System.out.println("Remoção concluída com sucesso!");
                    } else
                        System.out.println("Remoção interrompida!");

                    break;
                case 8:
                    rm_singer_band = -1;
                    System.out.println("A remoção será de qual artista?");
                    System.out.println("Digite (0) para parar o processo!");
                    artistRepo.showArtist();

                    do {
                        rm_singer_band = scan.nextInt();
                        rm_singer_band = rm_singer_band - 1;

                    } while (rm_singer_band < -1 || rm_singer_band > (artists.size() - 1));

                    if (rm_singer_band != -1) {
                        artists.remove(rm_singer_band);
                        System.out.println("Remoção concluída com sucesso!");
                    } else
                        System.out.println("Remoção interrompida!");
                    break;
                default:
                    StayorDie = 0;
                    scan.close();
                    break;
            }
        } while (StayorDie != 0);

    }

}
