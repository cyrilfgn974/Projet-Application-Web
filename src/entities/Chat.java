package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chat {

    /** Le nombre de messages conservés pour la discussion */
    private final static int NB_CONSERVES = 5;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private User user1;
    private User user2;
    private messages;

    public Money(long unnormValue, String currency) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public getMessages() {
        return messages;
    }

    public void setUser1() {
        this.user1 = user1;
    }

    public void setUser2() {
        this.user2 = user2;
    }

    public void setMessages() {
        this.messages = messages;
    }
}
