package entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Post implements Publication {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToMany(fetch = FetchType.EAGER)
	private User user;
	private Date date;
	private String text;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Comment> comments;
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<User> likeList;

	public Post(User user, String text) {
		this.user = user;
		this.date = new Date();
		this.text = text;
	}

	public Post(User user, Date date, String text) {
        this.user = user;
		this.date = date;
		this.text = text;
	}

	public Post () {}

	public boolean isLiking (User user) {
		for (User u: likeList) {
			if (user.equals(u)) {
				return true;
			}
		}
		return false;
	}

	public Collection<Comment> getCommentsFromUser(User user) {
		Collection<Comment> comments = new HashSet<Comment>();
		for (Comment c: comments) {om
			comments.addAll(c.getCommentsFromUser(user));
		}

		return comments;
	}

	public int getId() {
		return id;
	}

	public User getOwner() {
		return user;
	}

	public Date getDate() {
		return date;
	}

	public Collection<Comment> getComments() {
		return listComment;
	}

	public Collection<User> getLikeUsers() {
		return likeList;
	}
}

// Définition de @Id et de @OneToMany pour une classe abstraite ?
