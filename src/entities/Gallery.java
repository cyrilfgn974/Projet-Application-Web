package entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gallery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private int galleryId;
    private Artist artistOwner;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Work> listWorks;

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

    public Collection<Work> getListWorks() {
        return listWorks;
    }
}

//OneToany ou ManyToMany ?
