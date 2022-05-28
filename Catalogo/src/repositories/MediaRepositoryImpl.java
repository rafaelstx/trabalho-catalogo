package repositories;

import models.Media;

public class MediaRepositoryImpl implements MediaRepository {

    Media media = new Media();

    @Override
    public void createMedia(Media media) {
        this.media = media;
    }

    @Override
    public void showMedia() {
        System.out.println(media.toString());
    }
    
}
