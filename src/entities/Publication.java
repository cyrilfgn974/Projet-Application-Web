package entities;

import java.util.*;

public interface Publication {
    public boolean userLiked(User user);
    public Collection<Comment> getCommentsFromUser(User user);
    public int getID();
    public User getOwner();
    public String getContent();
    public String getPublicationDate();
    public List<Comment> getComments();
	public Collection<User> getLikeUsers();
}
