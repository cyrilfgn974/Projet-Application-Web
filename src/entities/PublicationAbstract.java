package entities;

import java.util.Collection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public abstract class PublicationAbstract implements Publication {

	@Id
    	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int id;
	protected User user;
	protected Date date;

	@OneToMany(fetch = FetchType.EAGER)
	protected Collection<Comment> listComment;
	@OneToMany(fetch = FetchType.EAGER)
	protected Collection<User> likeList;

	protected PublicationAbstract(User user) {
		this.user = user;
		this.date = new Date();
	}

	protected PublicationAbstract(User user, Date date) {
        this(user);
		this.date = date;
	}

	public boolean userLiked(User user) {
		for (User u: likeList) {
			if (user.equals(u)) {
				return true;
			}
		}
		return false;
	}

	public Collection<Comment> getCommentsFromUser(User user) {
		Collection<Comment> comments = new HashSet<Comment>();
		for (Comment c: listComment) {
			comments.addAll(c.getCommentsFromUser(user));
		}

		return comments;
	}

	public int getID() {
		return id;
	}

	public User getOwner() {
		return user;
	}

	public Date getPublicationDate() {
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
