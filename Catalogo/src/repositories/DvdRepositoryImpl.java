package repositories;

import models.Dvd;

public class DvdRepositoryImpl implements DvdRepository {

    Dvd dvd = new Dvd();

    @Override
    public void createDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    @Override
    public void showDvd() {
        System.out.println(dvd.toString());
    }
    
}
