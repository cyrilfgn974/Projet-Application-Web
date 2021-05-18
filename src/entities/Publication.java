package entities;

import java.util.Collection;

public interface Publication {
    public boolean userLiked(User user);
    public Collection<Comment> getCommentsFromUser(User user);
    public int getID();
    public User getOwner();
    public Date getPublicationDate();
    public Collection<Comment> getComments();
    public Collection<User> getLikeUsers();
}
