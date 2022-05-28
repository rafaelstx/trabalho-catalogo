package repositories;

import models.Band;

public class BandRepositoryImpl implements BandRepository {

    Band band = new Band();

    @Override
    public void createBand(Band band) {
        this.band = new Band();
    }

    @Override
    public void showBand() {
        System.out.println(band.toString());
    }
    
}
