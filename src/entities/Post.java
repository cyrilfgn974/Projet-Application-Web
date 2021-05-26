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
	private String title;
	private String text;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Comment> comments;
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<User> likeList;

	public Post(User user, String title, String text) {
		this.user = user;
		this.date = new Date();
		this.title = title;
		this.text = text;
	}

	public Post(User user, Date date, String title, String text) {
        this.user = user;
		this.date = date;
		this.title = title
		this.text = text;
	}

	public Post () {}

	public boolean isLiking (User user) {
		for (User u: this.likeList) {
			if (user.equals(u)) {
				return true;
			}
		}
		return false;
	}

	public Collection<Comment> getCommentsFromUser(User user) {
		Collection<Comment> commentsUser = new HashSet<Comment>();
		for (Comment c: this.comments) {
			commentsUser.addAll(c.getCommentsFromUser(user));
		}
		return comments;
	}

	public int getNbLikes () {
		return likeList.size();
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Date getDate() {
		return date;
	}

	public String getTitle () {
		return title;
	}

	public String getText () {
		return text;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<User> getLikeList() {
		return likeList;
	}

	public void setId (int id) {
		this.id = id;
	}

	public void setUser (User user) {
		this.user = user;
	}

	public void setDate (Date date) {
		this.date = date;
	}

	public void setComments (Collection<Comment> comments) {
		this.comments = comments;
	}

	public void setLikeList (Collection<User> likeList) {
		this.likeList = likeList;
	}

	public void setTitle (String title) {
		thie.title = title;
	}

	public void setText (String text) {
		this.text = text;
	}
}
