package models;

public class Cd extends Media {

    private int tracks;

    public Cd() {

    }

    public Cd(String name, double price, String barcode, int tracks, int artistId) {
        super(name, price, barcode, artistId);
        this.tracks = tracks;
    }

    public int getTracks() {
        return this.tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }


    @Override
    public String toString() {
        return "{" + " CD='" +"{" +
            " artist='"+ super.toString() + "'," +
            " tracks='" + getTracks() + "'" +
            "}" + "'}";
    }

}
