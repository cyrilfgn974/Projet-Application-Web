package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrator extends User {

	protected Administrator(String user, String pass, String first, String last, String mail, String phone) {
		super(user, pass, first, last, mail, phone);
	}
	
	
}
