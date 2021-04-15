package entities;

import java.util.*;


public class Gallery {
    private int galleryId;
    private Artist artistOwner;
    private List<Work> listWorks;

    public Gallery(int galleryId, Artist artistOwner) {
        this.galleryId = galleryId;
        this.artistOwner = artistOwner;
        this.listWorks = new ArrayList<Work>();
    }
}
