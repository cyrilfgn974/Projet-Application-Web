package entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.*;


@Entity
public class Post implements Publication {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	public User user;
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
		this.title = title;
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

	@Override
	public boolean userLiked(User user) {
		return false;
	}

	public Collection<Comment> getCommentsFromUser(User user) {
		Collection<Comment> commentsUser = new HashSet<Comment>();
		for (Comment c: this.comments) {
			commentsUser.addAll(c.getCommentsFromUser(user));
		}
		return comments;
	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public User getOwner() {
		return null;
	}

	@Override
	public Date getPublicationDate() {
		return null;
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

	@Override
	public Collection<User> getLikeUsers() {
		return null;
	}

	@Override
	public void setID(int ID) {

	}

	@Override
	public void setOwner(User owner) {

	}

	@Override
	public void setPublicationDate(Date date) {

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

	@Override
	public void setLikeUsers(Collection<User> likeUsers) {

	}

	public void setLikeList (Collection<User> likeList) {
		this.likeList = likeList;
	}

	public void setTitle (String title) {
		this.title = title;
	}

	public void setText (String text) {
		this.text = text;
	}
}
