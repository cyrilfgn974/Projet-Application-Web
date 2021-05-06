package entities;

import java.util.*;

public class Post {
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

	public int getID() {
		return postID;
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

	public List<Comment> getComments() {
		return listComment;
	}

	public Collection<User> getLikeUsers() {
		return likeList;
	}
}
