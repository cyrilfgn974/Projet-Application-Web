package entities;

import java.util.List;

public class Wall {
	private int wallID;
	private User user;
	private List<Post> postList;
	public Wall (int id, User us, List<Post> post) {
		this.wallID = id;
		this.user = us;
		this.postList = post;
	}
}