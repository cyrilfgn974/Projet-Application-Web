package entities;

import java.util.*;

public class Post {
	private int PostID;
	private User user;
	private String content;
	private String datePublication;
	private List<Comment> listComment;
	private List<User> likeList;

	
	public Post(int id, User us, String cont, String date) {
		this.PostID = id;
		this.user = us;
		this.content = cont;
		this.datePublication = date;
		this.listComment = new ArrayList<Comment>();
		this.likeList = new ArrayList<User>();
	}
}
