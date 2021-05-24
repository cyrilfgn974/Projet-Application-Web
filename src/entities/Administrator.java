package entities;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {

	public Administrator(String user, String pass, String first, String last, String mail, String phone) {
		super(user, pass, first, last, mail, phone);
	}
	
	public Administrator() {
		super();
	}
}
