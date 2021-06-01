package entities;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Gallery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private int galleryId;

    @OneToOne(fetch = FetchType.EAGER)
    private Artist artistOwner;



    public Gallery(Artist artistOwner) {
        this.artistOwner = artistOwner;
    }

    public Gallery () {}

    public int getID() {
        return galleryId;
    }

    public Artist getArtistOwner() {
        return artistOwner;
    }

}

//OneToany ou ManyToMany ?
