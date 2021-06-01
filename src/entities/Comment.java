package entities;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentID;
	@ManyToOne
	private User user;
	private String content;
	private String datePublication;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<User> likeList;
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Comment> replies;
	
	public Comment(User us, String cont, String date) {
		this.user = us;
		this.content = cont;
		this.datePublication = date;
	}

	public Comment() {}

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

		if (user.equals(this.user)) {
			comments.add(this);
		}

		for (Comment c: replies) {
			comments.addAll(c.getCommentsFromUser(user));
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

	public Collection<Comment> getReplies() {
		return replies;
	}
}
