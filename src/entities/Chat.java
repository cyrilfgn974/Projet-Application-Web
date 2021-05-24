package entities;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Chat {

    /** Le nombre de messages conservés pour la discussion */
    private final static int NB_CONSERVES = 5;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private User user1;
    private User user2;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Message> messages;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Chat() {}

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public void setMessages(List<Message> messages) {
        try {
            this.messages = messages.subList(0, NB_CONSERVES);
        } catch (IndexOutOfBoundsException e) {
            this.messages = messages;
        }
    }
}
