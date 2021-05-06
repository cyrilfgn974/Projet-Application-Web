package entities;

import java.util.*;

public class Post implements Publication {
	private int postID;
	private User user;
	private String content;
	private String datePublication;
	private List<Comment> listComment;
	private List<User> likeList;

	
	public Post(int id, User us, String cont, String date) {
		this.postID = id;
		this.user = us;
		this.content = cont;
		this.datePublication = date;
		this.listComment = new ArrayList<Comment>();
		this.likeList = new ArrayList<User>();
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
		return postID;
	}

	public User getOwner() {
		return user;
	}

	public String getContent() {
		return content;
	}

	public String getPublicationDate() {
		return datePublication;
	}

	public List<Comment> getComments() {
		return listComment;
	}

	public Collection<User> getLikeUsers() {
		return likeList;
	}
}
