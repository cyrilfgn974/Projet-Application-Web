package entities;

import javax.persistence.*;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int donationID;
    @ManyToOne
    private User from;
    @ManyToOne
    private User to;
    private Frequence frequence;
    @ManyToOne
    private Money value;

    public enum Frequence {MONTHLY, ANNUALLY}

    public Donation(User from, User to, Money value, Frequence freq) {
        this.from = from;
        this.to = to;
        this.frequence = freq;
        this.value = value;
    }

    public Donation () {}

    public int getDonationID() {
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

    public void setDonationID (int id) {

        this.donationID = id;
    }

    public void setFrom (User from) {
        this.from = from;
    }

    public void setTo (User to) {
        this.to = to;
    }

    public void setFrequence (Frequence frequence) {
        this.frequence = frequence;
    }

    public void setValue (Money value) {
        this.value = value;
    }
}
