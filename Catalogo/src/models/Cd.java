package models;

public class Cd extends Media {

    private int tracks;

    public Cd() {

    }

    public Cd(int tracks) {
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
        return super.toString();
    }
}
