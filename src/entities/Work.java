package entities;

import java.util.*;

public class Work extends PublicationAbstract {
    private Object content;
    public Work(int workID, Artist artistOwner, Object workContent) {
        super(workID, artistOwner);
        this.content = workContent;
    }

    public Work(int workID, Artist artistOwner, Object workContent, Date date) {
        super(workID, artistOwner, date);
        this.content = workContent;
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

    public Object getContent() {
        return content;
    }
}
