package entities;

import java.util.*;

public class Comment {
	private int CommentID;
	private User user;
	private String content;
	private String datePublication;
	private List<User> likeList;
	
	public Comment(int id, User us, String cont, String date) {
		this.CommentID = id;
		this.user = us;
		this.content = cont;
		this.datePublication = date;
		this.likeList = new ArrayList<User>();
	}
}
