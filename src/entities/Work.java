package entities;

import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Work {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int workID;
    private Object content;

    @MayToMany(fetch = FetchType.EAGER)
    private Collection<User> collaborateurs;

    public Work(Object workContent) {
        this.content = workContent;
    }

    public Work() {}

    public int getWorkID () {
        return workID;
    }

    public void setWorkID (int workID) {
        this.workID = workID;
    }

    public Object getContent() {
        return content;
    }

    public void setContent (Object content) {
        this.content = content;
    }

    public Collection<User> getCollaborateurs () {
        return collaborateurs;
    }

    public void setCollaborateurs (Collection<User> collaborateurs) {
        this.collaborateurs = collaborateurs;
    }
}
