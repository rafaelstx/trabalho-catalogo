package models;

public class Singer extends Artist {
    
    private int carrerTime;

    public Singer() {

    }

    public Singer(int id, String name, int carrerTime) {
        super(id, name);
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
        return "{" +
            " singer= '"+ super.toString() + "'" +
            " carrerTime='" + getCarrerTime() + "'" +
            "}";
    }
    
}
