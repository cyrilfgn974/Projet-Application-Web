package entities;

import java.util.*;

public class Post extends PublicationAbstract {
	String text;
	public Post(int id, User user, String text) {
		super(id, user);
		this.text = text;
	}

	public Post(int id, User user, String cont, String text, Date date) {
		super(id, user, date);
		this.text = text;
	}

	public String getTextContent() {
		return text;
	}
}
