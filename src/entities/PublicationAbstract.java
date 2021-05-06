package entities;

import java.util.*;

public abstract class PublicationAbstract implements Publication {
	protected int id;
	protected User user;
	protected Date date;
	protected List<Comment> listComment;
	protected List<User> likeList;

	protected PublicationAbstract(int id, User user) {
		this.id = id;
		this.user = user;
		this.date = new Date();
		this.listComment = new ArrayList<Comment>();
		this.likeList = new ArrayList<User>();
	}

	protected PublicationAbstract(int id, User user, Date date) {
        this(id, user);
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

	public List<Comment> getComments() {
		return listComment;
	}

	public Collection<User> getLikeUsers() {
		return likeList;
	}
}
