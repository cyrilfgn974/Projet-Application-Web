package entities;

import java.util.*;

public class Comment {
	private int commentID;
	private User user;
	private String content;
	private String datePublication;
	private List<User> likeList;
	
	public Comment(int id, User us, String cont, String date) {
		this.commentID = id;
		this.user = us;
		this.content = cont;
		this.datePublication = date;
		this.likeList = new ArrayList<User>();
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
}
