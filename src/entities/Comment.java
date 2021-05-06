package entities;

import java.util.*;

public class Comment {
	private int commentID;
	private User user;
	private String content;
	private String datePublication;
	private List<User> likeList;
	private List<Comment> replies;
	
	public Comment(int id, User us, String cont, String date) {
		this.commentID = id;
		this.user = us;
		this.content = cont;
		this.datePublication = date;
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

	public Collection<User> getCommentUsers(User user) {
		Collection<User> comments = new HashSet<User>();

		if (user.equals(this.user)) {
			comments.add(user);
		}

		for (Comment c: replies) {
			if (user.equals(c.getUser())) {
				comments.add(c.getUser());
			}
		}

		return comments;
	}

	public int getID() {
		return commentID;
	}

	public User getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}

	public String getPublicationDate() {
		return datePublication;
	}

	public Collection<User> getLikeList() {
		return likeList;
	}

	public int getLikeCount() {
		return likeList.size();
	}

	public List<Comment> getReplies() {
		return replies;
	}
}
