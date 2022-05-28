package models;
public class Singer extends Artist {
    private int carrerTime;

    public int getCarrerTime() {
        return carrerTime;
    }

    public void setCarrerTime(int carrerTime) {
        this.carrerTime = carrerTime;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
