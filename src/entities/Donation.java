package entities;

import java.util.*;

public class Donation {
    private int donationID;
    private Muse from;
    private Artist to;
    private int frequence;

    public Donation(int donation, Muse from, Artist to, int freq) {
        this.donationID = donation;
        this.from = from;
        this.to = to;
        this.frequence = freq;
    }

    public int getID() {
        return donationID;
    }

    public Muse getFrom() {
        return from;
    }

    public Artist getTo() {
        return to;
    }

    public int getFrequence() {
        return frequence;
    }
}
