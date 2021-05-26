package entities;

import java.util.Collection;
import java.util.Date;

public interface Publication {
    public boolean userLiked(User user);
    public Collection<Comment> getCommentsFromUser(User user);
    public int getID();
    public User getOwner();
    public Date getPublicationDate();
    public Collection<Comment> getComments();
    public Collection<User> getLikeUsers();
    public void setID(int ID);
    public void setOwner(User owner);
    public void setPublicationDate(Date date);
    public void setComments(Collection<Comment> comments);
    public void setLikeUsers(Collection<User> likeUsers);
}
