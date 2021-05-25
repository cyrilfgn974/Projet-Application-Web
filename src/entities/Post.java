package entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Post extends PublicationAbstract {
	String text;
	
	public Post() {
		super();
	}

	public Post(User user, String text) {
		super(user);
		this.text = text;
	}

	public Post(User user, String cont, String text, Date date) {
		super(user, date);
		this.text = text;
	}

	

	public String getTextContent() {
		return text;
	}

	@Override
	public boolean userLiked(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}

// Comment définir @Id pour PublicationAbstract ?
