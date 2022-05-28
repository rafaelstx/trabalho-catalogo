package repositories;

import models.Singer;

public interface SingerRepository {
    void createSinger(Singer singer);
    void showSinger();
}
