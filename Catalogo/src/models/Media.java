package models;

import java.util.Objects;

public class Media {

    private String name;
    private double price;
    private String barcode;
    private int artistId;

    public Media() {

    }

    public Media(String name, double price, String barcode, int artistId){
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.artistId = artistId;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getArtistId() {
        return this.artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", artistId='" + getArtistId() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        Media media = (Media) o;
        return Objects.equals(barcode, media.barcode);
    }

}
