package models;

public class Dvd extends Media {

    private Long duration;
    
    public Dvd() {

    }        

    public Dvd(String name, double price, String barcode, Long duration, int artistId) {
        super(name, price, barcode, artistId);
        this.duration = duration;
    }
    
    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "{" + " DVD='" +"{" +
            " artist='"+ super.toString() + "'," +
            " duration='" + getDuration() + "'" +
            "}" + "'}";
    }
    
}
