package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int donationID;
    @ManyToOne
    private User from;
    private Artist to;
    private Frequence frequence;
    @ManyToOne
    private Money value;

    public enum Frequence {ONCE, MONTHLY, ANNUALLY}

    public Donation(User from, Artist to, Money value, Frequence freq) {
        this.from = from;
        this.to = to;
        this.frequence = freq;
        this.value = value;
    }

    public Donation () {}

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
