package models;

public class Singer extends Artist {
    
    private int carrerTime;

    public Singer() {

    }

    public Singer(int carrerTime) {
        this.carrerTime = carrerTime;
    }
    
    public int getCarrerTime() {
        return carrerTime;
    }

    public void setCarrerTime(int carrerTime) {
        this.carrerTime = carrerTime;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
