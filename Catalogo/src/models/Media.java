package models;

public class Media {

    private String name;
    private double price;
    private String barcode;

    public Media() {

    }

    public Media(String name, double price, String barcode){
        this.name = name;
        this.price = price;
        this.barcode = barcode;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
