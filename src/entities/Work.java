package entities;

import java.util.*;

public class Work implements Publication {
    private int workID;
    private Artist artistOwner;
    private String workContent;
	private List<Comment> listComment;
	private List<User> likeList;
    private String date;
    
    public Work(int workID, Artist artistOwner, String workContent, String date) {
        this.workID = workID;
        this.artistOwner = artistOwner;
        this.workContent = workContent;
		this.listComment = new ArrayList<Comment>();
		this.likeList = new ArrayList<User>();
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
        return workID;
    }

    public User getOwner() {
        return artistOwner;
    }

    public String getContent() {
        return workContent;
    }

	public String getPublicationDate() {
		return date;
	}

	public List<Comment> getComments() {
		return listComment;
	}

	public Collection<User> getLikeUsers() {
		return likeList;
	}
}
