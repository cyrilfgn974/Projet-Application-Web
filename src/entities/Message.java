package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
