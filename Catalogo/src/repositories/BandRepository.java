package repositories;

import models.Band;

public interface BandRepository {
    void createBand(Band band);
    void showBand();
}
