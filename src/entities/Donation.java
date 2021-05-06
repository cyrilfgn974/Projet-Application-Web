package entities;

import java.util.*;

public class Donation {
    private int donationID;
    private User from;
    private Artist to;
    private Frequence frequence;
    private Money value;

    public enum Frequence {ONCE, MONTHLY, ANNUALLY}

    public Donation(int donation, User from, Artist to, Money value, Frequence freq) {
        this.donationID = donation;
        this.from = from;
        this.to = to;
        this.frequence = freq;
        this.value = value;
    }

    public int getID() {
        return donationID;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public Frequence getFrequence() {
        return frequence;
    }

    public Money getValue() {
        return value;
    }
}
