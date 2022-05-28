package repositories;

import models.Singer;

public class SingerRepositoryImpl implements SingerRepository {

    Singer singer = new Singer();

    @Override
    public void createSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void showSinger() {
        System.out.println(singer.toString());
    }
    
}
