import java.sql.Time;

public class Dvd extends Media {
    private Time time;
    
    public Dvd() {

    }

    public Dvd(Time time){
        this.time = time;
    }
    
    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
