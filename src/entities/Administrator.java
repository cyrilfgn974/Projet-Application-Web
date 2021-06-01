package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Administrator extends User {

	public Administrator(String user, String pass, String first, String last, String mail, String phone) {
		super(user, pass, first, last, mail, phone);
	}
	
	public Administrator() {
		super();
	}
}
