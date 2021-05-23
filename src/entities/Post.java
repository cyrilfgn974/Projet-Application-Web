package entities;

import javax.persistence.Entity;

@Entity
public class Post extends PublicationAbstract {
	String text;

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
}

// Comment définir @Id pour PublicationAbstract ?
