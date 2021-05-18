package entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Wall {

	@Id
    	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int wallID;
	private User user;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Post> postList;

	public Wall (User us) {
		this.user = us;
	}

	public int getID() {
		return wallID;
	}

	public User getUser() {
		return user;
	}

	public Collection<Post> getPosts() {
		return postList;
	}
}
